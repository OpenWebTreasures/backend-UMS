package com.example.UMS.features.role.model;

import java.util.List;

public enum Feature {
    GET_ALL_FEATURES("GET_ALL_FEATURES"),
    FEATURE_2("FEATURE_2"),
    FEATURE_3("FEATURE_3"),
    FIND_ROLE_BY_ID("FIND_ROLE_BY_ID"),
    FIND_ALL_ROLES("FIND_ALL_ROLES"),
    FIND_ROLE_BY_NAME("FIND_ROLE_BY_NAME"),
    ASSIGN_FEATURE_TO_ROLE("ASSIGN_FEATURE_TO_ROLE"),
    REVOKE_FEATURE_TO_ROLE("REVOKE_FEATURE_TO_ROLE"),
    CREATE_USER("CREATE_USER"),
    FIND_USER_BY_ID("FIND_USER_BY_ID"),
    FIND_ALL_USERS("FIND_ALL_USERS"),
    DELETE_USER_BY_ID("DELETE_USER_BY_ID");


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
