package CommTests;

import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;





public class PathSummaryTest extends BaseTest {

    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;
    private QuickAddPage quickAdd;


    @Before


    public void Setup() {
        pathSummary = new PathSummaryPage(driver);
        createPath = new CreateNewPathPage(driver);
        quickAdd = new QuickAddPage(driver);

    }
    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);


    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    /**
     * Given that user is logged in with appropriate permission,
     * When a cursor hovers over the "P" (passive repeater) icon in the PATH column,
     * Then the site name, lat #; long #, and antenna # will be displayed in a pop up
     * And this can include multiple sites and/or multiple antennas at any site.
     */

    @Test
    public void hoverPassiveRepeaterValSiteInfo() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "4.0 GHz", "ASR-Call","", "","55", "KA3982");
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","", "","55", "KA2049");

        //pathSummary.hoverPassiveRepeaterValSiteInfo();
    }
    //    Given that user is logged in with appropriate permission,
    //    When a cursor hovers over the Site Location icon icon in the SITE column,
    //    Then the site name, lat #; long #, and ground elevation will be displayed in a pop up
    @Test
    public void hoverSiteLocationValSiteInfo() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "4.0 GHz", "ASR-Call","", "","55", "KA3982");
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","", "","55", "KA2049");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        pathSummary.valSiteLocationToggle();
    }

   //    Given that user is viewing the Project Summary header,
   //    When user views the filter,
   //    Then Site Frequency Band will be the default dropdown input.
    @Test
    public void valDefaultFilterValue() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "4.0 GHz", "ASR-Call","", "","55", "KA3982");
        assertEquals("Band is not the default dropdown input", "band", pathSummary.defaultFilterValue());
    }
    // COM 102
    // Project Filter - The Filter box gives the User the ability
    // to limit the project via 1 filter parameters.
    // Filter Box input defaults to Band - User types in desired
    // characters and clicks search button to limit displayed Paths.

    /*COM 125
    Given a user wants to filter a project via one output field,
    When a filter field is selected,
    AND search parameters are typed in the search field,
    AND the magnifying glass is clicked,
    Then relevant results will come up as a result.

    Given the user types something for which there are no search results,
    When results come back,
    Then there is is an appropriate result or message about no search results

    Given a user is flitering via the Filter text entry box,
    When a dropdown item is selected that doesn't allow for filtering by unassigned,
    Then the "Show all Paths with
    No Assigned _____" checkbox will not be displayed.
    */



    @Test
    public void valFilterResultSet() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","", "","55", "KA3982");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","", "","55", "KA2049");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","", "","55", "KA2124");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 4", "4.0 GHz", "KGO-TV","", "","55", "1000036");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 5", "4.0 GHz", "KGO-TV","", "","55", "1000036");


        pathSummary.filter("Band", "23.0");
        pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();
        assertEquals(pathSummary.showAllCheckBoxText(),"Show all Paths with No Assigned Frequency Bands");
        pathSummary.validateBandFilteredResult("Test Path 1");
        pathSummary.filter("Path Name","Test Path 3");
        pathSummary.validatePathNameFilteredResult("Test Path 3");

        //NO Hurry... in the process of moving off the static data...https://www.screencast.com/t/wweHelHOqd
        pathSummary.filter("Company","WILL BE CHANGING!!!");
        pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();
//        assertEquals(pathSummary.showAllCheckBoxText(),"Show all Paths with No Assigned Licensee");
//        pathSummary.validateLicenseeFilteredResult("Second Path adding extra for testing length", "Third Path", "Fourth Path", "Fifth Path");

        pathSummary.filter("Site Name", "KOTA TX - Skyline");
        pathSummary.validateSiteNameFilteredResult("Test Path 3");


        pathSummary.filter("ASR", "1000036");
        pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();
        assertEquals(pathSummary.showAllCheckBoxText(),"Show all Paths with No Assigned ASR");
        pathSummary.validateASRFilteredResult("Test Path 4");


        pathSummary.filter("Call Sign","KA2049");
        pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();
        assertEquals(pathSummary.showAllCheckBoxText(),"Show all Paths with No Assigned Call Sign");
        pathSummary.validateCallSignFilteredResult("Test Path 2");


        pathSummary.filter("Antenna Code","NOT READY");
        pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();
        assertEquals(pathSummary.showAllCheckBoxText(),"Show all Paths with No Assigned Antenna");
        pathSummary.validateAntennaCodeFilteredResult("Second Path adding extra for testing length", "Third Path", "Fifth Path");

        pathSummary.filter("Antenna Model","NOT READY");
        pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();
