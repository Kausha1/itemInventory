package com.example.inventorymanagement.service;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.dto.OrderResponse;
import com.example.inventorymanagement.models.Order;

import java.util.ArrayList;

public interface OrderService {

    Order addOrder(int id);


}
