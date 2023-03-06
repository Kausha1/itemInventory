package com.example.inventorymanagement.service.imp;

import com.example.inventorymanagement.dto.CartItem;
import com.example.inventorymanagement.dto.CartItemRequest;
import com.example.inventorymanagement.dto.CartItemResponse;
import com.example.inventorymanagement.repo.CartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService implements com.example.inventorymanagement.service.CartService {

    private final CartRepo cartRepo;

    public CartItemResponse showCart(int id){
        CartItemResponse cartItemResponse =validate(id,"Your Cart");
        if(cartItemResponse.isStatus()){
            cartItemResponse.setCartItems(cartRepo.getCart(id));
        }
        return cartItemResponse;

    }
    public CartItemResponse addToCart(int id, CartItemRequest request){
        CartItemResponse cartItemResponse =validate(id,"item is added");
        if(cartItemResponse.isStatus()){
            cartRepo.getCart(id).add(new CartItem(request.getItemId(), request.getQuantity()));
            cartItemResponse.setCartItems(cartRepo.getCart(id));
        }
        return cartItemResponse;
    }
    CartItemResponse validate(int id, String description){
        if(!cartRepo.isContainCart(id)){
            return new CartItemResponse(false,"Customer is invalid");
        }
        return new CartItemResponse(true,description);

    }

    public CartItemResponse updateCart(int id, CartItemRequest request){
        CartItemResponse cartItemResponse =validate(id,"");

        if(cartItemResponse.isStatus()){
            int CartItemIndex=cartRepo.findItemInCart(id,request.getItemId());
           if(CartItemIndex==-1){
               cartItemResponse.setStatus(false);
               cartItemResponse.setResponse("cart is not valid");
           }else{
               if(request.getQuantity()==0){
                   cartRepo.getCart(id).remove(CartItemIndex);
               }
               else {

                   cartRepo.getCart(id).get(CartItemIndex).setQuantity(request.getQuantity());
               }

               cartItemResponse.setCartItems(cartRepo.getCart(id));

           }
        }
        return cartItemResponse;
    }




}
