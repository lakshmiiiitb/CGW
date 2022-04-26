package com.example.cgw.JPAData;

import javax.persistence.*;

@Entity
@Table
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private char status;
    @OneToOne
    Cart cart;
    @OneToOne
    Address address;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    Partner partner;


    public Orders(int id, Cart cart, Address address, Partner partner, char Status) {
        this.id = id;
        this.cart = cart;
        this.address = address;
        this.partner = partner;
        this.status= Status;
        //this.delivery=delivery;
    }

    public Orders(){}

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", status=" + status +
                ", cart=" + cart +
                ", address=" + address +
                ", partner=" + partner +
                '}';
    }
}
