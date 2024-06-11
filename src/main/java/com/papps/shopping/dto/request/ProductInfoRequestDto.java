package com.papps.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductInfoRequestDto {


    @NotBlank(message = "Name cannot be empty")
    private String name;

    private String metaData;

    @NotBlank(message = "Name cannot be empty")
    private String barcode;
}
