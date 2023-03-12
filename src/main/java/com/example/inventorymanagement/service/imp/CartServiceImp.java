package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.dto.CartItemRequest;
import com.example.inventorymanagement.models.Cart;
import com.example.inventorymanagement.repo.CartRepo;
import com.example.inventorymanagement.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService {

  private final CartRepo cartRepo;

  public Cart findById(int id) throws Exception {
    return findByIdOrThrow(id);
  }

  private Cart findByIdOrThrow(int id) throws Exception {
    final Cart cart = cartRepo.getCart(id);
    if (cart == null) {
      throw new Exception("No such Customer Exist");
    }
  }

  public Cart addToCart(int id, CartItemRequest request) throws Exception {
    Cart cart = findById(id);
    cart.getCartItemArrayList().add(new CartItem(request.getItemId(), request.getQuantity()));
    return cart;
  }


  public Cart updateCart(int id, CartItemRequest request) throws Exception {
    final Cart cart = findById(id);
    int CartItemIndex = findItemInCart(request.getItemId(), cart);
    if (request.getQuantity() == 0) {
      cart.getCartItemArrayList().remove(CartItemIndex);
    } else {
      cart.getCartItemArrayList().get(CartItemIndex).setQuantity(request.getQuantity());
    }
    return cart;
  }

  public int findItemInCart(int itemId, Cart cart) throws Exception {
    for (int i = 0; i < cart.getCartItemArrayList().size(); i++) {
      if (cart.getCartItemArrayList().get(i).getItemId() == itemId) {
        return i;
      }
    }
    throw new Exception("No such Item Exist");
  }


}
