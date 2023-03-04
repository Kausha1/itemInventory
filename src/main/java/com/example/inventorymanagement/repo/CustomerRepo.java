package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    List<Customer> findAll();

    @Override
    Optional<Customer> findById(Integer integer);


}