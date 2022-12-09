package com.example.demo.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TechnicalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technical_detail_id", unique = true)
    private long technicalDetailID;

    // @Column(name = "product_id")
    // private long productID;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "productId", referencedColumnName = "product_id")
    private Product product;

    public TechnicalDetail() {
    }
    public TechnicalDetail(int airflow, int power, int operatingVoltage, int fanSpeed) {
        this.airflow = airflow;
        this.power = power;
        this.operatingVoltage = operatingVoltage;
        this.fanSpeed = fanSpeed;
    }

    @Column(name = "airflow")
    private int airflow;
    @Column(name = "power")
    private int power;
    @Column(name = "operating_voltage")
    private int operatingVoltage;
    @Column(name = "fan_speed")
    private int fanSpeed;

    public long getTechnicalDetailID() {
        return technicalDetailID;
    }

    public void setTechnicalDetailID(long technicalDetailID) {
        this.technicalDetailID = technicalDetailID;
    }

    // public long getProductID() {
    //     return productID;
    // }

    // public void setProductID(long productID) {
    //     this.productID = productID;
    // }

    public int getAirflow() {
        return airflow;
    }

    public void setAirflow(int airflow) {
        this.airflow = airflow;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getOperatingVoltage() {
        return operatingVoltage;
    }

    public void setOperatingVoltage(int operatingVoltage) {
        this.operatingVoltage = operatingVoltage;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}