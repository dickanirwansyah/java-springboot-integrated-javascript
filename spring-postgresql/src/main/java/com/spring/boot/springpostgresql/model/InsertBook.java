package com.spring.boot.springpostgresql.model;

import com.spring.boot.springpostgresql.entity.Book;
import com.spring.boot.springpostgresql.entity.Category;
import lombok.*;


@Getter
@Setter
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsertBook {

    private String idbuku;
    private String title;
    private String author;
    private int quantity;
    private Category idcategory;
    private int price;
    private boolean disabled;

}
