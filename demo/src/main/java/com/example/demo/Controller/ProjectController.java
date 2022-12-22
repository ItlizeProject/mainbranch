package com.example.demo.Controller;


import com.example.demo.Entity.Description;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Entity.User;
import com.example.demo.Service.ProjectProductService;
import com.example.demo.Service.ProjectService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/projectController")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectProductService projectProductService;

    @GetMapping("/project")//passed
    public ResponseEntity<?> listAllProject() {//to findAll

        List<Project> list = projectService.findAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"project not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getProjectById")
    public ResponseEntity<?> getProjectById(@RequestParam("id") Integer id) {//@RequestParam:extract value from the request URI
        Project project = projectService.findProjectByProjectId(id);
        if (project == null) {
            return new ResponseEntity<>("{\"error\":\"project not found by id!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/getProjectByUser")
    public ResponseEntity<?> getProjectByUser(@RequestParam("user") User user) {
        List<Project> list = projectService.findByUser(user);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"project not found by user!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/createProject")//passed
    public ResponseEntity<?> addProject(@RequestParam("userId") Long userId){

        User user = userService.findUserById(userId);//get user info

        Project project1 = new Project();
        project1.setUser(user);//set user info into project
        projectService.createProject(project1);//send project info to database

        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProject")//Q:when I try to delete, user with input id are all deleted
    public ResponseEntity<?> deleteProject(@RequestParam("id") Integer id) {
        Project project = projectService.findProjectByProjectId(id);
        if (project == null) {
            return new ResponseEntity<>("{\"error\":\"project not found!\"}", HttpStatus.NOT_FOUND);
        }
        //explanation to next two lines:
        //action: set userId in project table as null before delete
        //reason: if userId duplicate in project table, when try to delete project, related line(same userID) in User table would be deleted.
        //then, the deletion of user table will lead to the deletion of project (because of cascade = CascadeType.ALL setting in user entity one-to-many with project)
        //result: in project table, all lines with same specific userID will all be deleted
        project.setUser(null);
        projectService.save(project);

        String s = projectService.deleteProject(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
