package api;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.workshop.api.models.ParentProject;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.Project;
import org.workshop.api.requests.CheckedRequest;
import org.workshop.api.requests.Request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BuildConfigurationTest extends BaseTest {

    @Test
    public void buildConfigurationTest() {
        //token
       //spec

        //project
        NewProjectDescription project = NewProjectDescription.builder()
                .parentProject(ParentProject.builder().locator("_Root").build())
                .name("Generated project4")
                .id("GeneratedProjectId4")
                .copyAllAssociatedSettings(true)
                .build();

        //var projectJson = new Gson().toJson(project);

        //POST request create project
        var createdProject = new CheckedRequest().createProject(project);

       // softy.assertThat(createdProject);
    }
}
