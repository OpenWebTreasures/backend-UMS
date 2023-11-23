package com.example.UMS.features.role.controller;

import com.example.UMS.features.common.ResponseHandler;
import com.example.UMS.features.role.dto.FeatureRoleDto;
import com.example.UMS.features.role.dto.RoleDto;
import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import com.example.UMS.security.RequiresFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @RequiresFeature(Feature.CREATE_ROLE)
    public ResponseEntity createRole(@RequestBody RoleDto roleDto) {
        log.warn("Creating New Role :"+roleDto.toString());
        return ResponseHandler.successfulResponse(roleService.createRole(roleDto));
    }

    @GetMapping
    @RequiresFeature(Feature.FIND_ALL_ROLES)
    public ResponseEntity findAllRoles() {
        return ResponseHandler.successfulResponse(roleService.findAllRoles());
    }

    @PostMapping("/assignfeature")
    @RequiresFeature(Feature.ASSIGN_FEATURE_TO_ROLE)
    public ResponseEntity addFeatureToRole(@RequestBody FeatureRoleDto featureRoleDto) {
        log.warn(String.format("Service call : Assign Feature: %s To Role : %s", featureRoleDto.getFeatureName(),featureRoleDto.getRoleName()));
        roleService.addFeatureToRole(featureRoleDto.getRoleName(), featureRoleDto.getFeatureName());
        return ResponseHandler.successfulResponse("{} assigned successfully to {}".formatted(featureRoleDto.getFeatureName(),featureRoleDto.getRoleName()));
    }

    @PostMapping("/revokefeature")
    @RequiresFeature(Feature.REVOKE_FEATURE_TO_ROLE)
    public ResponseEntity revokeFeatureFromRole(@RequestBody FeatureRoleDto featureRoleDto) {
        log.warn(String.format("Service call : Revoke Feature: %s from Role : %s", featureRoleDto.getFeatureName(),featureRoleDto.getRoleName()));

        roleService.revokeFeatureFromRole(featureRoleDto.getRoleName(), featureRoleDto.getFeatureName());
        return ResponseHandler.successfulResponse("{} revoked from {}".formatted(featureRoleDto.getFeatureName(),featureRoleDto.getRoleName()));
    }

    @GetMapping("/{name}")
    @RequiresFeature(Feature.FIND_ROLE_BY_NAME)
    public ResponseEntity findRoleByName(@PathVariable String name) {
        return ResponseHandler.successfulResponse(roleService.findRoleByName(name));
    }
}
