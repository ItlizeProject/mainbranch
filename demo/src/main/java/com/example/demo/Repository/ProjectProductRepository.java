package com.example.demo.Repository;

import com.example.demo.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Long>{
    Optional<ProjectProduct> findProjectProductById(long id);

    Optional<ProjectProduct> findProjectProductByProductId(long id);
    Optional<ProjectProduct> findProjectProductByProjectId(long id);
}
