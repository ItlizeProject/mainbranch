package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Repository.ProjectProductRepository;
import com.example.demo.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {
    @Autowired
    private ProjectProductRepository projectProductRepository;
    public ProjectProductServiceImpl(ProjectProductRepository projectProductRepository) {
        super();
        this.projectProductRepository = projectProductRepository;
    }
    @Override
    public ProjectProduct createProjectProduct(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }

    @Override
    public ProjectProduct save(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }


    @Override
    public String deleteProjectProduct(Integer id) {
        projectProductRepository.deleteById(id);
        return "Project Product "+ id +" has been removed";
    }

    @Override
    public ProjectProduct findProjectProductByProductId(Integer id) {
        return projectProductRepository.findByProduct(id).orElse(null);
    }

    @Override
    public ProjectProduct findProjectProductByProjectId(Integer id) {
        return projectProductRepository.findByProject(id).orElse(null);
    }

    @Override
    public List<ProjectProduct> findAll() {
        return projectProductRepository.findAll();
    }

//    @Override
//    public List<ProjectProduct> addProductToProjectProductList(Product productToAdd) {
//        projectProductRepository.
//        return null;
//    }
}