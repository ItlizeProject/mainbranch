package com.example.demo.Service.Impl;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class UserServiceImplTest {

    UserRepository repository;
    UserServiceImpl service;
    @Test
    void createUser() {
        List<Project> usersProjectList = new ArrayList<>();
        User newUser = new User();
        newUser.setUserId((long)3);
        newUser.setUserName("Simon");
        newUser.setUserPassword("abc123");
        newUser.setUserType("Manager");
        newUser.setProjectList(usersProjectList);
        service.createUser(newUser);
        Assertions.assertEquals("Simon",repository.findById((long)3).get().getUserName());
    }

    @Test
    void findUser() {
        List<User> usersList = new ArrayList<>();
        User u1 = new User("Simon1", "123");
        service.createUser(u1);
        User u2 = new User("Simon2", "1234");
        service.createUser(u2);
        User u3 = new User("Simon3", "12345");
        service.createUser(u3);
        usersList.add(u1);
        usersList.add(u2);
        usersList.add(u3);
        List<User> testUsersList = new ArrayList<>();
        testUsersList = service.findUser();
        Assertions.assertEquals(usersList,testUsersList);

    }

    @Test
    void findUserById() {
        List<Project> usersProjectList = new ArrayList<>();
        User newUser = new User();
        newUser.setUserId((long)3);
        newUser.setUserName("Simon");
        newUser.setUserPassword("abc123");
        newUser.setUserType("Manager");
        newUser.setProjectList(usersProjectList);
        service.createUser(newUser);
        Assertions.assertEquals(newUser, service.findUserById((long)3));
    }

    @Test
    void deleteUser() {
        List<Project> usersProjectList = new ArrayList<>();
        User newUser = new User();
        newUser.setUserId((long)3);
        newUser.setUserName("Simon");
        newUser.setUserPassword("abc123");
        newUser.setUserType("Manager");
        newUser.setProjectList(usersProjectList);
        service.createUser(newUser);
        Assertions.assertNotNull(service.findUserById((long)3));
        service.deleteUser((long)3);
        Assertions.assertNull(service.findUserById((long)3));

    }

    @Test
    void findUserByUsername() {
        List<Project> usersProjectList = new ArrayList<>();
        User newUser = new User();
        newUser.setUserId((long)3);
        newUser.setUserName("Simon");
        newUser.setUserPassword("abc123");
        newUser.setUserType("Manager");
        newUser.setProjectList(usersProjectList);
        service.createUser(newUser);
        Assertions.assertEquals(newUser, service.findUserByUsername("Simon"));
    }

    @Test
    void findUserByUserType() {
        List<Project> usersProjectList = new ArrayList<>();
        User newUser = new User();
        newUser.setUserId((long)3);
        newUser.setUserName("Simon");
        newUser.setUserPassword("abc123");
        newUser.setUserType("Manager");
        newUser.setProjectList(usersProjectList);
        service.createUser(newUser);
        Assertions.assertEquals(newUser, service.findUserByUserType("Manager"));
    }
}