package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Role", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
