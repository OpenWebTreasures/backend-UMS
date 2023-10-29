package com.example.UMS.features.role.service.impl;

import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.repository.FeatureRepository;
import com.example.UMS.features.role.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;


    // Create a new feature
    public Feature createFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    // Retrieve a feature by ID
    public Feature getFeatureById(Long id) {
        return featureRepository.findById(id).orElse(null);
    }

    // Retrieve all features
    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    // Update a feature
    public Feature updateFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    // Delete a feature by ID
    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
}
