package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

@Entity
@Data
@Table(name = "stock_product", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token"})})
@SQLDelete(sql = "UPDATE stock_product SET deleted=true, deletion_token = id WHERE id=?")
public class StockProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    private ProductInfo productInfo;

    private float price;

    private int quantity;

    @JsonIgnore
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;
}
