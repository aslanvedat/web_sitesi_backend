package com.papps.shopping.dto.response;

import com.papps.shopping.entity.ContactInfo;
import lombok.Data;

@Data
public class ContactInfoResponseDto {
    private Long id;

    private String name;

    private String AddressName;

    private String fullAddress;

    private String postaCode;

    private String country;

    private String phoneNumber;

    //  private String idNumber;

    private Boolean isDefault;

    public ContactInfoResponseDto(ContactInfo contactInfo) {
        this.id = contactInfo.getId();
        this.name = contactInfo.getName();
        this.AddressName = contactInfo.getAddressName();
        this.fullAddress = contactInfo.getFullAddress();
        this.postaCode = contactInfo.getPostaCode();
        this.country = contactInfo.getCountry();
        this.phoneNumber = contactInfo.getPhoneNumber();
        this.isDefault = contactInfo.getIsDefault();

    }
}
