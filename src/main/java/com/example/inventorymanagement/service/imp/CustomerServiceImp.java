package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.repo.CartRepo;
import com.example.inventorymanagement.repo.CustomerRepo;
import com.example.inventorymanagement.utils.Imp.CustomerIdGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImp implements com.example.inventorymanagement.service.CustomerService {

  @Autowired
  CustomerRepo customerRepo;
  @Autowired
  CustomerIdGenerator customerIdGenerator;

  @Autowired
  CartRepo cartRepo;

  public List<Customer> getAllCustomer() {
    return customerRepo.findAll();
  }

  public Customer addCustomer(Customer customer) {
    customer.setCustomerId(customerIdGenerator.generator());
    cartRepo.addCart(customer.getCustomerId());
    return customerRepo.save(customer);
  }

  public Customer updateCustomer(int id, String contact) throws Exception{
      final Customer customer=findById(id);
      customer.setContactDetails(contact);
     return customer;

  }

  private Customer findByIdOrThrow(int id) throws Exception{
    Customer customer=customerRepo.findById(id);
    if(customer==null){
      throw  new Exception("No such Customer Exist");
    }
    return customer;
  }

  public Customer findById(int id) throws Exception {
   return findByIdOrThrow(id);

  }


  public Customer deleteCustomer(int id) throws Exception{

      final Customer customer = findById(id);
      customerRepo.deleteById(id);
      cartRepo.deleteById(id);
      return customer;
  }


}
