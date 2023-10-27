package com.example.UMS.features.role.repository;

import com.example.UMS.features.role.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
