package com.papps.shopping.controller;

import com.papps.shopping.dto.request.AuthRequestDto;
import com.papps.shopping.dto.request.UserRequestDto;
import com.papps.shopping.dto.response.UserResponseDto;
import com.papps.shopping.service.AuthService;
import com.papps.shopping.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public UserResponseDto signUp(@Valid @RequestBody UserRequestDto request) {
        return userService.save(request);
    }


    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequestDto requestDTO) {
        String token = authService.authenticate(requestDTO);
        var response = Map.of("JwtToken", token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
