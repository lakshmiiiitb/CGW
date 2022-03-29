package com.example.cgw.JPAData;

import javax.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String item_name;
    private int qty;
    private double price;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    Customer customer;

    public Cart(){}
    public Cart(int id, String item_name, int qty, double price, Customer customer) {
        this.id = id;
        this.item_name = item_name;
        this.qty = qty;
        this.price = price;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
