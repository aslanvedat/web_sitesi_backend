package com.papps.shopping.service;

import com.papps.shopping.dto.request.OrderRequestDto;
import com.papps.shopping.dto.response.OrderResponseDto;
import com.papps.shopping.entity.Order;

public interface OrderService {
    Order findById(long id);

    Order save(OrderRequestDto input);

    OrderResponseDto view(long id);

    Order delete(long id);

    Order update(long id, OrderRequestDto input);
}
