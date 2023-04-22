package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewProjectDescription {
    private ParentProject parentProject;
    private String name;
    private String id;
    private Boolean copyAllAssociatedSettings;
}
