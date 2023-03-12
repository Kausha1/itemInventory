package com.example.inventorymanagement.dto;

import com.example.inventorymanagement.models.Item;

public class ItemResponse {

  private boolean status;
  private String response;

  private Item item;

  public ItemResponse(boolean status, String response, Item item) {
    this.status = status;
    this.response = response;
    this.item = item;
  }

  public ItemResponse(boolean status, String response) {
    this.status = status;
    this.response = response;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}
