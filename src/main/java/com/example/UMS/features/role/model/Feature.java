package com.example.UMS.features.role.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Feature {
    GET_ALL_FEATURES("GET_ALL_FEATURES", "Get a list of all features in the system."),
    COUNT_USERS("COUNT_USERS", "Count the number of users in the system."),
    CREATE_ROLE("CREATE_ROLE", "Create a new role in the system."),
    FIND_ROLE_BY_ID("FIND_ROLE_BY_ID", "Find a role in the system by its ID."),
    FIND_ALL_ROLES("FIND_ALL_ROLES", "Find a list of all roles in the system."),
    FIND_ROLE_BY_NAME("FIND_ROLE_BY_NAME", "Find a role in the system by its name."),
    ASSIGN_FEATURE_TO_ROLE("ASSIGN_FEATURE_TO_ROLE", "Assign a feature to a role."),
    REVOKE_FEATURE_TO_ROLE("REVOKE_FEATURE_TO_ROLE", "Revoke a feature from a role."),
    CREATE_USER("CREATE_USER", "Create a new user in the system."),
    FIND_USER_BY_ID("FIND_USER_BY_ID", "Find a user in the system by their ID."),
    FIND_ALL_USERS("FIND_ALL_USERS", "Find a list of all users in the system."),
    DELETE_USER_BY_ID("DELETE_USER_BY_ID", "Delete a user from the system by their ID."),
    CHANGE_ANY_USER_PASSWORD("CHANGE_ANY_USER_PASSWORD", "Change the password of any user in the system."),
    CHANGE_SELF_PASSWORD("CHANGE_SELF_PASSWORD", "Change the password of the currently authenticated user."),
    CHANGE_USER_ROLES("CHANGE_USER_ROLES", "Change the roles assigned to a user."),
    UPDATE_SELF_USER_DETAILS("UPDATE_SELF_USER_DETAILS", "Update the details of the currently authenticated user."),
    UPDATE_ANY_USER_DETAILS("UPDATE_ANY_USER_DETAILS", "Update the details of any user in the system.");

    private final String featureName;
    private final String description;

    Feature(String featureName, String description) {
        this.featureName = featureName;
        this.description = description;
    }

    public String getFeatureName() {
        return featureName;
    }

    public String getDescription() {
        return description;
    }

    public static List<Feature> getAllFeatures() {
        return List.of(Feature.values());
    }

    public static List<Map<String, String>> getAll() {
        return Arrays.stream(Feature.values())
                .map(feature -> Map.of("name", feature.getFeatureName(), "description", feature.getDescription()))
                .collect(Collectors.toList());
    }
}
