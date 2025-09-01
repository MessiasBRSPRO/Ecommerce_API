package com.Project.Ecommerce.Controller;

import com.Project.Ecommerce.DTOs.DTORegisterCustomer;
import com.Project.Ecommerce.Entities.Customer;
import com.Project.Ecommerce.Services.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer-area")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    @RequestMapping("/register")
    @Transactional
    public ResponseEntity<Customer> registerCustomerEndpoint(@RequestBody DTORegisterCustomer customer){
        return ResponseEntity.status(201).body(customerService.createCustomer(customer));
    }
}
