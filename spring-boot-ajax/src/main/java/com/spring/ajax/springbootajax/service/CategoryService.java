package com.spring.ajax.springbootajax.service;

import com.spring.ajax.springbootajax.entity.Category;
import com.spring.ajax.springbootajax.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    List<Category> listCategory();

    Category createdCategory(CategoryModel category);

    Category updatedCategory(CategoryModel category);

    Category disabledCategory(CategoryModel category);

    Category getId(String idcategory);
}
