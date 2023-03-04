package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.ItemResponse;
import com.example.inventorymanagement.models.Item;
import com.example.inventorymanagement.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.inventorymanagement.utils.ItemUtil.*;

@Service
@RequiredArgsConstructor
public class ItemService implements com.example.inventorymanagement.service.ItemService {


    private final ItemRepo itemRepo;

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public ItemResponse addItem(Item item) {
        return new ItemResponse(true, "added", itemRepo.save(item));
    }

    public ItemResponse updateItem(int id, Item request) {
        ItemResponse itemResponse = validate(id, "updated");
        if (itemResponse.isStatus()) {
            Item item = itemRepo.findById(id).get();
            updateDTO(request, item);
            request = itemRepo.save(item);
        }
        itemResponse.setItem(request);
        return itemResponse;

    }

    public ItemResponse getItem(int id) {
        ItemResponse customerResponse = validate(id, "ok");
        if (customerResponse.isStatus()) {
            Item item = itemRepo.findById(id).get();
            customerResponse.setItem(item);
        }
        return customerResponse;

    }



    public ItemResponse deleteItem(int id) {
        ItemResponse customerResponse = validate(id, "deleted");
        if (customerResponse.isStatus()) {
            Item item = itemRepo.findById(id).get();
            customerResponse.setItem(item);
            itemRepo.deleteById(id);

        }
        return customerResponse;
    }

    public ItemResponse validate(int id, String type) {
        try {
            Item item = itemRepo.findById(id).get();
            return new ItemResponse(true, type);
        } catch (Exception ex) {
            return new ItemResponse(false, "failed");
        }

    }


}
