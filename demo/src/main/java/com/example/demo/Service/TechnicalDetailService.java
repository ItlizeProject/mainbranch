package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;

public interface TechnicalDetailService {
    TechnicalDetail createDetail(TechnicalDetail detail);
    String deleteDetailById(Long id);
    TechnicalDetail findDetailById(Long id);
}
