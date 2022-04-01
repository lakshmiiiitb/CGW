package com.example.cgw.dao;

import com.example.cgw.JPAData.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,Integer> {
    List<Orders> findAllBy
}
