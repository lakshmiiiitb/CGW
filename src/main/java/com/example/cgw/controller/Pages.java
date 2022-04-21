package com.example.cgw.controller;

import com.example.cgw.JPAData.Customer;
import com.example.cgw.JPAData.Delivery;
import com.example.cgw.JPAData.Partner;
import com.example.cgw.dao.CustomerRepo;
import com.example.cgw.dao.DeliveryRepo;
import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class Pages {
    @Autowired
    CustomerRepo cust;

    @Autowired
    DeliveryRepo del;

    @Autowired
    PartnerRepo part;


    @PostMapping(path = "/login")
    public String login(String type, String username, String password)
    {
        System.out.println(type+"  "+username+"  "+password);
        System.out.println("Entered login");
        if(type.equals("cust"))
        {
            //check cust table
            //on successful login, return respective dashboards
            Customer account=cust.findByUsername(username);
            if(account == null)
                return "failure.html";
            //System.out.println(account.size());
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getName());
                return "customerdashboard.html";
            }
            else
                return "failure.html";

        }
        else if(type.equals("del"))
        {
            //check cust table
            Delivery account=del.findByUsername(username);
            if(account == null)
                return "failure.html";
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getName());
                return "deliverydashboard.html";
            }
            else
                return "failure.html";

        }
        else if(type.equals("part"))
        {
            //check cust table
            Partner account=part.findByUsername(username);
            if(account == null)
                return "failure.html";
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getStoreName());
                return "partnerdashboard.jsp";
            }
            else
                return "failure.html";

        }
        //verify credentials
        return "home.html";
    }

    @PostMapping(path = "/partner")
    public String partner(Partner p)
    {
        //register
        //accept partner input, save it in db
        part.save(p);
        System.out.println("Saved");
        return "home.html";//present him home page, so he can login
    }
    @PostMapping(path="/customer")
    public String customer(Customer c)
    {
        //register
        //accept customer input, save it in db
        cust.save(c);
        System.out.println("cust reg");
        return "home.html";//present him home page, so he can login
    }
    @PostMapping(path="/delivery")
    public String delivery(Delivery d)
    {
        //register
        //accept delivery input, save it in db
        del.save(d);
        System.out.println("Del reg");
        return "home.html";//present him home page, so he can login
    }
}
