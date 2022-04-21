package com.example.cgw.dao;

import com.example.cgw.JPAData.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PartnerRepo extends JpaRepository<Partner,Integer> {
    public Partner findByUsername(String uname);
    public List<Partner> findAllByStoreLoc(String loc);
    public Partner findByStoreName(String store);
    public Partner findById(int id);

}
