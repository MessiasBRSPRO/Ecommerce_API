package com.Project.Ecommerce.DTOs;

import com.Project.Ecommerce.Entities.Product;

public record DTOListedProduct(Long id, String productName, Double price) {

    public DTOListedProduct(Product product){
        this(product.getId(), product.getProductName(), product.getPrice());
    }
}
