package com.example.demo.Controller;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Service.Impl.UserServiceImpl;
import com.example.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
//    @Autowired
    private UserRepository userRepository;
    private UserService userService;
    private ProjectService projectService;
    @GetMapping("/user")
    public List<User> list(){
        return userRepository.findAll();
    }

//    @GetMapping("/users/")
//    public User findById(@RequestParam("id") long id){
//        return userService.findUserById(id);
//
//    }

//    @PostMapping("/create")
//    public User addNewUser(@RequestParam("userId") Long userId,
//                           @RequestParam("userName") String username,
//                           @RequestParam("userPassword") String userPassword,
//                           @RequestParam("userType") String userType){
//        User newUser = new User();
//        List<Project> project = new ArrayList<>();
//        newUser.setUserId(userId);
//        newUser.setUserName(username);
//        newUser.setUserPassword(userPassword);
//        newUser.setUserType(userType);
//        newUser.setProjectList(project);
//        return userService.save(newUser);
//    }

}