//        assertEquals(pathSummary.showAllCheckBoxText(),"Show all Paths with No Assigned Antenna");
//        pathSummary.validateAntennaModelFilteredResult("Fifth Path");

        pathSummary.filter("Radio Code", "NOT READY");
        pathSummary.showAllPathsWithNoAssignedRadio();
//        assertEquals(pathSummary.showAllCheckBoxText(),"Show all Paths with No Assigned Radio");
//        pathSummary.validateRadioCodeFilteredResult("Fourth Path");
        pathSummary.filter("Radio Bandwidth", "NOT READY");
        pathSummary.showAllPathsWithNoAssignedRadio();
//        pathSummary.validateRadioBandwidthFilteredResult("Fifth Path");
//        pathSummary.filter("Max Power","NOT READY");
//        pathSummary.validateMaxPowerFilteredResult("Fifth Path");
//        pathSummary.filter("Max Power","no results");

    }
    // COM 102
    // Project Filter - The Filter box gives the User the ability to limit the project via 1 filter parameters. Filter Box input defaults to Band - User types in desired characters and clicks search button to limit displayed Paths.

    // COM 125
    // Given the user wants to search by an unassigned value,
    //  When searching by the following values,
    //  Then appropriate search results will come up:
    //  • Band (BLANK) Default
    //  • Licensee (BLANK)
    //  • ASR (US ONLY) (BLANK)
    //  • Call Sign  (US ONLY) (BLANK)
    //  • Antenna Code (BLANK)
    //  • Antenna Model (BLANK)
    //  • Radio Code (BLANK)
    //  • Radio Model (BLANK)
        @Test
        public void valBlankFilterResultSet() {

            createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
            quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","", "","55", "KA3982");
            pathSummary.hoverSiteLocationValSiteInfo(0);
            pathSummary.filter("Band", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Path Name", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Company", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Site Name", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("ASR", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Call Sign", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Antenna Code", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Antenna Model", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Radio Code", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Radio Bandwidth", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
            pathSummary.filter("Max Power", "");
            pathSummary.validateBlankFilteredResult("Test Path 1");
        }

    // Given the user wants to sort by LOS, Avail or Valid columns,
    // When user clicks on one of these sortable column headers: LOS, Avail, Valid,
    // Then the table will sort only in descending order (Red - Orange - Grey - Green) even when clicking multiple times.

    //COM 108
    // Given the user wants to select all paths displayed in the Project Summary table,
    // When user clicks on the SELECT ALL button,
    // Then all of the paths listed will be highlighted,
    // AND Then the Select All button will change into a DESELECT ALL button.
    @Test
    public void valSelectAllPaths() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","", "","55", "KA3982");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","", "","55", "KA2049");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","", "","55", "KA2124");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 4", "4.0 GHz", "KGO-TV","", "","55", "1000036");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 5", "4.0 GHz", "KGO-TV","", "","55", "1000036");
        pathSummary.checkThatSelectButtonIsAvailable();
        pathSummary.clickSelectButton_CheckForDeselectButton();
        pathSummary.checkThatAllPathsAreSelected();
        //COM 108
        // Given that a user wants to deselect Paths that have been filtered out,
        // When user clicks on the DESELECT ALL button,
        // Then all paths will be deselected.
        // pathSummary.deselectAll();
        // pathSummary.clickDeselectAllButton();
        pathSummary.clickDeselectAllButton();
        /*108
        "Given that a user wants to select an individual Path,
         When user clicks in the blue box on the left-hand side of a path,
         Then it will be highlighted."
         "Given that a user wants to deselect an individual Path,
         When user clicks on a currently selected path (in the orange-highlighted left-hand side),
         Then it will be deselected."
         */
        pathSummary.highlightSinglePathDeselectAndValidate();
        }

        /*
        Given that user wants to take additional actions with Paths,
        When paths are selected/highlighted,
        Then the following action can be taken:
        Split Project; Delete Paths; Quick Check; Bulk Edits; Interference Analysis
        //TODO//    Split Project; Delete Paths; Quick Check; Bulk Edits; Interference Analysis

        //2/18 Added support for new locators
    */
    @Test
    public void valDeletePaths() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","", "","55", "KA3982");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","", "","55", "KA2049");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","", "","55", "KA2124");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 4", "4.0 GHz", "KGO-TV","", "","55", "1000036");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 5", "4.0 GHz", "KGO-TV","", "","55", "1000036");
        pathSummary.checkThatSelectButtonIsAvailable();
        pathSummary.checkForDeleteCandidates("Test Path 1", "Test Path 2", "Test Path 3");
        pathSummary.deleteSinglePath();
        pathSummary.checkForDeletedPath("First Path adding extra to test name length");
        //pathSummary.valSplitProject("First Path");
        //pathSummary.valQuickCheck("First Path");
        //pathSummary.valBulkEdits("First Path");
        //pathSummary.valInterferenceAnalysis("First Path");
    }

    /*
        "Given that user is logged in with appropriate permission,
        When user is looking at the last column in the header,
        Then the user will see a LOS Analysis icon,
        And an Availability analysis icon."

        "Given that user is logged in with appropriate permission,
        When user is looking at the last column in the header,
        Then the user will see a Validation analysis icon."

        Given the user wants to sort by LOS, Avail or Valid columns,
        When user clicks on one of these sortable column headers: LOS, Avail, Valid,
        Then the table will sort only in descending order (Red - Orange - Grey - Green) even when clicking multiple times
     */

    @Test
    public void viewLOSAvailVal() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","", "","55", "KA3982");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","", "","55", "KA2049");
        pathSummary.validatePresenceOfLOSAvailVal();

    }
    //COM 103
    //  Given the user wants to sort path summaries,
    //  When user clicks on one of these sortable column headers: #, Path, Band,
    //  Then the table sorts in descending order,
    //  AND sorts in ascending order when user clicks again on header.
    @Test
    public void valSortingNumPathBand() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","", "","55", "KA3982");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","", "","55", "KA2049");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","", "","55", "KA2124");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 4", "4.0 GHz", "KGO-TV","", "","55", "1000036");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 5", "4.0 GHz", "KGO-TV","", "","55", "1000036");
        pathSummary.checkPathNumForAscend();
        pathSummary.checkPathNumForDescend();
        pathSummary.checkBandForAcend();
        pathSummary.checkBandForDescend();
        pathSummary.checkPathNameForDescend();
        pathSummary.checkPathNameForAcend();
    }

    /*103
        Given the user wants to sort by LOS, Avail or Valid columns,
        When user clicks on one of these sortable column headers: LOS, Avail, Valid,
        Then the table will sort only in descending order (Red - Orange - Grey - Green) even when clicking multiple times
     */
    @Test
    public void sortLOSAvailVal() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","37 47 59.7 N", "122 23 58.8 W","55", "KA2049");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","44 04 07.4 N", "103 15 05 W","55", "KA2124");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 4", "4.0 GHz", "KGO-TV","37 41 47.6 N", "121 46 10.5 W","55", "1000036");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 5", "4.0 GHz", "KGO-TV","37 41 47.6 N", "121 46 10.5 W","55", "1000036");
        pathSummary.validateSortOfLOSAvailVal();
    }

     /*COM 105
        Given that a user wants to delete an already established path,
        When the path is highlighted AND Delete Paths button (located in the upper right corner hamburger menu) is clicked,
        Then popup confirmation will be displayed.

        Given a user clicks the Delete Paths button,
        When a slideout confirmation is displayed,
        Then the user will see a summary of all selected paths,
        AND will have the option to remove paths from the list.

        Given a user has finalized the decision about which paths to keep on the slideout confirmation,
        When the Delete Paths button is clicked,
        Then the action will be saved.
     */
     @Test
     public void deletePathFromHamburgerMenu() {
         createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
         quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
         pathSummary.hoverSiteLocationValSiteInfo(0);
         quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","37 47 59.7 N", "122 23 58.8 W","55", "KA2049");
         pathSummary.hoverSiteLocationValSiteInfo(0);
         quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","44 04 07.4 N", "103 15 05 W","55", "KA2124");
         pathSummary.hoverSiteLocationValSiteInfo(0);
         quickAdd.quickAddPathGeneral2("Test Path 4", "4.0 GHz", "KGO-TV","37 41 47.6 N", "121 46 10.5 W","55", "1000036");
         pathSummary.hoverSiteLocationValSiteInfo(0);
         quickAdd.quickAddPathGeneral2("Test Path 5", "4.0 GHz", "KGO-TV","37 41 47.6 N", "121 46 10.5 W","55", "1000036");
         pathSummary.highlightPathAndSelectDeleteFromHamburger();
    }

    /*
        COM 102
        Project Menu - The project menu will give Users additional tools for managing their Project:
        -Split Project //TODO
        -Delete Paths
        -Settings
        -Reporting//TODO

       COM 106
        Settings: Settings allows the user to manage basic settings & controls for the Project (Default setting are controlled in the User Settings) - Project Settings will have defaults set up in the Global setting for the application - *Individual User defaults is a potential option
        User clicks on Menu to Access Settings Button - User clicks on Settings to slide open the Settings Widget - No Acceptance Criteria
        Settings Displays:
        Project Unit Measurement Type
        Default Licensee
        Show Location
        Line of Site Analysis Defaults
        Availability Defaults

        "Given a user wants to access Project settings,
        When the hamburger menu located in the upper right corner of the Project Summary screen is clicked,
        Then the Settings menu will be one of the selections that drop down."
        "Given the hamburger menu selections are displayed,
        When the Settings buttons is clicked,
        Then the Project Settings window slides out from the right side of the screen."
    */
    @Test
    public void viewSettingsFromHamburgerMenu() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.selectAndViewSettingsFromHamburgerMenu();
    }

    /* COM 107
        "Given that a user wants to edit the settings for a project,
        When s/he clicks on Project Summary>hamburger menu,
        Then the Settings modal pops up."
        "Given a user wants to change the unit type to be displayed in a project,
        When s/he changes the value by clicking on a unit radio button and then clicking Save,
        Then the unit type will be changed in the project (feet to meters, meters to feet)."

        COM-169
        "Given that US Unit is selected,
        When user views Minimum Clearance,
        Then by default the Units will be measured in ""(ft)"""

        COM-169
        "Given that a US user wants to change the Unit in Settings,
        When the SI button is clicked,
        Then the Minimum Clearance units will change to ""(m)""."

        COM-169
        "Given the Unit is in meters,
        When the units are changed from meters to feet,
        The minimum clearance amount will convert accordingly (e.g. 1,000 m = 3,280.84 ft.)
        AND When the units are changed from feet to meters,
        The minimum clearance amount will convert accordingly (e.g. 3,280.84 ft. = 1,000 m.)"

        COM-169
        "Given the largest or smallest minimum clearance is required,
        When minimum clearance min/max = -1000/1000 for meters and -3280.84/3280.84 for feet
        Then they will be accepted in the project settings,
        BUT when numbers outside of the acceptable limits are entered,
        Then an error message will be displayed as follows: ""MUST BE BETWEEN -1,000 AND 1,000"" when meters are the selected unit,
        OR ""MUST BE BETWEEN -3280.84 AND 3280.84"" when feet are the selected unit."
  */
    @Test
    public void changeUnitsSettingsAndVal() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.changeUnitsFromUsToSi("02","0.61");
        pathSummary.changeUnitsFromUsToSi("03","0.91");
        pathSummary.changeUnitsFromUsToSi("55","16.76");
        pathSummary.changeUnitsFromUsToSi("90","27.43");
        pathSummary.changeUnitsFromUsToSi("120","36.58");
        pathSummary.changeUnitsFromUsToSi("1000","304.8");
        pathSummary.changeUnitsFromUsToSi("-3280.84","-1000");
        pathSummary.changeUnitsFromUsToSi("-02","-0.61");
        pathSummary.changeUnitsFromUsToSi("-03","-0.91");
        pathSummary.changeUnitsFromUsToSi("-55","-16.76");
        pathSummary.changeUnitsFromUsToSi("-90","-27.43");
        pathSummary.changeUnitsFromUsToSi("-120","-36.58");
        pathSummary.changeUnitsFromUsToSi("-10000","-3048");
        assertEquals("MUST BE BETWEEN -1,000 AND 1,000",quickAdd.projectFieldError(0));

    }

    /*COM 107 & 116
        Given that a user opens Project Settings,
        When Project Settings opens,
        Then the default values are as follows:
        Summary Display = Hide Location (user level)
        Default Line of Sight Settings:
        Fresnel Zone Radius default = 60%
        K Factor default = 1
        Minimum Clearance default = 0
        Total Availability Targets:  99.99%
     */

    @Test
    public void viewDefaultSettingsFromProjectSetting() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.viewDefaultSettings();
    }
    /*
        COM 102
        Path Summary Header - (Sortable by Path #, Path Name, LOS, Avail & Valid) Displays the following fields to the Users (Note: In settings user can Hide/Unhide Location details Lat, Long & GE.)
        Path #
        Path Name
        Band
        Site
        Call Sign
        Antenna
        Radio
        Bandwidth
        Freq
        LOS
        AVAIL
        VALID

        COM 107
        Given a user wants to display Site Location Details in the Project Summary,
        When the "Show Site Location Details" checkbox is unchecked (default),
        Then the columns Latitude, Longitude and Ground Elevation columns will NOT be displayed,
        AND the hover pin will be displayed (revealing Site Location Details when hovered over)
        BUT
        When the checkbox is activated and saved,
        Then Site Location Details will be displayed via lat, Long and G.E. columns,
        and the hover tooltip which displays the site's info will NOT be displayed.

        COM 109
         "Given a user is viewing the Site columns,
         When the Project Settings 'Show Site Location Details' box is checked,
         Then the Lat, Long & G.E. columns will be displayed,
         BUT When it is unchecked,
         Then the Lat, Long & G.E. columns will NOT be displayed."

         "Given a user is viewing the Site columns,
         When the Project Settings 'Show Site Location Details' box is NOT checked,
         Then the Site tooltip trigger will be displayed,
         BUT When it is unchecked,
         Then the Site tooltip trigger will NOT be displayed."
    */
    @Test
    public void valEffectsOfSiteSettingsCheckbox() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.valSiteLocationToggle();
    }
    /*COM 107
        Given a user wants to update a fresnel zone,
        When a user enters a fresnel zone radius as a whole number between 1 and 1000,
        AND clicks the Save Settings button,
        Then the Fresnel Zone setting will be changed.

        Given a user wants to update a fresnel zone,
        When a user enters a fresnel zone radius as a whole number < 1 or > 1000,
        AND clicks the Save Settings button,
        Then a graceful error message will be displayed.
     */

    @Test
    public void valFresnelZoneRadiusField() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.valFresnelZoneRadius();
    }

    /*COM 107
        This value shows the current assigned k Factor for the project.
        Changing this value will update the k Factor upon save.
        (Default at application level is 1)
        Validation: value must be a number which is greater than 0
        and no greater than 1000. Only two decimal places are allowed.
     */
