package com.spring.ajax.springbootajax.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "student_orders",
        catalog = "springboot")
public class StudentOrders implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idorders;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "ordersdate", nullable = false)
    private Date ordersdate;

    @ManyToMany
    @JoinTable(name = "orders_book",
            joinColumns = {@JoinColumn(name = "idorders")},
            inverseJoinColumns = {@JoinColumn(name = "idbuku")})
    private Set<Book> books;

    @OneToOne
    private Student student;
}
