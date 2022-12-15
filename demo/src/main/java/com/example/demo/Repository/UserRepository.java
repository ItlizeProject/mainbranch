package com.example.demo.Repository;

import java.util.*;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUserName(String userName);
//    Optional<User> findByUserProjectList(Project projectList);
    Optional<User> findByUserType(String userType);
//    Optional<User> findUserById(Long id);
}

