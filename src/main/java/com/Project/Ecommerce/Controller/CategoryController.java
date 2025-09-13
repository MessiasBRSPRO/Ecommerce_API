package com.Project.Ecommerce.Controller;

import com.Project.Ecommerce.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<HashMap<String, Long>> allCategories(){
        return ResponseEntity.ok().body(categoryService.getProductsCategoryQtd());
    }
}
