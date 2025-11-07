package com.golam.userInfo.controllers;

import com.golam.userInfo.dtos.UserDto;
import com.golam.userInfo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public String getAllUsers() {
        return "Hello from User Info Controller";
    }

    @GetMapping("/getuserById/{id}")
    public ResponseEntity<UserDto> getAllUsers(@PathVariable int id) {
        UserDto userById = userService.getUserById(id);
        return userById != null ?
                new ResponseEntity<>(userById, HttpStatus.OK) :  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.saveUser(userDto);
        return savedUser != null ?
                new ResponseEntity<>(savedUser, HttpStatus.CREATED) :
                ResponseEntity.status(500).build();
    }
}
