package org.workshop.api.requests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.Projects;

public class CheckedRequest {
    private final Request request = new Request();
    public String getCsrfToken() {
        return request.getCsrfToken()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }

    public Projects createProject(NewProjectDescription project) {
        return request.createProject(project)
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Projects.class);
    }
}
