package com.sumit.springboot.service;

import com.sumit.springboot.dto.UserDto;
import com.sumit.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userID);
    List<UserDto> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
}
