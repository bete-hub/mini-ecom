package com.betemariam.miniecom.repository;
import com.betemariam.miniecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {}

