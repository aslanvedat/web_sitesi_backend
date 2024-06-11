package com.papps.shopping.entity;

import com.papps.shopping.entity.enum_.OrderProductStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

@Data
@Entity
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    private Order order;
    @ManyToOne
    private ProductInfo productInfo;
    private float price;

    @Enumerated(EnumType.STRING)
    private OrderProductStatus status;

}
