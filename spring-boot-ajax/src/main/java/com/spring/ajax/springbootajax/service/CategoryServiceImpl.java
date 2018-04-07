package com.spring.ajax.springbootajax.service;

import com.spring.ajax.springbootajax.dao.CategoryDao;
import com.spring.ajax.springbootajax.entity.Category;
import com.spring.ajax.springbootajax.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> listCategory() {
        return categoryDao.listCategory();
    }

    @Override
    public Category createdCategory(CategoryModel category) {
        return categoryDao.createdCategory(category);
    }

    @Override
    public Category updatedCategory(CategoryModel category) {
        return categoryDao.updatedCategory(category);
    }

    @Override
    public Category disabledCategory(CategoryModel category) {
        return null;
    }

    @Override
    public Category getId(String idcategory) {
        return categoryDao.getId(idcategory);
    }
}
