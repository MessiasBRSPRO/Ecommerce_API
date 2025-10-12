package com.Project.Ecommerce.DTOs;

import com.Project.Ecommerce.Entities.Cart;
import com.Project.Ecommerce.Entities.Customer;

public record DTORegisterCustomer(
        Long id,
        String username,
        String email,
        String password,
        Cart cart) {
}
