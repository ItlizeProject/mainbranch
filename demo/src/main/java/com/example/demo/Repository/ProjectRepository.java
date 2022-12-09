package com.example.demo.Repository;

import java.util.*;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Optional<List<Project>> findByUser(User user);
}
