package com.papps.shopping.dto.response;

import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.entity.Order;
import com.papps.shopping.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private User user;
    private List<ProductResponseDto> products;
    private ContactInfo contact;
    private float amaount;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.user = order.getUser();
        this.amaount = order.getAmaount();
        this.contact = order.getContact();
        this.products = order.getProducts().stream().map(ProductResponseDto::new).toList();
    }


}
