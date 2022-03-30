package com.example.cgw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewShopsByLocation {
    @RequestMapping("viewitems/{choice}")
    public String viewshops(@PathVariable("choice") String choice)
    {
        System.out.println("worked");
        return "";
    }
}
