package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.CustomerResponse;
import com.example.inventorymanagement.repo.CartRepo;
import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.repo.CustomerRepo;
import com.example.inventorymanagement.utils.Imp.CustomerIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements com.example.inventorymanagement.service.CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerIdGenerator customerIdGenerator;

    @Autowired
    CartRepo cartRepo;
    public List<Customer>getAllCustomer(){
        return customerRepo.findAll();
    }

    public CustomerResponse addCustomer(Customer customer){
        customer.setCustomerId(customerIdGenerator.generator());
        customer= customerRepo.save(customer);
        cartRepo.addCart(customer.getCustomerId());
        return new CustomerResponse(true,"added",customer, cartRepo.getCart(customer.getCustomerId()));
    }

    public CustomerResponse updateCustomer(int id, String contact){
        CustomerResponse customerResponse =validate(id,"updated");
        if(customerResponse.isStatus()){
            Customer customer= customerRepo.findById(id);
            customer.setContactDetails(contact);
            customerResponse.setCustomer(customerRepo.save(customer));
        }
        return customerResponse;

    }

    public CustomerResponse getCustomer(int id){
        CustomerResponse customerResponse =validate(id,"ok");
        if(customerResponse.isStatus()){
            Customer customer= customerRepo.findById(id);
            customerResponse.setCustomer(customer);
        }
        return customerResponse;

    }


    public CustomerResponse validate(int id, String type){
        try{
            Customer customer=customerRepo.findById(id);
            return new CustomerResponse(true,type);
        }catch (Exception ex){
            return new CustomerResponse(false,"failed");
        }

    }

    public CustomerResponse deleteCustomer(int id){
        CustomerResponse customerResponse =validate(id,"deleted");
        if(customerResponse.isStatus()){
            Customer customer= customerRepo.findById(id);
            customerResponse.setCustomer(customer);
            customerRepo.deleteById(id);
            cartRepo.deleteById(id);

        }
        return customerResponse;
    }






}
