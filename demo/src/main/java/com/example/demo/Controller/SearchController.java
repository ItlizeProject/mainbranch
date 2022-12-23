package com.example.demo.Controller;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProductType;
import com.example.demo.Entity.TechnicalDetail;
import com.example.demo.Service.DescriptionService;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.ProductTypeService;
import com.example.demo.Service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/search")
public class SearchController {
    // Structure of this controller:
    // 1 Retrieving Products (Search for products)
    // 2 Previous codes in Description, ProductType and TechnicalDetail Controller

    @Autowired ProductService productService;

    @GetMapping("/advanced-search")
    public ResponseEntity<?> findProductByAdvancedSearch(@RequestParam(value = "type", required = false) String type,
                                                         @RequestParam(value = "mountingLocation", required = false) String location,
                                                         @RequestParam(value = "application", required = false) String app,
                                                         @RequestParam(value = "accessories", required = false) String accs,
                                                         @RequestParam(value = "modelYear", required = false) Integer year1,
                                                         @RequestParam(value = "modelYear", required = false) Integer year2,
                                                         @RequestParam(value = "airflow", required = false) Integer para1,
                                                         @RequestParam(value = "modelYear", required = false) Integer para2,
                                                         @RequestParam(value = "power", required = false) Integer para3,
                                                         @RequestParam(value = "modelYear", required = false) Integer para4,
                                                         @RequestParam(value = "productBrand",required = false) String brand) {
        List<Product> list1 = productService.findByProductTypeType(type);
        List<Product> list2 = productService.findByProductTypeMountingLocation(location);
        List<Product> list3 = productService.findByProductTypeApplication(app);
        List<Product> list4 = productService.findByProductTypeAccessories(accs);
        List<Product> list5 = productService.findByProductTypeModelYearBetween(year1, year2);
        List<Product> list6 = productService.findByTechnicalDetailAirflowBetween(para1, para2);
        List<Product> list7 = productService.findByTechnicalDetailPowerBetween(para3, para4);
        List<Product> list8 = productService.findProductByProductBrand(brand);

        List<Product> joinedList = new ArrayList<>();
        Stream.of(list1,list2,list3,list4,list5,list6,list7,list8).forEach(joinedList::addAll);
        List<Product> uniqueJoinedList = joinedList.stream().distinct().collect(Collectors.toList());

        if (uniqueJoinedList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(uniqueJoinedList, HttpStatus.OK);
    }

    @GetMapping("/product-by-id")
    public ResponseEntity<?> findProductById(@RequestParam("productId") Integer id) {
        Product product =  productService.findProductById(id);
        if (product == null) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/product-by-brand")
    public ResponseEntity<?> findProductByProductBrand(@RequestParam("productBrand") String brand) {
        List<Product> productList = productService.findProductByProductBrand(brand);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-by-certification")
    public ResponseEntity<?> findProductByCertification(@RequestParam("certification") String certification) {
        List<Product> productList = productService.findByCertification(certification);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }


    //**********
    // Description Controller
    //**********
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

    //hint:addDescription method need to ask client to input productId because any changes to Description table can be thought as
    // change to Product table, the productID is used as a connection between two table.
    @PostMapping("/createDescription")
    public ResponseEntity<?> addDescription(@RequestParam("productId") Integer id,
                                            @RequestParam("manufacturer") String manufacturer,
                                            @RequestParam("series") String series,
                                            @RequestParam("model") String model){

        Description description1 = new Description();
        description1.setManufacturer(manufacturer);
        description1.setSeries(series);
        description1.setModel(model);

        Product product1 = productService.findProductById(id);//find product by id
        description1.setProduct(product1);//put product into  description
        Description res = descriptionService.createDescription(description1);//put description data into database
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
    public ResponseEntity<?> deleteDescription(@RequestParam("id") Integer id) {
        Description description = descriptionService.findDescriptionByDescriptionId(id);
        if (description == null) {
            return new ResponseEntity<>("{\"error\":\"description not found!\"}", HttpStatus.NOT_FOUND);
        }
        String s = descriptionService.deleteDescriptionByDescriptionId(id);
        return new ResponseEntity<>(description, HttpStatus.OK);
    }
    //**********
    // ProductType Controller
    //**********
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
    //**********
    // TechnicalDetail Controller
    //**********

    @Autowired
    private TechnicalDetailService service;
    //    TechnicalDetail createDetail(TechnicalDetail detail);
    @PostMapping ("/tech-details/create")
    public ResponseEntity<?> createDetail(@RequestParam("airflow") Integer airflow,
                                          @RequestParam("power") Integer power,
                                          @RequestParam("operatingVoltage") Integer operatingVoltage,
                                          @RequestParam("fanSpeed") Integer fanSpeed) {
        TechnicalDetail detail = new TechnicalDetail(airflow, power, operatingVoltage, fanSpeed);
        return new ResponseEntity<>(service.createDetail(detail), HttpStatus.CREATED);
    }
    //    String deleteDetailById(Integer id);
    @DeleteMapping("/tech-details/delete")
    public String deleteDetailById(@RequestParam("technicalDetailId") Integer id) {
        return service.deleteDetailById(id);
    }
    //    TechnicalDetail findDetailById(Integer id);
    @GetMapping("/tech-details-by-id")
    public ResponseEntity<?> findDetailById(@RequestParam("technicalDetailId") Integer id) {
        TechnicalDetail detail = service.findDetailById(id);
        if (detail == null) {
            return new ResponseEntity<>("{\"error\":\"Detail not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }
    // Retrieving Products By Technical Details
    @GetMapping("/product-by-airflow")
    public ResponseEntity<?> findProductByAirflowBetween(@RequestParam("airflow") Integer para1,
                                                         @RequestParam("airflow") Integer para2) {
        List<Product> productList = productService.findByTechnicalDetailAirflowBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-by-power")
    public ResponseEntity<?> findProductByPowerBetween(@RequestParam("power") Integer para1,
                                                       @RequestParam("power") Integer para2) {
        List<Product> productList = productService.findByTechnicalDetailPowerBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-by-operating-voltage")
    public ResponseEntity<?> findProductByOperatingVoltageBetween(@RequestParam("operatingVoltage") Integer para1,
                                                                  @RequestParam("operatingVoltage") Integer para2) {
        List<Product> productList = productService.findByTechnicalDetailOperatingVoltageBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-by-fan-speed")
    public ResponseEntity<?> findProductByFanSpeedBetween(@RequestParam("fanSpeed") Integer para1,
                                                          @RequestParam("fanSpeed") Integer para2) {
        List<Product> productList = productService.findByTechnicalDetailFanSpeedBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}


