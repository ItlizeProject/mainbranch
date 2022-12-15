package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.TechnicalDetail;
import org.hibernate.boot.registry.classloading.internal.TcclLookupPrecedence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Repository
public interface TechnicalDetailRepository extends JpaRepository<TechnicalDetail, Integer> {
    Optional<List<TechnicalDetail>> findProductByAirflowBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByPowerBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByOperatingVoltageBetween(Integer para1, Integer para2);
    Optional<List<TechnicalDetail>> findProductByFanSpeedBetween(Integer para1, Integer para2);
}