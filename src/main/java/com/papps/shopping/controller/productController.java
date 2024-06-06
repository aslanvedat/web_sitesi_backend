package com.papps.shopping.controller;

import com.papps.shopping.dto.request.ProductRequestDto;
import com.papps.shopping.dto.response.ProductResponseDto;
import com.papps.shopping.entity.Product;
import com.papps.shopping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class productController {
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> save(@RequestBody ProductRequestDto input) {
        var saveProduct = productService.save(input);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> view(@PathVariable long id) {
        var result = productService.viewProduct(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id) {
        var result = productService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductRequestDto input, @PathVariable long id) {
        var result = productService.update(input, id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
