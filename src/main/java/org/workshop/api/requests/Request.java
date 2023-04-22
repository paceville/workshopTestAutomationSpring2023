package org.workshop.api.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class Request {
    private static final String AUTHENTICATION_ENDPOINT = "/authenticationTest.html?csrf";
    private static final String PROJECTS_ENDPOINT = "/app/rest/projects";
    private static final String VCS_ENDPOINT = "/app/rest/vcs-roots";
    private static final String BUILD_ENDPOINT = "/app/rest/buildTypes";
    private static final String RUN_BUILD_ENDPOINT = "/app/rest/buildQueue";
    private static final String CHECK_BUILD_RESULT_ENDPOINT = "/app/rest/buildQueue";
    private final Specifications spec = new Specifications();
    public Response getCsrfToken() {
        return RestAssured.get(AUTHENTICATION_ENDPOINT);
    }

    public Response createProject(NewProjectDescription project) {
        return given().spec(spec.reqSpec()).body(project).post(PROJECTS_ENDPOINT);
    }

    //TODO create object
    public Response createVcs() {
        return given().spec(spec.reqSpec()).body("{\n" +
                "  \"id\": \"TestVcsId5\",\n" +
                "  \"name\": \"TestVcsIdName5\",\n" +
                "  \"vcsName\": \"jetbrains.git\",\n" +
                "  \"project\": {\n" +
                "    \"id\": \"TestPrId5\"\n" +
                "  },\n" +
                "  \"properties\": {\n" +
                "    \"property\": [\n" +
                "      {\n" +
                "        \"name\": \"authMethod\",\n" +
                "        \"value\": \"ANONYMOUS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"branch\",\n" +
                "        \"value\": \"refs/heads/master\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"url\",\n" +
                "        \"value\": \"https://github.com/paceville/workshopTestAutomationSpring2023\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}").post(VCS_ENDPOINT);
    }

    //TODO: create object, send param instead of message??
    public Response createBuild() {
        return given().spec(spec.reqSpec().body("{\n" +
                "  \"id\": \"TestBuildId5\",\n" +
                "  \"name\": \"TestBuildName5\",\n" +
                "  \"project\": {\n" +
                "    \"id\": \"TestPrId5\"\n" +
                "  },\n" +
                "  \"parameters\": {\n" +
                "    \"property\": [\n" +
                "      {\n" +
                "        \"name\": \"myBuildParameter\",\n" +
                "        \"value\": \"myValue\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"steps\": {\n" +
                "    \"step\": [\n" +
                "      {\n" +
                "        \"name\": \"myCommandLineStep\",\n" +
                "        \"type\": \"simpleRunner\",\n" +
                "        \"properties\": {\n" +
                "          \"property\": [\n" +
                "            {\n" +
                "              \"name\": \"script.content\",\n" +
                "              \"value\": \"echo \\\"Hello world\\\"\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"name\": \"teamcity.step.mode\",\n" +
                "              \"value\": \"default\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"name\": \"use.custom.script\",\n" +
                "              \"value\": \"true\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}")).post(BUILD_ENDPOINT);
    }

    //TODO: create object
    public Response runBuildConfiguration() {
        return given().spec(spec.reqSpec().body("{\n" +
                "  \"buildType\": {\n" +
                "    \"id\": \"TestBuildId5\"\n" +
                "  }\n" +
                "}")).post(RUN_BUILD_ENDPOINT);
    }

    public Response checkBuildResult(String buildId) {
        return RestAssured.get(CHECK_BUILD_RESULT_ENDPOINT + buildId);
    }

}
