package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.models.Cart;
import java.util.ArrayList;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartRepo {// In Memory

  private HashMap<Integer, Cart> itemMap;

  public void setItemMap(HashMap<Integer, Cart> itemMap) {
    this.itemMap = itemMap;
  }

  public void addCart(int id) {
    if (itemMap == null) {
      setItemMap(new HashMap<Integer, Cart>());
    }
    itemMap.put(id, new Cart());
  }

  public HashMap<Integer, Cart> showAllCart() {
    return this.itemMap;
  }

  public Cart getCart(int id) {
    return this.itemMap.get(id);
  }

  public void EmptyCart(int id) {
    getCart(id).getCartItemArrayList().clear();
  }

  public void deleteById(int id) {
    itemMap.remove(id);
  }

  public boolean isContainCart(int id) {
    return itemMap.containsKey(id);
  }



}
