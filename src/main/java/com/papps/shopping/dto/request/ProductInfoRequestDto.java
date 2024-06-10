package com.papps.shopping.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class ProductInfoRequestDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Name cannot be empty")//todo burda bi degisiklik yapilabilir!!!
    private Map<String, String> metaData;

    @NotBlank(message = "Name cannot be empty")
    private String barcode;
}
