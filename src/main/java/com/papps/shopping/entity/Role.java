package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "roleName")
    private String name;
}
