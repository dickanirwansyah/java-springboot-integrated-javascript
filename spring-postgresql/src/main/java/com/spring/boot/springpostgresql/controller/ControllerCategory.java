package com.spring.boot.springpostgresql.controller;

import com.spring.boot.springpostgresql.entity.Category;
import com.spring.boot.springpostgresql.model.InsertCategory;
import com.spring.boot.springpostgresql.model.UpdateCategory;
import com.spring.boot.springpostgresql.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/category")
public class ControllerCategory {

    @Autowired
    public CategoryService categoryService;

    @GetMapping(value = "/{idcategory}")
    public ResponseEntity<Optional<Category>> getId(@PathVariable String idcategory){
        return Optional.ofNullable(categoryService.getId(idcategory))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Optional<Category>>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/created")
    public ResponseEntity<Category> created(@RequestBody InsertCategory category){
        return Optional.ofNullable(categoryService.created(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/updated")
    public ResponseEntity<Category> updated(@RequestBody UpdateCategory category){
        return Optional.ofNullable(categoryService.updated(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/disabled")
    public ResponseEntity<Category> disabled(@RequestBody UpdateCategory category){
        return Optional.ofNullable(categoryService.disabled(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public ResponseEntity<List<Category>> list(){
        return Optional.ofNullable(categoryService.listCategory())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
