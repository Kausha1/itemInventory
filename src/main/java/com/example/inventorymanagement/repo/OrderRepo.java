package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    List<Order> findAll();
    Order findById(int id);
    List<Order> findAllByCustomer(int id);


}
