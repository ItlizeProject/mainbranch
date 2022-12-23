package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectServiceImplTest {
//    ProjectRepository repository;
    @Autowired
    ProjectServiceImpl service;

    @Test
    void createProject() {

        Project project = new Project();
        User newUser = new User();
        newUser.setUserName("simon");
        newUser.setUserType("Owner");
        newUser.setUserPassword("bca234");
//        List<ProjectProduct> projectProductList = new ArrayList<>();
//        ProjectProduct projProd = new ProjectProduct();
//        projectProductList.add(projProd);
//        project.setProjectProduct(projectProductList);
        project.setUser(newUser);
        service.createProject(project);
        Assertions.assertEquals(project.toString(),service.findProjectByProjectId(2).toString());

//
//        service.createProject(project);


//        List<Project> projectList = new ArrayList<>();
//        Project project = new Project();
//        List<ProjectProduct> projectProductList = new ArrayList<>();
//        ProjectProduct projPrd = new ProjectProduct();
//        User newUser = new User();
//        projectProductList.add(projPrd);
//        project.setProjectProduct(projectProductList);
//        project.setUser(newUser);
//        projectList.add(project);
//        newUser.setUserName("Simon");
//        newUser.setUserType("Owner");
//        newUser.setUserPassword("bca234");
//        newUser.setProjectList(projectList);

//        User newUser = new User();
//        newUser.setUserName("Simon");
//        newUser.setUserType("Owner");
//        newUser.setUserPassword("bca234");
//        newUser.setProjectList();
//        List<ProjectProduct> projectProductList = new ArrayList<>();
//        ProjectProduct projPrd = new ProjectProduct();
//        projectProductList.add(projPrd);
//        project.setProjectProduct(projectProductList);
//        project.setUser(newUser);

    }

    @Test
    void save() {
        Project project = new Project();
        User newUser = new User();
        newUser.setUserName("simon");
        newUser.setUserType("Owner");
        newUser.setUserPassword("bca234");
//        List<ProjectProduct> projectProductList = new ArrayList<>();
//        ProjectProduct projProd = new ProjectProduct();
//        projectProductList.add(projProd);
//        project.setProjectProduct(projectProductList);
        project.setUser(newUser);
        service.save(project);
        Assertions.assertEquals(project.toString(),service.findProjectByProjectId(3).toString());
    }

    @Test
    void findAll() {
//        List<Project> projectList = new ArrayList<>();
//        List<ProjectProduct> projectProductList = new ArrayList<>();
//        Project p1 = new Project();
//        p1.setProjectProduct(projectProductList);
//
//        service.save(p1);
//        Project p2 = new Project();
//        service.save(p2);
//        Project p3 = new Project();
//        service.save(p3);
//        projectList.add(p1);
//        projectList.add(p2);
//        projectList.add(p3);
        List<Project> testProjectList = service.findAll();

        Assertions.assertEquals("projectList",testProjectList);

    }


    @Test
    void findByUser() {
        //return list of proj by user
        List<Project> projectList = new ArrayList<>();
        Project project1 = new Project();
        User user = new User();
        user.setUserName("Nemo");
        user.setUserPassword("applepie");
        user.setUserType("Employer");
        user.setProjectList(projectList);
        project1.setUser(user);
        projectList.add(project1);
        user.setProjectList(projectList);
        service.save(project1);
        Assertions.assertEquals("projectList", service.findByUser(user));
    }

    @Test
    void deleteProject() {
        Project project = new Project();
        service.createProject(project);
        Assertions.assertNotNull(service.findProjectByProjectId(1));
        service.deleteProject(01);
        Assertions.assertNull(service.findProjectByProjectId(1));

    }
}