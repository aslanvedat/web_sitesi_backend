package com.papps.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StockProductRequestDto {

    @NotBlank(message = "Name cannot be empty")
    private long productInfoId;

    @NotBlank(message = "Name cannot be empty")
    private float price;

    @NotBlank(message = "Name cannot be empty")
    private int quantity;
}
