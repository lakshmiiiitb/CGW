package com.example.cgw.JPAData;

import javax.persistence.*;
@Table
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // 1 vijay nagar
    // 2 shanti nagar
    private Integer id;
    private String area;
    private String city;
    private String state;
    private String pincode;

    @ManyToOne
    //Adding the name
    @JoinColumn(name = "Cust_id")
    private Customer customer;

    public Address(){}


    public Address(Integer id, String area, String city, String state, Customer p, String pincode) {
        this.id = id;
        this.area = area;
        this.city = city;
        this.state = state;
        this.customer = p;
        this.pincode=pincode;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer p) {
        this.customer = p;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", customer=" + customer +
                '}';
    }
}
