package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.dto.OrderResponse;
import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.models.Order;
import com.example.inventorymanagement.repo.*;
import com.example.inventorymanagement.service.OrderService;

import com.example.inventorymanagement.utils.Imp.OrderIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {

    private final OrderRepo orderRepo;
    private final CartRepo cartRepo;
    private final ItemRepo itemRepo;
    private final CustomerRepo customerRepo;

    private final OrderIdGenerator orderIdGenerator;


    public Order addOrder(int id){
        int total= totalBill(cartRepo.getCart(id));
        Customer customer=customerRepo.findById(id);
        Order order=orderRepo.save(new Order(orderIdGenerator.generator(),customer,total,new Date()));
        orderRepo.addItemList(order.getId(),cartRepo.getCart(id));
        cartRepo.EmptyCart(id);
        return order;
    }


    private int totalBill(ArrayList<CartItem> cartItemArrayList){
        int total=0;
        for(CartItem cartItem: cartItemArrayList){
            total+=cartItem.getQuantity()*(itemRepo.findById(cartItem.getItemId()).getPrice());
        }
        return total;
    }

}
