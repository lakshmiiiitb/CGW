package com.example.cgw.dao;

import com.example.cgw.JPAData.Customer;
import com.example.cgw.JPAData.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> findByUsername(String uname);
}
