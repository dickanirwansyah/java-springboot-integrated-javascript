package com.spring.boot.springpostgresql.model.models;

import com.spring.boot.springpostgresql.model.dto.StudentDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentModels {

    //student model di ambil dari fieldn orders
    //di class orders terdapat field name, address, phone.

    private String name;
    private String address;
    private String phone;
    private boolean valid;

    public StudentModels(StudentDto studentDto){
        this.name = studentDto.getName();
        this.address = studentDto.getAddress();
        this.phone = studentDto.getPhone();
        this.valid = studentDto.isValid();
    }
}
