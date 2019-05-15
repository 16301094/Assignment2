package bjtu.edu.javaee.a2.controller;

import bjtu.edu.javaee.a2.domain.User;
import bjtu.edu.javaee.a2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /*
    HATEOAS
     */
    @ResponseBody
    @GetMapping("/{userId}")
    public User getCustomerById(@PathVariable int userId) {
        User result = userService.getUserDetail(userId);
//        result.add(new Link("http://localhost:8080/spring-security-rest/api/users/5"));
        Link selfLink = linkTo(UserController.class).slash(result.getUserId()).withSelfRel();
        result.add(selfLink);
        return result;
    }

    @RequestMapping(value = { "", "/" })
    public String index(Model model) {
        model.addAttribute("activePage", "users");
        model.addAttribute("users", this.userService.getAllUsers());
        return "users/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserForm(User user, Model model) {
        model.addAttribute("activePage", "users");
        return "users/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "users");
            return "users/add";
        }

        this.userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/view/{id}")
    public String viewUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("activePage", "users");
        return "users/view";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("activePage", "users");
        return "users/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(User user) {
        System.out.println("User ID: " + user.getUserId());
        this.userService.saveUser(user);
        return "redirect:/users/view/" + user.getUserId();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);
        return "redirect:/users";
    }



}
