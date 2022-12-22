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

    @GetMapping("/project")
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

    @PostMapping("/createProject")
    public ResponseEntity<?> addProject(@RequestParam("userId") Long userId){

        User user = userService.findUserById(userId);//get user info

        Project project1 = new Project();
        project1.setUser(user);//set user info into project
        projectService.createProject(project1);//send project info to database

        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProject")
    public ResponseEntity<?> deleteProject(@RequestParam Integer id) {//?????????????does user know project id?
        Project project = projectService.findProjectByProjectId(id);
        if (project == null) {
            return new ResponseEntity<>("{\"error\":\"project not found!\"}", HttpStatus.NOT_FOUND);
        }
        String s = projectService.deleteProject(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
