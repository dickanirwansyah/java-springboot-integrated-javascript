package com.spring.boot.spriNG.service;

import com.spring.boot.spriNG.entity.Category;
import com.spring.boot.spriNG.model.ModelCategory;

import java.util.List;

public interface CategoryService {

    Category created(ModelCategory category);
    Category updated(ModelCategory category);
    List<Category> listcategory();
}
