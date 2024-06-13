package com.papps.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class OrderRequestDto {

    private List<String> orderProductIds;
    @NotBlank(message = "Name cannot be empty")
    private Long contactId;
    @NotBlank(message = "Name cannot be empty")
    private float amaount;
}
