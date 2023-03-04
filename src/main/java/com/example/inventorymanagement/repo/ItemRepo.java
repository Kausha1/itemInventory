package com.example.inventorymanagement.repo;

import com.example.inventorymanagement.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {

    List<Item> findAll();

    @Override
    Optional<Item> findById(Integer integer);


}
