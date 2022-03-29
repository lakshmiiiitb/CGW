package com.example.cgw.dao;

import com.example.cgw.JPAData.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
