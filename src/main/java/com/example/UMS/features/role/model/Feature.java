package com.example.UMS.features.role.model;

import java.util.List;

public enum Feature {
    FEATURE_1("FEATURE_1"),
    FEATURE_2("FEATURE_2"),
    FEATURE_3("FEATURE_3");

    private final String featureName;

    Feature(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureName() {
        return featureName;
    }

    public static List<Feature> getAllFeatures() {
        return List.of(Feature.values());
    }

}
