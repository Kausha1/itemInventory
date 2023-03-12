package com.example.inventorymanagement.utils;

abstract public class IdGenerator {

  public int id = 0;

  public int generator() {
    return id++;
  }


}
