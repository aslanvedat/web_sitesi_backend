package com.papps.shopping.controller;


import com.papps.shopping.dto.request.StockProductRequestDto;
import com.papps.shopping.dto.response.StockProductResponseDto;
import com.papps.shopping.entity.StockProduct;
import com.papps.shopping.service.StockProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stockProduct")
public class StockProductController {
    private final StockProductService stockProductService;

    @PostMapping("/")
    public ResponseEntity<StockProduct> save(@RequestBody StockProductRequestDto input) {
        var result = stockProductService.save(input);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockProductResponseDto> view(@PathVariable long id) {
        var result = stockProductService.view(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StockProduct> delete(@PathVariable long id) {
        var result = stockProductService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockProduct> update(@PathVariable long id, @RequestBody StockProductRequestDto input) {
        var result = stockProductService.update(id, input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
