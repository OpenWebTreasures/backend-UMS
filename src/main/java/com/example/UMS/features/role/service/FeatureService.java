package com.example.UMS.features.role.service;

import com.example.UMS.features.role.model.Feature;

import java.util.List;

public interface FeatureService {

    Feature createFeature(Feature feature);

    Feature getFeatureById(Long id);

    List<Feature> getAllFeatures();

    Feature updateFeature(Feature feature);

    void deleteFeature(Long id);
}
