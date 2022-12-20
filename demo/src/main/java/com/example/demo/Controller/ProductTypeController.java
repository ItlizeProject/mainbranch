package com.example.demo.Controller;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.ProductType;
import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/productTypeController")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/productType")
    public ResponseEntity<?> listAllProductType() {
        List<ProductType> list = productTypeService.findAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"productType not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("getProductTypeById")
    public ResponseEntity<?> getProductTypeById(@RequestParam("id") Integer id) {
        ProductType productType = productTypeService.findProductTypeByProductTypeId(id);
        if (productType == null) {
            return new ResponseEntity<>("{\"error\":\"productType not found by id!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productType, HttpStatus.OK);
    }

    @PostMapping("createProductType")
    public ResponseEntity<?> addProductType(@RequestParam("application") String application,
                                            @RequestParam("type") String type,
                                            @RequestParam("mountingLocation") String mountingLocation,
                                            @RequestParam("accessories") String accessories,
                                            @RequestParam("modelYear") Integer modelYear) {//need product_id?
        ProductType productType1 = new ProductType();
        productType1.setApplication(application);
        productType1.setType(type);
        productType1.setMountingLocation(mountingLocation);
        productType1.setAccessories(accessories);
        productType1.setModelYear(modelYear);
        ProductType res = productTypeService.createProductType(productType1);
        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    @GetMapping("getProductTypeByProduct")
    public ResponseEntity<?> getProductTypeByProduct(@RequestParam("product") Product product) {
        ProductType productType1 = productTypeService.findProductTypeByProduct(product);
        if (productType1 == null) {
            return new ResponseEntity<>("{\"error\":\"productType not found by product!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productType1, HttpStatus.OK);
    }

    @GetMapping("getProductTypeByApplication")
    public ResponseEntity<?> getProductTypeByApplication(@RequestParam("application") String application) {
        List<ProductType> list = productTypeService.findProductTypeByApplication(application);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"productType not found by application!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("getProductTypeByType")
    public ResponseEntity<?> getProductTypeByType(@RequestParam("type") String type) {
        List<ProductType> list = productTypeService.findProductTypeByType(type);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"productType not found by type!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("getProductTypeByMountingLocation")
    public ResponseEntity<?> getProductTypeByMountingLocation(@RequestParam("mountingLocation") String mountingLocation) {
        List<ProductType> list = productTypeService.findProductTypeByMountingLocation(mountingLocation);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"productType not found by mounting location!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("getProductTypeByAccessories")
    public ResponseEntity<?> getProductTypeByAccessories(@RequestParam("accessories") String accessories) {
        List<ProductType> list = productTypeService.findProductTypeByAccessories(accessories);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"productType not found by accessories!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("getProductTypeByModelYear")
    public ResponseEntity<?> getProductTypeByModelYear(@RequestParam("modelYear") Integer modelYear) {
        List<ProductType> list = productTypeService.findProductTypeByModelYear(modelYear);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"productType not found by model year!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductType")
    public ResponseEntity<?> deleteProductType(@RequestParam("id") Integer id) {
        ProductType productType = productTypeService.findProductTypeByProductTypeId(id);
        if (productType == null) {
            return new ResponseEntity<>("{\"error\":\"productType not found!\"}", HttpStatus.NOT_FOUND);
        }
        String s = productTypeService.deleteProductTypeByProductTypeId(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

}
