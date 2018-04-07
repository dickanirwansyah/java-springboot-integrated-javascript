package com.spring.ajax.springbootajax.dao;

import com.spring.ajax.springbootajax.entity.Category;
import com.spring.ajax.springbootajax.model.CategoryModel;
import com.spring.ajax.springbootajax.repository.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    private Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

    @Override
    public List<Category> listCategory() {
        List<Category> list = new ArrayList<>();
        for(Category category: categoryRepository.findAll()){
            logger.info("menampilkan data");
            list.add(category);
        }
        return list;
    }

    @Override
    public Category createdCategory(CategoryModel category) {
        Category entityCategory = null;
        boolean valid = false;
        String idcategory = category.getIdcategory();

        if(idcategory == null){
            entityCategory = new Category();
            valid = true;
            logger.info("insert category");
        }

        entityCategory.setDisabled(true);
        entityCategory.setName(category.getName());
        return categoryRepository.save(entityCategory);
    }

    @Override
    public Category updatedCategory(CategoryModel category) {
        Category entityCategory = null;
        boolean valid = false;
        String idcategory = category.getIdcategory();

        if(idcategory != null){
            entityCategory = this.getId(category.getIdcategory());
            valid = true;
            logger.info("updated category");
        }

        entityCategory.setIdcategory(category.getIdcategory());
        entityCategory.setName(category.getName());
        entityCategory.setDisabled(category.isDisabled());
        return categoryRepository.save(entityCategory);
    }

    @Override
    public Category disabledCategory(CategoryModel category) {
        return null;
    }

    @Override
    public Category getId(String idcategory) {
        logger.info("get id category");
        return categoryRepository
                .findOne(idcategory);
    }
}
