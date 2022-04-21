package com.example.cgw.controller;

import com.example.cgw.JPAData.Items;
import com.example.cgw.JPAData.Partner;
import com.example.cgw.dao.ItemsRepo;
import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewShopsByLocation {
    @Autowired
    PartnerRepo partnerRepo;

    @Autowired
    ItemsRepo itemsRepo;

    @RequestMapping(path = "viewitems")
    public List<Items> viewshops(String choice)
    {
        System.out.println("worked");
        System.out.println(choice);
        Partner shop= partnerRepo.findByUsername("choice");
        List<Items>  items= itemsRepo.findAllByPartner(shop);
        for(Items i:items)
            System.out.println(i);
        return items;
    }
}
