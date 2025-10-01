package com.Project.Ecommerce.Repositories;

import com.Project.Ecommerce.Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
