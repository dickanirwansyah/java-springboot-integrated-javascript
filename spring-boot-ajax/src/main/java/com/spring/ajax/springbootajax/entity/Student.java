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
@Table(name = "student",
        catalog = "springboot")
public class Student implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idstudent;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "name", nullable = false)
    private String name;
}
