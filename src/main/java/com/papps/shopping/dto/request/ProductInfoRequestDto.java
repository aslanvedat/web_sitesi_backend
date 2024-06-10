package com.papps.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class ProductInfoRequestDto {


    @NotBlank(message = "Name cannot be empty")
    private String name;

    private Map<String, String> metaData;

    @NotBlank(message = "Name cannot be empty")
    private String barcode;
}
