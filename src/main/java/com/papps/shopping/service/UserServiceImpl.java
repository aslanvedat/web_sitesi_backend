package com.papps.shopping.service;

import com.papps.shopping.dto.request.UserRequestDto;
import com.papps.shopping.dto.response.UserResponseDto;
import com.papps.shopping.entity.User;
import com.papps.shopping.exception.ApiRequestException;
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
    public User findById(long id) {
        Optional<User>userOptional=userRepository.findById(id);

        return userOptional.orElseThrow(()->new ApiRequestException("user is not found"));
    }


    //todo burasi validation  eklendikten sonra duzenlenecek
    @Override
    public UserResponseDto save(UserRequestDto request) {
        if(userRepository.existsByMail(request.getMail())){
            throw new ApiRequestException("this user already exist!");

        }
        if(!request.getPassword().equals(request.getPasswordTekrar())){
            throw new ApiRequestException("this password cannot match");
        }
        var theUser=new User(request);
        var savedUser=userRepository.save(theUser);
        return new UserResponseDto(savedUser);
    }

    @Override
    public User save(User user) {
        if (userRepository.existsByMail(user.getEmailAddress())){
            throw new ApiRequestException("this user already exist!");
        }
        return userRepository.save(user);
    }

    @Override
    public UserResponseDto update(long user_id, UserRequestDto requestDTO)  {
  var user=findById(user_id);
  User user1=new User(requestDTO);
  user1.setId(user.getId());
   var updateUser=userRepository.save(user1);
  return new UserResponseDto(updateUser);
    }

    @Override
    public UserResponseDto deleteById(long id)  {
       var user=findById(id);
       userRepository.delete(user);
       return  new UserResponseDto(user);
    }

    @Override
    public boolean existByMail(String mail) {return userRepository.existsByMail(mail);
    }
}
