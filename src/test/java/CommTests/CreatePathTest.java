package CommTests;

import static org.junit.Assert.*;

import CommPageObjects.CreateNewPathPage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

public class CreatePathTest extends BaseTest {
    private CreateNewPathPage createPath;

    @Before
    public void Setup(){
        createPath = new CreateNewPathPage(driver);
    }
    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(10);

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
        /*
        "Given a user wants to name a project,
        When the name is unique,
        AND has <41 characters,
        AND all characters are in the acceptable character set,
        Then it will save successfully."
        "Given a user wants to name a project,
        When the name is NOT unique,
        Then a graceful error message will be displayed."
        "Given the the max number of characters is 40,
        When the project name is >40,
        Then an error message will indicate that the 'Project name is too long'."
        "Given that the acceptable character set is [a-zA-Z0-9\s\_\-],
        When the characters in a project name are outside of this set,
        Then an error message will indicate that 'Project name contains invalid characters.'"
         */
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
