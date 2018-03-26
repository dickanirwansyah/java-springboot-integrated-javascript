package com.spring.boot.springpostgresql.model.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDetilsModels {

    private String idordersdetils;
    private String bookid;
    private String bookname;
    private int quantity;

    public OrdersDetilsModels(String idordersdetils, String bookid, String bookname, int quantity){
        this.idordersdetils = idordersdetils;
        this.bookid = bookid;
        this.bookname = bookname;
        this.quantity = quantity;
    }
}
