package com.example.demo.Entity;
//modified by Victoria
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
//import lombok.Builder;

//Domain Layer
@Entity
public class Description {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "description_id")
    private Integer descriptionId;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "series")
    private String series;

    @Column(name = "model")
    private String model;


    //Q(Victoria):cascade = CascadeType.ALL or cascade={CascadeType. DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType. REFRESH})
    @JsonIgnore//作用是后端发送给前端数据的时候让JSON file里不包括这个attribute（即将其忽略）
    @OneToOne(targetEntity = Product.class, cascade={CascadeType. DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType. REFRESH}, orphanRemoval = true, fetch = FetchType.EAGER)//fk
    @JoinColumn(name = "product_id")
    private Product product;

    public Description() {

    }

    public Description(String manufacturer, String series, String model) {
        this.manufacturer = manufacturer;
        this.series = series;
        this.model = model;
    }

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
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

    @Override
    public String toString() {
        return "Description{" +
                "descriptionId=" + descriptionId +
                ", manufacturer='" + manufacturer + '\'' +
                ", series='" + series + '\'' +
                ", model='" + model + '\'' +
                ", product=" + product +
                '}';
    }
}