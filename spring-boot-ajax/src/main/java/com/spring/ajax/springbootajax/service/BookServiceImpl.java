package com.spring.ajax.springbootajax.service;

import com.spring.ajax.springbootajax.dao.BookDao;
import com.spring.ajax.springbootajax.entity.Book;
import com.spring.ajax.springbootajax.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public Book createdBook(BookModel book, String idcategory) {
        return bookDao.createdBook(book, idcategory);
    }

    @Override
    public List<Book> listBook() {
        return bookDao.listBook();
    }
}
