package com.example.UMS.features.user.controller;

import com.example.UMS.features.common.ResponseHandler;
import com.example.UMS.features.user.dto.CreateUserEntityDto;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.service.UserService;
import com.example.UMS.security.RequiresFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserEntityController {

    private final UserService userService;

    @PostMapping
    @RequiresFeature("CREATE_USER")
    public ResponseEntity createUser(@RequestBody CreateUserEntityDto createUserEntityDto) {
        return ResponseHandler.successfulResponse(userService.create(createUserEntityDto));
    }

    @GetMapping
    @RequiresFeature("FIND_ALL_USERS")
    public ResponseEntity getAllUsers() {
        return ResponseHandler.successfulResponse(userService.findAll());
    }

    @GetMapping("/{id}")
    @RequiresFeature("FIND_USER_BY_ID")
    public ResponseEntity getUserById(@PathVariable Long id) {
        return ResponseHandler.successfulResponse(userService.getUserById(id));
    }

    @GetMapping("/me")
    public ResponseEntity getConnectedUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return ResponseHandler.successfulResponse(userService.getConnectedUserDetails(user.getUsername()));
    }


    @DeleteMapping("/{id}")
    @RequiresFeature("DELETE_USER_BY_ID")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseHandler.successfulResponse();
    }

}
