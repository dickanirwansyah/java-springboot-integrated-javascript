package com.spring.ajax.springbootajax.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name = "book",
        catalog = "springboot")
public class Book implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idbuku;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @Column(name = "disabled", nullable = false)
    private boolean disabled;
}
