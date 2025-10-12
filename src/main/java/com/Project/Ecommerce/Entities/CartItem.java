package com.Project.Ecommerce.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer quantity;
    private Double price;

    public CartItem(){}

    public CartItem(Cart cart, Product product, Integer quantity, Double price){
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice() * quantity;
    }

    public CartItem(Integer quantity){
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.price = this.product.getPrice() * this.quantity;
    }
}

