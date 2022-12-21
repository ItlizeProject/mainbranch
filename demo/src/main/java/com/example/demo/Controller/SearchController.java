package com.example.demo.Controller;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProductType;
import com.example.demo.Entity.TechnicalDetail;
import com.example.demo.Service.DescriptionService;
import com.example.demo.Service.ProductTypeService;
import com.example.demo.Service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/serach")
public class SearchController {
    // Description
    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/description")
    public ResponseEntity<?> listAllDescription() {//to findAll

        List<Description> list = descriptionService.findAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"description not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);//返回两个内容，后一个是HttpStatus code
    }

    @GetMapping("/getDescriptionById")
    public ResponseEntity<?> getDescriptionById(@RequestParam("id") Integer id) {//@RequestParam:extract value from the request URI
        Description description = descriptionService.findDescriptionByDescriptionId(id);
        if (description == null) {
            return new ResponseEntity<>("{\"error\":\"description not found by id!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(description, HttpStatus.OK);
    }

    @PostMapping("/createDescription")//add mapping
    public ResponseEntity<?> addDescription(@RequestParam("manufacturer") String manufacturer,
                                            @RequestParam("series") String series,
                                            @RequestParam("model") String model){//need product_id?

        Description description1 = new Description();
        description1.setManufacturer(manufacturer);
        description1.setSeries(series);
        description1.setModel(model);
        Description res = descriptionService.createDescription(description1);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/getDescriptionByManufacturer")
    public ResponseEntity<?> getDescriptionByManufacturer(@RequestParam("manufacturer") String manufacturer) {
        List<Description> list = descriptionService.findDescriptionByManufacturer(manufacturer);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"description not found by manufacturer!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDescriptionBySeries")
    public ResponseEntity<?> getDescriptionBySeries(@RequestParam("series") String series) {
        List<Description> list = descriptionService.findDescriptionBySeries(series);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"description not found by series!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDescriptionByModel")
    public ResponseEntity<?> getDescriptionByModel(@RequestParam("model") String model) {
        List<Description> list = descriptionService.findDescriptionByModel(model);
        if (list.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"description not found by model!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDescriptionByProduct")
    public ResponseEntity<?> getDescriptionByProduct(@RequestParam("product") Product product) {
        Description description1 = descriptionService.findDescriptionByProduct(product);
        if (description1 == null) {
            return new ResponseEntity<>("{\"error\":\"description not found by product!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(description1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDescription")
    public ResponseEntity<?> deleteDescription(@RequestParam Integer id) {
        Description description = descriptionService.findDescriptionByDescriptionId(id);
        if (description == null) {
            return new ResponseEntity<>("{\"error\":\"description not found!\"}", HttpStatus.NOT_FOUND);
        }
        String s = descriptionService.deleteDescriptionByDescriptionId(id);
        return new ResponseEntity<>(description, HttpStatus.OK);
    }

// Product Type

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

    // Technical Detail

    @Autowired
    private TechnicalDetailService techservice;

    @PostMapping ("/tech-details/create")
    public ResponseEntity<?> createDetail(@RequestParam("airflow") Integer airflow,
                                          @RequestParam("power") Integer power,
                                          @RequestParam("operatingVoltage") Integer operatingVoltage,
                                          @RequestParam("fanSpeed") Integer fanSpeed) {
        TechnicalDetail detail = new TechnicalDetail(airflow, power, operatingVoltage, fanSpeed);
        return new ResponseEntity<>(techservice.createDetail(detail), HttpStatus.CREATED);
    }

    @DeleteMapping("/tech-details/delete")
    public String deleteDetailById(@RequestParam("id") Integer id) {
        return techservice.deleteDetailById(id);
    }

    @GetMapping("/tech-details-by-id")
    public ResponseEntity<?> findDetailById(@RequestParam("id") Integer id) {
        TechnicalDetail detail = techservice.findDetailById(id);
        if (detail == null) {
            return new ResponseEntity<>("{\"error\":\"Detail not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @GetMapping("/product-by-airflow")
    public ResponseEntity<?> findProductByAirflowBetween(@RequestParam("para1") Integer para1,
                                                         @RequestParam("para2") Integer para2) {
        List<TechnicalDetail> productList = techservice.findProductByAirflowBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-by-power")
    public ResponseEntity<?> findProductByPowerBetween(@RequestParam("para1") Integer para1,
                                                       @RequestParam("para2") Integer para2) {
        List<TechnicalDetail> productList = techservice.findProductByPowerBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-by-operating-voltage")
    public ResponseEntity<?> findProductByOperatingVoltageBetween(@RequestParam("para1") Integer para1,
                                                                  @RequestParam("para2") Integer para2) {
        List<TechnicalDetail> productList = techservice.findProductByOperatingVoltageBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-by-fan-speed")
    public ResponseEntity<?> findProductByFanSpeedBetween(@RequestParam("para1") Integer para1,
                                                          @RequestParam("para2") Integer para2) {
        List<TechnicalDetail> productList = techservice.findProductByFanSpeedBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}


