package com.example.inventorymanagement.models;

import com.example.inventorymanagement.dto.CartItem;
import java.util.ArrayList;
import java.util.Date;


public class Order {

    private int id;
    Customer customer;
    private int total;
    private Date time;
    private ArrayList<CartItem>cartItems;

    public Order(int id,Customer customer, int total, Date time) {
        this.id=id;
        this.customer = customer;
        this.total = total;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Order() {


    }
}
