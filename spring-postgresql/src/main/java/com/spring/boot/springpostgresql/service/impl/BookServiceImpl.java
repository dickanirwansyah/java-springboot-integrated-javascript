package com.spring.boot.springpostgresql.service.impl;

import com.spring.boot.springpostgresql.dao.BookDao;
import com.spring.boot.springpostgresql.entity.Book;
import com.spring.boot.springpostgresql.model.InsertBook;
import com.spring.boot.springpostgresql.model.UpdateBook;
import com.spring.boot.springpostgresql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired private BookDao bookDao;

    @Override
    public Book createdBook(InsertBook book) {
        return bookDao.createdBook(book);
    }

    @Override
    public Book buatBuku(Book book) {
        return bookDao.buatBuku(book);
    }

    @Override
    public List<Book> listBook() {
        return bookDao.listBook();
    }

    @Override
    public Optional<Book> getId(String idbook) {
        return bookDao.getId(idbook);
    }

    @Override
    public Book updatedBook(UpdateBook book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book getIdbuku(String idbuku) {
        return bookDao.getIdbuku(idbuku);
    }
}
