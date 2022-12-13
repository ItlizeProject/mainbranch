package com.example.demo.Entity;
//modified by Victoria
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.Date;
@Entity

public class ProductType {

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id", unique = true)
    private Integer productTypeId;

    @Column(name = "application")
    private String application;

    @Column(name = "type")
    private String type;

    @Column(name = "mounting_location")
    private String mountingLocation;

    @Column(name = "accessories")
    private String accessories;

    @Column(name = "model_year")
    private Date modelYear;

    @JsonIgnore
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)//fk
    @JoinColumn(name = "product_id", referencedColumnName="product_id")
    private Product product;//I didn't creat Product class

    public ProductType() {
    }

    public ProductType(String application, String type, String mountingLocation, String accessories, Date modelYear) {
        this.application = application;
        this.type = type;
        this.mountingLocation = mountingLocation;
        this.accessories = accessories;
        this.modelYear = modelYear;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMountingLocation() {
        return mountingLocation;
    }

    public void setMountingLocation(String mountingLocation) {
        this.mountingLocation = mountingLocation;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public Date getModelYear() {
        return modelYear;
    }

    public void setModelYear(Date modelYear) {
        this.modelYear = modelYear;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}