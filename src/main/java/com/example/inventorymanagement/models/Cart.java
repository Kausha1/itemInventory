package com.example.inventorymanagement.models;

import com.example.inventorymanagement.dto.CartItem;
import java.util.ArrayList;

public class Cart {

  ArrayList<CartItem> cartItemArrayList;

  public Cart() {
    this.cartItemArrayList = new ArrayList<>();
  }

  public ArrayList<CartItem> getCartItemArrayList() {
    return cartItemArrayList;
  }

  public void setCartItemArrayList(ArrayList<CartItem> cartItemArrayList) {
    this.cartItemArrayList = cartItemArrayList;
  }
}
