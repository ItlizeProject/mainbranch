package com.example.demo.Controller;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Service.Impl.UserServiceImpl;
import com.example.demo.Service.ProjectService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public ResponseEntity<?> allUsers(){
        List<User> users = userService.findUser();
        if(users == null || users.isEmpty()){
            return new ResponseEntity<>("no users found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/userById/")
    public ResponseEntity<?> getUserById(@RequestParam("id") Long id){
        User user = userService.findUserById(id);
        if(user == null){
            return new ResponseEntity<>("user was not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PostMapping("/createUser")
    public ResponseEntity<?> addUser(@RequestParam("userId") Long userId,
                           @RequestParam("userName") String username,
                           @RequestParam("userPassword") String userPassword,
                           @RequestParam("userType") String userType){
        User newUser = new User();
        List<Project> project = new ArrayList<>();
        newUser.setUserId(userId);
        newUser.setUserName(username);
        newUser.setUserPassword(userPassword);
        newUser.setUserType(userType);
        newUser.setProjectList(project);
        User createdUser = userService.createUser(newUser);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

}
