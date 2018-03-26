package com.spring.boot.springpostgresql.model.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersModels {

    private String idorders;
    private Date dateorders;
    private String name;
    private String address;
    private String phone;
    private List<OrdersDetilsModels> ordersDetilsModels = new ArrayList<>();

    public OrdersModels(String idorders, Date dateorders, String name, String address, String phone){
        this.idorders = idorders;
        this.dateorders = dateorders;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getIdorders(){
        return idorders;
    }

    public void setIdorders(String idorders){
        this.idorders = idorders;
    }

    public Date getDateorders(){
        return dateorders;
    }

    public void setDateorders(Date dateorders){
        this.dateorders = dateorders;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public List<OrdersDetilsModels> getOrdersDetilsModels(){
        return ordersDetilsModels;
    }

    public void setOrdersDetilsModels(List<OrdersDetilsModels> ordersDetilsModels){
        this.ordersDetilsModels = ordersDetilsModels;
    }
}
