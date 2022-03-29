package com.example.cgw.controller;

import com.example.cgw.JPAData.Partner;
import com.example.cgw.dao.CustomerRepo;
import com.example.cgw.dao.DeliveryRepo;
import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pages {
    @Autowired
    CustomerRepo cust;

    @Autowired
    DeliveryRepo del;

    @Autowired
    PartnerRepo part;

    @RequestMapping("/")
    public String firstpage()
    {
        System.out.println("Entered");
       return "home.html";
    }
    @RequestMapping("/login")
    public String login(String type,String username,String password)
    {
        System.out.println("Entered login");
        if(type.equals("Customer"))
        {
            //check cust table
            //on successful login, return respective dashboards
            return "customerdashboard.html";
        }
        else if(type.equals("Delivery"))
        {
            //check cust table
            return "deliverydashboard.html";
        }
        else if(type.equals("Partner"))
        {
            //check cust table
            return "partnerdashboard.html";
        }
        //verify credentials
        return "home.html";
    }
    @RequestMapping("/register")
    public String register()
    {
        System.out.println("Entered regoster");
        return "register.html";
    }
    @RequestMapping("/partner")
    public String partner(Partner p)
    {
        //register
        //accept partner input, save it in db
        part.save(p);
        System.out.println("Saved");
        return "home.html";//present him home page, so he can login
    }
    @RequestMapping("/customer")
    public String customer()
    {
        //register
        //accept customer input, save it in db
        return "home.html";//present him home page, so he can login
    }
    @RequestMapping("/delivery")
    public String delivery()
    {
        //register
        //accept delivery input, save it in db
        return "home.html";//present him home page, so he can login
    }
}
