package com.example.inventorymanagement.service;

import com.example.inventorymanagement.models.Item;
import java.util.List;

public interface ItemService {

  List<Item> getAllItems();

  Item addItem(Item item);

  Item updateItem(int id, Item request) throws Exception;

  Item findById(int id) throws Exception;

  Item deleteItem(int id) throws Exception;


}
