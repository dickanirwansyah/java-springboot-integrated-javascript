package com.spring.ajax.springbootajax.repository;

import com.spring.ajax.springbootajax.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String>{
}
