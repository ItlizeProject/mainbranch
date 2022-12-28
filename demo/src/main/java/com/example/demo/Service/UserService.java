package com.example.demo.Service;

import com.example.demo.Entity.User;
import java.util.List;


public interface UserService {
    // User createUser(User user);
    List<User> findUser();
    User saveUser(User user);
    User findUserById(Long id);
    String deleteUser(Long id);
    User findUserByUsername(String username);

    User findUserByUserType(String userType);

    void clear();

    boolean update(String userName, User user);





}