package api;

import org.testng.annotations.Test;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.ParentProject;
import org.workshop.api.requests.CheckedRequest;

public class ApiTestVersion2 extends BaseTest {
    private static final String PROJECT_ID = "TestPrId5";
    private static final String VCS_ID = "TestVcsId5";
    private static final String BUILD_ID = "TestBuildId5";

    @Test
    public void buildConfigurationTest() {
        createProject();
        createVcs();
        createBuildConfiguration();
        runBuildConfiguration();

        //TODO: fix and add assertions
       // checkBuildResult();
    }

    private void createProject() {
        NewProjectDescription project = NewProjectDescription.builder()
                .parentProject(ParentProject.builder().locator("_Root").build())
                .name(PROJECT_ID)
                .id(PROJECT_ID)
                .copyAllAssociatedSettings(true)
                .build();

        NewProjectDescription createdProject = new CheckedRequest().createProject(project);
        softy.assertThat(createdProject.getId().equals(PROJECT_ID));
    }

    private void createVcs() {
        NewProjectDescription vcs = new CheckedRequest().createVcs();
        softy.assertThat(vcs.getId().equals(VCS_ID));
    }

    private void createBuildConfiguration() {
        NewProjectDescription build = new CheckedRequest().createBuild();
        softy.assertThat(build.getId().equals(BUILD_ID));
    }

    private void runBuildConfiguration() {
        NewProjectDescription runBuild = new CheckedRequest().runBuildConfiguration();
        softy.assertThat(runBuild.getId().equals(BUILD_ID));
    }

    //TODO: add assertions
    private void checkBuildResult() {
        NewProjectDescription buildResult = new CheckedRequest().checkBuildResult(BUILD_ID);
       // softy.assertThat(buildResult.)
    }
}
