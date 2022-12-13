package com.example.demo.Service;

import com.example.demo.Entity.User;
import java.util.List;


public interface UserService {
    User createUser(User user);
    List<User> findUser();
    User findUserById(long id);
    String deleteUser(long id);
    User findUserByUsername(String username);



}
