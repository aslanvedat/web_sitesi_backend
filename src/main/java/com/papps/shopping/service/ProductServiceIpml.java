package com.papps.shopping.service;

import com.papps.shopping.dto.request.ProductRequestDto;
import com.papps.shopping.dto.response.ProductResponseDto;
import com.papps.shopping.entity.Product;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repostory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceIpml implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public Product save(ProductRequestDto input) {
        Product product = new Product();
        product.setName(input.getName());
        product.setBarcode(input.getBarcode());
        product.setQuantity(input.getQuantity());
        product.setPrice(input.getPrice());
        product.setShow(input.isShow());//todo burasi da response taki hatadan dolayi dogru calismiyor
        return productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ApiRequestException("contact info is not found"));
    }

    @Override
    public ProductResponseDto viewProduct(long id) {
        var result = findById(id);
        return new ProductResponseDto(result);
    }

    @Override
    public Product delete(long id) {
        var result = findById(id);
        productRepository.delete(result);
        //     productRepository.deleteById(id);

        return result;
    }

    @Override
    public Product update(ProductRequestDto input, Long id) {
        Product product = new Product();
        product.setName(input.getName());
        product.setBarcode(input.getBarcode());
        product.setQuantity(input.getQuantity());
        product.setPrice(input.getPrice());
        product.setShow(input.isShow());//todo burasi da response taki hatadan dolayi dogru calismiyor
        return productRepository.save(product);
    }
}
