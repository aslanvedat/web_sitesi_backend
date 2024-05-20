package com.papps.shopping.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
private  Long id;

    @Column(name = "userName")
private String name;
    @Column(name = "userMail")
private String emailAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContactInfo>contacts;//todo one to many

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order>orders;//todo one to many




}
