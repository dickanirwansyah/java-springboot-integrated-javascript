package com.spring.boot.springpostgresql.dao;

import com.spring.boot.springpostgresql.entity.Book;
import com.spring.boot.springpostgresql.model.InsertBook;
import com.spring.boot.springpostgresql.model.UpdateBook;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    //pattern simpan buku
    Book createdBook(InsertBook book);

    //create buku berdasarkan entity buku
    Book buatBuku(Book book);

    //patter update buku
    Book updateBook(UpdateBook updateBook);

    //menampilkan daftar buku secara keseluruhan
    List<Book> listBook();

    //mengambil data buku berdasarkan kode buku
    Optional<Book> getId(String idbook);

    //list book by id
    Book getIdbuku(String idbuku);
}
