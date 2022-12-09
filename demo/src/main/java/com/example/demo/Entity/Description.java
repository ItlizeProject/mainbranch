package com.example.demo.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "description_id", unique = true)
    private int descriptionId;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "series")
    private String series;

    @Column(name = "model")
    private String model;

    @OneToOne(cascade = CascadeType.ALL)//fk
    @JsonIgnore
    @JoinColumn(name = "productId", referencedColumnName = "product_id")
    private Product product;

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