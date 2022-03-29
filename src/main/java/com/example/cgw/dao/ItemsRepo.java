package com.example.cgw.dao;

import com.example.cgw.JPAData.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items,Integer> {
}
