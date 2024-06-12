package com.papps.shopping.dto.response;

import com.papps.shopping.entity.OrderProduct;
import com.papps.shopping.entity.ProductInfo;
import com.papps.shopping.entity.enum_.OrderProductStatus;
import lombok.Data;

@Data
public class OrderProductResponseDto {
    private long id;

    //  private Order order;
    private ProductInfo productInfo;
    private float price;
    private OrderProductStatus status;


    public OrderProductResponseDto(OrderProduct input) {
        this.id = input.getId();
        //    this.order = input.getOrder();
        this.productInfo = input.getProductInfo();
        this.price = input.getPrice();
        this.status = input.getStatus();
    }
}
