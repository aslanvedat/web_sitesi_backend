package com.papps.shopping.service;

import com.papps.shopping.dto.request.ProductRequestDto;
import com.papps.shopping.dto.response.ProductResponseDto;
import com.papps.shopping.entity.Product;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repostory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceIpml implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public Product save(ProductRequestDto input) {
        if (productRepository.existsByName(input.getName())) {
            throw new ApiRequestException("this product already exist!");
        }
        Product product = new Product();
        product.setName(input.getName());
        product.setBarcode(input.getBarcode());
        product.setQuantity(input.getQuantity());
        product.setPrice(input.getPrice());
        product.setShow(input.isShow());
        return productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ApiRequestException("contact info is not found"));
    }

    @Override
    public Collection<Product> findByIds(List<Long> ids) {
        //todo bu method yazilacak!!!
        return null;
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

        return result;
    }

    @Override
    public Product update(ProductRequestDto input, Long id) {
        Product product = findById(id);
        product.setName(input.getName());
        product.setBarcode(input.getBarcode());
        product.setQuantity(input.getQuantity());
        product.setPrice(input.getPrice());
        product.setShow(input.isShow());//todo burasi da response taki hatadan dolayi dogru calismiyor
        return productRepository.save(product);
    }
    //findbyids yazilacak
}
