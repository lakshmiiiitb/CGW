package com.example.cgw.dao;

import com.example.cgw.JPAData.Address;
import com.example.cgw.JPAData.Orders;
import com.example.cgw.JPAData.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,Integer> {
    List<Orders> findAllByPartner(Partner p);
    List<Orders> findAllByAddress(Address a);
}
