package CommPageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class CreateNewPath extends BasePage {

    By commHome = By.id("home-newProjectModalOpen");
    By createButton = By.id("newProjectForm-submit");
    By newProjectField = By.id("newProjectForm-projectName");
    By defaultLic = By.id("newProjectForm-defaultLicensee");
    By pathRadioButton = By.className("styled-radio");
    By projectRequired = By.className("error-message");

    public CreateNewPath(WebDriver driver){
        super(driver);

    visit("/#/");
        Assert.assertTrue(driver.findElement(commHome).isDisplayed());
    }

    public void createBrandNewProjectPath(String projectName, String defaultLicensee){
        click(commHome);
        assertTrue("can't find the Create button",
                isDisplayed(createButton));
        type(projectName,newProjectField);
        type(defaultLicensee,defaultLic);
        click(pathRadioButton);
        click(createButton);
        //assertTrue(alertMessagePresent());
        //checkAlertAndAccept();

    }

    public void createProjectPathErrorChecking(String projectName, String defaultLicensee){
        click(commHome);
        assertTrue("can't find the Create button",
                isDisplayed(createButton));
        type(projectName,newProjectField);
        type(defaultLicensee,defaultLic);
        click(pathRadioButton);
        //click(createButton);

    }

    public Boolean projectNameRequired() {
        return isDisplayed(projectRequired);
    }

    public Boolean alertMessagePresent(){
        return waitForIsDisplayed(createButton,10);
    }

}
