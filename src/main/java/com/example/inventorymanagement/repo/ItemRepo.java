package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.models.Item;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class ItemRepo {

    private final HashMap<Integer, Item> itemRepo=new HashMap<>();


    public Item save(Item item){
        itemRepo.put(item.getItemId(),item);
        return item;
    }

    public List<Item> findAll(){
        List<Item> itemList=new ArrayList<>();
        for(Item item:itemRepo.values()){
            itemList.add(item);
        }
        return itemList;

    }

    public Item findById(int id) throws NullPointerException{

        Item item=itemRepo.get(id);
        if(item==null){
            throw new NullPointerException();
        }
        return item;

    }

    public void deleteById(int id){
        itemRepo.remove(id);
    }






}
