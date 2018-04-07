package com.spring.ajax.springbootajax.controller;

import com.spring.ajax.springbootajax.entity.Book;
import com.spring.ajax.springbootajax.model.BookModel;
import com.spring.ajax.springbootajax.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/book")
public class ControllerBook {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> listBook(){
        return Optional.ofNullable(bookService.listBook())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Book>>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/created/{idcategory}")
    public ResponseEntity<Book> createdBook(@RequestBody BookModel book,
                                            @PathVariable String idcategory){

        return Optional.ofNullable(bookService.createdBook(book, idcategory))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Book>(HttpStatus.BAD_REQUEST));
    }
}
