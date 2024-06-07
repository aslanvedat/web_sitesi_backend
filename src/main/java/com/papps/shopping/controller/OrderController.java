package com.papps.shopping.controller;

import com.papps.shopping.dto.request.OrderRequestDto;
import com.papps.shopping.dto.response.OrderResponseDto;
import com.papps.shopping.entity.Order;
import com.papps.shopping.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;


    @PostMapping("/")
    public ResponseEntity<Order> save(@RequestBody OrderRequestDto input) {
        var result = orderService.save(input);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> view(@PathVariable long id) {
        var result = orderService.view(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable long id) {
        var result = orderService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable long id, @RequestBody OrderRequestDto input) {
        var result = orderService.update(id, input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
