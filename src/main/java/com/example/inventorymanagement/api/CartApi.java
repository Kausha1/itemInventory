package com.example.inventorymanagement.api;

import static com.example.inventorymanagement.utils.ResponseUtils.okResponseEntity;

import com.example.inventorymanagement.dto.CartItemRequest;
import com.example.inventorymanagement.dto.ResponseEntity;
import com.example.inventorymanagement.service.CartService;
import com.example.inventorymanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CartApi {

  private final CartService cartService;
  private final OrderService orderService;

  @PostMapping("/{id}/cart")
  ResponseEntity addToCart(@PathVariable("id") int id, @RequestBody CartItemRequest request) throws Exception {
    return okResponseEntity(cartService.addToCart(id, request));
  }

  @GetMapping("/{id}/cart")
  ResponseEntity showCart(@PathVariable("id") int id) throws Exception {
    return okResponseEntity(cartService.findById(id));
  }

  @PutMapping("/{id}/cart")
  ResponseEntity updateCart(@PathVariable("id") int id, @RequestBody CartItemRequest request) throws Exception {
    return okResponseEntity(cartService.updateCart(id, request));
  }

  @GetMapping("/{id}/order")
  ResponseEntity addOrder(@PathVariable("id") int id) throws Exception {
    return okResponseEntity(orderService.addOrder(id));
  }

}
