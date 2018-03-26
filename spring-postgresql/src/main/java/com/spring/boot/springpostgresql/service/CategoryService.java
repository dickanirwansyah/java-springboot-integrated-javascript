package com.spring.boot.springpostgresql.service;

import com.spring.boot.springpostgresql.entity.Category;
import com.spring.boot.springpostgresql.model.InsertCategory;
import com.spring.boot.springpostgresql.model.UpdateCategory;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> getId(String idcategory);

    Category created(InsertCategory category);

    Category saved(Category category);

    Category findId(String idcategory);

    Category updated(UpdateCategory category);

    Category disabled(UpdateCategory category);

    List<Category> listCategory();
}
