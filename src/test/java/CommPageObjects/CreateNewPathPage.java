package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateNewPathPage extends BasePage {

    By commHome = By.id("home-newProjectModalOpen");
    By createButton = By.id("newProjectForm-submit");
    By newProjectField = By.id("newProjectForm-projectName");
    By defaultLic = By.id("newProjectForm-defaultCompany");
    By pathRadioButton = By.className("styled-radio");
    By projectRequired = By.className("error-message");
    By filterField = By.id("project-summary-filter-input");
    By projectTitle = By.xpath("//span[text()='Project ']");
    By projectTitleName = By.xpath("//*[@class=\"project-summary-overview\"]/p[1]/span[2]");
    By totalPathAmount = By.xpath("//*[@class=\"project-summary-overview\"]/p[3]/span[2]");
    By licenseeName = By.xpath("//*[@class=\"project-summary-overview\"]/p[2]/span[2]");
    By errorMessage = By.className("error-message");
    By returnHome = By.id("header-homeLink");



    //Project Landing
    By projectTitile = By.tagName("span");

    public CreateNewPathPage(WebDriver driver){
    //Used by class constructors to invoke constructors of its parent class.
        super(driver);

    visit("");
    }

    public void createBrandNewProjectPath(String projectName, String defaultLicensee){
        String filterEntryField;
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName, newProjectField);
        click(pathRadioButton);
        isDisplayed(defaultLic,20);

        click(createButton);
        waitForIsDisplayed(filterField,10);
        //type(defaultLicensee, defaultLic);
    }



    public void attemptToCreateProject(String projectName, String defaultLicensee){
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName, newProjectField);
        //type(defaultLicensee, defaultLic);
        click(pathRadioButton);
        isDisplayed(defaultLic,20);
        click(createButton);
    }

    public void attemptToCreateDupProject(String projectName, String defaultLicensee){
        String dupMessageText;
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton));
        type(projectName, newProjectField);
        type(defaultLicensee, defaultLic);
        click(pathRadioButton);
        click(createButton);
        if(isDisplayed(filterField,10)){
            click(returnHome);
            click(commHome);
            assertTrue("can't find the Create button", isDisplayed(createButton));
            type(projectName, newProjectField);
            type(defaultLicensee, defaultLic);
            click(pathRadioButton);
        }
        isDisplayed(errorMessage);
        dupMessageText = getText(errorMessage);
        assertEquals(dupMessageText,"That project name already exists.");
    }

    public void createProjectPathErrorChecking(String projectName, String defaultLicensee){
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName,newProjectField);

        click(pathRadioButton);
        isDisplayed(defaultLic,20);

        click(createButton);

        //type(defaultLicensee,defaultLic);
    }

    public Boolean projectNameRequired() {
        return isDisplayed(projectRequired);
    }

    public String projectFieldError(){
        return getText(errorMessage);
    }

    public Boolean alertMessagePresent(){
        return waitForIsDisplayed(createButton,10);
    }

    public Boolean landedOnPathSummaryPage(){
        return waitForIsDisplayed(projectTitle,10);
    }

    public boolean projectName() {
        return isDisplayed(projectTitleName);
    }

    public String projectNameText() {
        return getText(projectTitleName);
    }


    public String pathAmounts() {
        return getText(totalPathAmount);
    }

    public String licenseeName() {
        return getText(licenseeName);
    }
}
