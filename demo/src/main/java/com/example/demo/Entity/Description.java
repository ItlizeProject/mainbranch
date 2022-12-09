package com.example.demo.Entity;
//modified by Victoria
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "description_id", unique=true)
    private int descriptionId;


    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "series")
    private String series;

    @Column(name = "model")
    private String model;

    @JsonIgnore
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)//fk
    @JoinColumn(name = "product_id")
    private Product product;//I didn't creat Product class

    public Description() {

    }

    public Description(String manufacturer, String series, String model) {
        this.manufacturer = manufacturer;
        this.series = series;
        this.model = model;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}