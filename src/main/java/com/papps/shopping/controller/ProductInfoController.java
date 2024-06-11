package com.papps.shopping.controller;

import com.papps.shopping.dto.request.ProductInfoRequestDto;
import com.papps.shopping.dto.response.ProductInfoResponseDto;
import com.papps.shopping.entity.ProductInfo;
import com.papps.shopping.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {

    private final ProductInfoService productInfoService;


    @PostMapping("/")
    public ResponseEntity<ProductInfo> save(@RequestBody ProductInfoRequestDto input) {
        var result = productInfoService.save(input);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInfoResponseDto> view(@PathVariable long id) {
        var result = productInfoService.view(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductInfo> update(@PathVariable long id, @RequestBody ProductInfoRequestDto input) {
        var result = productInfoService.update(id, input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductInfo> delete(@PathVariable long id) {
        var result = productInfoService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
