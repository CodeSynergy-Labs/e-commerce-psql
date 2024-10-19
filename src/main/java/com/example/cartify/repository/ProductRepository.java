package com.example.cartify.repository;

import com.example.cartify.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {

    boolean existsByName(String name);

}
