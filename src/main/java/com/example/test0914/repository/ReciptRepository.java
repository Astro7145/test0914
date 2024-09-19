package com.example.test0914.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test0914.entity.Recipt;

@Repository
public interface ReciptRepository extends JpaRepository<Recipt, Long>{

}
