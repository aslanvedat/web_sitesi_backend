package com.papps.shopping.dto.request;

import com.papps.shopping.entity.enum_.OrderProductStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderProductRequestDto {
    private long orderId;
    private long productInfoId;
    private float price;
    private OrderProductStatus status;
}
