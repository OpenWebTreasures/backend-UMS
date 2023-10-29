package com.example.UMS.features.role.dao.impl;

import com.example.UMS.features.role.dao.FeatureDao;
import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FeatureDaoImpl implements FeatureDao {

    private final FeatureRepository featureRepository;

    @Override
    public Feature create(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature findById(Long id) {
        return featureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    @Override
    public Feature findByName(String name) {
        return featureRepository.findByName(name);
    }

    @Override
    public Feature update(Feature feature) {
        return null;
    }
}
