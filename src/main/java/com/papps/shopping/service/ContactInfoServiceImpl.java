package com.papps.shopping.service;

import com.papps.shopping.dto.request.ContactInfoRequestDto;
import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.repostory.ContactInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;

    //todo user bilgisi daha sonra tokendan alinip eklenecek
    @Override
    public ContactInfo save(ContactInfoRequestDto contactInfoRequestDto) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setName(contactInfoRequestDto.getName());
        contactInfo.setAddressName(contactInfoRequestDto.getAddressName());
        contactInfo.setFullAddress(contactInfoRequestDto.getFullAddress());
        contactInfo.setPostaCode(contactInfoRequestDto.getPostaCode());
        contactInfo.setCountry(contactInfoRequestDto.getCountry());
        contactInfo.setPhoneNumber(contactInfoRequestDto.getPhoneNumber());
        contactInfo.setIsDefault(contactInfoRequestDto.getIsDefault());//todo unique kontrolu yapilacak
        return contactInfoRepository.save(contactInfo);
    }
}
