package com.spring.boot.springpostgresql.service.impl;

import com.spring.boot.springpostgresql.dao.CategoryDao;
import com.spring.boot.springpostgresql.entity.Category;
import com.spring.boot.springpostgresql.model.InsertCategory;
import com.spring.boot.springpostgresql.model.UpdateCategory;
import com.spring.boot.springpostgresql.repository.CategoryRepository;
import com.spring.boot.springpostgresql.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Optional<Category> getId(String idcategory) {
        return categoryDao.getId(idcategory);
    }

    @Override
    public Category created(InsertCategory category) {
        return categoryDao.created(category);
    }

    @Override
    public Category saved(Category category) {
        return categoryDao.saved(category);
    }

    @Override
    public Category findId(String idcategory) {
        return categoryDao.findId(idcategory);
    }

    @Override
    public Category updated(UpdateCategory category) {
        return categoryDao.updated(category);
    }

    @Override
    public Category disabled(UpdateCategory category) {
        return categoryDao.disabled(category);
    }


    @Override
    public List<Category> listCategory() {
        return categoryDao.findAll();
    }
}
