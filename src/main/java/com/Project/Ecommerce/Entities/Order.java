package com.Project.Ecommerce.Entities;

import com.Project.Ecommerce.DTOs.DTOListedProduct;
import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // A costumer can do many orders with one or more products
    private Customer customer;

    private List<DTOListedProduct> productsOrdered;

    private StatusPayment payment;

    public Order(){}

    public Order(Long id, Customer customer, List<DTOListedProduct> productsOrdered){
        this.id = id;
        this.customer = customer;
        this.productsOrdered = productsOrdered;
        this.payment = StatusPayment.PROCESSING;
    }
}
