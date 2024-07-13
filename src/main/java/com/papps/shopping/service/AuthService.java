package com.papps.shopping.service;

import com.papps.shopping.dto.request.AuthRequestDto;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.security.JpaUserService;
import com.papps.shopping.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JpaUserService jpaUserDetailsService;

    private final JwtUtils jwtUtils;

    public String authenticate(AuthRequestDto request) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getMail(), request.getPassword(),
                            new ArrayList<>()));
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(request.getMail());
            if (user != null) {
                return jwtUtils.generateToken(user);

            }
            throw new ApiRequestException("Error authentication");
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage(), e);
        }
    }

}
