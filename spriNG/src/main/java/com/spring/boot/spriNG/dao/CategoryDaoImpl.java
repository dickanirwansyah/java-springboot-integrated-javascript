package com.spring.boot.spriNG.dao;

import com.spring.boot.spriNG.entity.Category;
import com.spring.boot.spriNG.model.ModelCategory;
import com.spring.boot.spriNG.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao{

    private static Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    private Category findId(String idcategory){
        return categoryRepository.findOne(idcategory);
    }

    @Override
    public Category created(ModelCategory category) {

        logger.info("created category {} "+category.getIdcategory());
        String idcategory = category.getIdcategory();
        Category entityCategory = null;
        boolean valid = false;

        if(idcategory == null){
            entityCategory = new Category();
            valid = true;
        }
        entityCategory.setName(category.getName());
        return categoryRepository.save(entityCategory);
    }

    @Override
    public Category updated(ModelCategory category) {

        logger.info("updated category {} "+category.getIdcategory());
        String idcategory = category.getIdcategory();
        Category entityCategory = null;
        boolean valid = false;

        if(idcategory != null){
            entityCategory = this.findId(idcategory);
            valid = true;
        }
        entityCategory.setIdcategory(category.getIdcategory());
        entityCategory.setName(category.getName());
        return categoryRepository.save(entityCategory);
    }


    @Override
    public List<Category> listcategory() {

        logger.info("list category ");
        List<Category> categoryList = new ArrayList<>();
        for(Category category : categoryRepository.findAll()){
            categoryList.add(category);
        }
        return categoryList;
    }
}
