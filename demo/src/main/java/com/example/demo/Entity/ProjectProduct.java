package com.example.demo.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProjectProduct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_product_id")
    private Long ProjectProductId;

    //project_id(fk)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	@JsonIgnore
	@JoinColumn(name = "projectId", referencedColumnName = "project_id")
    private Project project;

    //product_id(fk)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
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