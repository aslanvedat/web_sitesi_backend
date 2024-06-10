package com.papps.shopping.service;

import com.papps.shopping.dto.request.ProductInfoRequestDto;
import com.papps.shopping.dto.response.ProductInfoResponseDto;
import com.papps.shopping.entity.ProductInfo;

public interface ProductInfoService {
    ProductInfo findById(long id);

    ProductInfo save(ProductInfoRequestDto input);

    ProductInfoResponseDto view(long id);

    ProductInfo delete(long id);

    ProductInfo update(long id, ProductInfoRequestDto input);
}
