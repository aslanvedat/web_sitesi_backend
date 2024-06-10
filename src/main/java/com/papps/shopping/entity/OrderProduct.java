package com.papps.shopping.entity;

import com.papps.shopping.entity.enum_.OrderProductStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

@Data
@Entity
@Table(name = "order_product", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token"})})
@SQLDelete(sql = "UPDATE order_product SET deleted=true, deletion_token = id WHERE id=?")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    Order order;
    ProductInfo productInfo;
    private float price;

    @Enumerated(EnumType.STRING)
    private OrderProductStatus status;

}
