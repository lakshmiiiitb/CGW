package com.example.cgw.controller;

import com.example.cgw.JPAData.*;
import com.example.cgw.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            orders.addAll(ordersRepo.findAllByAddress(a));
        }

        for(Orders o:orders)
            System.out.println(o);

        return orders;
    }
}

