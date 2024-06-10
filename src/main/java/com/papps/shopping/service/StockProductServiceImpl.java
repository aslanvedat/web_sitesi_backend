package com.papps.shopping.service;

import com.papps.shopping.dto.request.StockProductRequestDto;
import com.papps.shopping.dto.response.StockProductResponseDto;
import com.papps.shopping.entity.StockProduct;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repostory.StockProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockProductServiceImpl implements StockProductService {
    private final StockProductRepository stockProductRepository;

    @Override
    public StockProduct findById(long id) {
        Optional<StockProduct> stockProduct = stockProductRepository.findById(id);
        return stockProduct.orElseThrow(() -> new ApiRequestException("product stock is not found"));
    }

    @Override
    public StockProduct save(StockProductRequestDto input) {
        StockProduct stockProduct = new StockProduct();
        stockProduct.setPrice(input.getPrice());
        stockProduct.setQuantity(input.getQuantity());
        stockProduct.setProductInfo(input.getProductInfo());//todo burasida daha sonra duzenlenecek
        return stockProductRepository.save(stockProduct);
    }

    @Override
    public StockProductResponseDto view(long id) {
        var result = findById(id);
        return new StockProductResponseDto(result);
    }

    @Override
    public StockProduct delete(long id) {
        var result = findById(id);
        stockProductRepository.delete(result);
        return result;
    }

    @Override
    public StockProduct update(long id, StockProductRequestDto input) {
        var stockProduct = findById(id);
        stockProduct.setPrice(input.getPrice());
        stockProduct.setQuantity(input.getQuantity());
        stockProduct.setProductInfo(input.getProductInfo());//todo burasida daha sonra duzenlenecek
        return stockProductRepository.save(stockProduct);
    }
}
