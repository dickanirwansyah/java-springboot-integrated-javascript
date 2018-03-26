package com.spring.boot.springpostgresql.dao.impl;

import com.spring.boot.springpostgresql.dao.CategoryDao;
import com.spring.boot.springpostgresql.entity.Category;
import com.spring.boot.springpostgresql.model.GetIdcategory;
import com.spring.boot.springpostgresql.model.InsertCategory;
import com.spring.boot.springpostgresql.model.UpdateCategory;
import com.spring.boot.springpostgresql.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getId(String idcategory) {
        return categoryRepository.findById(idcategory);
    }

    @Override
    public Category findId(String idcategory) {
        return categoryRepository.idcategory(idcategory);
    }

    @Override
    public Category saved(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category created(InsertCategory category) {
        String idcategory = category.getIdcategory();
        Category cat = null;
        boolean valid = false;
        if(idcategory == null){
            valid = true;
            cat = new Category();
        }
        cat.setDisabled(true);
        cat.setName(category.getName());
        return categoryRepository.save(cat);
    }


    private Category findone(String idcategory){
        return categoryRepository.getOne(idcategory);
    }

    @Override
    public Category updated(UpdateCategory category) {
        String idcategory = category.getIdcategory();
        Category cat = null;
        boolean valid = false;
        if(idcategory !=null){
            cat = this.findone(idcategory);
            valid = true;
        }
        cat.setDisabled(category.isDisabled());
        cat.setIdcategory(category.getIdcategory());
        cat.setName(category.getName());
        return categoryRepository.save(cat);
    }

    @Override
    public Category disabled(UpdateCategory category) {
        String idcategory = category.getIdcategory();
        Category cat = null;
        boolean valid = false;

        if(idcategory != null){
            cat = new Category();
            valid = true;
        }
        cat.setDisabled(false);
        cat.setName(category.getName());
        cat.setIdcategory(category.getIdcategory());
        return categoryRepository.save(cat);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
