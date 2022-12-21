package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;
import com.example.demo.Service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technical-details")
public class TechnicalDetailController {

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
    public String deleteDetailById(@RequestParam("id") Integer id) {
        return service.deleteDetailById(id);
    }
//    TechnicalDetail findDetailById(Integer id);
    @GetMapping("/tech-details-by-id")
    public ResponseEntity<?> findDetailById(@RequestParam("id") Integer id) {
    TechnicalDetail detail = service.findDetailById(id);
    if (detail == null) {
        return new ResponseEntity<>("{\"error\":\"Detail not found!\"}", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(detail, HttpStatus.OK);
    }
//    List<TechnicalDetail> findProductByAirflowBetween(Integer para1, Integer para2);
    @GetMapping("/product-by-airflow")
    public ResponseEntity<?> findProductByAirflowBetween(@RequestParam("para1") Integer para1,
                                                         @RequestParam("para2") Integer para2) {
        List<TechnicalDetail> productList = service.findProductByAirflowBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
//    List<TechnicalDetail> findProductByPowerBetween(Integer para1, Integer para2);
    @GetMapping("/product-by-power")
    public ResponseEntity<?> findProductByPowerBetween(@RequestParam("para1") Integer para1,
                                                                           @RequestParam("para2") Integer para2) {
        List<TechnicalDetail> productList = service.findProductByPowerBetween(para1, para2);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
//    List<TechnicalDetail> findProductByOperatingVoltageBetween(Integer para1, Integer para2);
    @GetMapping("/product-by-operating-voltage")
    public ResponseEntity<?> findProductByOperatingVoltageBetween(@RequestParam("para1") Integer para1,
                                                                                      @RequestParam("para2") Integer para2) {
    List<TechnicalDetail> productList = service.findProductByOperatingVoltageBetween(para1, para2);
    if (productList.isEmpty()) {
        return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(productList, HttpStatus.OK);
}
//    List<TechnicalDetail> findProductByFanSpeedBetween(Integer para1, Integer para2);
    @GetMapping("/product-by-fan-speed")
    public ResponseEntity<?> findProductByFanSpeedBetween(@RequestParam("para1") Integer para1,
                                                                              @RequestParam("para2") Integer para2) {
    List<TechnicalDetail> productList = service.findProductByFanSpeedBetween(para1, para2);
    if (productList.isEmpty()) {
        return new ResponseEntity<>("{\"error\":\"Product not found!\"}", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(productList, HttpStatus.OK);
}
}
