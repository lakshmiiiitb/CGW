package com.example.cgw.controller;

import com.example.cgw.JPAData.*;
import com.example.cgw.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CustomerPages {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PartnerRepo partnerRepo;

    @Autowired
    ItemsRepo itemsRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    AddressRepo addressRepo;

    @PostMapping(path = "viewitems/{id}")
    public List<Items> viewItemsInShop(@PathVariable("id") int shopid)
    {
        Partner shop= partnerRepo.findById(shopid);
        List<Items>  items= itemsRepo.findAllByPartner(shop);
        for(Items i:items)
            System.out.println(i);
        return items;
    }


    @PostMapping(path = "viewshops")
    public List<Partner> viewShopsbyLocation(@RequestBody String loc)
    {

        loc=loc.substring(0,loc.length()-1);
        List<Partner> shops=partnerRepo.findByStoreLoc(loc);
        System.out.println(loc);
        System.out.println(shops.size());
        for(Partner shp:shops)
            System.out.println(shp);
        return shops;
    }

    @Transactional
    @PutMapping(path = "/{id}/addtocart")
    public String addToCart(@PathVariable("id") int id,String itemname, String shopname, int qty)
    {
        Customer customer=customerRepo.findById(id);
        Partner partner=partnerRepo.findByStoreName(shopname);
        Items items=itemsRepo.findByShopAndItem(partner, itemname);
        if(items!=null)
        {
            int status=itemsRepo.decrementQuantity(qty,partner,itemname);
            if(status >0)
                System.out.println("Updated");
            else
                System.out.println("Not updated");

            Cart c=new Cart(itemname,qty, qty*items.getPrice(), items.getDescription(),items.getImage(), customer);
            cartRepo.save(c);
        }

        System.out.println(items.getItem_name());

        return items.getItem_name();
    }

    @GetMapping(path = "viewcart/{id}")
    public List<Cart> viewCart(@PathVariable("id") int id)
    {
        List<Cart> carts=cartRepo.findByCustomer(customerRepo.findById(id));
        for(Cart c:carts)
            System.out.println(c);
        return carts;
    }

    @GetMapping(path = "viewaddress/{id}")
    public List<Address> viewAddress(@PathVariable("id") int id)
    {
        List<Address> addresses = addressRepo.findByCustomer(customerRepo.findById(id));
        for(Address c:addresses)
            System.out.println(c);
        return addresses;
    }



}
