package com.example.inventorymanagement.service;

import com.example.inventorymanagement.models.Customer;
import java.util.List;

public interface CustomerService {

  List<Customer> getAllCustomer();

  Customer addCustomer(Customer customer);

  Customer updateCustomer(int id, String contact) throws Exception;

  Customer findById(int id) throws Exception;

  Customer deleteCustomer(int id) throws Exception;




}
