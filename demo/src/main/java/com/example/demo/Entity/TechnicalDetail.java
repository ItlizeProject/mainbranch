package com.example.demo.Entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TechnicalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technical_detail_id", unique = true)
    private Integer technicalDetailID;

    // @Column(name = "product_id")
    // private Integereger productID;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "productId", referencedColumnName = "product_id")
    private Product product;

    public TechnicalDetail() {
    }
    public TechnicalDetail (Integer airflow, Integer power, Integer operatingVoltage, Integer fanSpeed) {
        this.airflow = airflow;
        this.power = power;
        this.operatingVoltage = operatingVoltage;
        this.fanSpeed = fanSpeed;
    }

    @Column(name = "airflow")
    private Integer airflow;
    @Column(name = "power")
    private Integer power;
    @Column(name = "operating_voltage")
    private Integer operatingVoltage;
    @Column(name = "fan_speed")
    private Integer fanSpeed;

    public Integer getTechnicalDetailID() {
        return technicalDetailID;
    }

    public void setTechnicalDetailID (Integer technicalDetailID) {
        this.technicalDetailID = technicalDetailID;
    }

    // public Integereger getProductID() {
    //     return productID;
    // }

    // public void setProductID Integereger productID) {
    //     this.productID = productID;
    // }

    public Integer getAirflow() {
        return airflow;
    }

    public void setAirflow (Integer airflow) {
        this.airflow = airflow;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getOperatingVoltage() {
        return operatingVoltage;
    }

    public void setOperatingVoltage (Integer operatingVoltage) {
        this.operatingVoltage = operatingVoltage;
    }

    public Integer getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed (Integer fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "TechnicalDetail{" +
                "technicalDetailID=" + technicalDetailID +
                ", product=" + product +
                ", airflow=" + airflow +
                ", power=" + power +
                ", operatingVoltage=" + operatingVoltage +
                ", fanSpeed=" + fanSpeed +
                '}';
    }
}