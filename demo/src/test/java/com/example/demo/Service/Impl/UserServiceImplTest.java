package com.example.demo.Service.Impl;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

    //    UserRepository repository;
    @Autowired
    UserService service;
    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        List<Project> usersProjectList = new ArrayList<>();
        User newUser = new User();
        newUser.setUserName("Victoria");
        newUser.setUserPassword("abc123");
        newUser.setUserType("Manager");
        newUser.setProjectList(usersProjectList);
        service.saveUser(newUser);
        Assertions.assertEquals(newUser.getUserName(),service.findUserById((long)5).getUserName());
    }

    @Test
    void findUser() {
        List<User> usersList = new ArrayList<>();
        User u1 = new User("Simon1", "123");
        service.saveUser(u1);
        User u2 = new User("Simon2", "1234");
        service.saveUser(u2);
        User u3 = new User("Simon3", "12345");
        service.saveUser(u3);
        usersList.add(u1);
        usersList.add(u2);
        usersList.add(u3);
        Assertions.assertEquals(usersList,service.findUser());

    }

    @Test
    void findUserById() {
        List<Project> usersProjectList = new ArrayList<>();
        User newUser = new User();
//        newUser.setUserId((long)3);
        newUser.setUserName("Simon2");
        newUser.setUserPassword("abc1233");
        newUser.setUserType("Employee");
        newUser.setProjectList(usersProjectList);
        service.saveUser(newUser);
        User testUser = service.findUserById((long)16);
        Assertions.assertEquals("User{userId=16, userName='Simon2', userPassword='abc1233', userType='Employee', projectList=[]}", testUser.toString());
    }

    @Test
    void deleteUser() {
      //  List<Project> usersProjectList = new ArrayList<>();
      //  Project proj1 = new Project();
      //  usersProjectList.add(proj1);
     //   User newUser = new User();
        User newUser = service.findUserById(4L);
//        newUser.setUserName("Simon");
//        newUser.setUserPassword("abc123");
//        newUser.setUserType("Manager");
//        newUser.setProjectList(usersProjectList);
        System.out.println(newUser);
     //   service.saveUser()(newUser);
     //   Assertions.assertNotNull(service.findUserById(4L));
        service.deleteUser((long)4);
        Assertions.assertNull(service.findUserById((long)4));

    }

    @Test
    void findUserByUsername() {
        Assertions.assertEquals("User{userId=25, userName='SimonZh', userPassword='abc1233', userType='Employee', projectList=[]}", service.findUserByUsername("SimonZh").toString());
    }

    @Test
    void findUserByUserType() {
        List<Project> usersProjectList = new ArrayList<>();
        Project proj1 = new Project();
        usersProjectList.add(proj1);
        User newUser = new User();
        newUser.setUserName("SimonZhen");
        newUser.setUserPassword("passwordqwe123");
        newUser.setUserType("AccountManager");
        service.saveUser(newUser);
        Assertions.assertEquals(newUser.toString(), service.findUserByUserType("AccountManager").toString());

    }
}