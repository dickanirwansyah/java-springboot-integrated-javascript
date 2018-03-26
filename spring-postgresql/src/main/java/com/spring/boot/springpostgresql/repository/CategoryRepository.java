package com.spring.boot.springpostgresql.repository;

import com.spring.boot.springpostgresql.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Category idcategory(String idcategory);
}
