package com.example.inventorymanagement.models;

import com.example.inventorymanagement.dto.CartItem;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne(targetEntity = Customer.class)
    Customer customer;

    private int total;

    @CreatedDate
    @Column(name = "Invoice created at")
    private Date time;

    public Order(Customer customer,int total){
        this.customer=customer;
        this.total=total;
    }


    public Order() {

    }
}
