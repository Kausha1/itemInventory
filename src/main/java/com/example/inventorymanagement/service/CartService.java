package com.example.inventorymanagement.service;

import com.example.inventorymanagement.dto.CartItemRequest;
import com.example.inventorymanagement.dto.CartItemResponse;

public interface CartService {
     CartItemResponse showCart(int id);
     CartItemResponse addToCart(int id, CartItemRequest request);
     CartItemResponse updateCart(int id, CartItemRequest request);


}
