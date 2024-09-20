package com.example.test0914.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test0914.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    Products findByProdSerial(Long serial) throws Exception;
}
