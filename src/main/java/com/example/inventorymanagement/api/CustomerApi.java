package com.example.inventorymanagement.api;


import static com.example.inventorymanagement.utils.ResponseUtils.okResponseEntity;

import com.example.inventorymanagement.dto.CustomerUpdateRequest;
import com.example.inventorymanagement.dto.ResponseEntity;
import com.example.inventorymanagement.models.Customer;
import com.example.inventorymanagement.service.CustomerService;
import com.example.inventorymanagement.service.imp.CustomerServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerApi {

  private final CustomerService customerService;


  @PostMapping("")
  ResponseEntity addCustomer(@RequestBody Customer customer) {
    return okResponseEntity(customerService.addCustomer(customer));
  }


  @GetMapping()
  ResponseEntity getAllCustomer() {
    return okResponseEntity(customerService.getAllCustomer());
  }

  @GetMapping("/{id}")
  ResponseEntity getCustomer(@PathVariable("id") int id) throws Exception {
    return okResponseEntity(customerService.findById(id));
  }


  @PutMapping("/{id}")
  ResponseEntity updateCustomer(@PathVariable("id") int id, @RequestBody CustomerUpdateRequest contact)
      throws Exception {
    return okResponseEntity(customerService.updateCustomer(id, contact.getContactDetails()));
  }


  @DeleteMapping("/{id}")
  ResponseEntity deleteCustomer(@PathVariable("id") int id) throws Exception {
    return okResponseEntity(customerService.deleteCustomer(id));
  }

}
