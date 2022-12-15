package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectProductServiceImplTest {

    ProjectProductRepository repository;
    ProjectProductServiceImpl service;
    @Test
    void createProjectProduct() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        Product product = new Product();
        newProjProd.setProjectProductId(01);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertNotNull(repository.findById(01));



    }

    @Test
    void save() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        Product product = new Product();
        newProjProd.setProjectProductId(02);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.save(newProjProd);
        Assertions.assertNotNull(repository.findById(01));
    }

    @Test
    void deleteProjectProduct() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        Product product = new Product();
        newProjProd.setProjectProductId(03);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertNotNull(repository.findById(3));
        service.deleteProjectProduct(03);
        Assertions.assertNull(repository.findById(3));
    }

    @Test
    void findProjectProductByProductId() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        Product product = new Product();
        product.setProductId(01);
        newProjProd.setProjectProductId(03);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertEquals(newProjProd,repository.findByProduct(01));
    }

    @Test
    void findProjectProductByProjectId() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        Product product = new Product();
        project.setProjectId(04);
        newProjProd.setProjectProductId(03);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertEquals(newProjProd,repository.findByProject(04));

    }

    @Test
    void findAll() {
        List<ProjectProduct> projectProductList = new ArrayList<>();
        ProjectProduct pp1 = new ProjectProduct();
        pp1.setProjectProductId(01);
        ProjectProduct pp2 = new ProjectProduct();
        pp2.setProjectProductId(02);
        ProjectProduct pp3 = new ProjectProduct();
        pp3.setProjectProductId(03);
        projectProductList.add(pp1);
        projectProductList.add(pp2);
        projectProductList.add(pp3);
        List<ProjectProduct> testProjectProdList;
        testProjectProdList = service.findAll();
        Assertions.assertEquals(projectProductList,testProjectProdList);
    }
}