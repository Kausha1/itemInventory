package com.example.inventorymanagement.service;

import com.example.inventorymanagement.dto.ItemResponse;
import com.example.inventorymanagement.models.Item;

import java.util.List;

public interface ItemService {
     List<Item> getAllItems();
     ItemResponse addItem(Item item);
     ItemResponse updateItem(int id, Item request);
     ItemResponse getItem(int id);
     ItemResponse deleteItem(int id);






}
