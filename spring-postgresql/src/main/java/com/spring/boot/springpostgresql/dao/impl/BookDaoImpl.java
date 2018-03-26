package com.spring.boot.springpostgresql.dao.impl;

import com.spring.boot.springpostgresql.dao.BookDao;
import com.spring.boot.springpostgresql.entity.Book;
import com.spring.boot.springpostgresql.entity.Category;
import com.spring.boot.springpostgresql.model.InsertBook;
import com.spring.boot.springpostgresql.model.UpdateBook;
import com.spring.boot.springpostgresql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired private BookRepository bookRepository;

    @Override
    public Book createdBook(InsertBook book) {
        String idbuku = book.getIdbuku();
        boolean valid = false;
        Book mybook = null;

        if(idbuku == null){
            valid = true;
            mybook = new Book();
            mybook.setDisabled(true);
        }
        mybook.setTitle(book.getTitle());
        mybook.setAuthor(book.getAuthor());
        mybook.setQuantity(book.getQuantity());
        mybook.setPrice(book.getPrice());
        mybook.setCategory(book.getIdcategory());
        return bookRepository.save(mybook);
    }

    @Override
    public Book buatBuku(Book book) {
        book.setDisabled(true);
        return bookRepository.save(book);
    }

    private Book findId(String idbuku){
        return bookRepository.getOne(idbuku);
    }

    @Override
    public Book updateBook(UpdateBook book) {
        String idbuku = book.getIdbuku();
        boolean valid = false;
        Book mybook = null;

        if(idbuku != null){
            valid = true;
            mybook = this.findId(idbuku);
        }

        mybook.setIdbuku(book.getIdbuku());
        mybook.setCategory(book.getCategory());
        mybook.setQuantity(book.getQuantity());
        mybook.setDisabled(book.isDisabled());
        mybook.setAuthor(book.getAuthor());
        mybook.setPrice(book.getPrice());
        mybook.setTitle(book.getTitle());
        return bookRepository.save(mybook);
    }

    @Override
    public List<Book> listBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getId(String idbook) {
        return bookRepository.findById(idbook);
    }

    @Override
    public Book getIdbuku(String idbuku) {
        return bookRepository.idbuku(idbuku);
    }

}
