package com.example.demo.Controller;

import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.DescriptionRepository;
import com.example.demo.Service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

//Controller Layer
@RestController//= @ResponseBody+@Controller, 表明当前类是控制器且返回的是一组数据，不是跳转页面
@RequestMapping("/descriptionController")//right?need"/" or not?
public class DescriptionController {
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
}
