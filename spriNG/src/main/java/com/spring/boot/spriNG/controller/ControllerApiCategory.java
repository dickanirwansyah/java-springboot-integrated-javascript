package com.spring.boot.spriNG.controller;

import com.spring.boot.spriNG.entity.Category;
import com.spring.boot.spriNG.model.ModelCategory;
import com.spring.boot.spriNG.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/category/")
public class ControllerApiCategory {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        return Optional.ofNullable(categoryService.listcategory())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "created")
    public ResponseEntity<Category> createdCategory(@RequestBody ModelCategory category){
        return Optional.ofNullable(categoryService.created(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "updated")
    public ResponseEntity<Category> updatedCategory(@RequestBody ModelCategory category){
        return Optional.ofNullable(categoryService.updated(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }
}
