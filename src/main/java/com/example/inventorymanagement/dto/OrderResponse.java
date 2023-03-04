package com.example.inventorymanagement.dto;

import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.models.Order;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class OrderResponse {

    Order order;
    ArrayList<CartItem> cartItems;

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public OrderResponse(Order order, ArrayList<CartItem> cartItems) {
        this.order = order;
        this.cartItems = cartItems;
    }
}