//TODO Update this val messages to 100000
    @Test
    public void valKFactorField() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.valKFactorSetting();
    }

     /*COM 107
        #project-summary-settings-minimum-clearance
        This value shows the current assigned Minimum
        Clearance for the project. This value is displayed in whatever unit is currently selected in the form's unit type.
        Changing the unit type changes this value to match the respective units. Changing this value will update the Minimum Clearance upon save.
        (Default at application level is 0)
        Validation: value must be a number which between -1000 and 1000. Only two decimal places are allowed.
     */

    @Test
    public void valKMinClearanceField() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.valKMinClearanceSetting();
    }

    /*COM 107
       Default Availability Target
       #project-summary-settings-target-availability
       This value shows the current assigned Target Availability for the project.
       Changing this value will update the Target Availability upon save.
       (Default at application level is 99.995%.)
       Validation: value must be a number between 50 and 100. Up to 6 decimals are allowed.
       On successful submit, the form panel will slide to the right out of view and the project summary view will update accordingly.
     */

    @Test
    public void valDefaultAvailabilityTarget() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.valKDefaultAvailabilityTargetSetting();
    }

    /*COM 109
    Given a user is viewing Project Summary path rows,
    When looking at the Blue Section,
    Then the following items will be visible:
    # column; Path; Band (Details); Path Menu caret; MOD/NEW icon; Passive Repeater tooltip trigge

    Given that a user is viewing the blue section,
    When the Path menu (caret) is open,
    Then two buttons, 'delete' and 'copy', will be visible.

    Given that a user is viewing the blue section,
    When a path has a Passive Repeater,
    Then the Passive Repeater tooltip trigger will be visiible.
    AND will display the path's passive repeater information (site name, lat, long, antennas)

    Given multiple antennas are assigned to a path,
    When the cursor hovers over a Diversity Antenna tooltip trigger,
    Then the Code, Model and Centerline of the antenna will be displayed.

    "Given a user is viewing the Project Summary Radio column,
    When both radios in a path are the same,
    //TODO need a case for single radios
    Then only a single radio will display in this section instead of two radios.
    (e.g. see path 3 in /1234)"

    "Given a user is viewing the Project Summary Radio column,
    When a radio has adaptive modulation (simulated until APIs are complete),
    Then the ACM icon will be displayed."

    "Given the ACM icon is displayed,
    When the cursor hovers over the icon,
    Then it will display the radio's modulation settings. "

    "Given a user is viewing Project Summary path rows,
    When looking at the Pass/Fail section,
    Then the following items will be visible:
    LOS; Avail; Valid."

    COM-100
    Given that a new path is created,
    When it is added to the Project Summary path list,
    Then it will be assigned a path number one higher than the previous highest path number, based on the order of creation.
     */




    @Test
    public void viewPathBlueSection() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "KDFW Studio","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","37 47 59.7 N", "122 23 58.8 W","55", "KA2049");
        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","44 04 07.4 N", "103 15 05 W","55", "KA2124");
        pathSummary.viewPathBlueSection(0,"Test Path 1","1","MOD","","Details");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0,"KDFW Studio","KA3982","32 47 16.4 N","96 47 59 W","54.99");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1,"ASR-Call","KA2049","37 47 59.7 N","122 23 58.8 W","54.99");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2,"KOTA TX - Skyline","KA2124","44 4 7.4 N","103 15 5 W","54.99");
        //pathSummary.viewAntennaRadioBandwidthFreq();TODO feature not ready
        //pathSummary.viewDiversityAntAmcPassFail();TODO feature not ready
    }
    /*
    Given a user is viewing the Path list table,
    When multiple paths have the same radio configuration,
    Then the path only displays one radio.
     */
