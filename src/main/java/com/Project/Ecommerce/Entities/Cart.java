package com.Project.Ecommerce.Entities;

import com.Project.Ecommerce.DTOs.DTORegisterCustomer;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    public Cart(){}

    public Cart(Long id, Customer customer){
        this.id = id;
        this.customer = customer;
    }

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addToMyCart(CartItem cartItem){
        this.items.add(cartItem);
    }

    public void removeFromMyCart(CartItem cartItem){
        this.items.remove(cartItem);
    }
}
