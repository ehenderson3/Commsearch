package CommPageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateNewPathPage extends BasePage {

    By commHome = By.id("home-newProjectModalOpen");
    By createButton = By.id("newProjectForm-submit");
    By newProjectField = By.id("newProjectForm-projectName");
    By defaultLic = By.id("newProjectForm-defaultLicensee");
    By pathRadioButton = By.className("styled-radio");
    By projectRequired = By.className("error-message");
    By filterField = By.id("project-summary-filter-input");
    By projectTitle = By.xpath("//span[text()='Project ']");
    By projectTitleName = By.xpath("//*[@class=\"project-summary-overview\"]/p[1]/span[2]");
    By totalPathAmount = By.xpath("//*[@class=\"project-summary-overview\"]/p[3]/span[2]");
    By licenseeName = By.xpath("//*[@class=\"project-summary-overview\"]/p[2]/span[2]");



    //Project Landing
    By projectTitile = By.tagName("span");

    public CreateNewPathPage(WebDriver driver){
        super(driver);

    visit("/");
        Assert.assertTrue(driver.findElement(commHome).isDisplayed());
    }

    public void createBrandNewProjectPath(String projectName, String defaultLicensee){
        String filterEntryField;
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName, newProjectField);
        type(defaultLicensee, defaultLic);
        click(pathRadioButton);
        click(createButton);
        waitForIsDisplayed(filterField,10);
        type("asdfasfd",filterField);
        filterEntryField = getFieldText(filterField);
        assertEquals(filterEntryField,"asdfasfd");
    }

    public void attemptToCreateProject(String projectName, String defaultLicensee){
        String filterEntryField;
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName, newProjectField);
        type(defaultLicensee, defaultLic);
        click(pathRadioButton);
        click(createButton);
    }

    public void createProjectPathErrorChecking(String projectName, String defaultLicensee){
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName,newProjectField);
        type(defaultLicensee,defaultLic);
        click(pathRadioButton);
        click(createButton);
    }

    public Boolean projectNameRequired() {
        return isDisplayed(projectRequired);
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
