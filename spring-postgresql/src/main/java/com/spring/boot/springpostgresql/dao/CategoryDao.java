package com.spring.boot.springpostgresql.dao;

import com.spring.boot.springpostgresql.entity.Category;
import com.spring.boot.springpostgresql.model.GetIdcategory;
import com.spring.boot.springpostgresql.model.InsertCategory;
import com.spring.boot.springpostgresql.model.UpdateCategory;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    Optional<Category> getId(String idcategory);

    Category findId(String idcategory);

    Category saved(Category category);

    Category created(InsertCategory category);

    Category updated(UpdateCategory category);

    Category disabled(UpdateCategory category);

    List<Category> findAll();
}
