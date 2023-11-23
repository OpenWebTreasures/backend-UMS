package com.example.UMS.features.user.controller;

import com.example.UMS.features.common.ResponseHandler;
import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.user.dto.*;
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
    @RequiresFeature(Feature.CREATE_USER)
    public ResponseEntity createUser(@RequestBody CreateUserEntityDto createUserEntityDto) {
        return ResponseHandler.successfulResponse(userService.create(createUserEntityDto));
    }

    @PostMapping("/changeuserpassword")
    @RequiresFeature(Feature.CHANGE_ANY_USER_PASSWORD)
    public ResponseEntity changeUserPassword(@RequestBody ChangeUserPasswordDto changeUserPasswordDto) {
        userService.changeUserPassword(changeUserPasswordDto);
        return ResponseHandler.successfulResponse();
    }

    @PostMapping("/changeselfpassword")
    @RequiresFeature(Feature.CHANGE_SELF_PASSWORD)
    public ResponseEntity changeSelfPassword(@RequestBody ChangeSelfPasswordDto changeSelfPasswordDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        changeSelfPasswordDto.setUsername(user.getUsername());
        userService.changeSelfPassword(changeSelfPasswordDto);
        return ResponseHandler.successfulResponse();
    }

    @PostMapping("/changeroles")
    @RequiresFeature(Feature.CHANGE_USER_ROLES)
    public ResponseEntity changeUserRoles(@RequestBody ChangeUserRolesDto changeUserRolesDto) {
        userService.updateRoles(changeUserRolesDto);
        return ResponseHandler.successfulResponse();
    }

    @GetMapping("/me")
    public ResponseEntity getConnectedUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return ResponseHandler.successfulResponse(userService.getConnectedUserDetails(user.getUsername()));
    }

    @GetMapping("/countusers")
    @RequiresFeature(Feature.COUNT_USERS)
    public ResponseEntity count() {
        return ResponseHandler.successfulResponse(userService.countUsers());
    }


    @GetMapping
    @RequiresFeature(Feature.FIND_ALL_USERS)
    public ResponseEntity getAllUsers() {
        return ResponseHandler.successfulResponse(userService.findAll());
    }

    @PutMapping("/updateuserdetails/{username}")
    @RequiresFeature(Feature.UPDATE_ANY_USER_DETAILS)
    public ResponseEntity updateAnyUserDetails(@PathVariable String username, @RequestBody ChangeUserDetailsDto changeUserDetailsDto) {
        userService.updateUserDetails(username,changeUserDetailsDto);
        return ResponseHandler.successfulResponse();
    }

    @PutMapping("/updateselfdetails")
    @RequiresFeature(Feature.UPDATE_SELF_USER_DETAILS)
    public ResponseEntity updateSelfUserDetails(@RequestBody ChangeUserDetailsDto changeUserDetailsDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        userService.updateUserDetails(user.getUsername(),changeUserDetailsDto);
        return ResponseHandler.successfulResponse();
    }

    @GetMapping("/{id}")
    @RequiresFeature(Feature.FIND_USER_BY_ID)
    public ResponseEntity getUserById(@PathVariable Long id) {
        return ResponseHandler.successfulResponse(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    @RequiresFeature(Feature.DELETE_USER_BY_ID)
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseHandler.successfulResponse();
    }

}
