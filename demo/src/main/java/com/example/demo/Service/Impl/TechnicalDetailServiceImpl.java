package com.example.demo.Service.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;
import com.example.demo.Repository.TechnicalDetailRepository;
import com.example.demo.Service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalDetailServiceImpl implements TechnicalDetailService {
    @Autowired
    private TechnicalDetailRepository technicalDetailRepository;

    @Override
    public TechnicalDetail createDetail(TechnicalDetail detail) {
        return technicalDetailRepository.save(detail);
    }

    @Override
    public String deleteDetailById(Integer id) {
        technicalDetailRepository.deleteById(id);
        return "Technical details " + id + " has been deleted.";
    }

    @Override
    public TechnicalDetail findDetailById(Integer id) {
        return technicalDetailRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<List<TechnicalDetail>> findProductByAirflowBetween(Integer para1, Integer para2) {
        return technicalDetailRepository.findProductByAirflowBetween(para1, para2);
    }

    @Override
    public Optional<List<TechnicalDetail>> findProductByPowerBetween(Integer para1, Integer para2) {
        return technicalDetailRepository.findProductByPowerBetween(para1, para2);
    }

    @Override
    public Optional<List<TechnicalDetail>> findProductByVoltageBetween(Integer para1, Integer para2) {
        return technicalDetailRepository.findProductByOperatingVoltageBetween(para1, para2);
    }

    @Override
    public Optional<List<TechnicalDetail>> findProductByFanSpeedBetween(Integer para1, Integer para2) {
        return technicalDetailRepository.findProductByFanSpeedBetween(para1, para2);
    }

}