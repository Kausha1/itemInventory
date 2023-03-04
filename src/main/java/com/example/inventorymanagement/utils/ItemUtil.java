package com.example.inventorymanagement.utils;

import com.example.inventorymanagement.models.Item;
import lombok.experimental.UtilityClass;


public final class ItemUtil {
    public static void updateDTO(Item source,Item destination){
        destination.setDescription(source.getDescription());
        destination.setName(source.getName());
        destination.setPrice(source.getPrice());
    }

}
