package CommTests;

import static org.junit.Assert.*;

import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathSummaryPage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.Random;

public class CreatePathTest extends BaseTest {
    private CreateNewPathPage createPath;

    @Before
    public void Setup(){
        createPath = new CreateNewPathPage(driver);
    }
    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

    @Test
    public void Test_projectFieldFailure () {
        createPath.createProjectPathErrorChecking("", "This is the Default");
        assertTrue(createPath.projectNameRequired());
    }

    @Test
    public void createProjectWithoutDefaultFieldPopulated () {

        createPath.createProjectPathErrorChecking("Project Field" +randomNumber+ "iAutomation Data", "");
        assertTrue(createPath.landedOnPathSummaryPage());
    }

    @Test
    public void createNewProject() {
        createPath.createBrandNewProjectPath("Best Project Ever" +randomNumber+ "f", "This is the Default");
    }

    @Test
    public void maxProjectNameTest() {
        createPath.attemptToCreateProject("12345678901234567890123456789012345678901", "This is the Default");
        //TODO//assertTrue(createPath.projectNameTooLongError());
    }

    @Test
    public void valPathSummaryLanding() {
        String randomProjectName;
        randomProjectName = "Validating Landing" +randomNumber+"";
        createPath.createBrandNewProjectPath(randomProjectName, "This is the Default");
        assertTrue(createPath.landedOnPathSummaryPage());
        assertTrue(createPath.projectName());
        assertEquals("Licensee name is incorrect","acme", createPath.licenseeName());
        assertEquals("Project name is incorrect", randomProjectName, createPath.projectNameText());
        assertEquals("Paths amt incorrect", "0", createPath.pathAmounts());
    }

}
