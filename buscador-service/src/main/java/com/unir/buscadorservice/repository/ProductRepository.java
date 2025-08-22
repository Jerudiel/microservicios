package com.unir.buscadorservice.repository;

import com.unir.buscadorservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

