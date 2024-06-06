package com.papps.shopping.service;

import com.papps.shopping.dto.request.ProductRequestDto;
import com.papps.shopping.dto.response.ProductResponseDto;
import com.papps.shopping.entity.Product;

public interface ProductService {
    Product save(ProductRequestDto input);

    Product findById(long id);

    ProductResponseDto viewProduct(long id);

    Product delete(long id);

    Product update(ProductRequestDto input, Long id);
}
