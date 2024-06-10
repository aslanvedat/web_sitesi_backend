package com.papps.shopping.service;


import com.papps.shopping.dto.request.StockProductRequestDto;
import com.papps.shopping.dto.response.StockProductResponseDto;
import com.papps.shopping.entity.StockProduct;

public interface StockProductService {
    StockProduct findById(long id);

    StockProduct save(StockProductRequestDto input);

    StockProductResponseDto view(long id);

    StockProduct delete(long id);

    StockProduct update(long id, StockProductRequestDto input);
}
