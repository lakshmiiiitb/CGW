package com.example.cgw.controller;

import com.example.cgw.JPAData.*;
import com.example.cgw.dao.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Delivery_Pages {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PartnerRepo partnerRepo;

    @Autowired
    ItemsRepo itemsRepo;

    @Autowired
    DeliveryRepo deliveryRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    OrdersRepo ordersRepo;

    @GetMapping("delivery/{id}")
    public Delivery getDelivery(@PathVariable("id") int id)
    {
        Delivery delivery=deliveryRepo.findById(id);
        return delivery;
    }

    @GetMapping("viewordersatdeliverylocation/{pincode}")
    public List<Orders> viewOrdersAtDeliveryLocation(@PathVariable("pincode") String pincode)
    {
        List<Address> address=addressRepo.findByPincode(pincode);
        List<Orders> orders= new ArrayList<>();
        for(Address a:address)
        {
            List<Orders> o=ordersRepo.findAllByAddress(a);
            for(Orders o1: o)
            {
                if(o1.getStatus() == 'o')
                    orders.add(o1);
            }
        }

        for(Orders o:orders)
            System.out.println(o);

        return orders;
    }


    @GetMapping("viewpickedorders/{id}")
    public List<Orders> viewPickedOrders(@PathVariable("id") int id)
    {
        Delivery d=deliveryRepo.findById(id);
        List<Orders> orders=ordersRepo.findAllByDelivery(d);
        for(Orders o1: orders)
        {
                if(o1.getStatus() == 'p')
                    orders.add(o1);
        }

        return orders;
    }

    @GetMapping("viewdeliveredorders/{id}")
    public List<Orders> viewDeliveredOrders(@PathVariable("id") int id)
    {
        Delivery d=deliveryRepo.findById(id);
        List<Orders> orders=ordersRepo.findAllByDelivery(d);
        for(Orders o1: orders)
        {
            if(o1.getStatus() == 'd')
                orders.add(o1);
        }

        return orders;
    }

    @GetMapping("pickorders/{id}")
    public String pickOrders(@PathVariable("id") int id)//orderid
    {
        Orders o=ordersRepo.findById(id);
        o.setStatus('p');
        return "picked";
    }

    @GetMapping("deliverIt/{id}")
    public String deliverIt(@PathVariable("id") int id)//orderid
    {
        Orders o=ordersRepo.findById(id);
        o.setStatus('d');
        return "delivered";
    }


    @PostMapping(path = "addprofilephotoDelivery")
    public String  saveProfile(int id, MultipartFile file, String item_name, int qty, double price, String desc)
    {
        Delivery delivery=deliveryRepo.findById(id);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            delivery.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        deliveryRepo.save(delivery);
        return "done";
    }
}

