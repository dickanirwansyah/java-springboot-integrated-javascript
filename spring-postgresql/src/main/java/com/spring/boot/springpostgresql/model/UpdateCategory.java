package com.spring.boot.springpostgresql.model;


public class UpdateCategory {

    private String idcategory;
    private String name;
    private boolean disabled;

    public String getIdcategory(){
        return idcategory;
    }

    public String getName(){
        return name;
    }

    public boolean isDisabled(){
        return disabled;
    }

}

