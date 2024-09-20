package com.example.test0914.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test0914.entity.ReciptProducts;

public interface ReciptProductsRepository extends JpaRepository<ReciptProducts, Long> {
    List<ReciptProducts> findByRecipt_rctId(Long rctId) throws Exception;

}
