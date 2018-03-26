package com.spring.boot.springpostgresql.repository;

import com.spring.boot.springpostgresql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    //List<Book> idbuku(String idbuku);

    Book idbuku(String idbuku);
}
