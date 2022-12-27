package com.example.demo.Service.Impl;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));//实现对password加密
        return userRepository.save(user);
    }

    @Override
    public List<User> findUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User " + id + " has been removed";
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUserName(username).orElse(null);
    }

    @Override
    public User findUserByUserType(String userType) {
        return userRepository.findByUserType(userType).orElse(null);
    }

    @Override
    public void clear(){
        userRepository.deleteAll();
    }
    @Override
    public boolean update(String userName, User user){
        User toUpdate = userRepository.findByUserName(userName).orElse(null);
        toUpdate.setUserName(user.getUserName());

        toUpdate.setUserPassword(user.getUserPassword());
        try{
            userRepository.save(toUpdate);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}