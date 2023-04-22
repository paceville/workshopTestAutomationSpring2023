package api;

import org.testng.annotations.Test;
import org.workshop.api.models.ParentProject;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.requests.CheckedRequest;

public class BuildConfigurationTest extends BaseTest {
    private static final String PROJECT_ID = "GeneratedProjectId5";

    @Test
    public void buildConfigurationTest() {

        //project
        NewProjectDescription project = NewProjectDescription.builder()
                .parentProject(ParentProject.builder().locator("_Root").build())
                .name(PROJECT_ID)
                .id(PROJECT_ID)
                .copyAllAssociatedSettings(true)
                .build();

        //POST request create project
        NewProjectDescription createdProject = new CheckedRequest().createProject(project);

        softy.assertThat(createdProject.getId().equals(PROJECT_ID));
    }
}
