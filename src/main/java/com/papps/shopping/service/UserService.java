package com.papps.shopping.service;

import com.papps.shopping.dto.request.UserRequestDto;
import com.papps.shopping.dto.response.UserResponseDto;
import com.papps.shopping.entity.User;

import java.util.Collection;

public interface UserService {

    Collection<User> findAll();

    User findById(long id) throws Exception;

    UserResponseDto save(UserRequestDto request);

    User save(User user);

    UserResponseDto update(long user_id, UserRequestDto requestDTO);

    UserResponseDto deleteById(long id);

    boolean existByMail(String mail);

}
