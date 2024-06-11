package com.papps.shopping.controller;

import com.papps.shopping.dto.request.OrderProductRequestDto;
import com.papps.shopping.dto.response.OrderProductResponseDto;
import com.papps.shopping.entity.OrderProduct;
import com.papps.shopping.service.OrderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderProduct")
public class OrderProductController {
    private final OrderProductService orderProductService;

    @PostMapping("/")
    public ResponseEntity<OrderProduct> save(@RequestBody OrderProductRequestDto input) {
        var result = orderProductService.save(input);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProductResponseDto> view(@PathVariable long id) {
        var result = orderProductService.view(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderProduct> delete(@PathVariable long id) {
        var result = orderProductService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderProduct> update(@PathVariable long id, @RequestBody OrderProductRequestDto input) {
        var result = orderProductService.update(id, input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
