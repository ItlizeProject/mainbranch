package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Description;

import java.util.*;

public interface DescriptionRepository extends JpaRepository<Description, Integer>{

    // 声明repository的methods（写了名字之后jpa会自动帮我实现）

    Optional<Description> findBy(Integer id);
    Optional<Description> findByProductId(Integer id);
    Optional<List<Description>> findByManufacturer(String manufacturer);//user可以通过输入manufacturer来查询所有相关的description tuple

    Optional<List<Description>> findBySeries(String series);

    Optional<List<Description>> findByModel(String model);

}
