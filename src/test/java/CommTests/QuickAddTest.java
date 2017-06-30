package CommTests;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathDetailAntennaPage;

//import CommPageObjects.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by ehend on 2/25/2017.
 */
public class QuickAddTest extends BaseTest {
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;
    private PathDetailPage pathDetail;
    private PathDetailAntennaPage pathDetailAnt;



    @Before
    public void Setup() {
        if(host != "localhost"){
            driver.manage().window().maximize();
        }
        quickAdd = new QuickAddPage(driver);
        pathSummary = new PathSummaryPage(driver);
        createPath = new CreateNewPathPage(driver);
        pathDetail = new PathDetailPage(driver);
        pathDetailAnt = new PathDetailAntennaPage(driver);


    }

    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);
    int randomNumber1 = rndNum.nextInt(100000);

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    /*COM-100
    Given that a user wants to add a new path to a project,
     When Quick Add button is clicked,
     Then a path creation form slides out from the left side of screen showing the following:
     ADD PATH button; CANCEL button; Path Name field; Band dropdown,
     AND text entry boxes for Site 1; ASR/Call Sign; Lat; Long; Elev,
     AND text entry boxes for Site 2; ASR/Call Sign; Lat; Long; Elev,

     Given that a user wants to add a new path to a project,
     When valid entries are added into EITHER the Site 1 & Site 2 fields, OR the ASR/Call Sign field for Site 1 & Site 2,
     AND when the user clicks the ADD PATH button,
     Then a new path will be saved.

     COM-148
     Given a user wants to add a path,
     When the Quick Add button is clicked,
     Then an ADD PATH form will slide out from the left.

     COM-148
     Given that a user has clicked the Quick Add button,
     When the ADD PATH form is on screen,
     Then it will contain the following fields: Path name; Band (dropdown); Site Name; ASR / Call Sign; Latitude; Longitude; Elevation

     COM-148
     Given a user wants to find an existing site,
     When user types in a value (placeholder site names are Mulberry, Apple, Banana, Kiwi and Mango),
     Then existing site names which contain the typed value are fetched (fetch is emulated).

     Given site(s) is/are suggested beneath the input field,
     When user selects a suggested site,
     Then the corresponding site's fields will auto populate (ASR/Call Sign field will auto populate with Call Sign if it exists.)

     COM-100
     Given that a new path is created,
     When it is added to the Project Summary path list,
     Then it will be assigned a path number one higher than the previous highest path number, based on the order of creation.

     COM-100
     Given that the information from the Quick Add form is displayed in the Project Summary Path list,
     When a Path is saved,
     Then the entries from all fields display accurately in the Project Summary Path list.

     COM-146
     Given a user is searching for a Site in the Quick Add section of Project Summary,
     When the user begins typing a valid site name,
     AND after the 1st character is typed,
     Then the browser will (emulate) fetch for all sites which contain the input's value in their Site Name,
     AND they will display beneath the input field.

     COM-146
     Given the browser is displaying all fetched site names,
     When the user hovers on a site name,
     Then additional site information will display on the side

     COM-146
     Given a site option is displayed,
     When user clicks on a site to select it,
     Then the corresponding fields (Lat, Long, Elev) will auto-populate with the Site's information,
     AND the Site field will auto-populate with the completed value that the user started to type,
     AND the ASR/Call Sign field will be auto populated with the site's Call Sign if one is present.

     */
    @Test
    public void quickAddSiteNameSuggest() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("SiteNameSuggest" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();

        siteExist = quickAdd.checkForExistingSite("Tonto Mtn");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();}
        else {
            quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "Tonto Mtn", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        }
        quickAdd.quickAddPathSimple("Ton", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "98");
        //pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "98");

    }

    /**COM-255 Split Project handling in UI
     * "Given a user wants to split a project,
     When one or more paths are selected in the project summary page,
     Then the Split Paths button is activated in the Project Settings menu."


     "Given that one or more paths are selected in the Project Summary page,
     When the Split Project button is clicked in the Project Settings menu,
     Then a Split Project modal is displayed."

     "Given that the Split Project button is clicked in the Project Settings menu,
     When the Split Project modal is displayed,
     Then the following items will be visible in the modal window:
     Split Project modal title & summary; Project Name field; Company; selected path(s); delete button (red circle ""X""); Split Project button."

     "Given the Split Project modal is displayed,
     When all required data is entered, AND Split Project button is clicked,
     Then a Split Project Confirmation modal is displayed."

     "Given the Split Project modal is displayed,
     When the Split Project button is clicked,
     Then two buttons are displayed providing the options: Stay in Current Project; and Go To New Project."


     "Given two buttons are displayed providing the options: Stay in Current Project; and Go To New Project,
     When user clicks the Go To New Project button,
     Then then the paths that were selected transfer to the new project,
     AND those paths are removed from the previous project,
     AND the user is taken to the new project's Project Summary page,
     AND the selected path(s) is/are displayed there."
     "Given a user is taken to the new project's Project Summary page,
     When all of the path information is displayed on the Project Summary page,
     Then it will include duplicate Lat/Long/Elev information for the paths (if this is selected in the Project Settings menu)."
     */



    @Test
    public void splitProjectGoToNewProject() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("splitProjectNEW" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();

        siteExist = quickAdd.checkForExistingSite("Tonto Mtn");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();}
        else {
            quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "Tonto Mtn", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        }

        quickAdd.quickAddPathSimple("Tonto Mtn", "940 MHz", "Stay 1", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        quickAdd.quickAddPathExistingSetup("STAY2", "940 MHz", "Stay 2", "34 37 42.1 N", "112 39 26.2 W", "250", "KBY45");
        quickAdd.quickAddPathExistingSetup("STAY3", "940 MHz", "Stay 3", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        quickAdd.quickAddPathSimple("Tonto Mtn", "940 MHz", "Go To New 1", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        quickAdd.quickAddPathExistingSetup("NEW2", "940 MHz", "Go To New 2", "40 34 10 N", "122 26 14 W", "250", "1208837");
        quickAdd.quickAddPathExistingSetup("NEW3", "940 MHz", "Go To New 3", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");


        pathSummary.splitProject("Splitting Half of Project "+randomNumber);
        pathSummary.valSiteLocationToggleOn();
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn","KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "180.45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "NEW2", "", "40 34 10 N", "122 26 14 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(1, "NEW2","KA20003", "40 44 54 N", "73 59 9 W", "180.45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "NEW3","", "35 12 26.7 N", "78 3 21.2 W", "48.69");
        pathSummary.viewSiteCallSignLatLongGeColumns2(2, "NEW3", "KA20003", "40 44 54 N", "73 59 9 W", "180.45");
    }

    /**COM-255 Split Project handling in UI
     *      "Given two buttons are displayed providing the options: Stay in Current Project; and Go To New Project,
     When user clicks the Stay in Current Project button,
     Then then the paths that were selected transfer to the new project,
     AND those paths are removed from the previous project,
     AND the user is returned to the project that was open prior to splitting."
     */

    @Test
    public void splitProjectStayInCurrentProject() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("splitProjectStay" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();

        siteExist = quickAdd.checkForExistingSite("Tonto Mtn");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();}
        else {
            quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "Tonto Mtn", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        }
        siteExist = quickAdd.checkForExistingSite("SYNRAMS STATION");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();}
        else {
            quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "SYNRAMS STATION", "40 34 10 N", "122 26 14 W", "250", "1208837");}
        siteExist = quickAdd.checkForExistingSite("CAMSLANT STATION");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();}
        else {
            quickAdd.quickAddPathDataSetup("CAM SUPPORT DATA", "940 MHz", "CAMSLANT STATION", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        }
        siteExist = quickAdd.checkForExistingSite("Not York");
        if (siteExist == true){quickAdd.cancelPathCreation();
        } else {
            quickAdd.quickAddPathDataSetup("NY SUPPORT DATA", "940 MHz", "Not York", "40 44 44 N", "73 59 5 W", "0.98", "KA20003");}


        quickAdd.quickAddPathSimple("Ton", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        quickAdd.quickAddPathExistingSetup("SPLIT_C1", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "250", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SPLIT_C1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(1, "SPLIT_C1", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        quickAdd.quickAddPathExistingSetup("SPLIT_C2", "940 MHz", "Best Path", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "SPLIT_C2", "", "35 12 26.7 N", "78 3 21.2 W", "48.69");
        pathSummary.viewSiteCallSignLatLongGeColumns2(2, "SPLIT_C2", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        quickAdd.quickAddPathSimple("Ton", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(3, "Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29");
        pathSummary.viewSiteCallSignLatLongGeColumns2(3, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        quickAdd.quickAddPathExistingSetup("SPLIT_C3", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "250", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(4, "SPLIT_C3", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(4, "SPLIT_C3", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        quickAdd.quickAddPathExistingSetup("SPLIT_C4", "940 MHz", "Best Path", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "SPLIT_C4", "", "35 12 26.7 N", "78 3 21.2 W", "48.69");
        pathSummary.viewSiteCallSignLatLongGeColumns2(5, "SPLIT_C4", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        pathSummary.splitProjectStay("Splitting Half of Project "+randomNumber);
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SPLIT_C1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(1, "SPLIT_C1", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "SPLIT_C2", "", "35 12 26.7 N", "78 3 21.2 W", "48.69");
        pathSummary.viewSiteCallSignLatLongGeColumns2(2, "SPLIT_C2", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

    }

    /**COM-255 Split Project handling in UI
     *      * "Given the Split Project modal is displayed,
     When a user clicks on the Split Project button before a New Project Name is entered,
     Then a graceful error is displayed about the Project Name being required. "

     * "Given that no paths are selected in the project summary page,
     When the Project Settings menu is displayed,
     Then the Split Project button is inactive."

     * "Given the Split Project modal is displayed,
     When the red circle x is clicked,
     Then the path associated with it is removed from the Project Summary path list."
     */

    @Test
    public void splitProjectAlt() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("splitProject" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();

        siteExist = quickAdd.checkForExistingSite("Tonto Mtn");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();}
        else {
            quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "Tonto Mtn", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        }

        quickAdd.quickAddPathSimple("Ton", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        quickAdd.quickAddPathExistingSetup("SPLIT_ALT", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "250", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SPLIT_ALT", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(1, "SPLIT_ALT", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
        pathSummary.openSettingMenuValDisabledSplitOption();

        pathSummary.splitProjectStayAlt("Splitting Half of Project "+randomNumber);
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "SPLIT_ALT", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "SPLIT_ALT", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
   }

/*COM-97
* " Given a user is creating a new project,
    When the Create New Project modal comes up,
    AND the Project Name field is completed,
    AND the Project Type field is clicked,
    Then a Default Company field is displayed below the Project Type field."

    "Given a user is entering a Default Company to a new project,
    When an existing company is selected from the company lookup,
    Then it will be added to the Project Summary Header after clicking the Create button."

    TODO Not currently working
    "Given a user is entering a Default Company to a new project,
    When a company is entered that doesn't exist in the db,
    Then a graceful error message will be displayed."

    "Given a user wants to add a Company to a new project,
    When s/he clicks on the Company lookup icon,
    Then a modal will display the following fields: Company Code; Company Name; and Contact Name
    AND the search results column headings will be as follows: Company Code; Company Name; Parent/Child; Contacts; and Status."

    TODO Not enough test data currently
    "Given a user clicks on company lookup icon,
    When the modal is displayed,
    Then search results will display 10 results,
    AND the results will scroll vertically,
    AND hovering over a company's Contacts icon in the results will display a popup with contact names.
    AND user can select an item from the search results."
* */
    @Test
    public void createNewProjectWithCompanyByCode() {
        boolean siteExist;
        createPath.enterProjectForCompany("withCompanyByCode" +randomNumber+ "f", "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
            quickAdd.quickAddPathExistingSetup("ByCode1", "940 MHz", "", "40 44 44 N", "73 59 5 W", "0.98", "KA20003");
            pathSummary.viewSiteCallSignLatLongGeColumns1(0, "ByCode1",  "KA20003", "40 44 44 N", "73 59 5 W", "0.98");
            pathSummary.viewSiteCallSignLatLongGeColumns2(0, "ByCode1", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

    }

    @Test
    public void createNewProjectWithCompanyByName() {
        boolean siteExist;
        createPath.enterProjectForCompany("withCompanyByName" +randomNumber+ "f", "This is the Default");
        createPath.fillOutCompanyFilter("","Verizon", "",0);
        pathSummary.valSiteLocationToggleOn();
        siteExist = quickAdd.checkForExistingSite("Not York");
        if (siteExist == true){quickAdd.cancelPathCreation();
        }else {
            quickAdd.quickAddPathDataSetup("NY SUPPORT DATA", "940 MHz", "Not York", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");
            quickAdd.quickAddPath("New", "940 MHz", "", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");
            pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Not York", "KA20003", "40 44 44 N", "73 59 5 W", "0.98");
            pathSummary.viewSiteCallSignLatLongGeColumns2(0, "New York", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
        }
    }

   /*@Test
    public void createNewProjectWithCompanyByContact() {
        boolean siteExist;

        createPath.enterProjectForCompany("Company By Contact" +randomNumber+ "f", "This is the Default");
        //TODO Can't search by contact name
        createPath.fillOutCompanyFilter("","", "John Doe",0);
        pathSummary.valSiteLocationToggleOn();
        siteExist = quickAdd.checkForExistingSite("New York");
        if (siteExist == true)
            quickAdd.cancelPathCreation();
        else
            quickAdd.quickAddPathDataSetup("NY SUPPORT DATA", "940 MHz", "New York", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");

        quickAdd.quickAddPath("New", "940 MHz", "", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "New York", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "New York", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
    }*/

    @Test
    public void createNewProjectNameDoesNoteExist() {
        boolean siteExist;
        createPath.enterProjectForCompany("ProjectNameDoesNoteExist" +randomNumber+ "f", "This is the Default");
        createPath.fillOutCompanyFilterErrorChecking("","WWEEERWWER", "",0);
        //createPath.projectFieldError();//TODO company not present warning not implemented yet.

    }

    /*COM-100
    Given that a Path Name is optional,
    When no path name is set,
    Then the Path Name will default to the names "Site 1" + "Site 2"
    (e.g. No Path Name is set, but Site Name 1 = "Qwerty" and Site Name 2 = "Asdfg".
    The default Path Name would then become "Qwerty - Asdfg".

    COM-148
    Given the Path Name field is empty,
    When saving a new path,
    Then the path's site names will be assigned as the path name, separated by a hyphen. eg. 'My site 1 - My site 2'
     */

    @Test
    public void quickAddProjectNoName() {
        String pathName;
        boolean siteExist;
        createPath.createBrandNewProjectPath("ProjectNoName"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();

        siteExist = quickAdd.checkForExistingSite("Not York");
        if (siteExist == true){
            quickAdd.cancelPathCreation();}
        else{
            quickAdd.quickAddPathDataSetup("NY SUPPORT DATA", "940 MHz", "Not York", "40 44 44 N", "73 59 5 W", "0.98", "KA20003");}

        quickAdd.quickAddPathExistingSetup("NoName", "940 MHz", "", "40 34 54 N", "33 59 9 W", "68898.04", "KA20003");
        pathName = pathSummary.projectNameSite1Site2Text(0);
        assertEquals(pathName, "NoName - New York2");

        siteExist = quickAdd.checkForExistingSite("CAMSLANT STATION");
        if (siteExist == true){
            quickAdd.cancelPathCreation();}
        else{
            quickAdd.quickAddPathDataSetup("CAM SUPPORT DATA", "940 MHz", "CAMSLANT STATION", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");}
        quickAdd.quickAddPathExistingSetup("NoName2", "940 MHz", "", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        pathName = pathSummary.projectNameSite1Site2Text(1);
        assertEquals(pathName, "NoName2 - New York2");

    }

    /*COM-100
    Given that a Path Name can be a maximum of 43 characters,
    When a Path name has 44+ characters,
    Then a graceful error will be displayed.

    COM-148
    Given a user wants to add a path to a project,
    When a path name is created,
    Then it does not need to be unique,
    AND it has a 43 char limit,
    AND must be in this character set: [a-z, A-Z, 0-9\space\_\-].

    COM-148
    Given user wants a a path's band to be included in the path information,
    When a user selects a band in this optional dropdown,
    Then the band selection will be displayed in the path summary.
     */

    @Test
    public void quickAddProjectName43Char() {
        String pathError;
        createPath.createBrandNewProjectPath("ProjectName43Char"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup("Name43", "940 MHz", "12345678912345678912345678912345678912345678", "40 44 54 N", "73 59 9 W", "68898.04", "KA20003");
        pathError = quickAdd.projectFieldError(0);
        assertEquals(pathError, "Path Name cannot be longer than 43 characters.");
    }

    /*COM-100
    Given that a Band dropdown selection is optional,
    When no Band is selected,
    Then a Path is still able to save successfully.
     */

    @Test
    public void quickAddNoBand() {
        boolean siteExist;
        String pathError;
        createPath.createBrandNewProjectPath("NoBand"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
            quickAdd.quickAddPathNoBand("SITE1", "", "SITE1", "35 30 4.68 N", "110 9 35.68 W", "98", "");
        }
    /*COM-100
    Given that a user wants to add a new path to a project,
    When valid entries are added into EITHER the Site 1 & Site 2 fields, OR the ASR/Call Sign field for Site 1 & Site 2,
    AND when the user clicks the ADD PATH button,
    Then a new path will be saved.
     */

    @Test
    public void quickAddInvalidChars() {
        createPath.createBrandNewProjectPath("quickAddInvalidChars"+ randomNumber+randomNumber1, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathInvalidChar();
    }

    @Test
    public void quickAddInvalidCharsCallSign() {
        createPath.createBrandNewProjectPath("InvalidCharsCallSign"+ randomNumber+randomNumber1, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathCallSignInvalidChar();
        quickAdd.quickAddPathCallSignInvalidChar2();

    }

    /*COM-100
     Given that a Site Name can be a maximum of 20 characters,
     When a Site Name has 21+ characters,
     Then a graceful error will be displayed.
     */

    @Test
    public void quickAddSite21PlusChars() {
        String pathError;
        String pathError2;
        createPath.createBrandNewProjectPath("Site21PlusChars"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathSiteName21Plus("VEUBDEKSKHIHSKHKSKHOOIJD");
        pathError = quickAdd.projectFieldError(0);
        pathError2 = quickAdd.projectFieldError(1);
        assertEquals(pathError, "Site Name cannot be longer than 20 characters.");
        assertEquals(pathError2, "Site Name cannot be longer than 20 characters.");
    }

    /*COM-100
    Given that a Call Sign is 8 characters (US),
    When a Call Sign with 8 characters is entered,
    AND the Call Sign is in the database,
    Then the Site Name, Latitude, Longitude and Elevation will auto-fill.
    ASRs: 7654321, 2345678, 1234567, 2354635 and 2356474
    Call Signs: 3d5g3s, FT3g3s, V43Sf, Td5G43s and FFR3ds

    */
    @Test
    public void quickAddCallSign() {
        createPath.createBrandNewProjectPath("quickAddCallSign"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.callSignErrorChecking("888888888", "888888888", "ASR must be 7 numbers long.", "ASR must be 7 numbers long.");
        quickAdd.callSignErrorChecking("55555", "55555", "ASR must be 7 numbers long.", "ASR must be 7 numbers long.");
        quickAdd.quickAddPathSimple("Tonto Mtn", "940 MHz", "Stay 1", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KA95314");
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KA95347");
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KAH72");
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KAC87");

    }

     /*
    Given that an ASR (Antenna Structure Registration) is 7 characters (US),
    When an ASR with 7 characters is entered,
    AND the ASR is in the database,
    Then the Latitude, Longitude and Elevation will auto-fill
    AND the Site Name will still need to be entered.
     */

    /*COM-100
    Given that Lat/Long are optional,
    When no lat/long coordinates are set,
    Then a Path will still save as expected.
    */
    @Test
    public void quickAddWithLatOrLong(){
        String pathError;
        String pathError2;
        createPath.createBrandNewProjectPath("WithLatOrLong"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude","4.0 GHz","SITE1","", "","98","");
        pathError = quickAdd.projectFieldError(0);
        pathError2 = quickAdd.projectFieldError(1);
        assertEquals(pathError, "Required");
        assertEquals(pathError2, "Required");
    }

    /*COM-100
        "35-30-4.683 N", "110-9-35.684 W"
        "35 30 4.683", "-110 9 35.684"
        "35.5013009N", "110.1599121W"
        "35.5013009", "-110.1599121"

    COM-129
    DD MM SS.SS N/S or DDD MM SS.SS E/W
    DD MM SS.SSN/S or DDD MM SS.SSE/W
    DD MM SS.SS or DDD MM SS.SS
    DD°MM'SS.SS" N/S or DDD°MM'SS.SS" E/W
    DD° MM' SS.SS" N/S or DDD° MM' SS.SS" E/W
    N/S DD MM SS.SS or E/W DDD MM SS.SS
    DD-­MM-­SS.SS N/S or DDD-­MM-­SS.SS E/W
    DD-­MM-SS and DDD-­MM­-SS.SS
    N/S DD-MM-SS.SS or E/W DDD-­MM-­SS.SS
    DD-­MM-­SS.SSN/S or DDD-­MM-­SS.SSE/W
    DD.DDDDDD or DDD.DDDDDD
    DD.DDDDDD N/S or DDD.DDDDDD E/W
    N/S DD.DDDDDD or E/W DDD.DDDDDD

    Given that a user wants to enter lat/long values,
    When they are entered in the following formats,
    Then they are accepted
    AND they are understood as intended:
    • DD-MM-SS.SS N/S, DDD-MM-SS.SS E/W
            -No negative sign allowed
    • DD MM SS.SS N/S, DDD MM SS.SS E/W DD-MM-SS.SS, DDD-MM-SS.SS
            -A negative sign in front of lat value implies S, otherwise N
            -A negative sign in front of long value implies W, otherwise E
    • DD.DDDDDD N/S, DDD.DDDDDD E/W
            -No negative sign allowed
    • DD.DDDDDD, DDD.DDDDDD
        -A negative sign in front of lat value implies S, otherwise N
        -A negative sign in front of long value implies W, otherwise E
     */
    @Test
    public void quickAddLatOrLongFormat1() {
        createPath.createBrandNewProjectPath("quickAddLatOrLongFormat"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();

        //N/S DD MM SS.SS or E/W DDD MM SS.SS
        quickAdd.quickAddPathExistingSetupNoVal("NS DD MM SSdotSS", "4.0 GHz", "First", "N 43°38 19.39", "W 116° 14 28.86", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "NS DD MM SSdotSS", "KBY45", "43 38 19.39 N", "116 14 28.86 W", "98");
        //("SPLIT_C1", "940 MHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "250", "KBY45")

        //DD-­MM-­SS.SS N/S or DDD-­MM-­SS.SS E/W
        quickAdd.quickAddPathExistingSetupNoVal("DD-MM-SSdotSS NS", "4.0 GHz", "Second", "43-38-19.39 N", "116-14-28.86 W", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "DD-MM-SSdotSS NS", "KBY45", "43 38 19.39 N", "116 14 28.86 W", "98");

        //DD-­MM-SS and DDD-­MM­-SS.SS
        quickAdd.quickAddPathExistingSetupNoVal("DD-MM-SS", "4.0 GHz", "third", "43-38-19.39", "-116-14-28.86", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "DD-MM-SS", "KBY45", "43 38 19.39 N", "116 14 28.86 W", "98");

        //N/S DD-MM-SS.SS or E/W DDD-­MM-­SS.SS
        quickAdd.quickAddPathExistingSetupNoVal("NS DD-MM-SSdotSS", "4.0 GHz", "forth", "N 43-38-19.39", "W 116-14-28.86", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(3, "NS DD-MM-SSdotSS", "KBY45", "43 38 19.39 N", "116 14 28.86 W", "98");

        //DD-­MM-­SS.SSN/S or DDD-­MM-­SS.SSE/W
        quickAdd.quickAddPathExistingSetupNoVal("DD-MM-SSdotSSNS", "4.0 GHz", "fifth", "43-38-19.39 N", "116-14-28.86 W", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(4, "DD-MM-SSdotSSNS", "KBY45", "43 38 19.39 N", "116 14 28.86 W", "98");

        //DD.DDDDDD or DDD.DDDDDD
        quickAdd.quickAddPathExistingSetupNoVal("DDdotDDDDDD", "4.0 GHz", "sixth", "38.959390", "-95.265483", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "DDdotDDDDDD", "KBY45", "38 57 33.8 N", "95 15 55.74 W", "98");

        //DD.DDDDDD N/S or DDD.DDDDDD E/W
        quickAdd.quickAddPathExistingSetupNoVal("DDdotDDDDDD NS", "4.0 GHz", "seventh", "38.959390 N", "95.265483 W", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(6, "DDdotDDDDDD NS", "KBY45", "38 57 33.8 N", "95 15 55.74 W", "98");

        //N/S DD.DDDDDD or E/W DDD.DDDDDD
        quickAdd.quickAddPathExistingSetupNoVal("NS DDdotDDDDDD", "4.0 GHz", "eighth", "N 38.959390", "W 95.265483", "98", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(7, "NS DDdotDDDDDD", "KBY45", "38 57 33.8 N", "95 15 55.74 W", "98");

    }

    @Test
    public void quickAddLatOrLongFormat2() {
        createPath.createBrandNewProjectPath("quickAddLatOrLongFormat" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
        pathSummary.valSiteLocationToggleOn();

        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35-30-4.683 N", "110-9-35.684 W", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "SITE1", "", "35 30 4.68 N", "110 9 35.68 W", "98");

        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35 30 4.683", "-110 9 35.684", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SITE1", "", "35 30 4.68 N", "110 9 35.68 W", "98");

        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35.5013009N", "110.1599121W", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "SITE1", "", "35 30 4.68 N", "110 9 35.68 W", "98");

        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35.5013009", "-110.1599121", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(3, "SITE1", "", "35 30 4.68 N", "110 9 35.68 W", "98");

        quickAdd.quickAddPathGeneral1("DD MM SSdotSS NS or DDD MM SSdotSS EW", "4.0 GHz", "SITE1", "38°57'33.804 N", "95°15'55.739 W", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(4, "SITE1", "", "38 57 33.8 N", "95 15 55.74 W", "98");

        quickAdd.quickAddPathGeneral1("DD MM SSdotSSNS or DDD MM SSdotSSEW", "4.0 GHz", "SITE1", "38°57'33.804N", "95°15'55.739W", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "SITE1", "", "38 57 33.8 N", "95 15 55.74 W", "98");

        quickAdd.quickAddPathGeneral1("DD MM SSdotSS or DDD MM SSdotSS", "4.0 GHz", "SITE1", "38°57'33.804", "-95°15'55.739", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(6, "SITE1", "", "38 57 33.8 N", "95 15 55.74 W", "98");

        quickAdd.quickAddPathGeneral1("DD MM SSdotSS NS or DDD degMMSSdotSS EW", "4.0 GHz", "SITE1", "84°17'14.0363 N", "042°14'52.4473E", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(7, "SITE1", "", "84 17 14.04 N", "42 14 52.45 E", "98");
    }

    /*COM-100
        GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]        35:30:4.683N 110:9:35.684W
        Would like a list of non-preferred formats that will convert, also the rules as to which of the 3 accepted formats that
        the non-preferred will predictably convert


    Given that a user enters a valid format that isn't the preferred format (DD MM SS.SS N/S, DDD MM SS.SS E/W),
    When the field is onBlurred,
    Then the value is converted to the preferred format.
     */
    @Test
    public void quickAddLatOrLongNotPerferredFormatConvertToPerferred() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("AddLatOrLongNotPerferredFormat"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);


        siteExist = quickAdd.checkForExistingSite("Not York");
        if (siteExist == true){
            quickAdd.cancelPathCreation();}
        else{
            quickAdd.quickAddPathDataSetup("NY SUPPORT DATA", "940 MHz", "Not York",  "40 44 44 N", "73 59 5 W", "0.98", "KA20003");}


        siteExist = quickAdd.checkForExistingSite("SITE1");
        if (siteExist == true){
            quickAdd.cancelPathCreation();}
        else{
            quickAdd.quickAddPathDataSetup("SITE1 SUPPORT DATA", "940 MHz", "SITE1", "76 26 47.7 N", "43 18 43.2 W", "0.98", "KA20003");}

        pathSummary.valSiteLocationToggleOn();
        //TODO currently lat and long is adding trailing zeros I am editing to allow for further examination of the tests
        quickAdd.quickAddPathGeneral1("Not Perferred to Convert To Perferred", "4.0 GHz", "SITE1", "76.446584", "-43.312", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "SITE1", "", "76 26 47.7 N", "43 18 43.2 W", "98");

    }
    /*COM-100
    Given that a user wants to enter lat/long values,
    When they are NOT entered in the formats listed above,
    Then they are NOT accepted
    AND a graceful error message comes up.
     */

    @Test
    public void quickAddLatOrLongNotPerferredWillNotConvert() {
        //GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]	35:30:4.683N 110:9:35.684W
        String invalidFormat1;
        String invalidFormat2;
        createPath.createBrandNewProjectPath("NotPerferredWillNotConvert"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35:30:4.683N", "110:9:35.684W", "98", "");
        invalidFormat1 = quickAdd.projectFieldError(0);
        invalidFormat2 = quickAdd.projectFieldError(1);
        assertEquals(invalidFormat1,"Invalid latitude format");
        assertEquals(invalidFormat2,"Invalid longitude format");



    }
    /*COM-100
    Given that the ground Elevation auto-fills,
    When the user wants to change the elevation,
    Then s/he can manually overwrite the existing number.
     */

    @Test
    public void quickAddElevationAutofillUserCanOverwrite() {
        //GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]	35:30:4.683N 110:9:35.684W
        boolean siteExist;

        createPath.createBrandNewProjectPath("ElevationCanOverwrite"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        siteExist = quickAdd.checkForExistingSite("New York2");
        if (siteExist == true){
            quickAdd.cancelPathCreation();}
        else {
            quickAdd.quickAddPathDataSetup("BTM SUPPORT DATA", "940 MHz", "BLACKTAIL MTN", "48 0 47.8 N", "114 21 58.4 W", "2035.79", "KBM76");
        }
        pathSummary.valSiteLocationToggleOn();
            quickAdd.quickAddPathGeneralNoSave("Elevation Autofill User Can Overwrite", "4.0 GHz", "new", "45 26 47.70 N", "4 7 12.00 W", "98", "Td5G43s");
            quickAdd.changeLatLong("9 26 42.70 N", "8 7 9.00 W");
            quickAdd.savePath();
            pathSummary.viewSiteCallSignLatLongGeColumns2(0, "New York", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

    }
    /*COM-148
    "Given a user wants to find an existing ASR/Call Sign,
    When user types in a value,
    AND on input blur,
    Then the app will determine it is ASR or Call Sign and emulate hitting the corresponding API."

    COM-148
    "Given that the app has hit the corresponding API,
    When an ASR auto populates in Quick Add,
    Then the ASR / Call Sign field will show the ASR."

    COM-148
    "Given that the app has hit the corresponding API,
    When a Call Sign auto populates in Quick Add,
    Then the ASR / Call Sign field will show the Call Sign."

    COM-148
    "Given a user wants to find an existing ASR/Call Sign,
    When user tries to assign an ASR or Call Sign which is not in the DB,
    Then a graceful error message will be displayed."

    COM-148
    "Given the elevation can only have one decimal point,
    When there are >1 decimal points (for both US and SI types),
    Then the value will be rounded up."

    COM-148
    "Given that all required Quick Add fields have been filled out,
    When a valid form is submitted,
    Then the UI will create the path (through API),
    AND add the path to the project with the API's response,
    AND close the Quick Add tool."

    COM-147
    Given a user is searching for an ASR or Call Sign in the Quick Add section of Project Summary,
    When the user has completed typing a valid ASR or Call Sign,
    AND after the input field is blurred,
    Then the app will determine if value is call sign or ASR,
    AND emulate hitting the corresponding API.
    IF there is an exact match found,
    Then the app will populate the site's fields with the corresponding data.

    147
    Given a user is searching for an ASR or Call Sign in the Quick Add section of Project Summary,
    When the user types AN INVALID ASR or Call Sign,
    AND after the input field is blurred,
    Then an error messsage will come up indicating that an ASR or Call Sign which is not found in the DB can't be assigned
     */

    @Test
    public void quickAddASRSuggest() {
        String FCCError1;

        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        //GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]	35:30:4.683N 110:9:35.684W
        quickAdd.quickAddPathExistingSetup("quickAddASRSug", "940 MHz", "KDFW Studio","32 47 16.4 N", "96 47 59 W","55.45", "KA3982");

        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "quickAddASRSug", "KA3982", "32 47 16.4 N", "96 47 59 W", "55.45");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "Studio","", "90 11 16.7 W","", "KBM40");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "Studio", "KBM40", "38 37 28.9 N", "90 11 16.7 W", "140.7");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "960 MHz", "WTCM-FM Tx Site","44 27 31 N", "","", "KBM93");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "WTCM-FM Tx Site", "KBM93", "44 27 31 N", "85 42 2 W", "323.1");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "6.4 GHz", "KSTU Transmitter","40 39 33 N", "12 12 08 W","8", "KA44228");
        pathSummary.viewSiteCallSignLatLongGeColumns1(3, "KSTU Transmitter", "KA44228", "40 39 33 N", "112 12 8 W", "8");

        quickAdd.quickAddPathGeneralError2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "NoFound");
        FCCError1 = quickAdd.projectFieldError(1);

        assertEquals(FCCError1,"Call Sign 'NoFound' not found");

    }

    /**COM-452
     *  Given a path is created in Path Details or Quick Add,
        When space " " character(s) are used before or after a path or site name,
        Then they will be trimmed off of the Path and Site names in the both the Path Summary list AND the Path Detail screen.
     */
    @Test//
    public void creatingQuickAddPath_WhenThereIsSpace_TrimSpaceOnBlur() {
        createPath.createBrandNewProjectPath("TrimSpaceOnBlur"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup("TrailingSpace ", "940 MHz", "TrailingSpace ", "34 44 46.3 N", "92 16 20.5 W", "68898.04", "KA2133");
        quickAdd.compareText("TrailingSpace ", "TrailingSpace",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup(" PreSpace", "940 MHz", "PreSpace", "34 44 46.3 N", "92 16 20.5 W", "68898.04", "KA2133");
        quickAdd.compareText(" PreSpace", "PreSpace",1);

    }

    /**COM-454
     *  Given a user is in the Path Details screen
        AND a Frequency Band is assigned to a path,
        When user clicks on Passive Repeater button in the Path Details header,
        Then the Passive Repeater section modal opens.
     */
    @Test
    public void passiveRepeater_OpenPassiveRepeaterForm_ValidateAllFieldsAndButtons() {
        createPath.createBrandNewProjectPath("OPEN Passive Repeater"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup("Passive Repeater", "940 MHz", "Passive Repeater", "34 44 46.3 N", "92 16 20.5 W", "68898.04", "KA2133");

        pathDetail.openPathDetailViaDetails();
        pathDetail.openPassiveRepeaterAndValidateFieldsAndButtons();
        }

    /**COM-454
     *  Given a user is in the Path Details screen
        AND NO Frequency Band is assigned to a path,
        When user clicks on Passive Repeater button in the Path Details header,
        Then the Passive Repeater section modal does NOT open.*/
    @Test
    public void passiveRepeater_NoFrequencyBand_PassiveRepeaterTriggerInactive() {
        createPath.createBrandNewProjectPath("Inactive Passive Repeater"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup("Passive Repeater", "Band", "Passive Repeater", "34 44 46.3 N", "92 16 20.5 W", "68898.04", "KA2133");

        pathDetail.openPathDetailViaDetails();
        pathDetail.clickInactivePassiveRepeaterTrigger();
    }

    /**COM-454
     *  Given the required fields for >= one Passive Repeater have been filled in with relevant data,
        When the + Passive Repeater button in the lower left corner of the Passive Repeater modal is clicked,
        Then the entry fields for a new Passive Repeater will be added,
        AND following this process will add up to a total of 3 repeaters.//TODO will implement in 13

         Site Search	Given a default company is assigned to a project,
         When a user is searching for a site in the Site field of the Passive Repeater modal,
         Then Site auto suggest will populate with sites that are associated with the project's default company.
         Site Lookup search results	Given the Site lookup icon is clicked in the Passive Repeater modal,
         When user enters Site Name, Call Sign, and/or ASR,
         AND clicks the search button,
         IF sites exist which match the search criteria
         AND their first character(s) match the first character(s) in the search criteria,
         Then a selection of sites will be displayed.
         Passive Repeater Site fields filled	Given a selection of sites is displayed in the Passive Repeater Site Lookup modal,
         When a user selects a site,
         Then the lookup closes
         AND the following current site fields will be filled with the selected site info for the following fields:
         Site Name, Lat, Long, Elevation


         Site Name field
         Given the Add Passive Repeater modal is open,
         When a valid passive Site Name is entered and the field is unfocused,
         Then the Latitude, Longitude and Ground Elevation fields will auto fill.

         Given the Add Passive Repeater modal is open,
         When the Repeater Type "Back-to-Back" is selected,
         Then the following fields will be displayed:
         Site Name; Latitude; Longitude; Ground Elev; Common Loss; Polarization Change (Yes/No selector); Antenna Model (2x); Antenna Code (2x) and Centerline (2x)
         AND a tooltip icon will be displayed to the right of the Ground Elev and Centerline (2x) field titles,
         AND the following lookups will be displayed:
         Site Name and Antenna Model (2x).

     */
    @Test
    public void passiveRepeater_AllValidData_PassiveRepeaterRecordIsCreated() {
        createPath.createBrandNewProjectPath("Inactive Passive Repeater"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup("Passive Repeater", "940 MHz", "Passive Repeater", "34 44 46.3 N", "92 16 20.5 W", "68898.04", "KA2133");

        pathDetail.openPathDetailViaDetails();
        pathDetail.addBackToBackPassiveRepeater();
        pathDetailAnt.antennaLookUpFromPassiveRepeater("02306A");
        pathDetail.returnFromAntennaLookUp("P8F-9","02306A");
        pathDetail.setAntennaOnPassiveRepeater(1,"02306A");
        pathDetail.savePassiveRepeater();
    }

    /**COM-454
     *  Remove passive Repeater	Given a passive repeater needs to be removed from a path,
        When the Remove button is clicked,
        Then the repeater from the section in which the Remove button was clicked will be removed.

         Creating a Back to Back type passive repeater	Given a Back to Back type repeater needs to be added to path,
         When the Passive Repeater modal is open,
         Then a valid Site Name, Back to Back Repeater Type, Common Loss (an integer), Antenna Models (2) OR Antenna Codes (2), and Centerlines (2) can be entered
         AND the Latitude, Longitude, Ground Elevation and Antenna Code fields are auto-filled.
         Edit Passive Repeater	Given a passive repeater's details need to be changed,
         When "+ Passive Repeater" is clicked
         Then field entry(s) in an existing repeater can be edited.
     */


    @Test
    public void passiveRepeater_SelectRemoveButton_PassiveRepeaterRecordWillBeRemoved() {
        createPath.createBrandNewProjectPath("Inactive Passive Repeater"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup("Passive Repeater", "940 MHz", "Passive Repeater", "34 44 46.3 N", "92 16 20.5 W", "68898.04", "KA2133");

        pathDetail.openPathDetailViaDetails();
        pathDetail.addBackToBackPassiveRepeater();
        pathDetailAnt.antennaLookUpFromPassiveRepeater("02306A");
        pathDetail.returnFromAntennaLookUp("P8F-9","02306A");
        pathDetail.setAntennaOnPassiveRepeater(1,"02306A");
        pathDetail.savePassiveRepeater();
        pathDetail.removePassiveRepeater();
    }

    /**COM-454
     *  Billboard Repeater fields	Given the Passive Repeater modal is open,
        When the Repeater Type "Billboard" is selected,
        Then the following fields will be displayed:
        Site Name; Latitude; Longitude; Ground Elev; Antenna Model; Antenna Code; Centerline
        Back-to-Back Repeater fields

        Creating a Billboard type passive repeater	Given a Billboard type Passive Repeater needs to be added to a path,
        When the Passive Repeater modal is open,
        Then a valid Site Name, Billboard Repeater Type, and Antenna Model/Code & Centerline can be entered,
        AND then the Latitude, Longitude, Ground Elevation and Antenna Code fields are auto-filled.
     */

    @Test
    public void passiveRepeater_AddBillboardPassiveRepeater_RecordWillBeAdded() {
        createPath.createBrandNewProjectPath("Inactive Passive Repeater"+ randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathExistingSetup("Passive Repeater", "940 MHz", "Passive Repeater", "34 44 46.3 N", "92 16 20.5 W", "68898.04", "KA2133");

        pathDetail.openPathDetailViaDetails();
        pathDetail.addBillboardPassiveRepeater();
        pathDetailAnt.antennaLookUpFromPassiveRepeater("%");
        pathDetail.returnFromAntennaLookUp("30x32 Foot Passive Billboard","3032RF");
        pathDetail.savePassiveRepeater();
    }


}


