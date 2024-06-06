package com.papps.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductRequestDto {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Name cannot be empty")
    private String barcode;

    @NotBlank(message = "Name cannot be empty")
    private int quantity;

    @NotBlank(message = "Name cannot be empty")
    private float price;

    @NotBlank(message = "Name cannot be empty")
    private boolean isShow;
}
