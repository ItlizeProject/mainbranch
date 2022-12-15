package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project save(Project project);
    List<Project> findAll();

    List<Project> findByUser(User user);

    String deleteProject(Integer id);

//    Project findProjectByProjectProductId(Integer id);


}
