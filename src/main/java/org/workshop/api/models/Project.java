package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String id;
    private String name;
    private String parentProjectId;
    private Boolean virtual;
    private String href;
    private String webUrl;
    private Project parentProject;
    private BuildTypes buildTypes;
    private BuildTypes templates;
    private Properties parameters;
    private VscRoots vcsRoots;
    private ProjectFeatures projectFeatures;
    private Projects projects;
}
