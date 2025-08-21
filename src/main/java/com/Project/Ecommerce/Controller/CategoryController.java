package com.Project.Ecommerce.Controller;

import com.Project.Ecommerce.Entities.Category;
import com.Project.Ecommerce.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> allCategories(){
        return ResponseEntity.ok().body(categoryRepository.findAll());
    }
}
