package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import java.util.Map;

@Data
@Entity
@Table(name = "product_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token"})})
@SQLDelete(sql = "UPDATE product_info SET deleted=true, deletion_token = id WHERE id=?")
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private Map<String, String> metaData;
    
    private String barcode;
}
