package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;
import com.example.demo.Repository.TechnicalDetailRepository;
import com.example.demo.Service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicalDetailServiceImpl implements TechnicalDetailService {
//    @Autowired
    private TechnicalDetailRepository technicalDetailRepository;

    @Override
    public TechnicalDetail createDetail(TechnicalDetail detail) {
        return technicalDetailRepository.save(detail);
    }

    @Override
    public void deleteDetailById(Integer id) {
        technicalDetailRepository.deleteById(id);
    }

    @Override
    public TechnicalDetail findDetailById(Integer id) {
        return technicalDetailRepository.findById(id).orElse(null);
    }

}
