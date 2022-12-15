package com.example.demo.Repository;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer>{

    Optional<ProjectProduct> findByProduct(Integer id);
    Optional<ProjectProduct> findByProject(Integer id);

    //    find ProjectProductList
    //    Optional<List<ProjectProduct>> findListByProject(Project project);
    //    Optional<List<ProjectProduct>> findListByProduct(Project project);
}
