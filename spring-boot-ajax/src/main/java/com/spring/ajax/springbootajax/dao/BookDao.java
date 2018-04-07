package com.spring.ajax.springbootajax.dao;

import com.spring.ajax.springbootajax.entity.Book;
import com.spring.ajax.springbootajax.model.BookModel;

import java.util.List;

public interface BookDao {

    List<Book> listBook();

    Book getId(String idbuku);

    Book createdBook(BookModel book, String idcategory);

    Book updatedBook(BookModel book);

    Book disabled(BookModel book);
}
