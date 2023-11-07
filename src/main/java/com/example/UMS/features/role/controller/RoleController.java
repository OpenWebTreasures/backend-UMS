package com.example.UMS.features.role.controller;

import com.example.UMS.features.common.ResponseHandler;
import com.example.UMS.features.role.dto.FeatureRoleDto;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import com.example.UMS.security.RequiresFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @RequiresFeature("CREATE_ROLE")
    public ResponseEntity createRole(@RequestBody Role role) {
        return ResponseHandler.successfulResponse(roleService.createRole(role));
    }

    @GetMapping("/{id}")
    @RequiresFeature("FIND_ROLE_BY_ID")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        return ResponseHandler.successfulResponse(roleService.getRoleById(id));
    }

    @GetMapping
    @RequiresFeature("FIND_ALL_ROLES")
    public ResponseEntity findAllRoles() {
        return ResponseHandler.successfulResponse(roleService.findAllRoles());
    }

    @GetMapping("/find/{name}")
    @RequiresFeature("FIND_ROLE_BY_NAME")
    public ResponseEntity findRoleByName(@PathVariable String name) {
        return ResponseHandler.successfulResponse(roleService.findRoleByName(name));
    }

    @PostMapping("/assignfeature")
    @RequiresFeature("ASSIGN_FEATURE_TO_ROLE")
    public ResponseEntity addFeatureToRole(@RequestBody FeatureRoleDto featureRoleDto) {
        roleService.addFeatureToRole(featureRoleDto.getRoleName(), featureRoleDto.getFeatureName());
        return ResponseHandler.successfulResponse("{} assigned successfully to {}".formatted(featureRoleDto.getFeatureName(),featureRoleDto.getRoleName()));
    }

    @PostMapping("/revokefeature")
    @RequiresFeature("REVOKE_FEATURE_TO_ROLE")
    public ResponseEntity revokeFeatureFromRole(@RequestBody FeatureRoleDto featureRoleDto) {
        roleService.revokeFeatureFromRole(featureRoleDto.getRoleName(), featureRoleDto.getFeatureName());
        return ResponseHandler.successfulResponse("{} revoked from {}".formatted(featureRoleDto.getFeatureName(),featureRoleDto.getRoleName()));

    }
}
