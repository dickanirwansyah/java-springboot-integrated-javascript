package com.spring.ajax.springbootajax.repository;

import com.spring.ajax.springbootajax.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String>{
}
