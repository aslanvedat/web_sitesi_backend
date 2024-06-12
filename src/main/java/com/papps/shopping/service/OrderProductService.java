package com.papps.shopping.service;

import com.papps.shopping.dto.request.OrderProductRequestDto;
import com.papps.shopping.dto.response.OrderProductResponseDto;
import com.papps.shopping.entity.OrderProduct;

import java.util.List;

public interface OrderProductService {
    OrderProduct findById(long id);

    List<OrderProduct> findByIds(List<Long> ids);

    OrderProduct save(OrderProductRequestDto input);

    OrderProductResponseDto view(long id);

    OrderProduct delete(long id);

    OrderProduct update(long id, OrderProductRequestDto input);
}
