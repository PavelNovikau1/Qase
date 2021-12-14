package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTest {

    @Test
    public void getProjectsTest() {
        new BaseAdapter().get("/project");
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .code("QA08VC1")
                .title("QA08VCDEMOTITLE1")
                .description("Test project")
                .build();
        new ProjectsAdapter().create(project);
    }

    @Test
    public void createSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Smoke test")
                .description("This is the smoke test suite")
                .preconditions("This is preconditions")
                .build();
        new SuiteAdapter().create("QA08VC1", testSuite);
    }

    @Test
    public void createSuite2Test() {
        TestSuite testSuite = TestSuite.builder()
                .title("Smoke test2")
                .description("This is the smoke test suite")
                .preconditions("This is preconditions")
                .build();
        boolean status = new SuiteAdapter().createDemo("QA08VC1", testSuite).path("status");
        Assert.assertTrue(status);
    }


}