package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Description;

import java.util.*;

public interface DescriptionRepository extends JpaRepository<Description, Integer>{

    // 声明repository的methods（写了名字之后jpa会自动帮我实现,起名很关键，比如写findByProductId，Jpa就会自动帮我实现通过ProductId在Description这张table里
    // 查找符合要求的tuple）
    //下面这些内容本质上定义了我想给用户提供的用来搜索整张Description table的index（比如manufacturer是Description表的一个attribute。本身对于表来说查找所用的
    // index应该是primary key。但是我想给user提供一个通过输入Manufacturer,找到表里对应符合要求的tuple的功能，所以我在这里写了findByManufacturer这个方法）

    //Optional<Description> findBy(Integer id);
    Optional<Description> findByProductId(Integer id);
    Optional<List<Description>> findByManufacturer(String manufacturer);//user可以通过输入manufacturer来查询所有相关的description tuple

    Optional<List<Description>> findBySeries(String series);

    Optional<List<Description>> findByModel(String model);

}
