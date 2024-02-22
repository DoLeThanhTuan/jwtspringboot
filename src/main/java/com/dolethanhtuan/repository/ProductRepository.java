package com.dolethanhtuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolethanhtuan.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
