package com.Project.Ecommerce.Services;

import com.Project.Ecommerce.Entities.Category;
import com.Project.Ecommerce.Entities.Product;
import com.Project.Ecommerce.Repositories.CategoryRepository;
import com.Project.Ecommerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    public HashMap<String, Long> getProductsCategoryQtd(){
        List<Product> products = productRepository.findAll();
        HashMap<String, Long> numberOfCategoryProducts = new HashMap<>();

        for(Category category : categoryRepository.findAll()){
            for(Product product : products){
                if(product.getCategory().getCategoryName().equals(category.getCategoryName())){
                    numberOfCategoryProducts.put(category.getCategoryName(), products.stream().filter(produto -> produto.getCategory().getCategoryName().equals(category.getCategoryName())).count());
                }
            }
        }
        return numberOfCategoryProducts;
    }
}
