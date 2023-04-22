package org.workshop.api.requests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.NewProjectDescription;

public class CheckedRequest {
    private static final long TIMEOUT = 60_000;
    private final Request request = new Request();
    public String getCsrfToken() {
        return request.getCsrfToken()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }

    public NewProjectDescription createProject(NewProjectDescription project) {
        return request.createProject(project)
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response().as(NewProjectDescription.class);
    }

    public NewProjectDescription createVcs() {
        return request.createVcs()
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response().as(NewProjectDescription.class);
    }

    public NewProjectDescription createBuild() {
        return request.createBuild()
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response().as(NewProjectDescription.class);
    }

    public NewProjectDescription runBuildConfiguration() {
        return request.runBuildConfiguration()
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response().as(NewProjectDescription.class);
    }

    public NewProjectDescription checkBuildResult(String buildId) {
        var startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < TIMEOUT) {
            return request.checkBuildResult(buildId)
                    .then().statusCode(HttpStatus.SC_OK)
                    .extract().response().as(NewProjectDescription.class);
        }
        return null;
    }
}
