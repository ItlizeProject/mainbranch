package com.example.demo.Controller;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestParam("productBrand") String brand,
                                           @RequestParam("certification") String certification) {
        Product product = new Product();
        product.setProductBrand(brand);
        product.setCertification(certification);

        Product newProduct = service.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public String deleteProductById(@RequestParam("productId") Integer id) {
        return service.deleteProductById(id);
    }

//    @GetMapping("/product-list")
//    public ResponseEntity<?> findAllProduct() {
//        List<Product> productList = service.findAllProduct();
//        if (productList.isEmpty()) {
//            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }
//
//    @GetMapping("/product-by-id")
//    public ResponseEntity<?> findProductById(@RequestParam("id") Integer id) {
//        Product product = service.findProductById(id);
//        if (product == null) {
//            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @GetMapping("/product-by-brand")
//    public ResponseEntity<?> findProductByProductBrand(@RequestParam("brand") String brand) {
//        List<Product> productList = service.findProductByProductBrand(brand);
//        if (productList.isEmpty()) {
//            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }
//
//    @GetMapping("/product-by-certification")
//    public ResponseEntity<?> findProductByCertification(@RequestParam("certification") String certification) {
//        List<Product> productList = service.findByCertification(certification);
//        if (productList.isEmpty()) {
//            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }


}

