package CommTests;

import CommPageObjects.CreateNewPathPage;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class CreatePathTest extends BaseTest {
    private CreateNewPathPage createPath;

    @Before
    public void Setup(){
        createPath = new CreateNewPathPage(driver);
    }
    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);




    @Test
    public void projectNoNameFieldError () {
        createPath.createProjectPathErrorChecking("", "This is the Default");
        assertTrue(createPath.projectNameRequired());

    }

        /* COM 124
        When the Default Licensee is NOT existing already,
        Then a project can still be created."
        "Given a project name has previously been created and saved,
        */
    @Test
    public void createProjectWithoutDefaultFieldPopulated () {
        createPath.createProjectPathErrorChecking("Project Field" +randomNumber+ "iAutomation Data", "");
        assertTrue(createPath.landedOnPathSummaryPage());
    }

        /*COM 117
        "Given a user wants to name a project,
        When the name is unique,
        AND has <41 characters,
        AND all characters are in the acceptable character set,
        Then it will save successfully."
         */

    @Test
    public void createNewProject() {
        createPath.createBrandNewProjectPath("Best Project Ever" +randomNumber+ "f", "This is the Default");
    }

        /*COM 121
        "Given a user wants to name a project,
        When the name is NOT unique,
        Then a graceful error message will be displayed."
        "Given the the max number of characters is 40,
        When the project name is >40,
        Then an error message will indicate that the 'Project name is too long'."
         */
    @Test
    public void maxProjectNameTest() {
        createPath.attemptToCreateProject("12345678901234567890123456789012345678901", "This is the Default");
        assertEquals("Project name is too long.",createPath.projectFieldError());
    }

        /*COM 121
        "Given that the acceptable character set is [a-zA-Z0-9\s\_\-],
        When the characters in a project name are outside of this set,
        Then an error message will indicate that 'Project name contains invalid characters.'"
        */
    @Test
    public void valProject_InvalidChar() {
        createPath.attemptToCreateProject("!@#$%^&*()", "This is the Default");
        assertEquals("Project name contains invalid characters.",createPath.projectFieldError());
    }

    /*
    COM-198
    Create New Project: Error format is different when "/" character is used.
     */

    @Test
    public void valProject_ValidChar() {
        createPath.attemptToCreateProject("a-zA-Z0-9s_-"+ randomNumber, "This is the Default");
        assertTrue(createPath.landedOnPathSummaryPage());
    }

        /*COM 124
        "Given that a user wants to create a new manual project,
        When New Project button is clicked,
        Then a modal pops up with the following fields: Project Name; Default Licensee; Licensee Lookup; Path/Area-Based/Earth Station radio buttons; Create button; and Import button."
        "Given that a user is filling out the fields in the New Project modal,
        */

        /*COM 124
        When a duplicate project name is created,
        Then the validation will be case-insensitive."
        "Given that a user is filling out the fields in the Create New Project modal,
        */
    @Test
    public void duplicateProjectName() {
        createPath.attemptToCreateDupProject("Test Duplicate Project 8", "This is the Default");
        //assertTrue(createPath.projectNameTooLongError());
    }
        /*COM 124
        When a Project Type is selected (Path/Area-Based/Earth Station),
        Then only one can be selected."
        "Given that all required fields are filled out in the modal,
        When the Create button is clicked,
        Then a new project is created."
        "Given that all required fields are filled out in the modal,
        When a new project is created,
        Then the user is taken to the URL of the new Project Summary screen."
         */

    @Test
    public void valPathSummaryLanding() {
        String randomProjectName;
        randomProjectName = "Validating Landing" +randomNumber+"";
        createPath.createBrandNewProjectPath(randomProjectName, "This is the Default");
        assertTrue(createPath.landedOnPathSummaryPage());
        assertTrue(createPath.projectName());
       // assertEquals("Licensee name is incorrect","acme", createPath.licenseeName());
        assertEquals("Project name is incorrect", randomProjectName, createPath.projectNameText());
        assertEquals("Paths amt incorrect", "0", createPath.pathAmounts());
    }

}
