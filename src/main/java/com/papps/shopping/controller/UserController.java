package com.papps.shopping.controller;
import com.papps.shopping.dto.request.UserRequestDto;
import com.papps.shopping.dto.response.UserResponseDto;
import com.papps.shopping.entity.User;
import com.papps.shopping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    @GetMapping("/")
    public Collection<User>findAll(){return userService.findAll();}


    @CrossOrigin//buna bakacam
    @PostMapping("/")
public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto userRequestDto)//requestbody onune valid gelebilir
    {
var saveUser=userService.save(userRequestDto);
return  new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable long user_id ) {
        var deletedUser=userService.deleteById(user_id);
        return  new ResponseEntity<>(deletedUser,HttpStatus.OK);
    }
    @PutMapping("/{user_id}")
    public ResponseEntity<UserResponseDto>update(@PathVariable long user_id,@RequestBody UserRequestDto userRequestDto) {
        var updateUser=userService.update(user_id,userRequestDto);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }

}


