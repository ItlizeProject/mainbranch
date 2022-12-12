package com.example.demo.Service;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository projectRepository;
    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findByUser(User user) {
        return projectRepository.findByUser(user).orElse(null);
    }

    @Override
    public Project findProjectByProjectId(long id) {
        return projectRepository.findProjectById(id).orElse(null);
    }

    @Override
    public String deleteProject(long id) {
        projectRepository.deleteById(id);
        return "Project "+id+" has been removed";
    }

    @Override
    public Project findProjectByProjectProductId(long id) {
        return projectRepository.findProjectByProjectProductId(id).orElse(null);
    }

//    @Override
//    public void addProductToProject(Product product) {
//    }
}
