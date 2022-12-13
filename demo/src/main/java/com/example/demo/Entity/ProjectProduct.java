package com.example.demo.Entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProjectProduct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_product_id")
    private Integer ProjectProductId;

    //project_id(fk)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Project.class)
    @JsonIgnore
    @JoinColumn(name = "projectId", referencedColumnName = "project_id")
    private Project project;

    //product_id(fk)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
    @JsonIgnore
    @JoinColumn(name = "productId", referencedColumnName = "product_id")
    private Product product;

    //create Constructor
    public ProjectProduct(){

    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}