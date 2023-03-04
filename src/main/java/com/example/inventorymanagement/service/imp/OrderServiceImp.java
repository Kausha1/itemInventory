package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.OrderResponse;
import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.models.Order;
import com.example.inventorymanagement.repo.*;
import com.example.inventorymanagement.service.OrderService;
import com.example.inventorymanagement.utils.OrderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {
    private final OrderItemRepo orderItemRepo;
    private final OrderRepo orderRepo;
    private final CartRepo cartRepo;
    private final ItemRepo itemRepo;
    private final CustomerRepo customerRepo;


    public OrderResponse addOrder(int id){
        int total= OrderUtil.totalBill(cartRepo.getCart(id),itemRepo);
        Customer customer=customerRepo.findById(id).get();
        Order order=orderRepo.save(new Order(customer,total));
        orderItemRepo.addItemList(order.getId(),cartRepo.getCart(id));
        OrderResponse orderResponse=new OrderResponse(order,cartRepo.getCart(id));
        cartRepo.EmptyCart(id);
        return orderResponse;
    }

}
