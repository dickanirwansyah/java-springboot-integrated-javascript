package com.spring.boot.spriNG.service;

import com.spring.boot.spriNG.dao.CategoryDao;
import com.spring.boot.spriNG.entity.Category;
import com.spring.boot.spriNG.model.ModelCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category created(ModelCategory category) {
        return categoryDao.created(category);
    }

    @Override
    public Category updated(ModelCategory category) {
        return categoryDao.updated(category);
    }

    @Override
    public List<Category> listcategory() {
        return categoryDao.listcategory();
    }
}
