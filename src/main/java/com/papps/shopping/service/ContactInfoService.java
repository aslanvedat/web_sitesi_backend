package com.papps.shopping.service;

import com.papps.shopping.dto.request.ContactInfoRequestDto;
import com.papps.shopping.entity.ContactInfo;

public interface ContactInfoService {

    ContactInfo save(ContactInfoRequestDto contactInfoRequestDto);
}
