package com.spring.ajax.springbootajax.model;


public class CategoryModel {

    private String idcategory;
    private String name;
    private boolean disabled;


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
