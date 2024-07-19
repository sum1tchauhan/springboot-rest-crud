package com.sumit.springboot.mapper;

import com.sumit.springboot.dto.UserDto;
import com.sumit.springboot.entity.User;

public class UserMapper {
    //convert user JPA entity into UserDto
    public static UserDto maptoUserDto(User user){
        UserDto userDto=new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
        return userDto;
    }
    //convert userDto into user Jpa entity
    public static User maptoUser(UserDto userDto){
        User user=new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
