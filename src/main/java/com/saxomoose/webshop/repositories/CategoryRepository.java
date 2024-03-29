package com.saxomoose.webshop.repositories;

import com.saxomoose.webshop.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> { }
