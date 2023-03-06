package com.example.inventorymanagement.api;


import com.example.inventorymanagement.dto.*;
import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.models.Order;
import com.example.inventorymanagement.service.OrderService;
import com.example.inventorymanagement.service.imp.CartService;
import com.example.inventorymanagement.service.imp.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;
    private final CartService cartService;
    private final OrderService orderService;


    @PostMapping("")
    CustomerResponse addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PostMapping("/{id}/cart")
    CartItemResponse addToCart(@PathVariable("id") int id, @RequestBody CartItemRequest request) {
        return cartService.addToCart(id, request);
    }

    @GetMapping()
    List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    CustomerResponse getCustomer(@PathVariable("id") int id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/{id}/cart")
    CartItemResponse showCart(@PathVariable("id") int id) {
        return cartService.showCart(id);
    }

    @GetMapping("/{id}/order")
    Order addOrder(@PathVariable("id")int id){
         return orderService.addOrder(id);
    }


    @PutMapping("/{id}")
    CustomerResponse updateCustomer(@PathVariable("id") int id, @RequestBody CustomerUpdateRequest contact) {
        return customerService.updateCustomer(id, contact.getContactDetails());
    }


    @PutMapping("/{id}/cart")
    CartItemResponse updateCart(@PathVariable("id") int id, @RequestBody CartItemRequest request) {
        return cartService.updateCart(id, request);
    }

    @DeleteMapping("/{id}")
    CustomerResponse deleteCustomer(@PathVariable("id") int id) {
        return customerService.deleteCustomer(id);
    }

}
