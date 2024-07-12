package com.papps.shopping.security;

import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author : Onur TALANTIMUR
 * @mailto : onurta@netas.com.tr
 * @created : 12.07.2024, Friday
 **/
@Service
@RequiredArgsConstructor
public class JpaUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException { // mail kullanmadıgimiz icin mail ile islemleri yapiyoruz
        return userRepository.findByMail(mail).map(UserSecurity::new).orElseThrow(() -> new ApiRequestException("User not found mail: " + mail));
    }
}
