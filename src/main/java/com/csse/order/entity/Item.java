package com.csse.order.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "qty")
    private int qty;

    @Column(name = "price")
    private float price;

    public Item(String itemName, int qty, float price) {
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
    }
}
