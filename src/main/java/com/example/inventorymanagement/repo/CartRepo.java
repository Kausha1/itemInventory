package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.dto.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class CartRepo {// In Memory

    private HashMap<Integer, ArrayList<CartItem>> itemMap;

    public void setItemMap(HashMap<Integer, ArrayList<CartItem>> itemMap) {
        this.itemMap = itemMap;
    }

    public void addCart(int id) {
        if (itemMap==null) {
            setItemMap(new HashMap<Integer,ArrayList<CartItem>>());
        }
        itemMap.put(id, new ArrayList<>());
    }

    public HashMap<Integer, ArrayList<CartItem>> showAllCart() {
        return this.itemMap;
    }

    public ArrayList<CartItem> getCart(int id) {
        return this.itemMap.get(id);
    }

    public void EmptyCart(int id){
        getCart(id).clear();
    }

    public void deleteById(int id) {
        itemMap.remove(id);
    }

    public boolean isContainCart(int id) {
        return itemMap.containsKey(id);
    }

    public int findItemInCart(int id, int itemId) {
        for (int i = 0; i < itemMap.get(id).size(); i++) {
            if (itemMap.get(id).get(i).getItemId() == itemId) {
                return i;
            }
        }
        return -1;
    }

}
