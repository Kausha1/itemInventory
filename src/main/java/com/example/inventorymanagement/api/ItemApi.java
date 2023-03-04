package com.example.inventorymanagement.api;

import com.example.inventorymanagement.dto.ItemResponse;
import com.example.inventorymanagement.models.Item;
import com.example.inventorymanagement.service.imp.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemApi {

    private final ItemService itemService;

    @PostMapping("")
    ItemResponse addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @GetMapping()
    List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    ItemResponse getItem(@PathVariable("id") int id) {
        return itemService.getItem(id);
    }

    @PutMapping("/{id}")
    ItemResponse updateItem(@PathVariable("id") int id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    ItemResponse deleteItem(@PathVariable("id") int id) {
        return itemService.deleteItem(id);
    }


}
