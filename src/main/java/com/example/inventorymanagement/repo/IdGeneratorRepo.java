package com.example.inventorymanagement.repo;

import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class IdGeneratorRepo {

  private HashMap<String, Integer> IdGenerator;

  public IdGeneratorRepo() {
    IdGenerator = new HashMap<>();
  }

  public int getId(String model) {
    if (IdGenerator == null) {
      IdGenerator = new HashMap<>();
    }
    if (!IdGenerator.containsKey(model)) {
      IdGenerator.put(model, 0);
    }
    Integer id = IdGenerator.get(model);
    id++;
    return id;
  }
}
