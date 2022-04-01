package com.example.cgw.JPAData;

import javax.persistence.*;

@Entity
@Table
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String item_name;
    private double price;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Partner partner;

    public Items(){}

    public Items(int id, String item_name, double price, int qty, Partner p) {
        this.id = id;
        this.item_name = item_name;
        this.price = price;
        this.qty = qty;
        this.partner = p;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner p) {
        this.partner = p;
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_name='" + item_name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", partner=" + partner +
                '}';
    }
}
