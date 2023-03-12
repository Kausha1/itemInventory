package com.example.inventorymanagement.models;


public class Customer {


  private int customerId;

  private String name;

  private String contactDetails;

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContactDetails() {
    return contactDetails;
  }

  public void setContactDetails(String contactDetails) {
    this.contactDetails = contactDetails;
  }

}
