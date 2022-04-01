package com.example.cgw.dao;

import com.example.cgw.JPAData.Items;
import com.example.cgw.JPAData.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepo extends JpaRepository<Items,Integer> {
    public List<Items> findAllByPartner(Partner p);
}
