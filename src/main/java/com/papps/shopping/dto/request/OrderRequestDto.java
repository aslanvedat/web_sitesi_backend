package com.papps.shopping.dto.request;

import com.papps.shopping.entity.ContactInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    private List<String> productIds;

    @NotBlank(message = "Name cannot be empty")
    private ContactInfo contact;
    @NotBlank(message = "Name cannot be empty")
    private float amaount;
}
