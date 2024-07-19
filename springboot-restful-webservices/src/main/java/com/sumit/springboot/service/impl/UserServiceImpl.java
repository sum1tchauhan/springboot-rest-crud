package com.sumit.springboot.service.impl;

import com.sumit.springboot.mapper.UserMapper;
import lombok.AllArgsConstructor;
import com.sumit.springboot.dto.UserDto;
import com.sumit.springboot.entity.User;
import com.sumit.springboot.repository.UserRepository;
import com.sumit.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    //create user takes UserDto as method argument but we need to store jpa entity
    //object in to database so we need to first convert UserDto to user JPA entity object
//    and then we pass that user JPA entity object to this save method
    public UserDto createUser(UserDto userDto){
        //convert UserDto into User JPA entity
        User user = UserMapper.maptoUser(userDto);
                User savedUser=userRepository.save(user);
                //convert User jpa entity to UserDto
        UserDto savedUserDto=UserMapper.maptoUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userID) {
        Optional<User>optionalUser=userRepository.findById(userID);
        User user=optionalUser.get();
        return UserMapper.maptoUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User>users =userRepository.findAll();
        return users.stream().map(UserMapper::maptoUserDto).collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        User existingUser=userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
