package com.Project.Ecommerce.Controller;

import com.Project.Ecommerce.DTOs.ProductDTO;
import com.Project.Ecommerce.Entities.Product;
import com.Project.Ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @RequestMapping("/create-product")
    public ResponseEntity<Product> createProductEndpoint(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
}
