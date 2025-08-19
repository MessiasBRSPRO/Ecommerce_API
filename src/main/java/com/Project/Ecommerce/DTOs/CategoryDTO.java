package com.Project.Ecommerce.DTOs;

import com.Project.Ecommerce.Entities.Category;

public record CategoryDTO(Long id) {

    public CategoryDTO(Category category){
        this(category.getId());
    }
}
