package com.Project.Ecommerce.Entities;

import com.Project.Ecommerce.DTOs.DTOUpdatedProduct;
import com.Project.Ecommerce.DTOs.ProductDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Double price;

    private Integer stock;

    private String decription;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(){

    }

    public Product(Long id, String productName, Double price, Integer stock, String decription, Category category){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.decription = decription;
        this.category = category;
    }

    public Product(ProductDTO productDTO){
        this.id = productDTO.id();
        this.productName = productDTO.productName();
        this.price = productDTO.price();
        this.stock = productDTO.stock();
        this.decription = productDTO.decription();
        this.category = productDTO.category();
    }

    public void updateProduct(DTOUpdatedProduct updatedProduct){
        if(updatedProduct.updatedProductName() != null){
            this.productName = updatedProduct.updatedProductName();
        }if(updatedProduct.updatedPrice() != null){
            this.price = updatedProduct.updatedPrice();
        }if(updatedProduct.id() != null){
            this.id = updatedProduct.id();
        }
        if(updatedProduct.updatedCategory() != null){
            this.category = updatedProduct.updatedCategory();
        }

        if(updatedProduct.updatedDecription() != null){
            this.decription = updatedProduct.updatedDecription();
        }
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDecription() {
        return this.decription;
    }
}
