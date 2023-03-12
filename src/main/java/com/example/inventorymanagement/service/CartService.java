package com.example.inventorymanagement.service;

import com.example.inventorymanagement.dto.CartItemRequest;
import com.example.inventorymanagement.models.Cart;

public interface CartService {

  Cart findById(int id) throws Exception;

  Cart addToCart(int id, CartItemRequest request) throws Exception;

  Cart updateCart(int id, CartItemRequest request) throws Exception;


}
