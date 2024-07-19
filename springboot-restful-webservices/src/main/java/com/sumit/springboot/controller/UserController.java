package com.sumit.springboot.controller;

import com.sumit.springboot.service.UserService;
import lombok.AllArgsConstructor;
import com.sumit.springboot.dto.UserDto;
import com.sumit.springboot.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    //create User REST API
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
      UserDto savedUser=  userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build get user by ID rest api
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    //get all users rest api
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users= userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //api for updating existing user
    @PutMapping("{id}")
    //http://localhost:8080/api/users/1
    public ResponseEntity<User>updateUser(@PathVariable("id") Long userId,@RequestBody User user){
        user.setId(userId);
            User updatedUser=userService.updateUser(user);
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    //api for deleting an existing user
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }
}
