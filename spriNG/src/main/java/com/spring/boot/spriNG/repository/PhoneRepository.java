package com.spring.boot.spriNG.repository;

import com.spring.boot.spriNG.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String>{
}
