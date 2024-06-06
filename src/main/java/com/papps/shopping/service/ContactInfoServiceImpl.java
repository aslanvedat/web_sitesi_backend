package com.papps.shopping.service;

import com.papps.shopping.dto.request.ContactInfoRequestDto;
import com.papps.shopping.dto.response.ContactInfoResponseDto;
import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repostory.ContactInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;

    @Override
    public ContactInfo findById(long id) {
        Optional<ContactInfo> contactInfo = contactInfoRepository.findById(id);
        return contactInfo.orElseThrow(() -> new ApiRequestException("contact info is not found"));
    }

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

    @Override
    public ContactInfoResponseDto viewContactInfo(long id) {
        var result = findById(id);
        return new ContactInfoResponseDto(result);
    }

    @Override
    public ContactInfo deleteById(long id) {
        var result = findById(id);
        contactInfoRepository.delete(result);
        return result;
    }

    @Override
    public ContactInfo updateContactInfo(ContactInfoRequestDto contactInfoRequestDto, long id) {
        var contactInfo = findById(id);
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
