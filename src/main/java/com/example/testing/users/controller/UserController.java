package com.example.testing.users.controller;

import com.example.testing.users.dto.UserDTO;
import com.example.testing.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public UserDTO createuser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }
}
