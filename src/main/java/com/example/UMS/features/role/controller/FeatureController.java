package com.example.UMS.features.role.controller;

import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/features")
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureService featureService;

    @PostMapping
    public Feature createFeature(@RequestBody Feature feature) {
        return featureService.createFeature(feature);
    }

    @GetMapping("/{id}")
    public Feature getFeatureById(@PathVariable Long id) {
        return featureService.getFeatureById(id);
    }

    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }

    @PutMapping("/{id}")
    public Feature updateFeature(@PathVariable Long id, @RequestBody Feature feature) {
        return featureService.updateFeature(feature);
    }

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
    }
}
