package com.example.demo.Service.Impl;

import com.example.demo.Entity.ProductType;
import com.example.demo.Service.ProductTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductTypeServiceImpTest {
    @Autowired
    ProductTypeService productTypeService;
    @Test
    void createProductType() {
        ProductType productType = new ProductType();
        productType.setApplication("Outdoor");
        productType.setType("Industrial");
        productType.setMountingLocation("Wall");
        productType.setAccessories("Without light");
        //Q:how to set model_year?
        productTypeService.createProductType(productType);
//        System.out.println(productType.toString());
        Assertions.assertEquals(productTypeService.findProductTypeByProductTypeId(3).getApplication(), productType.getApplication());
    }

    @Test
    void findProductTypeByProductId() {
    }

    @Test
    void findAll() {
        List<ProductType> list = productTypeService.findAll();
//        System.out.println(list);
        Assertions.assertEquals("[ProductType{productTypeId=1, application='Indoor', type='Commercial', mountingLocation='Roof', accessories='With light', modelYear=null, product=null}," +
                " ProductType{productTypeId=2, application='Indoor', type='Commercial', mountingLocation='Roof', accessories='With light', modelYear=null, product=null}]"
                , list.toString());
    }

    @Test
    void deleteProductTypeByProductTypeId() {
        productTypeService.deleteProductTypeByProductTypeId(1);
        System.out.println("The line with id =" + 1 + "has been removed");
    }

    @Test
    void findProductTypeByApplication() {
        List<ProductType> list = productTypeService.findProductTypeByApplication("Outdoor");
//        System.out.println(list);
        Assertions.assertEquals("[ProductType{productTypeId=3, application='Outdoor', type='Industrial', mountingLocation='Wall', accessories='Without light', modelYear=null, product=null}]"
                , list.toString());
    }

    @Test
    void findProductTypeByType() {
        List<ProductType> list = productTypeService.findProductTypeByType("Industrial");
//        System.out.println(list);
        Assertions.assertEquals("[ProductType{productTypeId=3, application='Outdoor', type='Industrial', mountingLocation='Wall', accessories='Without light', modelYear=null, product=null}]"
                , list.toString());
    }

    @Test
    void findProductTypeByMountingLocation() {
        List<ProductType> list = productTypeService.findProductTypeByMountingLocation("Wall");
//        System.out.println(list);
        Assertions.assertEquals("[ProductType{productTypeId=3, application='Outdoor', type='Industrial', mountingLocation='Wall', accessories='Without light', modelYear=null, product=null}]"
                , list.toString());
    }

    @Test
    void findProductTypeByAccessories() {
        List<ProductType> list = productTypeService.findProductTypeByAccessories("Without light");
//        System.out.println(list);
        Assertions.assertEquals("[ProductType{productTypeId=3, application='Outdoor', type='Industrial', mountingLocation='Wall', accessories='Without light', modelYear=null, product=null}]"
                , list.toString());
    }

    @Test
    void findProductTypeByModelYear() {
    }
}