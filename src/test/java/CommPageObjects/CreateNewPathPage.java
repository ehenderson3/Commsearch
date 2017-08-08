package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateNewPathPage extends BasePage {

    //Buttons
   //By pathRadioButton = By.xpath("//span[text()='Path']");
    By pathRadioButton = By.id("newProjectForm-projectType-PATH-label-bottom");

    //newProjectForm-projectType-PATH-label-top

    By companyLookUp = By.id("default-company-lookup-trigger");
    By pathDetailCompanyLookUp = By.xpath("//*[contains(@id, 'path-details-company-') and contains(@id, '-lookup-trigger')]");
    By authPOCSuccess = By.id("api-auth-success-poc");
    //path-details-company-lookup-trigger
    By companySearchButton = By.id("company-lookup-submit");

    //Modal
    By companyModal = By.id("company-lookup-company-code");
    By commHome = By.id("home-newProjectModalOpen");

    //Fields
    By companyCodeField = By.id("company-lookup-company-code");
    By companyNameField = By.id("company-lookup-company-name");
    By defaultCompanyField = By.id("new-project-form-default-company");
    //By searchResultArray = By.cssSelector(".react-grid-Row.react-grid-Row--even");
    //react-grid-Cell
    By searchResultArray = By.xpath("//*[contains(@id, 'company-lookup-modal-table-data-companyCode-')]");

    By searchResultArrayPlural = By.xpath("//*[contains(@id, 'company-lookup-modal-table-data-companyCode-') and contains(@id, '-companyName')]");

    //By searchResultArray = By.cssSelector(".react-grid-Cell");

    By companyContactNameField = By.id("company-lookup-contact-name");
    By createButton = By.id("newProjectForm-submit");
    By newProjectField = By.id("newProjectForm-projectName");
    By defaultCompany = By.id("default-company-lookup-trigger");
    By projectRequired = By.className("error-message");
    By filterField = By.id("project-summary-filter-input");
    By projectTitle = By.xpath("//span[text()='Project ']");
    By projectTitleName = By.xpath("//*[@class=\"project-summary-overview\"]/p[1]/span[2]");
    By totalPathAmount = By.xpath("//*[@class=\"project-summary-overview\"]/p[3]/span[2]");
    By licenseeName = By.xpath("//*[@class=\"project-summary-overview\"]/p[2]/span[2]");
    By errorMessage = By.className("error-message");
    By returnHome = By.id("header-homeLink");
    By pathDetailDefaultCompanyField = By.id("path-details-site-0-company-name");



    //Project Landing
    By projectTitile = By.tagName("span");

    public CreateNewPathPage(WebDriver driver){
    //Used by class constructors to invoke constructors of its parent class.
        super(driver);

    visit("");
    }

    public void createBrandNewProjectPath(String projectName, String defaultLicensee){
        slowDown(2);
        assertTrue("can't find the home ",isDisplayed(commHome,30));
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton,30));
        type(projectName, newProjectField);
        assertTrue("can't find the path radio button",isDisplayed(pathRadioButton,30));
        click(pathRadioButton);
        slowDown(2);
        assertTrue("can't find the Default company button",isDisplayed(defaultCompany,30));
        assertTrue("can't find the company lookup button",isDisplayed(companyLookUp, 30));
        click(companyLookUp);
    }

    public void createProjectPath(String projectName, String defaultLicensee){
        slowDown(2);
        assertTrue("can't find the home ",isDisplayed(commHome,30));
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton,30));
        type(projectName, newProjectField);
        assertTrue("can't find the path radio button",isDisplayed(pathRadioButton,30));
        click(pathRadioButton);
    }

    public void createProjectPathAuth(String projectName, String defaultLicensee){
        slowDown(2);

        assertTrue("auth was not successful",isDisplayed(authPOCSuccess,30));
        assertTrue("can't find the home ",isDisplayed(commHome,30));
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton,30));
        type(projectName, newProjectField);
        assertTrue("can't find the path radio button",isDisplayed(pathRadioButton,30));
        click(pathRadioButton);
    }

    public void createBrandNewProjectPathNoCompany(String projectName, String defaultLicensee){
        String filterEntryField;
        isDisplayed(commHome,10);
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton,30));
        type(projectName, newProjectField);
        isDisplayed(pathRadioButton,30);
        click(pathRadioButton);
        isDisplayed(defaultCompany,20);
        click(createButton);
        assertTrue("No FILTER FIELD",isDisplayed(filterField,20));



    }
    public void enterProjectForCompany(String projectName, String defaultLicensee){
        click(commHome);
        assertTrue("can't find the Create button",
        isDisplayed(createButton));
        type(projectName, newProjectField);
        click(pathRadioButton);
        isDisplayed(defaultCompany,20);
        isDisplayed(companyLookUp, 10);
        click(companyLookUp);

    }

    public void fillOutCompanyFilter(String coCodeText,String coNameText, String coContactText, Integer company) {
        String a;
        slowDown(8);
        assertTrue("Can't find Code Field",isDisplayed(companyCodeField,30));
        assertTrue("Can't find Name Field",isDisplayed(companyNameField,30));
        assertTrue("Can't find Name Field",isDisplayed(companyContactNameField,30));
        type(coCodeText, companyCodeField);
        type(coNameText, companyNameField);
        type(coContactText, companyContactNameField);
        assertTrue("Can't find Search Button",isDisplayed(companySearchButton,30));
        click(companySearchButton);
        slowDown(4);
        isDisplayed(searchResultArray,30);
        slowDown(3);
        click(searchResultArray);
        a = getFieldText(defaultCompanyField);
        assertEquals(a, "Verizon AZ");
        click(createButton);
        isDisplayed(filterField, 30);
    }

    public void simpleClickCreateNewProjectButton(){
        isDisplayed(createButton, 30);
        click(createButton);
        isDisplayed(filterField, 30);
    }

    public void fillOutCompanyFilterFromDetails(String coCodeText,String coNameText, String coContactText, Integer company) {
        String a;
        assertTrue("Can't find LookUp",isDisplayed(pathDetailCompanyLookUp,10));
        click(pathDetailCompanyLookUp,company);
        assertTrue("Can't find Code Field",isDisplayed(companyCodeField,10));
        assertTrue("Can't find Name Field",isDisplayed(companyNameField,10));
        assertTrue("Can't find Name Field",isDisplayed(companyContactNameField));
        clear(companyCodeField);
        clear(companyNameField);
        type(coCodeText, companyCodeField);
        type(coNameText, companyNameField);
        type(coContactText, companyContactNameField);
        assertTrue("Can't find Search Button",isDisplayed(companySearchButton));
        click(companySearchButton );
        slowDown(2);
        assertTrue("Can't find Results",isDisplayed(searchResultArray,10));
        slowDown(2);


        //so you get the max number of rows
        int rows = getRows(searchResultArrayPlural);
        //Then loop through and do your check
        for (int i = 0; i < rows; i++) {
            //try and catch would be inside the for loop
            try
            {
                a = getTextPlural(searchResultArrayPlural,i);//path-details-site-0-company-name
                assertEquals(a, coNameText);
                click(searchResultArrayPlural,i);
                break;
            }
            catch (java.lang.AssertionError failure)
            {
                //in the catch you would check to see if there are any more rows left.
                if (i >= rows) {
                    throw failure;
                }
            }

        }






    }

    public void fillOutCompanyFilterErrorChecking(String coCodeText,String coNameText, String coContactText, Integer company) {
        String a;
        assertTrue("Can't find Code Field",isDisplayed(companyCodeField,10));
        assertTrue("Can't find Name Field",isDisplayed(companyNameField,10));
        assertTrue("Can't find Name Field",isDisplayed(companyContactNameField));
        type(coCodeText, companyCodeField);
        type(coNameText, companyNameField);
        type(coContactText, companyContactNameField);
        assertTrue("Can't find Search Button",isDisplayed(companySearchButton));
        click(companySearchButton);
        slowDown(4);
        isDisplayed(searchResultArray,10);
    }


    public void max(){
        max();
    }
    public void attemptToCreateProject(String projectName, String defaultLicensee){

        assertTrue("can't find the commHome ", isDisplayed(commHome,30));
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton,30));
        type(projectName, newProjectField);
        click(pathRadioButton);
        assertTrue("can't find the defaultCompany ",isDisplayed(defaultCompany,20));
        click(createButton);
    }
    public void attemptToCreateProjectNameTooLong(String projectName, String defaultLicensee){

        assertTrue("can't find the commHome ", isDisplayed(commHome,30));
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton,30));
        type(projectName, newProjectField);
        click(pathRadioButton);

    }
    public void attemptToCreateDupProject(String projectName, String defaultLicensee){
        String dupMessageText;
        click(commHome);
        assertTrue("can't find the Create button", isDisplayed(createButton,10));
        type(projectName, newProjectField);
        click(pathRadioButton);
        assertTrue("can't find the defaultCompany ",isDisplayed(defaultCompany,20));
        click(createButton);
        if(isDisplayed(filterField,10)){
            click(returnHome);
            click(commHome);
            assertTrue("can't find the Create button", isDisplayed(createButton));
            type(projectName, newProjectField);
            type(defaultLicensee, defaultCompany);
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
        isDisplayed(defaultCompany,20);
        click(createButton);

    }

    public Boolean projectNameRequired() {
        return isDisplayed(projectRequired);
    }

    public String projectFieldError(){
        assertTrue(isDisplayed(errorMessage,30));
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
