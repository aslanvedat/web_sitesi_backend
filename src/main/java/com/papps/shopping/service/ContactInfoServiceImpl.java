package com.papps.shopping.service;

import com.papps.shopping.dto.request.ContactInfoRequestDto;
import com.papps.shopping.dto.response.ContactInfoResponseDto;
import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.entity.User;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repository.ContactInfoRepository;
import com.papps.shopping.security.UserContext;
import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;
    private final UserService userService;
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

        UserPrincipal currentUser = UserContext.getCurrentUser();
        User user = userService.findByEmail(currentUser.getName());
        contactInfo.setUser(user);

        return contactInfoRepository.save(contactInfo);
    }

    @Override
    public ContactInfoResponseDto viewContactInfo(long id) { // todo current user check eklenecek
        var result = findById(id);
        return new ContactInfoResponseDto(result);
    }

    @Override
    public ContactInfo deleteById(long id) {
        var result = findById(id); // todo current user check eklenecek
        contactInfoRepository.delete(result);
        return result;
    }

    @Override
    public ContactInfo updateContactInfo(ContactInfoRequestDto contactInfoRequestDto, long id) {
        var contactInfo = findById(id);

        UserPrincipal currentUser = UserContext.getCurrentUser();
        if(!contactInfo.getUser().getName().equals(currentUser.getName())) {
            throw new ApiRequestException("You're only updated own contact info");
        }

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
