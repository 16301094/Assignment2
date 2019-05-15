package bjtu.edu.javaee.a2.controller;

import bjtu.edu.javaee.a2.domain.User;
import bjtu.edu.javaee.a2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

@Controller
public class LoginController {

    private UserRepository userRepository;

    @Autowired
    public void setContactRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

    }



    @RequestMapping(value = { "/login" } , method = RequestMethod.POST)
    public String index(@RequestParam("email") String email,
                        @RequestParam("password") String password) {

        Iterator<User> userIterator = userRepository.findAll().iterator();
        while (userIterator.hasNext()){
            User temp = userIterator.next();
            if (temp.getEmail().equals(email)  ){
                if (temp.getPassword().equals(password)  ){
                    System.out.print("登陆成功");
                    return "redirect:/users";
                }
                System.out.print("密码错误");
                return "index";
            }
        }
        System.out.print("用户不存在");



        return "index";
    }
}
