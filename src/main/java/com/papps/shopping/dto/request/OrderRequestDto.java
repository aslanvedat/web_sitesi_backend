package com.papps.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    private List<String> productIds;

    @NotBlank(message = "Name cannot be empty")
    private Long contactId;
    @NotBlank(message = "Name cannot be empty")
    private float amaount;
}
