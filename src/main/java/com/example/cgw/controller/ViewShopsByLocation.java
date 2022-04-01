package com.example.cgw.controller;

import com.example.cgw.JPAData.Items;
import com.example.cgw.JPAData.Partner;
import com.example.cgw.dao.ItemsRepo;
import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ViewShopsByLocation {
    @Autowired
    PartnerRepo partnerRepo;

    @Autowired
    ItemsRepo itemsRepo;

    @RequestMapping(path = "viewitems")
    @ResponseBody
    public String viewshops(String choice)
    {
        System.out.println("worked");
        System.out.println(choice);
        Partner shop= partnerRepo.findByUsername("choice");
        List<Items>  items= itemsRepo.findAllByPartner(shop);
        for(Items i:items)
            System.out.println(i);
        return "returned"+choice;
    }
}
