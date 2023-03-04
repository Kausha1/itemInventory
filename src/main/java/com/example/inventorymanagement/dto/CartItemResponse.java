package com.example.inventorymanagement.dto;

import java.util.ArrayList;

public class CartItemResponse {

    private boolean status;
    private String response;
    private ArrayList<CartItem> cartItems;

    public CartItemResponse() {
    }

    public CartItemResponse(boolean status, String response) {
        this.status = status;
        this.response = response;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
