package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

@Data
@Entity
@Table(name = "Product", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletionToken"})})
@SQLDelete(sql = "UPDATE Product SET deleted=yes, deletionToken = id WHERE id=?")
public class Product extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String barcode;

    private int quantity;

    private float price;

    private boolean isShow;

    @JsonIgnore
    @Column(name = "deletionToken")
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;
}
