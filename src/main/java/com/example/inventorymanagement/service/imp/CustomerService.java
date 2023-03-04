package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.CustomerResponse;
import com.example.inventorymanagement.repo.CartRepo;
import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements com.example.inventorymanagement.service.CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CartRepo cartRepo;
    public List<Customer>getAllCustomer(){
        return customerRepo.findAll();
    }

    public CustomerResponse addCustomer(Customer customer){
        customer= customerRepo.save(customer);
        cartRepo.addCart(customer.getCustomerId());
        return new CustomerResponse(true,"added",customer, cartRepo.getCart(customer.getCustomerId()));
    }

    public CustomerResponse updateCustomer(int id, String contact){
        CustomerResponse customerResponse =validate(id,"updated");
        if(customerResponse.isStatus()){
            Customer customer= customerRepo.findById(id).get();
            customer.setContactDetails(contact);
            customerResponse.setCustomer(customerRepo.save(customer));
        }
        return customerResponse;

    }

    public CustomerResponse getCustomer(int id){
        CustomerResponse customerResponse =validate(id,"ok");
        if(customerResponse.isStatus()){
            Customer customer= customerRepo.findById(id).get();
            customerResponse.setCustomer(customer);
        }
        return customerResponse;

    }


    public CustomerResponse validate(int id, String type){
        try{
            Customer customer=customerRepo.findById(id).get();
            return new CustomerResponse(true,type);
        }catch (Exception ex){
            return new CustomerResponse(false,"failed");
        }

    }

    public CustomerResponse deleteCustomer(int id){
        CustomerResponse customerResponse =validate(id,"deleted");
        if(customerResponse.isStatus()){
            Customer customer= customerRepo.findById(id).get();
            customerResponse.setCustomer(customer);
            customerRepo.deleteById(id);
            cartRepo.deleteById(id);

        }
        return customerResponse;
    }



}
