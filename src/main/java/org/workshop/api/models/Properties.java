package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Properties {
    private Integer count;
    private String href;
    private List<Property> property;
}
