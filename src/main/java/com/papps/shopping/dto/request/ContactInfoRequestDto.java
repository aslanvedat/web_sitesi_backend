package com.papps.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactInfoRequestDto {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Name cannot be empty")
    private String addressName;

    @NotBlank(message = "Name cannot be empty")
    private String fullAddress;

    @NotBlank(message = "Name cannot be empty")
    private String postaCode;

    @NotBlank(message = "Name cannot be empty")
    private String country;

    @NotBlank(message = "Name cannot be empty")
    private String phoneNumber;

//    private String idNumber;

    private Boolean isDefault;


}
