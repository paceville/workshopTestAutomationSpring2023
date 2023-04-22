package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParentProject {
    private String locator;
}
