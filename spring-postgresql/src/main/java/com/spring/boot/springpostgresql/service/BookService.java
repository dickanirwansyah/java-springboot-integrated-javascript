package com.spring.boot.springpostgresql.service;

import com.spring.boot.springpostgresql.entity.Book;
import com.spring.boot.springpostgresql.model.InsertBook;
import com.spring.boot.springpostgresql.model.UpdateBook;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book createdBook(InsertBook book);

    Book buatBuku(Book book);

    List<Book> listBook();

    Optional<Book> getId(String idbook);

    Book updatedBook(UpdateBook book);

    Book getIdbuku(String idbuku);
}
