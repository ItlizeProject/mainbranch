package com.example.demo.Service.Impl;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceImplTest {
    ProjectRepository repository;
    ProjectServiceImpl service;

    @Test
    void createProject() {
        Project project = new Project();
        User newUser = new User();
        newUser.setUserName("Simon");
        List<ProjectProduct> projectProductList = new ArrayList<>();
        project.setProjectProduct(projectProductList);
        project.setUser(newUser);
        service.createProject(project);
        Assertions.assertNotNull(repository.findById(01));

    }

    @Test
    void save() {
        Project project = new Project();
        User newUser = new User();
        newUser.setUserName("Simon");
        List<ProjectProduct> projectProductList = new ArrayList<>();
        project.setProjectProduct(projectProductList);
        project.setUser(newUser);
        service.save(project);
        Assertions.assertNotNull(repository.findById(01));
    }

    @Test
    void findAll() {
        List<Project> projectList = new ArrayList<>();
        Project p1 = new Project();
        service.save(p1);
        Project p2 = new Project();
        service.save(p2);
        Project p3 = new Project();
        service.save(p3);
        projectList.add(p1);
        projectList.add(p2);
        projectList.add(p3);
        List<Project> testProjectList;
        testProjectList = service.findAll();
        Assertions.assertEquals(projectList, testProjectList);

    }

    @Test
    void findByUser() {
        List<Project> projectList = new ArrayList<>();
        Project project1 = new Project();
        User user = new User();
        project1.setUser(user);
        projectList.add(project1);
        user.setProjectList(projectList);
        service.save(project1);
        Assertions.assertEquals(projectList, repository.findByUser(user));
    }

    @Test
    void deleteProject() {
        Project project = new Project();
        service.createProject(project);
        Assertions.assertNotNull(repository.findById(01));
        service.deleteProject(01);
        Assertions.assertNull(repository.findById(01));

    }
}