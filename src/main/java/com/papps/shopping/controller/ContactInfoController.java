package com.papps.shopping.controller;


import com.papps.shopping.dto.request.ContactInfoRequestDto;
import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contactInfo")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    @PostMapping
    public ResponseEntity<ContactInfo> save(@RequestBody ContactInfoRequestDto input) {
        var saveContactInfo = contactInfoService.save(input);
        return new ResponseEntity<>(saveContactInfo, HttpStatus.CREATED);
    }


}
