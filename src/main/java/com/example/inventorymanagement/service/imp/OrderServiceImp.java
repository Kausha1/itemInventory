package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.models.Order;
import com.example.inventorymanagement.repo.CartRepo;
import com.example.inventorymanagement.repo.CustomerRepo;
import com.example.inventorymanagement.repo.IdGeneratorRepo;
import com.example.inventorymanagement.repo.ItemRepo;
import com.example.inventorymanagement.repo.OrderRepo;
import com.example.inventorymanagement.service.OrderService;
import java.util.ArrayList;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {

  private final OrderRepo orderRepo;
  private final CartRepo cartRepo;
  private final ItemRepo itemRepo;
  private final CustomerRepo customerRepo;
  private final IdGeneratorRepo idGeneratorRepo;


  public Order addOrder(int id) throws Exception {
    int total = totalBill(cartRepo.getCart(id).getCartItemArrayList());
    Customer customer = findByIdOrThrow(id);
    Order order = orderRepo.save(new Order(idGeneratorRepo.getId("order"), customer, total, new Date()));
    orderRepo.addItemList(order.getId(), cartRepo.getCart(id).getCartItemArrayList());
    cartRepo.EmptyCart(id);
    return order;
  }

  private Customer findByIdOrThrow(int id) throws Exception {
    Customer customer = customerRepo.findById(id);
    if (customer == null) {
      throw new Exception("No such Customer Exist");
    }
    return customer;
  }


  private int totalBill(ArrayList<CartItem> cartItemArrayList) {
    int total = 0;
    for (CartItem cartItem : cartItemArrayList) {
      total += cartItem.getQuantity() * (itemRepo.findById(cartItem.getItemId()).getPrice());
    }
    return total;
  }

}
