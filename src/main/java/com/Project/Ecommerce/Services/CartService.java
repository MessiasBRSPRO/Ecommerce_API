package com.Project.Ecommerce.Services;

import com.Project.Ecommerce.Entities.Cart;
import com.Project.Ecommerce.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }
}
