package com.example.UMS.features.user.controller;

import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.service.UserService;
import com.example.UMS.security.RequiresFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserEntityController {

    private final UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntityDto userEntityDto) {
        return userService.create(userEntityDto);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @RequiresFeature("F1")
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/details")
    @ResponseBody
    public UserDetails getUserDetails(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
