package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectProductServiceImplTest {

    //    ProjectProductRepository repository;
    @Autowired
    ProjectProductServiceImpl service;
    @Test
    void createProjectProduct() {
        List<ProjectProduct> projectProductList = new ArrayList<>();
        ProjectProduct newProjProd = new ProjectProduct();
        projectProductList.add(newProjProd);
//        newProjProd.setProjectProductId(1);


        Project project = new Project();
        project.setProjectId(2);
        project.setProjectProduct(projectProductList);


        Product product = new Product();
        product.setProductBrand("Apple");
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertEquals(newProjProd.toString(),service.findProjectProductByProductId(1).toString());



    }

//    @Test
//    void save() {
//        ProjectProduct newProjProd = new ProjectProduct();
//        Project project = new Project();
//        Product product = new Product();
//        newProjProd.setProjectProductId(02);
//        newProjProd.setProduct(product);
//        newProjProd.setProject(project);
//        service.save(newProjProd);
//        Assertions.assertNotNull(repository.findById(01));
//    }

    @Test
    void deleteProjectProduct() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        project.setProjectId(1);
        Product product = new Product();
        product.setProductId(1);
//        newProjProd.setProjectProductId(03);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertNotNull(service.findProjectProductByProjectId(1));
        service.deleteProjectProduct(03);
        Assertions.assertNull(service.findProjectProductByProjectId(1));
    }

    @Test
    void findProjectProductByProductId() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        project.setProjectId(2);
        Product product = new Product();
        product.setProductId(01);
//        newProjProd.setProjectProductId(03);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertEquals(newProjProd,service.findProjectProductByProductId(1));
    }

    @Test
    void findProjectProductByProjectId() {
        ProjectProduct newProjProd = new ProjectProduct();
        Project project = new Project();
        project.setProjectId(4);
        Product product = new Product();
        product.setProductId(3);
//        newProjProd.setProjectProductId(03);
        newProjProd.setProduct(product);
        newProjProd.setProject(project);
        service.createProjectProduct(newProjProd);
        Assertions.assertEquals(newProjProd,service.findProjectProductByProjectId(4));

    }

    @Test
    void findAll() {
        List<ProjectProduct> projectProductList = service.findAll();
//        ProjectProduct pp1 = new ProjectProduct();
//        pp1.setProjectProductId(01);
//        ProjectProduct pp2 = new ProjectProduct();
//        pp2.setProjectProductId(02);
//        ProjectProduct pp3 = new ProjectProduct();
//        pp3.setProjectProductId(03);
//        projectProductList.add(pp1);
//        projectProductList.add(pp2);
//        projectProductList.add(pp3);
//        List<ProjectProduct> testProjectProdList;
//        testProjectProdList = service.findAll();
        Assertions.assertEquals("projectProductList",projectProductList);
    }
}