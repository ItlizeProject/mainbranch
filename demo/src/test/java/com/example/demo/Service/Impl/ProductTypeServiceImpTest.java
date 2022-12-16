package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
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
        productType.setApplication("Indoor");
        productType.setType("Residential");
        productType.setMountingLocation("Free standing");
        productType.setAccessories("With light");
        productType.setModelYear(2010);//Integer type

        Product product = new Product();//set product table's data via productType
        product.setProductBrand("Emerson");
        productType.setProduct(product);

        productTypeService.createProductType(productType);
//        System.out.println(productType.toString());
        //change the blow id when u test it!
        Assertions.assertEquals(productTypeService.findProductTypeByProductTypeId(3).getApplication(), productType.getApplication());
    }

    @Test
    void findProductTypeByProduct() {
        //create product object and input data
        Product product = new Product();
        product.setProductBrand("Emerson");
        product.setProductId(2);
        //based on the product data to retrieve ProductType(= database tuple)
        ProductType res = productTypeService.findProductTypeByProduct(product);
//        System.out.println(res);
        Assertions.assertEquals("ProductType{productTypeId=3, application='Indoor', type='Residential', mountingLocation='Free standing', accessories='With light', modelYear=2010, product=Product{productId=2, projectProduct=[], productType=null, technicalDetail=null, description=null, productBrand='Emerson', certification='null'}}"
        , res.toString());

    }

    @Test
    void findAll() {
        List<ProductType> list = productTypeService.findAll();
//        System.out.println(list);
        Assertions.assertEquals("run System.out.println(list); and copy-paste the print here", list.toString());
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
        List<ProductType> list = productTypeService.findProductTypeByModelYear(2010);//Date
//        System.out.println(list);
        Assertions.assertEquals("[ProductType{productTypeId=1, application='Indoor', type='Residential', mountingLocation='Free standing', accessories='With light', modelYear=2010, product=null}, " +
                "ProductType{productTypeId=2, application='Indoor', type='Residential', mountingLocation='Free standing', accessories='With light', modelYear=2010, product=null}]"
        , list.toString());
    }
}