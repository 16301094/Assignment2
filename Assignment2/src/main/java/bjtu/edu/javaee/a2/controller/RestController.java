//package bjtu.edu.javaee.a2.controller;
//
//import bjtu.edu.javaee.a2.domain.User;
//import bjtu.edu.javaee.a2.exception.MyResourceNotFoundException;
//import bjtu.edu.javaee.a2.service.UserService;
//import bjtu.edu.javaee.a2.util.RestPreconditions;
//import com.google.common.base.Preconditions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/rest")
//class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public List<User> findAll() {
//
//        return userService.findAll();
//    }
//
//    @GetMapping(value = "/{id}")
//    public User findById(@PathVariable("id") Long id) {
//        return RestPreconditions.checkFound(userService.findById(id));
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Long create(@RequestBody User resource) {
//        Preconditions.checkNotNull(resource);
//        return userService.create(resource);
//    }
//
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@PathVariable( "id" ) Long id, @RequestBody User resource) {
//        Preconditions.checkNotNull(resource);
//        RestPreconditions.checkNotNull(service.getById(resource.getId()));
//        service.update(resource);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void delete(@PathVariable("id") Long id) {
//        service.deleteById(id);
//    }
//
//}
