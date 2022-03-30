package com.example.cgw.controller;

import com.example.cgw.JPAData.Customer;
import com.example.cgw.JPAData.Delivery;
import com.example.cgw.JPAData.Partner;
import com.example.cgw.dao.CustomerRepo;
import com.example.cgw.dao.DeliveryRepo;
import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        System.out.println(type+"  "+username+"  "+password);
        System.out.println("Entered login");
        if(type.equals("cust"))
        {
            //check cust table
            //on successful login, return respective dashboards
            List<Customer> account=cust.findByUsername(username);
            System.out.println(account.size());
            if(account.get(0).getPassword().equals(password))
                return "customerdashboard.html";
            else
                return "failure.html";

        }
        else if(type.equals("del"))
        {
            //check cust table
            List<Delivery> account=del.findByUsername(username);
            if(account.get(0).getPassword().equals(password))
                return "deliverydashboard.html";
            else
                return "failure.html";

        }
        else if(type.equals("part"))
        {
            //check cust table
            Partner account=part.findByUsername(username);
            if(account == null)
                System.out.println("true");
            if(account.getPassword().equals(password))
            {
                System.out.println("succ");
                return "partnerdashboard.html";
            }
            else
                return "failure.html";

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
    public String customer(Customer c)
    {
        //register
        //accept customer input, save it in db
        cust.save(c);
        System.out.println("cust reg");
        return "home.html";//present him home page, so he can login
    }
    @RequestMapping("/delivery")
    public String delivery(Delivery d)
    {
        //register
        //accept delivery input, save it in db
        del.save(d);
        System.out.println("Del reg");
        return "home.html";//present him home page, so he can login
    }
}
