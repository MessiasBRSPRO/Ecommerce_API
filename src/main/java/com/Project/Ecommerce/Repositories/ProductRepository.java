package com.Project.Ecommerce.Repositories;

import com.Project.Ecommerce.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
