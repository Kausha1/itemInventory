package com.example.inventorymanagement.utils;

import com.example.inventorymanagement.dto.ResponseEntity;
import java.util.HashMap;

public class ResponseUtils {
  public static ResponseEntity okResponseEntity(Object data) {
    ResponseEntity response=new ResponseEntity();

    response.add("data", data);
    response.add("status", "ok");

    return response;

  }

}
