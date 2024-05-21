package com.papps.shopping.service;

import com.papps.shopping.dto.request.UserRequestDto;
import com.papps.shopping.dto.response.UserResponseDto;
import com.papps.shopping.entity.User;
import com.papps.shopping.repostory.UserRepository;

import java.util.Collection;
import java.util.Optional;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) throws Exception {
        Optional<User>userOptional=userRepository.findById(id);

        return userOptional.orElseThrow(()->new Exception("user is not found"));//todo burasi ve asagidaki methodlar da exception ile degisecek
    }


    //burasi validation ile eklendikten sonra duzenlenecek
    @Override
    public UserResponseDto save(UserRequestDto request) {
        return null;
    }

    @Override
    public User save(User user) {
        if (userRepository.existsByMail(user.getEmailAddress())){
            throw new RuntimeException("this use already exist!");
        }
        return userRepository.save(user);
    }

    @Override
    public UserResponseDto update(long user_id, UserRequestDto requestDTO) {
        return null;
    }

    @Override
    public UserResponseDto deleteById(long id) {
        return null;
    }

    @Override
    public boolean existByMail(String mail) {
        return false;
    }
}
