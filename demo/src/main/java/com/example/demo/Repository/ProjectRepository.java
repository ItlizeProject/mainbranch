package com.example.demo.Repository;

import java.util.*;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProjectRepository extends JpaRepository<Project,Integer> {

    Optional<List<Project>> findByUser(User user);
//    Optional<Project> findProjectById(Integer id);
//    Optional<Project> findByProjectProduct(Integer id);

//    Optional<Project> findProjectByProjectProductList(ProjectProduct projectProductList);
//    Optional<List<Product>>
}
