package com.example.demo.Entity;

//product_id(pk)
//product_type_id(fk)
//technical_detail_id(fk)
//description_id(fk)
//product_brand
//certification

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true)
    private Long productId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = ProjectProduct.class)
    @JsonIgnore
    private List<ProjectProduct> projectProduct;
 

    //product_type_id(fk)
    @OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "productTypeId", referencedColumnName = "product_type_id")
    private ProductType productType;

    //technical_detail_id(fk)
    @OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "technicalDetail", referencedColumnName = "technical_detail_id")
    private TechnicalDetail technicalDetail;

    //description_id(fk)
    @OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "description", referencedColumnName = "description_id")
    private Description description;
    
    public Product(){

    }

    public Product(String productBrand, String certification){
        this.productBrand=productBrand;
        this.certification=certification;
    }

    //product_brand
    @Column(name = "product_brand")
    private String productBrand;

    @Column(name="certification")
    private String certification;

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
    private Long ProductId;

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public TechnicalDetail getTechnicalDetail() {
        return technicalDetail;
    }

    public void setTechnicalDetail(TechnicalDetail technicalDetail) {
        this.technicalDetail = technicalDetail;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public List<ProjectProduct> getProjectProduct() {
        return projectProduct;
    }

    public void setProjectProduct(List<ProjectProduct> projectProduct) {
        this.projectProduct = projectProduct;
    }



    
}
