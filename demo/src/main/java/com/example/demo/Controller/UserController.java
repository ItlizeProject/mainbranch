package com.example.demo.Controller;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.MyUserLoginDetailsService;
import com.example.demo.Service.UserService;
import com.example.demo.Service.Impl.UserServiceImpl;
import com.example.demo.Service.ProjectService;
import com.example.demo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final AuthenticationManager authenticatonManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private MyUserLoginDetailsService userDetailsService;
    @GetMapping("/user")
    public ResponseEntity<?> allUsers(){
        List<User> users = userService.findUser();
        if(users == null || users.isEmpty()){
            return new ResponseEntity<>("no users found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/userById")
    public ResponseEntity<?> getUserById(@RequestParam("id") Long id){
        User user = userService.findUserById(id);
        if(user == null){
            return new ResponseEntity<>("user was not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    @PostMapping("/createUser")
    public ResponseEntity<?> addUser(
                                     @RequestParam("userName") String username,
                                     @RequestParam("userPassword") String userPassword,
                                     @RequestParam("userType") String userType,
                                     @RequestParam("role") Role role){

        User newUser = new User();
        List<Project> project = new ArrayList<>();
        newUser.setUserName(username);
        newUser.setUserPassword(userPassword);
        newUser.setUserType(userType);
        newUser.setProjectList(project);
        newUser.setRole(role);
        User createdUser = userService.saveUser(newUser);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
    //sign in
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam(name="username") String username,
                                                       @RequestParam(name="password") String password)
            throws Exception {

        try {
            authenticatonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)//User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);//loadUserByUsername()返回的是授予用户的权限//User.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return  new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long userId){
        User user = userService.findUserById(userId);
        if(user==null){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestParam("id") Long userid, User userDetails){
        User user = userService.findUserById(userid);
//        final UserDetails userDetails = userDetailsService;
        if(user==null){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
        user.setUserName(userDetails.getUserName());
        user.setUserPassword(userDetails.getUserPassword());
        user.setRole(userDetails.getRole());
        userService.saveUser(user);
        return new ResponseEntity<>("updated user" + user.toString(), HttpStatus.OK);
    }

}