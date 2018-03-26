package com.spring.boot.springpostgresql.controller;

import com.spring.boot.springpostgresql.entity.Book;
import com.spring.boot.springpostgresql.entity.Category;
import com.spring.boot.springpostgresql.model.InsertBook;
import com.spring.boot.springpostgresql.model.UpdateBook;
import com.spring.boot.springpostgresql.service.BookService;
import com.spring.boot.springpostgresql.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/book")
public class ControllerBook {

    @Autowired private BookService bookService;

    @Autowired private CategoryService categoryService;

    @PostMapping(value = "/created")
    public ResponseEntity<Book> created(@RequestBody InsertBook book){
        return Optional.ofNullable(bookService.createdBook(book))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Book>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/saved/{idcategory}")
    public ResponseEntity<Book> saved(@RequestBody Book book,
                                      @PathVariable String idcategory){

        Category category = categoryService.findId(idcategory);
        if(book.getIdbuku() == null){
            Book databook = new Book(
                    category, book.getTitle(), book.getAuthor(), book.getQuantity(),
                    book.getPrice());
            bookService.buatBuku(databook);
            category.addBook(databook);
            categoryService.saved(category);
        }
        return new ResponseEntity<Book>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBook(){
        return Optional.ofNullable(bookService.listBook())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Book>>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/{idbuku}")
    public ResponseEntity<Optional<Book>> getId(@PathVariable String idbuku){
        return Optional.ofNullable(bookService.getId(idbuku))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Optional<Book>>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/listbuku/{idbuku}")
    public ResponseEntity<Book> getListById(@PathVariable String idbuku){
        return Optional.ofNullable(bookService.getIdbuku(idbuku))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Book>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/updated")
    public ResponseEntity<Book> update(@RequestBody UpdateBook book){
        return Optional.ofNullable(bookService.updatedBook(book))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Book>(HttpStatus.BAD_REQUEST));
    }
}
