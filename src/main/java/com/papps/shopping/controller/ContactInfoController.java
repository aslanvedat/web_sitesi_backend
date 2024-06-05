package com.papps.shopping.controller;


import com.papps.shopping.dto.request.ContactInfoRequestDto;
import com.papps.shopping.dto.response.ContactInfoResponseDto;
import com.papps.shopping.entity.ContactInfo;
import com.papps.shopping.repostory.ContactInfoRepository;
import com.papps.shopping.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contactInfo")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;
    private final ContactInfoRepository contactInfoRepository;

    @PostMapping
    public ResponseEntity<ContactInfo> save(@RequestBody ContactInfoRequestDto input) {
        var saveContactInfo = contactInfoService.save(input);
        return new ResponseEntity<>(saveContactInfo, HttpStatus.CREATED);
    }

    //todo bu endpoint gereksiz olabilir user kisminda adresleri goruntulersek buna gerek olmayabilir!!
    @GetMapping("/{id}")
    public ResponseEntity<ContactInfoResponseDto> viewContactInfo(@PathVariable long id) {
        var result = contactInfoService.viewContactInfo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/id")
    public ResponseEntity<ContactInfo> delete(Long id) {
        var result = contactInfoService.deleteById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
