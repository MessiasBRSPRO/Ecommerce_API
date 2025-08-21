package com.Project.Ecommerce.DTOs;

import com.Project.Ecommerce.Entities.Category;
import com.Project.Ecommerce.Entities.Product;
import jakarta.validation.constraints.NotNull;

public record DTOUpdatedProduct(
        @NotNull
        Long id,

        String updatedProductName,
        Double updatedPrice,
        String updatedDecription,
        Category updatedCategory){

    public DTOUpdatedProduct(Product product){
        this(product.getId(), product.getProductName(), product.getPrice(), product.getDecription(), product.getCategory());
    }
}
