package com.Project.Ecommerce.Controller;

import com.Project.Ecommerce.DTOs.DTOListedProduct;
import com.Project.Ecommerce.DTOs.DTOUpdatedProduct;
import com.Project.Ecommerce.DTOs.ProductDTO;
import com.Project.Ecommerce.Entities.Product;
import com.Project.Ecommerce.Services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @RequestMapping("/create-product")
    @Transactional
    public ResponseEntity<Product> createProductEndpoint(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @PostMapping
    @RequestMapping("/create-products")
    @Transactional
    public ResponseEntity<Collection<Product>> createProductEndpoint(@RequestBody Collection<ProductDTO> productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @GetMapping
    @RequestMapping("/all-products")
    public ResponseEntity<List<DTOListedProduct>> allProductsEndpoint(){
        return ResponseEntity.ok(productService.allProducts());
    }

    @GetMapping
    @RequestMapping("/all-products/{id}")
    public ResponseEntity<List<DTOListedProduct>> allProductsEndpoint(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.allProductsByIdCategory(id));
    }

    @DeleteMapping
    @RequestMapping("/delete-product/{id}")
    @Transactional
    public ResponseEntity<?> deleteProductByIdEndpoint(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @RequestMapping("/update-product-information")
    @Transactional
    public ResponseEntity<?> deleteProductByIdEndpoint(@RequestBody DTOUpdatedProduct productDTO){
        return ResponseEntity.ok().body(productService.updateProductInfos(productDTO));
    }
}
