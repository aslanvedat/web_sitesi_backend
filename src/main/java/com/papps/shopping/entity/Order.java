package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Order")
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    @Column(name = "user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product>products;//todo burasi one to many olacak

    @Column(name = "contact")
    private ContactInfo contact;

    @Column(name = "amount")
    private float amaount;

}
