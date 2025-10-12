package com.Project.Ecommerce.Controller;

import com.Project.Ecommerce.DTOs.DTORegisterCustomer;
import com.Project.Ecommerce.Entities.CartItem;
import com.Project.Ecommerce.Services.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-area")
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @PostMapping
    @RequestMapping("/register")
    @Transactional
    public ResponseEntity<?> registerCustomerEndpoint(@RequestBody DTORegisterCustomer customer){
        customerService.createCustomer(customer);
        return ResponseEntity.status(201).build();
    }

    @PostMapping
    @RequestMapping("/add-item-my-cart/{idCustomer}+{idProduct}")
    @Transactional
    public ResponseEntity<?> addItemToMyCartEndpoint(@PathVariable Long idCustomer, @PathVariable Long idProduct,  @RequestBody CartItem cartItem){
        customerService.addItemToMyCart(idCustomer, idProduct, cartItem);
        return ResponseEntity.accepted().build();
    }
}
