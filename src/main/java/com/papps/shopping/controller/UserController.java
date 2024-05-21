package com.papps.shopping.controller;
//secondt

import com.papps.shopping.entity.User;
import com.papps.shopping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    @GetMapping("/")
    public Collection<User>findAll(){return userService.findAll();}

}


