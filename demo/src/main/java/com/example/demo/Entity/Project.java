package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="project_id")
    private Integer projectId;

    //Q:cascade type should be cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    //            CascadeType.DETACH, CascadeType.REFRESH}?
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "userId", referencedColumnName = "user_id")//userId is the attribute name of table Project
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = ProjectProduct.class)
    @JsonIgnore
    private List<ProjectProduct> projectProduct = new ArrayList<>();

    //create constructor
    public Project(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        projectId = projectId;
    }

    public List<ProjectProduct> getProjectProduct() {
        return projectProduct;
    }

    public void setProjectProduct(List<ProjectProduct> projectProduct) {
        this.projectProduct = projectProduct;
    }


    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", user=" + user +
                ", projectProduct=" + projectProduct +
                '}';
    }
}