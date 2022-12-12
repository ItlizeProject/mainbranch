package com.example.demo.Service;

import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Repository.ProjectProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductServiceImpl implements ProjectProductService{

//    @Autowired
    private ProjectProductRepository projectProductRepository;
    @Override
    public ProjectProduct createProjectProduct(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }

    @Override
    public ProjectProduct save(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }

    @Override
    public String deleteProjectProduct(long id) {
        projectProductRepository.deleteById(id);
        return "Project Product "+ id +" has been removed";
    }

    @Override
    public ProjectProduct findProjectProductById(long id) {
        return projectProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProjectProduct> findAll() {
        return projectProductRepository.findAll();
    }
}
