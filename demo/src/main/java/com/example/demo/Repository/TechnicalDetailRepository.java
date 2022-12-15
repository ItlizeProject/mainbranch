package com.example.demo.Repository;

import com.example.demo.Entity.TechnicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TechnicalDetailRepository extends JpaRepository {
    Optional<List<TechnicalDetail>> findProductByAirflowBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByPowerBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByOperatingVoltageBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByFanSpeedBetween(Integer para1, Integer para2);
}

