package com.example.cgw.JPAData;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private String storeName;
    private String storeLoc;
    private String username;
    private String password;
    private String contactno;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<Items> itemsSet;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<Orders> ordersSet;

    public Partner() {
    }

    public Partner(String storeName, String storeLoc, String username, String password, String contactno) {
        this.storeName = storeName;
        this.storeLoc = storeLoc;
        this.username = username;
        this.password = password;
        this.contactno = contactno;
    }

    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    public Set<Items> getItemsSet() {
        return itemsSet;
    }

    public void setItemsSet(Set<Items> itemsSet) {
        this.itemsSet = itemsSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLoc() {
        return storeLoc;
    }

    public void setStoreLoc(String storeLoc) {
        this.storeLoc = storeLoc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String toString()
    {
        return this.getStoreName()+" "+this.getStoreLoc()+" "+this.getContactno();
    }
}
