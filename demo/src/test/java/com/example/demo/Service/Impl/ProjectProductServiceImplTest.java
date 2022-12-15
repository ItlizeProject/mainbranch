package com.example.demo.Service.Impl;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Repository.ProjectRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectProductServiceImplTest {

    ProjectRepository repository;
    ProjectServiceImpl service;
    @Test
    void createProjectProduct() {
        Project newProj = new Project();
        List<ProjectProduct> projectProductList = new ArrayList<>();
        newProj.setProjectProduct(projectProductList);

    }

    @Test
    void save() {
    }

    @Test
    void deleteProjectProduct() {
    }

    @Test
    void findProjectProductByProductId() {
    }

    @Test
    void findProjectProductByProjectId() {
    }

    @Test
    void findAll() {
    }
}