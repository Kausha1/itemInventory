package com.example.inventorymanagement.repo;


import com.example.inventorymanagement.models.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class CustomerRepo {

    private final HashMap<Integer,Customer>customerRepo=new HashMap<>();


    public Customer save(Customer customer){
        customerRepo.put(customer.getCustomerId(),customer);
        return customer;
    }

    public List<Customer> findAll(){
        List<Customer> customerList=new ArrayList<>();
        for(Customer customer:customerRepo.values()){
            customerList.add(customer);

        }
        return customerList;

    }

    public Customer findById(int id) throws NullPointerException{

        Customer customer=customerRepo.get(id);
        if(customer==null){
            throw new NullPointerException();
        }
        return customer;

    }

    public void deleteById(int id){
        customerRepo.remove(id);
    }





}