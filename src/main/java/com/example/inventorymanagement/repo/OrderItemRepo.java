package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.dto.CartItem;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@Component
public class OrderItemRepo {// In Memory
    private HashMap<Integer, ArrayList<CartItem>> orderItemMap;
    private final ItemRepo itemRepo;

    public HashMap<Integer, ArrayList<CartItem>> getOrderItemMap() {
        return orderItemMap;
    }

    public void setOrderItemMap(HashMap<Integer, ArrayList<CartItem>> orderItemMap) {
        this.orderItemMap = orderItemMap;
    }

    public void addItemList(int id,ArrayList<CartItem>itemArrayList){
        if(orderItemMap==null){
            orderItemMap=new HashMap<Integer,ArrayList<CartItem>>();
        }
        orderItemMap.put(id,new ArrayList<CartItem>(itemArrayList));
    }



}
