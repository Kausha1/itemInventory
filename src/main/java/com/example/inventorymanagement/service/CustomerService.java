package com.example.inventorymanagement.service;

import com.example.inventorymanagement.dto.CustomerResponse;
import com.example.inventorymanagement.models.Customer;

import java.util.List;

public interface CustomerService {
     List<Customer> getAllCustomer();
     CustomerResponse addCustomer(Customer customer);
     CustomerResponse updateCustomer(int id, String contact);
     CustomerResponse getCustomer(int id);
     CustomerResponse deleteCustomer(int id);
   CustomerResponse validate(int id, String type);





}
