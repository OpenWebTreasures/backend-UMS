package com.example.UMS.features.role.dao;

import com.example.UMS.features.role.model.Feature;

import java.util.List;

public interface FeatureDao {
    Feature create(Feature feature);

    Feature findById(Long id);

    List<Feature> findAll();

    boolean existsByName(String name);

    Feature findByName(String name);


    Feature update(Feature feature);
}
