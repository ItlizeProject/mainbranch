package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProjectProduct;

import java.util.List;

public interface ProjectProductService {
    ProjectProduct createProjectProduct(ProjectProduct projectProduct);
    ProjectProduct save(ProjectProduct projectProduct);
    String deleteProjectProduct(Integer id);
    ProjectProduct findProjectProductByProductId(Integer id);
    ProjectProduct findProjectProductByProjectId(Integer id);
    List<ProjectProduct> findAll();

    //add project to product method
//    List<ProjectProduct> addProductToProjectProductList(Product productToAdd);

}
