package com.example.cgw.controller;

import com.example.cgw.JPAData.*;
import com.example.cgw.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("viewordersatdeliverylocation")
    public List<Orders> viewOrdersAtDeliveryLocation(@RequestBody InputAddress address)
    {
        Address addresses=addressRepo.findByLocAndCityAndState(address.getArea(),address.getCity(),address.getState(),address.getPincode());

        List<Orders> orders=ordersRepo.findAllByAddress(addresses);
        for(Orders o:orders)
            System.out.println(o);

        return orders;
    }
}

