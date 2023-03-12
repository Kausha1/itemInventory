package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.models.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class ItemRepo {

  private final HashMap<Integer, Item> itemRepo = new HashMap<>();


  public Item save(Item item) {
    itemRepo.put(item.getItemId(), item);
    return item;
  }

  public List<Item> findAll() {
    List<Item> itemList = new ArrayList<>();
    for (Item item : itemRepo.values()) {
      itemList.add(item);
    }
    return itemList;

  }

  public Item findById(int id) {
    return itemRepo.get(id);
  }

  public void deleteById(int id) {
    itemRepo.remove(id);
  }


}
