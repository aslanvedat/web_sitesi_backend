package com.papps.shopping.service;

import com.papps.shopping.dto.request.ProductInfoRequestDto;
import com.papps.shopping.dto.response.ProductInfoResponseDto;
import com.papps.shopping.entity.ProductInfo;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    private final ProductInfoRepository productInfoRepository;


    @Override
    public ProductInfo findById(long id) {
        Optional<ProductInfo> productInfo = productInfoRepository.findById(id);
        return productInfo.orElseThrow(() -> new ApiRequestException("Product info is not found"));
    }

    @Override
    public ProductInfo save(ProductInfoRequestDto input) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setName(input.getName());
        productInfo.setBarcode(input.getBarcode());
        productInfo.setMetaData(input.getMetaData());
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfoResponseDto view(long id) {
        var result = findById(id);
        return new ProductInfoResponseDto(result);
    }

    @Override
    public ProductInfo delete(long id) {
        var result = findById(id);
        productInfoRepository.delete(result);
        return result;
    }

    @Override
    public ProductInfo update(long id, ProductInfoRequestDto input) {
        var productInfo = findById(id);
        productInfo.setName(input.getName());
        productInfo.setBarcode(input.getBarcode());
        productInfo.setMetaData(input.getMetaData());
        return productInfoRepository.save(productInfo);
    }
}
