package com.example.inventorymanagement.service.imp;

import static com.example.inventorymanagement.utils.ItemUtil.updateDTO;

import com.example.inventorymanagement.models.Item;
import com.example.inventorymanagement.repo.IdGeneratorRepo;
import com.example.inventorymanagement.repo.ItemRepo;
import com.example.inventorymanagement.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService {

  /**
   * todo :
   * <p>
   * 1. Autowire vs RAC difference, konsa injections hota hai, which is better
   * 2. Final Keyword
   * 3. Formatting
   * 4. Repo is brainless
   * 5. getById -> api that should return null if no object id found with that id
   * 6. function name better
   * 7. cas service, check what should be the response from servcie layer.
   * <p>
   * 8. id generator // db,
   */


  private final ItemRepo itemRepo;
  private final IdGeneratorRepo idGeneratorRepo;

  public List<Item> getAllItems() {
    return itemRepo.findAll();
  }

  public Item addItem(Item item) {
    item.setItemId(idGeneratorRepo.getId("item"));
    return itemRepo.save(item);
  }

  public Item updateItem(int id, Item request) throws Exception {
    final Item existing = findByIdOrThrow(id);

    updateDTO(request, existing);
    request = itemRepo.save(existing);
    return request;

  }

  private Item findByIdOrThrow(int id) throws Exception {
    final Item item = itemRepo.findById(id);
    if (item == null) {
      throw new Exception("item is not found");
    }
    return item;
  }

  public Item findById(int id) throws Exception {
    return findByIdOrThrow(id);
  }


  public Item deleteItem(int id) throws Exception {

    Item item = itemRepo.findById(id);
    itemRepo.deleteById(id);
    return item;

  }


}
