package com.papps.shopping.dto.response;

import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.entity.Order;
import com.papps.shopping.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private User user;
    private List<OrderProductResponseDto> orderProducts;
    private ContactInfo contact;
    private float amaount;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.user = order.getUser();
        this.amaount = order.getAmaount();
        this.contact = order.getContact();
        this.orderProducts = order.getOrderProducts().stream().map(OrderProductResponseDto::new).toList();
    }


}
