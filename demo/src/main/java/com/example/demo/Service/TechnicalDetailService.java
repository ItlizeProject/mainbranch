package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;

import java.util.List;
import java.util.Optional;

public interface TechnicalDetailService {
    TechnicalDetail createDetail(TechnicalDetail detail);
    String deleteDetailById(Integer id);
    TechnicalDetail findDetailById(Integer id);
    Optional<List<TechnicalDetail>> findProductByAirflowBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByPowerBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByOperatingVoltageBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByFanSpeedBetween(Integer para1, Integer para2);
}