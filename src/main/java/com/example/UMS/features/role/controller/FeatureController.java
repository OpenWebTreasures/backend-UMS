package com.example.UMS.features.role.controller;

import com.example.UMS.features.common.ResponseHandler;
import com.example.UMS.features.role.dto.FeatureRoleDto;
import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import com.example.UMS.security.RequiresFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/features")
@RequiredArgsConstructor
public class FeatureController {


    @GetMapping
    @RequiresFeature(Feature.GET_ALL_FEATURES)
    public ResponseEntity getAllFeatures() {
        return ResponseHandler.successfulResponse(Feature.getAll());
    }

}
