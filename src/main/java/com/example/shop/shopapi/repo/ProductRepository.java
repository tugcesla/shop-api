package com.example.shop.shopapi.repo;

import com.example.shop.shopapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
