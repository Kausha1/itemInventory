package com.example.inventorymanagement.dto;


import com.example.inventorymanagement.models.Order;
import java.util.ArrayList;


public class OrderResponse {

  Order order;
  ArrayList<CartItem> cartItems;

  public OrderResponse(Order order, ArrayList<CartItem> cartItems) {
    this.order = order;
    this.cartItems = cartItems;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public ArrayList<CartItem> getCartItems() {
    return cartItems;
  }

  public void setCartItems(ArrayList<CartItem> cartItems) {
    this.cartItems = cartItems;
  }
}
