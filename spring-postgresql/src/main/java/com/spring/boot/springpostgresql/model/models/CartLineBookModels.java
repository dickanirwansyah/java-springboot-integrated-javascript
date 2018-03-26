package com.spring.boot.springpostgresql.model.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartLineBookModels {

    private BookModels bookModels;
    private int quantity;

    public CartLineBookModels(){
        this.quantity = 0;
    }
}
