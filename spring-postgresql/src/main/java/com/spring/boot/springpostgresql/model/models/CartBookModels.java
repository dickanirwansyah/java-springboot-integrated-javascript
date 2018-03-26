package com.spring.boot.springpostgresql.model.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CartBookModels {

   private StudentModels studentModels;
   private final List<CartLineBookModels> cartLineBookModels = new ArrayList<>();

   public CartBookModels(){}

   //mencari id
   private CartLineBookModels findByCode(String idbuku){
       for(CartLineBookModels cartlinebook : this.cartLineBookModels){
           if(cartlinebook.getBookModels().getIdbuku().equals(idbuku)){
               return cartlinebook;
           }
       }
       return null;
   }

   //add book to cart
   public void addBook(BookModels bookModels, int quantity){
       CartLineBookModels cartlinebook = this.findByCode(bookModels.getIdbuku());

       if(cartlinebook == null){
           cartlinebook = new CartLineBookModels();
           cartlinebook.setQuantity(0);
           cartlinebook.setBookModels(bookModels);
           this.cartLineBookModels.add(cartlinebook);
       }

       int newQuantity = cartlinebook.getQuantity() + quantity;
       if (newQuantity <= 0){
           this.cartLineBookModels.remove(cartlinebook);
       }else{
           cartlinebook.setQuantity(newQuantity);
       }
   }

   //update book yang ada di cart
    public void updateBook(String idbuku, Integer quantity){
       CartLineBookModels linesbook = this.findByCode(idbuku);

       if(linesbook != null){
           if(quantity <= 0){
               this.cartLineBookModels.remove(linesbook);
           }else{
               linesbook.setQuantity(quantity);
           }
       }
    }

    //remove book yang di cart
    public void removeBook(BookModels bookModels){
        CartLineBookModels linesbook = this.findByCode(bookModels.getIdbuku());
        if(linesbook != null){
            this.cartLineBookModels.remove(linesbook);
        }
    }

    //update jumlah beli buku atau order buku
    public void updateQuantity(CartBookModels cartBookModels){
        if(cartBookModels != null){
            List<CartLineBookModels> linesbook = cartBookModels.getCartLineBookModels();
            for(CartLineBookModels lines : linesbook){
                this.updateBook(lines.getBookModels().getIdbuku(), lines.getQuantity());
            }
        }
    }
}
