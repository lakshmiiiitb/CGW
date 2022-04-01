package com.example.cgw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class Partner_pages {
    @RequestMapping("inventory")
    public String show(String choice, HttpSession session)
    {
        if(choice.equals("orders"))
        {
            //display orders
            session.setAttribute("choice","orders");

        }
        else if(choice.equals("items"))
        {
            //display orders
            session.setAttribute("choice","items");

        }

    }
}
