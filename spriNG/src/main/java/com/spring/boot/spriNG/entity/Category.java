package com.spring.boot.spriNG.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "category",
        catalog = "spring")
public class Category implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idcategory;

    @Column(name = "name", nullable = false)
    private String name;
}
