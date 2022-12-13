package com.example.demo.Service;

import com.example.demo.Entity.ProjectProduct;

import java.util.List;

public interface ProjectProductService {
    ProjectProduct createProjectProduct(ProjectProduct projectProduct);
    ProjectProduct save(ProjectProduct projectProduct);
    String deleteProjectProduct(long id);
    ProjectProduct findProjectProductById(long id);
    List<ProjectProduct> findAll();
}
