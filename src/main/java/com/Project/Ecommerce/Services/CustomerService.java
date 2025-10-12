package com.Project.Ecommerce.Services;

import com.Project.Ecommerce.DTOs.DTORegisterCustomer;
import com.Project.Ecommerce.Entities.Cart;
import com.Project.Ecommerce.Entities.CartItem;
import com.Project.Ecommerce.Entities.Customer;
import com.Project.Ecommerce.Entities.Product;
import com.Project.Ecommerce.Exceptions.UsernameCustomerException;
import com.Project.Ecommerce.Exceptions.EmailCustomerException;
import com.Project.Ecommerce.Repositories.CartItemRepository;
import com.Project.Ecommerce.Repositories.CustomerRepository;
import com.Project.Ecommerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    public void createCustomer(DTORegisterCustomer customer){
        if(customerRepository.existsByUsername(customer.username())){
            throw new UsernameCustomerException("this username are in use");
        }else if(customerRepository.existsByEmail(customer.email())){
            throw new EmailCustomerException("this email are in use");
        }
        Customer registeredCustomer = new Customer(customer);
        customerRepository.save(registeredCustomer);
        savingCartToCustomer(registeredCustomer); // saving the cart in db
    }

    private void savingCartToCustomer(Customer customer){
        cartService.saveCart(new Cart(customer));
    }

    public void addItemToMyCart(Long idCustomer, Long idProduct, CartItem cartItem){

        Customer customer = customerRepository.getReferenceById(idCustomer);
        Product product = productRepository.getReferenceById(idProduct);

        Cart customerCart = customer.getMyCart();

        cartItem.setCart(customerCart);
        cartItem.setProduct(product);

        customerCart.addToMyCart(cartItem);
        cartItemRepository.save(cartItem);
    }
}
