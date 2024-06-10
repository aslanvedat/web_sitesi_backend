package com.papps.shopping.dto.request;

import com.papps.shopping.entity.ProductInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StockProductRequestDto {

    ProductInfo productInfo;//todo buraya bi bak sonra


    @NotBlank(message = "Name cannot be empty")
    private float price;

    @NotBlank(message = "Name cannot be empty")
    private int quantity;
}
