package com.example.cgw.dao;

import com.example.cgw.JPAData.Delivery;
import com.example.cgw.JPAData.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepo extends JpaRepository<Delivery,Integer> {
    List<Delivery> findByUsername(String uname);
}

