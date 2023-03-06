package com.example.inventorymanagement.dto;




public class CartItem {

    private int itemId;
    private int quantity;


    public CartItem(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;

    }

    public CartItem() {

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
