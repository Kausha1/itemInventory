package com.example.inventorymanagement.dto;

import java.util.HashMap;

public class ResponseEntity {

  private  HashMap<String, Object> response;

  public void add(String key,Object value){
    if(response==null){
      response=new HashMap<>();
    }
    response.put(key,value);
  }



}
