package com.papps.shopping.service;

import com.papps.shopping.dto.request.OrderProductRequestDto;
import com.papps.shopping.dto.response.OrderProductResponseDto;
import com.papps.shopping.entity.OrderProduct;

public interface OrderProductService {
    OrderProduct findById(long id);

    OrderProduct save(OrderProductRequestDto input);

    OrderProductResponseDto view(long id);

    OrderProduct delete(long id);

    OrderProduct update(long id, OrderProductRequestDto input);
}
