package com.example.demo.Service;

import com.example.demo.Entity.TechnicalDetail;
import com.example.demo.Repository.TechnicalDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicalDetailServiceImpl implements TechnicalDetailService {
    private final TechnicalDetailRepository technicalDetailRepository;

    public TechnicalDetailServiceImpl(TechnicalDetailRepository technicalDetailRepository) {
        this.technicalDetailRepository = technicalDetailRepository;
    }

    @Override
    public TechnicalDetail createDetail(TechnicalDetail detail) {
        return technicalDetailRepository.save(detail);
    }

    @Override
    public String deleteDetailById(Long id) {
        technicalDetailRepository.deleteById(id);
        return id + "has been deleted.";
    }

    @Override
    public TechnicalDetail findDetailById(Long id) {
        return technicalDetailRepository.findById(id).orElse(null);
    }
}
