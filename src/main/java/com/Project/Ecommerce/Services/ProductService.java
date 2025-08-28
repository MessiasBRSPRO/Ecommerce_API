package com.Project.Ecommerce.Services;

import com.Project.Ecommerce.DTOs.CategoryDTO;
import com.Project.Ecommerce.DTOs.DTOListedProduct;
import com.Project.Ecommerce.DTOs.DTOUpdatedProduct;
import com.Project.Ecommerce.DTOs.ProductDTO;
import com.Project.Ecommerce.Entities.Category;
import com.Project.Ecommerce.Entities.Product;
import com.Project.Ecommerce.Exceptions.NoExistentCategoryException;
import com.Project.Ecommerce.Exceptions.NoExistentProductException;
import com.Project.Ecommerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO){
        return productRepository.save(new Product(productDTO));
    }

    public Collection<Product> createProduct(Collection<ProductDTO> productDTOs){
        Collection<Product> productsToAdd = new ArrayList<>();
        for(ProductDTO productDTO : productDTOs){
            productsToAdd.add(new Product(productDTO));
        }
        return productRepository.saveAll(productsToAdd);
    }

    public List<DTOListedProduct> allProducts(){
        return productRepository.findAll().stream().map(DTOListedProduct::new).toList();
    }

    public List<DTOListedProduct> allProductsByIdCategory(Long id){
        List<DTOListedProduct> productById = new ArrayList<>();
        Category category = new Category(new CategoryDTO(id));
        for (DTOListedProduct product : allProducts()){
            if(product.category().equals(category)){
                productById.add(product);
            }
        }
        if(productById.isEmpty()){
            throw new NoExistentCategoryException("id category don't exist");
        }
        return productById;
    }

    public void deleteProductById(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
        else{
            throw new NoExistentProductException("The product don't exists in DataBase");
        }
    }

    public DTOUpdatedProduct updateProductInfos(DTOUpdatedProduct productDTO){
        if(productRepository.existsById(productDTO.id())){
            Product product = productRepository.getReferenceById(productDTO.id());
            product.updateProduct(productDTO);
            return new DTOUpdatedProduct(product);
        }else{
            throw new NoExistentProductException("impossible update a not existent product");
        }
    }
}
