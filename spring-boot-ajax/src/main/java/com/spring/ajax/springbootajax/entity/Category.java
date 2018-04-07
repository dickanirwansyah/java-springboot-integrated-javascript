package com.spring.ajax.springbootajax.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category",
        catalog = "springboot")
public class Category implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idcategory;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "disabled", nullable = false)
    private boolean disabled;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();


    public boolean isAddBooks(Book book){
        return books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books){
        this.books = books;
    }

    public String getIdcategory(){
        return idcategory;
    }

    public void setIdcategory(String idcategory){
        this.idcategory = idcategory;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isDisabled(){
        return disabled;
    }

    public void setDisabled(boolean disabled){
        this.disabled = disabled;
    }
}