//TODO antenna section is not complete at the moment will revisit once implemented


    @Test
    public void valTwoPathsSameConfigOneRadio() {
//        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
//        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
//        pathSummary.hoverSiteLocationValSiteInfo(0);
//        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","37 47 59.7 N", "122 23 58.8 W","55", "KA2049");
//        pathSummary.hoverSiteLocationValSiteInfo(0);
//        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","44 04 07.4 N", "103 15 05 W","55", "KA2124");
//        pathSummary.pathWithSameConfig_OneRadio();

    }
    /*
    "Given a user is searching for a Site in the Quick Add section of Project Summary,
    When the user begins typing a valid site name,
    AND after the 1st character is typed,
    Then the browser will (emulate) fetch for all sites which contain the input's value in their Site Name,
    AND they will display beneath the input field."
     */

    @Test
    public void valQuickAddSuggestedText() {
        createPath.createBrandNewProjectPath("Best Project Ever"+ randomNumber, "This is the Default");
        quickAdd.quickAddPathGeneral2("Test Path 1", "23.0 GHz", "ASR-Call","32 47 16.4 N", "96 47 59 W","55", "KA3982");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 2", "4.0 GHz", "ASR-Call","37 47 59.7 N", "122 23 58.8 W","55", "KA2049");
        pathSummary.hoverSiteLocationValSiteInfo(0);
        quickAdd.quickAddPathGeneral2("Test Path 3", "4.0 GHz", "KOTA TX - Skyline","44 04 07.4 N", "103 15 05 W","55", "KA2124");
        pathSummary.quickAddSuggestedText();

    }



}








