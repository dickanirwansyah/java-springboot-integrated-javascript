package com.spring.boot.springpostgresql.model.dto;

import com.spring.boot.springpostgresql.model.models.StudentModels;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    //student data transfer object di ambil berdasarkan dari class orders
    //karena di class orders terdapat field name, address, phone.

    private String name;
    private String address;
    private String phone;
    private boolean valid;

    public StudentDto(){

    }

    public StudentDto(StudentModels studentModels){
        if(studentModels!=null){
            this.name = studentModels.getName();
            this.address = studentModels.getAddress();
            this.phone = studentModels.getPhone();
        }
    }
}
