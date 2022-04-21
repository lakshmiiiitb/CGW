package com.example.cgw.controller;

import com.example.cgw.JPAData.Partner;
import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class Dashboard {
    @Autowired
    PartnerRepo partnerRepo;

    @RequestMapping("custdash")
    public String cust_dash(String location, HttpSession session)
    {
        //fetch value of location chosen
        //query shops by location
        //return one view to display them
        System.out.println("entered mv");

        List<Partner> shops= partnerRepo.findAllByStoreLoc(location);
        session.setAttribute("shops",shops);

        for(Partner p:shops)
            System.out.println(p.getStoreName()+"   "+p.getStoreLoc());
        return "displayshopcustdashboard.jsp";
    }

    @RequestMapping("del_dash")
    public void del_dash()
    {
        //fetch value of location chosen
        //query orders by location
        //return one view to display them
    }
}
