package com.spring.ajax.springbootajax.dao;

import com.spring.ajax.springbootajax.entity.Book;
import com.spring.ajax.springbootajax.entity.Category;
import com.spring.ajax.springbootajax.model.BookModel;
import com.spring.ajax.springbootajax.repository.BookRepository;
import com.spring.ajax.springbootajax.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Book> listBook() {
        List<Book> listbook = new ArrayList<>();
        for(Book book : bookRepository.findAll()){
            listbook.add(book);
        }
        return listbook;
    }

    @Override
    public Book getId(String idbuku) {
        return null;
    }

    @Override
    public Book createdBook(BookModel book, String idcategory) {

        Category category = categoryRepository.findOne(idcategory);
        Book entityBook = null;
        boolean valid = false;

        if(book.getIdbuku() == null){
            entityBook = new Book();
            valid = true;
        }
        entityBook.setTitle(book.getTitle());
        entityBook.setAuthor(book.getAuthor());
        entityBook.setDisabled(true);
        entityBook.setCategory(category);
        entityBook.setPrice(book.getPrice());
        entityBook.setQuantity(book.getQuantity());

        category.isAddBooks(entityBook);
        categoryRepository.save(category);
        return bookRepository.save(entityBook);
    }

    @Override
    public Book updatedBook(BookModel book) {
        return null;
    }

    @Override
    public Book disabled(BookModel book) {
        return null;
    }
}
