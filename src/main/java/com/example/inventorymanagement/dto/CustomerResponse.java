package com.example.inventorymanagement.dto;


import com.example.inventorymanagement.models.Customer;

import java.util.ArrayList;

public class CustomerResponse {
    private boolean status;
    private String response;

    private Customer customer;
    private ArrayList<CartItem> itemList;

    public CustomerResponse(boolean status, String response, Customer customer,ArrayList<CartItem> itemList) {
        this.status = status;
        this.response = response;
        this.customer=customer;
        this.itemList=itemList;
    }

    public CustomerResponse(boolean status, String response) {
        this.status = status;
        this.response = response;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
