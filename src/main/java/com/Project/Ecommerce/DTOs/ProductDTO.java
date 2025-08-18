package com.Project.Ecommerce.DTOs;

import com.Project.Ecommerce.Entities.Product;
import com.Project.Ecommerce.Repositories.ProductRepository;

public record ProductDTO(Long id, String productName, Double price, Integer stock, String decription) {
    public ProductDTO(Product product){
        this(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getStock(),
                product.getDecription());
    }
}
