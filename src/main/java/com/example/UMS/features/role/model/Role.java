package com.example.UMS.features.role.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, name = "name")
    private String name;

    @CreationTimestamp
    private Instant createdOn;
    @UpdateTimestamp
    private Instant lastUpdatedOn;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "role_features", joinColumns = @JoinColumn(name = "role_id"))
    @Enumerated(EnumType.STRING)
    private List<Feature> features;

    public Role(String name) {
        this.name = name;
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public void revokeFeature(Feature feature) {
        features.removeIf(f -> f == feature);
    }

}
