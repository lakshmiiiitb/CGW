package com.example.cgw.controller;

import com.example.cgw.JPAData.*;
import com.example.cgw.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
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

    @Autowired
    OrdersRepo ordersRepo;

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
    public List<Partner> viewShopsbyLocation(@RequestBody LocationType loc)
    {
        //String location=loc.getLocation().substring(0,loc.getLocation().length()-1);
        List<Partner> shops=partnerRepo.findByStoreLoc(loc.getLocation(), loc.getType());
        System.out.println(loc);
        System.out.println(shops.size());
        for(Partner shp:shops)
            System.out.println(shp);
        return shops;
    }

    @PostMapping(path = "viewshops1")
    public List<Partner> viewShopsbyLocation1(@RequestBody String location,@RequestBody String type)
    {
        System.out.println(location+" "+type);
        //String location=loc.getLocation().substring(0,loc.getLocation().length()-1);
        List<Partner> shops=partnerRepo.findByStoreLoc(location, type);

        System.out.println(shops.size());
        for(Partner shp:shops)
            System.out.println(shp);
        return shops;
    }

    /*@Transactional
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
    }*/

    @GetMapping(path = "/addtocart/{userid}/{itemid}/{qty}")
    public String addToCart(@PathVariable("userid") int id, @PathVariable("itemid") int itemid, @PathVariable("qty") int qty)
    {
        Customer customer=customerRepo.findById(id);
        Items items=itemsRepo.findById(itemid);
        cartRepo.save(new Cart(items.getItem_name(), qty, qty*items.getPrice(), items.getDescription(), items.getImage(),customer));
        return "added";
    }


    @Transactional
    @GetMapping(path = "/addorders/{cartid}/{addid}/{shopid}/{qty}")
    public String addOrders(@PathVariable("cartid") int cartid,@PathVariable("shopid") int shopid, @PathVariable("addid") int addid, @PathVariable("qty") int qty)
    {
        Cart cart= cartRepo.findById(cartid);
        Partner partner=partnerRepo.findById(shopid);
        Address address=addressRepo.findById(addid);
        Items items=itemsRepo.findByShopAndItemName(partner, cart.getItem_name());

        //System.out.println(partner.getStoreName());
        //System.out.println(items.getItem_name());
        if(items!=null)
        {
            int status=itemsRepo.decrementQuantity(qty,partner,items.getId());
            System.out.println(status);
            if(status >0)
                System.out.println("Updated");
            else
                System.out.println("Not updated");


            Orders o=new Orders(cart,address,partner, 'o',null);
            ordersRepo.save(o);

        }
        return "done";
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
        System.out.println(id);
        List<Address> addresses = addressRepo.findByCustomer(customerRepo.findById(id));
        System.out.println(addresses.size());
        for(Address c:addresses)
            System.out.println(c);
        return addresses;
    }

    @GetMapping("item/{id}")
    public Items getItem(@PathVariable("id") int id)
    {
        Items items=itemsRepo.findById(id);
        return items;
    }

    @GetMapping("address/{id}")
    public List<Address> getAddress(@PathVariable("id") int id)
    {
        List<Address> address= addressRepo.findByCustomer(customerRepo.findById(id));
        return address;
    }


    @PostMapping("addAddress/{id}")
    public String addAddress(@PathVariable("id") int id, Address address)
    {
        address.setCustomer(customerRepo.findById(id));
        addressRepo.save(address);
        return "done";
    }

    @PostMapping(path = "addprofilephotoCustomer")
    public String  saveProfile(int id, MultipartFile file, String item_name, int qty, double price, String desc)
    {
        Customer customer=customerRepo.findById(id);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            customer.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        customerRepo.save(customer);
        return "done";
    }

    @GetMapping(path = "customer/{id}")
    public Customer getCustomer(@PathVariable("id") int id)
    {
        return customerRepo.findById(id);
    }

}
