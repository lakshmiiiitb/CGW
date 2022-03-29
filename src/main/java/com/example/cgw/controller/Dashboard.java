package com.example.cgw.controller;

import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dashboard {
    @Autowired
    PartnerRepo partnerRepo;

    @RequestMapping("cust_dash")
    public void cust_dash()
    {
        //fetch value of location chosen
        //query shops by location
        //return one view to display them
    }

    @RequestMapping("del_dash")
    public void del_dash()
    {
        //fetch value of location chosen
        //query orders by location
        //return one view to display them
    }
}
