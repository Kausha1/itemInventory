package com.example.inventorymanagement.utils;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.repo.ItemRepo;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
@RequiredArgsConstructor
public class OrderUtil {

    public static int totalBill(ArrayList<CartItem> cartItemArrayList,ItemRepo itemRepo){
        int total=0;
        for(CartItem cartItem: cartItemArrayList){
            total+=cartItem.getQuantity()*(itemRepo.findById(cartItem.getItemId()).get().getPrice());
        }
        return total;
    }

}
