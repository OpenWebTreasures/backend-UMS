package com.example.UMS.features.role.dto;


import com.example.UMS.features.role.model.Feature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto {
    private String name;
    private Instant createdOn;
    private Instant lastUpdatedOn;
    private List<Feature> features;

}
