package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectFeatures {
    private Integer count;
    private String href;
}
