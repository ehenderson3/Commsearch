package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateNewPathPage extends BasePage {

    //Buttons
    By pathRadioButton = By.className("styled-radio");
    By companyLookUp = By.id("newProjectForm-defaultCompanyLookup");
    By companySearchButton = By.id("company-lookup-submit");

    //Modal
    By companyModal = By.id("company-lookup-modal");
    By commHome = By.id("home-newProjectModalOpen");

    //Fields
    By companyCodeField = By.id("company-lookup-company-code");
    By companyNameField = By.id("company-lookup-company-name");
    By defaultCompanyField = By.id("newProjectForm-defaultCompany");
    By searchResultArray = By.cssSelector(".react-grid-Row.react-grid-Row--even");
    By control = By.id("control");

    By companyContactNameField = By.id("company-lookup-contact-name");
    By createButton = By.id("newProjectForm-submit");
    By newProjectField = By.id("newProjectForm-projectName");
    By defaultLic = By.id("newProjectForm-defaultCompany");
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
    public void enterProjectForCompany(String projectName, String defaultLicensee){
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName, newProjectField);
        click(pathRadioButton);
        isDisplayed(defaultLic,20);
        isDisplayed(companyLookUp, 10);
        click(companyLookUp);//id="newProjectForm-defaultCompanyLookup"
    }

    public void fillOutCompanyFilter(String coCodeText,String coNameText, String coContactText, Integer company) {
        String a;
        assertTrue("Can't find company modal",isDisplayed(companyModal,10));//id="company-lookup-modal"
        assertTrue("Can't find Code Field",isDisplayed(companyCodeField,10));//id="company-lookup-company-code"
        assertTrue("Can't find Name Field",isDisplayed(companyNameField,10));//id="company-lookup-company-name"
        assertTrue("Can't find Name Field",isDisplayed(companyContactNameField));//id="company-lookup-contact-name"
        type(coCodeText, companyCodeField);
        type(coNameText, companyNameField);
        type(coContactText, companyContactNameField);
        assertTrue("Can't find Search Button",isDisplayed(companySearchButton));//id="company-lookup-contact-name"
        click(companySearchButton);//id="company-lookup-submit"
        isDisplayed(control,4);
        isDisplayed(searchResultArray,10);//class="react-grid-Cell__value"
        click(searchResultArray);
        a = getFieldText(defaultCompanyField);//id="newProjectForm-defaultCompany"
        assertEquals(a, "Verizon");
        click(createButton);
        isDisplayed(filterField, 10);
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
