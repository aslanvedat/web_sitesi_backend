package com.papps.shopping.dto.response;

import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.entity.Order;
import com.papps.shopping.entity.User;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private User user;
    //  private List<ProductResponseDto> products;
    private ContactInfo contact;
    private float amaount;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.user = order.getUser();
        this.amaount = order.getAmaount();
        this.contact = order.getContact();
        //   this.products = order.getProducts().stream().map(ProductResponseDto::new).toList();
    }


}
