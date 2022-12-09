package com.example.demo.Entity;
import javax.persistence.*;
import java.util.Date;
@Entity

public class ProductType {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id", unique = true)
    private int productTypeId;

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


    @OneToOne(cascade = CascadeType.ALL)//fk
    @JoinColumn(name = "productId", referencedColumnName="product_id")
    private Product product;

    public ProductType() {
    }

    public ProductType(String application, String type, String mountingLocation, String accessories, Date modelYear) {
        this.application = application;
        this.type = type;
        this.mountingLocation = mountingLocation;
        this.accessories = accessories;
        this.modelYear = modelYear;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
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
