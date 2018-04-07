package com.spring.ajax.springbootajax.service;

import com.spring.ajax.springbootajax.entity.Book;
import com.spring.ajax.springbootajax.model.BookModel;

import java.util.List;

public interface BookService {

    Book createdBook(BookModel book, String idcategory);

    List<Book> listBook();
}
