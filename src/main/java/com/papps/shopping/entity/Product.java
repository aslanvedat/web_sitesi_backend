package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "productName")
    private String name;

    @Column(name = "barcode")
    private  String barcode;

    @Column(name = "quantity")
    private  int quantity;

    @Column(name = "price")
    private  float price;

    @Column(name = "isShow")
    private  boolean isShow;
}
