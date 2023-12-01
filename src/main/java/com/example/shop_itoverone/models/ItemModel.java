package com.example.shop_itoverone.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="item_model")
@Data
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String name;

    @Column(name = "price")
    double price;

    @Column(name = "disc")
    private String disc;

    @Column(name = "url")
    private String url;

    @Column(name = "add_time")
    Long time;

    @Column(name = "type")
    private String type;
}
