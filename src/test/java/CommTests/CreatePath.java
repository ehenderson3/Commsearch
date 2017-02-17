package CommTests;

import static org.junit.Assert.*;

import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathSummaryPage;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Sleeper;

public class CreatePath extends BaseTest {
    private CreateNewPathPage createPath;

    @Before
    public void Setup(){
        createPath = new CreateNewPathPage(driver);
    }

    @Test
    public void projectFieldFailure () {
        createPath.createProjectPathErrorChecking("", "This is the Default");
        assertTrue(createPath.projectNameRequired());
    }

    @Test
    public void createProjectWithoutDefaultFieldPopulated () {
        createPath.createProjectPathErrorChecking("Project Field is Populated", "");
        assertTrue(createPath.landedOnPathSummaryPage());
    }

    @Test
    public void createNewProject() {
        createPath.createBrandNewProjectPath("Best Project Ever", "This is the Default");
    }

    @Test
    public void maxProjectName() {
        createPath.createBrandNewProjectPath("12345678901234567890123456789012345678901", "This is the Default");
        //TODO//assertTrue(createPath.projectNameTooLongError());
    }

    @Test
    public void valPathSummaryLanding() {
        assertTrue(createPath.landedOnPathSummaryPage());
        assertTrue(createPath.projectName());
        assertEquals("acme", createPath.licenseeName());
        assertEquals("Best Project Ever", createPath.projectNameText());
        assertEquals("0", createPath.pathAmounts());
    }

}
