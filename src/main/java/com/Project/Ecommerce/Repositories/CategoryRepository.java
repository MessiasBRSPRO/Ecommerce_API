package com.Project.Ecommerce.Repositories;

import com.Project.Ecommerce.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
