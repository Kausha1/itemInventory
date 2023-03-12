package com.example.inventorymanagement.api;

import static com.example.inventorymanagement.utils.ResponseUtils.okResponseEntity;

import com.example.inventorymanagement.dto.ResponseEntity;
import com.example.inventorymanagement.models.Item;
import com.example.inventorymanagement.service.ItemService;
import com.example.inventorymanagement.service.imp.ItemServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemApi {

  private final ItemService itemService;

  @PostMapping("")
  ResponseEntity addItem(@RequestBody Item item) {
    return okResponseEntity(itemService.addItem(item));
  }

  @GetMapping()
  ResponseEntity getAllItems() {
    return okResponseEntity(itemService.getAllItems());
  }

  @GetMapping("/{id}")
  ResponseEntity getItem(@PathVariable("id") int id) throws Exception {
    return okResponseEntity(itemService.findById(id));
  }

  @PutMapping("/{id}")
  ResponseEntity updateItem(@PathVariable("id") int id, @RequestBody Item item) throws Exception {
    return okResponseEntity(itemService.updateItem(id, item));
  }

  @DeleteMapping("/{id}")
  ResponseEntity deleteItem(@PathVariable("id") int id) throws Exception {
    return okResponseEntity(itemService.deleteItem(id));
  }


}
