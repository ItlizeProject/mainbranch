package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;

import java.util.Optional;

public interface TechnicalDetailService {
    TechnicalDetail createDetail(TechnicalDetail detail);
    void deleteDetailById(Integer id);
    TechnicalDetail findDetailById(Integer id);
}
