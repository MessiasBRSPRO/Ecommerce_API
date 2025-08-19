package com.Project.Ecommerce.Entities;

import com.Project.Ecommerce.DTOs.CategoryDTO;
import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private ArrayList<Product> products;

    public Category(){}

    public Category(Long id, String categoryName){
        this.id = id;
        this.categoryName = categoryName;
    }

    public Category(CategoryDTO categoryDTO){
        this.id = categoryDTO.id();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
