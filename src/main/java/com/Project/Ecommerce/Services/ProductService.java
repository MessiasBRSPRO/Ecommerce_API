package com.Project.Ecommerce.Services;

import com.Project.Ecommerce.DTOs.DTOListedProduct;
import com.Project.Ecommerce.DTOs.ProductDTO;
import com.Project.Ecommerce.Entities.Product;
import com.Project.Ecommerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO){
        return productRepository.save(new Product(productDTO));
    }

    public List<DTOListedProduct> allProducts(){
        return productRepository.findAll().stream().map(DTOListedProduct::new).toList();
    }
}
