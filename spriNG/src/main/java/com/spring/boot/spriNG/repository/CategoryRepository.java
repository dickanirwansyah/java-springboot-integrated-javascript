package com.spring.boot.spriNG.repository;

import com.spring.boot.spriNG.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String>{
}
