package com.example.cgw.dao;

import com.example.cgw.JPAData.Address;
import com.example.cgw.JPAData.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address,Integer> {
List<Address>  findByCustomer(Customer c);
}
