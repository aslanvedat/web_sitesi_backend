package com.papps.shopping.security;

import com.sun.security.auth.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author : Onur TALANTIMUR
 * @mailto : onurta@netas.com.tr
 * @created : 13.07.2024, Saturday
 **/
public class UserContext {

    public static UserPrincipal getCurrentUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new RuntimeException("Authenticated user not found !");
        }
        return (UserPrincipal) authentication.getPrincipal();
    }

}
