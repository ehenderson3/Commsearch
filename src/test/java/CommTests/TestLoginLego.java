package CommTests;

import static org.junit.Assert.*;

import CommPageObjects.CreateNewPath;
import org.junit.Before;
import org.junit.Test;

public class TestLoginLego extends BaseTest {
    //private WebDriver driver;
    private CreateNewPath createPath;

    @Before
    public void Setup(){
        createPath = new CreateNewPath(driver);
    }

    @Test
    public void createNewProjectFieldFailure () {
        createPath.createProjectPathErrorChecking("", "This is the Default");
        assertTrue("required message did not appear",createPath.projectNameRequired());
    }

    @Test
    public void createNewProject (){
        createPath.createBrandNewProjectPath("Best Project Ever", "This is the Default");
    }



}
