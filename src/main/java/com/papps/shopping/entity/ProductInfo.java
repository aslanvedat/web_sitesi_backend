package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

@Data
@Entity
@Table(name = "product_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token", "barcode"})})
@SQLDelete(sql = "UPDATE product_info SET deleted=true, deletion_token = id WHERE id=?")
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String metaData;

    private String barcode;

    @JsonIgnore
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;
}
