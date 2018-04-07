package com.spring.ajax.springbootajax.controller;

import com.spring.ajax.springbootajax.entity.Category;
import com.spring.ajax.springbootajax.model.CategoryModel;
import com.spring.ajax.springbootajax.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/category")
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        return Optional.ofNullable(categoryService.listCategory())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{idcategory}")
    public ResponseEntity<Category> getId(@PathVariable String idcategory){
        return Optional.ofNullable(categoryService.getId(idcategory))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/created")
    public ResponseEntity<Category> created(@RequestBody CategoryModel category){
        return Optional.ofNullable(categoryService.createdCategory(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/updated")
    public ResponseEntity<Category> updated(@RequestBody CategoryModel category){
        return Optional.ofNullable(categoryService.updatedCategory(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }


}
