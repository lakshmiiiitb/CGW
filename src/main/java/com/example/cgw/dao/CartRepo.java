package com.example.cgw.dao;

import com.example.cgw.JPAData.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Integer> {
}
