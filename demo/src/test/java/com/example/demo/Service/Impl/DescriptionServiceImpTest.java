package com.example.demo.Service.Impl;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Service.DescriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class DescriptionServiceImpTest {
    @Autowired
    private DescriptionService descriptionService;//Q:why don't use DescriptionServiceImp descriptionServiceImp;? how to name it,object?

    @Test
    void createDescription() {
        Description description = new Description();
        description.setManufacturer("testManufacturer4");
        description.setModel("testModel4");
        description.setSeries("series4");

        Product product = new Product();//set product table date from description
        product.setProductBrand("Emerson");
        description.setProduct(product);

        System.out.println(description.toString());
        descriptionService.createDescription(description);//database save the description object and create a tuple in db
        Assertions.assertEquals(descriptionService.findDescriptionByDescriptionId(2).getManufacturer(), description.getManufacturer());
    }


    @Test
    void findDescriptionByDescriptionId() {
        Description res = descriptionService.findDescriptionByDescriptionId(1);
        Assertions.assertEquals("Description{descriptionId=1, manufacturer='testManufacturer1', series='null', model='testModel1', product=null}", res.toString());
    }

    @Test
    void findDescriptionByProductId() {
        Product product = new Product();
        product.setProductBrand("Minka");
        product.setProductId(1);
        Description res = descriptionService.findDescriptionByProduct(product);
//        System.out.println(res);
        Assertions.assertEquals("Description{descriptionId=1, manufacturer='testManufacturer3', series='series3', model='testModel3', product=Product{productId=1, projectProduct=[], productType=null, technicalDetail=null, description=null, productBrand='Minka', certification='null'}}"
        , res.toString());


    }

    @Test
    void findAll() {
        List<Description> list = descriptionService.findAll();
//        System.out.println(list);
        Assertions.assertEquals("run System.out.println(list; and copy-paste the print here", list.toString());


    }

    @Test
    void deleteDescriptionByDescriptionId() {//test it
        descriptionService.deleteDescriptionByDescriptionId(2);
        System.out.println("The line with id =" + 2 + "has been removed");

    }

    @Test
    void findDescriptionByManufacturer() {
        List<Description> list = descriptionService.findDescriptionByManufacturer("testManufacturer3");
        System.out.println(list.toString());
        Assertions.assertEquals("[Description{descriptionId=1, manufacturer='testManufacturer3', series='series3', model='testModel3', product=Product{productId=1, projectProduct=[], productType=null, technicalDetail=null, description=null, productBrand='Minka', certification='null'}}]", list.toString());
    }

    @Test
    void findDescriptionBySeries() {
        List<Description> list = descriptionService.findDescriptionBySeries("series3");
        System.out.println(list.toString());
        Assertions.assertEquals("[Description{descriptionId=1, manufacturer='testManufacturer3', series='series3', model='testModel3', product=Product{productId=1, projectProduct=[], productType=null, technicalDetail=null, description=null, productBrand='Minka', certification='null'}}]", list.toString());
    }

    @Test
    void findDescriptionByModel() {
        List<Description> list = descriptionService.findDescriptionByModel("testModel3");
        System.out.println(list.toString());
        Assertions.assertEquals("[Description{descriptionId=1, manufacturer='testManufacturer3', series='series3', model='testModel3', product=Product{productId=1, projectProduct=[], productType=null, technicalDetail=null, description=null, productBrand='Minka', certification='null'}}]", list.toString());
    }
}