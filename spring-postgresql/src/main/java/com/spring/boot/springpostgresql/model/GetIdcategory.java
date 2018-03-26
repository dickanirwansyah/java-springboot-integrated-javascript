package com.spring.boot.springpostgresql.model;

import com.spring.boot.springpostgresql.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetIdcategory {

    private String categoryId;
    private String name;
    private boolean disabled;

    public GetIdcategory(Category category){
        this.categoryId = category.getIdcategory();
        this.name = category.getName();
        this.disabled = category.isDisabled();
    }

    public GetIdcategory(String categoryId, String name, boolean disabled){
        this.categoryId = categoryId;
        this.name = name;
        this.disabled = disabled;
    }

    public String getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(String categoryId){
        this.categoryId = categoryId;
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
