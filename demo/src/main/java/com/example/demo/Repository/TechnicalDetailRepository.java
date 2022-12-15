package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TechnicalDetailRepository extends JpaRepository<TechnicalDetail, Integer> {

}