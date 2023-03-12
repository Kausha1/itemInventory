package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.models.Order;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class OrderRepo {

  private final HashMap<Integer, Order> orderRepo = new HashMap<Integer, Order>();

  public Order save(Order order) {
    orderRepo.put(order.getId(), order);
    return order;
  }

  public void addItemList(int id, ArrayList<CartItem> itemArrayList) {

    orderRepo.get(id).setCartItems(new ArrayList<CartItem>(itemArrayList));
  }


}
