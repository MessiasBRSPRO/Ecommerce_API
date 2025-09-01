package com.Project.Ecommerce.Services;

import com.Project.Ecommerce.DTOs.DTORegisterCustomer;
import com.Project.Ecommerce.Entities.Customer;
import com.Project.Ecommerce.Exceptions.UsernameCustomerException;
import com.Project.Ecommerce.Exceptions.EmailCustomerException;
import com.Project.Ecommerce.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer createCustomer(DTORegisterCustomer customer){
        if(customerRepository.existsByUsername(customer.username())){
            throw new UsernameCustomerException("this username are in use");
        }else if(customerRepository.existsByEmail(customer.email())){
            throw new EmailCustomerException("this email are in use");
        }
        return customerRepository.save(new Customer(customer));
    }

}
