package com.papps.shopping.dto.response;

import com.papps.shopping.entity.User;
import lombok.Data;

@Data
public class UserResponseDto {
    private long id;
    private String name;
    private String emailAddress;


    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.emailAddress = user.getEmailAddress();
    }
}

