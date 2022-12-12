package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;

import java.util.List;

public interface ProjectService {
    public Project createProject(Project project);
    public Project save(Project project);
    List<Project> findAll();

    public List<Project> findByUser(User user);

    public Project findProjectByProjectId(long id);
    public String deleteProject(long id);

    public Project findProjectByProjectProductId(long id);


}
