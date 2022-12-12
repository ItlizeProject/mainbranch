package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TechnicalDetailRepository extends JpaRepository<TechnicalDetail, Long> {

}