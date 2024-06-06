package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "product", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token"})})
@SQLDelete(sql = "UPDATE product SET deleted=true, deletion_token = id WHERE id=?")
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
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;
}
