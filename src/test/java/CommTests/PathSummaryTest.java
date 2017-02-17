package CommTests;

import CommPageObjects.PathSummaryPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class PathSummaryTest extends BaseTest {

    private PathSummaryPage pathSummary;

    @Before
    public void Setup() {
        pathSummary = new PathSummaryPage(driver);
    }

    //    Given that user is logged in with appropriate permission,
    //    When a cursor hovers over the "P" (passive repeater) icon in the PATH column,
    //    Then the site name, lat #; long #, and antenna # will be displayed in a pop up
    //    And this can include multiple sites and/or multiple antennas at any site.
    @Test
    public void hoverPassiveRepeaterValSiteInfo() {
        //TODO//createPath.createBrandNewProjectPath("Best Project Ever", "This is the Default");
        //TODO//Add validation for values once data is no longer static currently only fields are validated
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.hoverPassiveRepeaterValSiteInfo();
    }
   //NOT DEMO'd
    //    Given that user is logged in with appropriate permission,
    //    When a cursor hovers over the Site Location icon icon in the SITE column,
    //    Then the site name, lat #; long #, and ground elevation will be displayed in a pop up
    @Test
    public void hoverSiteLocationValSiteInfo() {
        //TODO//createPath.createBrandNewProjectPath("Best Project Ever", "This is the Default");
        //TODO//Add validation for values once data is no longer static currently only fields are validated
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        //TODO The site location locator needs an ID added, sent request to Nemo
        //TODO The setting that controls this option is defaulting in the reverse Mark has defect
        pathSummary.hoverSiteLocationValSiteInfo();
    }

   //    Given that user is viewing the Project Summary header,
   //    When user views the filter,
   //    Then Site Frequency Band will be the default dropdown input.
    @Test
    public void valDefaultFilterValue() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        assertEquals("Band is not the default dropdown input", "band", pathSummary.defaultFilterValue());
    }
    //COM 125
    //    Given a user wants to filter a project via one output field,
    //    When a filter field is selected,
    //    AND search parameters are typed in the search field,
    //    AND the magnifying glass is clicked,
    //    Then relevant results will come up as a result.

    //  Given the user types something for which there are no search results,
    //  When results come back,
    //  Then there is is an appropriate result or message about no search results
    @Test
    public void valFilterResultSet() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.filter("Band", "23.0");
        pathSummary.validateBandFilteredResult("Second Path");
        pathSummary.filter("Path Name","First Path");
        pathSummary.validatePathNameFilteredResult("First Path");
        pathSummary.filter("Licensee","Licensee Inc");
        pathSummary.validateLicenseeFilteredResult("Second Path", "Third Path", "Fourth Path", "Fifth Path");
        pathSummary.filter("Site Name", "unique");
        pathSummary.validateSiteNameFilteredResult("First Path");
        pathSummary.filter("ASR", "345");
        pathSummary.validateASRFilteredResult("Fourth Path");
        pathSummary.filter("Call Sign","3");
        pathSummary.validateCallSignFilteredResult("Second Path", "Third Path", "Fourth Path");
        pathSummary.filter("Antenna Code","F500ANT");
        pathSummary.validateAntennaCodeFilteredResult("Second Path", "Third Path", "Fifth Path");
        pathSummary.filter("Antenna Model","Doo");
        pathSummary.validateAntennaModelFilteredResult("Fifth Path");
        pathSummary.filter("Radio Code", "unique");
        pathSummary.validateRadioCodeFilteredResult("Fourth Path");
        pathSummary.filter("Radio Bandwidth", "999");
        pathSummary.validateRadioBandwidthFilteredResult("Fifth Path");
        pathSummary.filter("Max Power","9990");
        pathSummary.validateMaxPowerFilteredResult("Fifth Path");
        pathSummary.filter("Max Power","no results");

    }
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
            assertTrue(pathSummary.landedOnPathSummaryPage());
            assertTrue(pathSummary.projectName());
            pathSummary.filter("Band", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Path Name", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Licensee", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Site Name", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("ASR", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Call Sign", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Antenna Code", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Antenna Model", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Radio Code", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Radio Bandwidth", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");
            pathSummary.filter("Max Power", "");
            pathSummary.validateBlankFilteredResult("First Path", "Second Path", "Third Path", "Fourth Path", "Fifth Path");

        }




    //TODO//Need to have locator created for  LOS, Avail or Valid!!
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
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
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

        }
    /*
        Given that user wants to take additional actions with Paths,
        When paths are selected/highlighted,
        Then the following action can be taken:
        Split Project; Delete Paths; Quick Check; Bulk Edits; Interference Analysis
        //TODO//    Split Project; Delete Paths; Quick Check; Bulk Edits; Interference Analysis
    */
    @Test
    public void valDeletePaths() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.checkThatSelectButtonIsAvailable();
        pathSummary.checkForDeleteCandidates("First Path", "Second Path", "Third Path");
        pathSummary.deleteSinglePath();
        pathSummary.checkForDeletedPath("First Path");
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
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.validatePresenceOfLOSAvailVal();

    }
    //COM 103
    //  Given the user wants to sort path summaries,
    //  When user clicks on one of these sortable column headers: #, Path, Band,
    //  Then the table sorts in descending order,
    //  AND sorts in ascending order when user clicks again on header.
    @Test
    public void valSortingNumPathBand() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.checkPathNumForAscend();
        pathSummary.checkPathNumForDescend();
        //TODO//Need to have locator created for Band!!//pathSummary.checkBandForAcend();
        //TODO//Need to have locator created for Band!!//pathSummary.checkBandForDescend();
        //TODO//Need to have locator created for Path Name!! pathSummary.checkPathNameForDescend();
        //TODO//Need to have locator created for Path Name!! pathSummary.checkPathNameForAcend();
    }



    /*103
        Given the user wants to sort by LOS, Avail or Valid columns,
        When user clicks on one of these sortable column headers: LOS, Avail, Valid,
        Then the table will sort only in descending order (Red - Orange - Grey - Green) even when clicking multiple times
     */
    @Test
    public void sortLOSAvailVal() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
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
         assertTrue(pathSummary.landedOnPathSummaryPage());
         assertTrue(pathSummary.projectName());
         pathSummary.highlightPathAndSelectDeleteFromHamburger();


    }
    /*COM 106
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
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.selectAndViewSettingsFromHamburgerMenu();
    }

    /* COM 107
        "Given that a user wants to edit the settings for a project,
        When s/he clicks on Project Summary>hamburger menu,
        Then the Settings modal pops up."
        "Given a user wants to change the unit type to be displayed in a project,
        When s/he changes the value by clicking on a unit radio button and then clicking Save,
        Then the unit type will be changed in the project (feet to meters, meters to feet)."
  */
    @Test
    public void changeUnitsSettingsAndVal() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.changeUnitsFromUsToSi();
    }

    /*COM 107
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
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.viewDefaultSettings();
    }
    /*COM 107
        Given a user wants to display Site Location Details in the Project Summary,
        When the "Show Site Location Details" checkbox is unchecked (default),
        Then the columns Latitude, Longitude and Ground Elevation columns will NOT be displayed,
        AND the hover pin will be displayed (revealing Site Location Details when hovered over)
        BUT
        When the checkbox is activated and saved,
        Then Site Location Details will be displayed via lat, Long and G.E. columns,
        and the hover tooltip which displays the site's info will NOT be displayed.
    */
    @Test
    public void valEffectsOfSiteSettingsCheckbox() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
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
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.valFresnelZoneRadius();
    }

    /*COM 107
        This value shows the current assigned k Factor for the project.
        Changing this value will update the k Factor upon save.
        (Default at application level is 1)
        Validation: value must be a number which is greater than 0
        and no greater than 1000. Only two decimal places are allowed.
     */

    @Test
    public void valKFactorField() {
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
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
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
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
        assertTrue(pathSummary.landedOnPathSummaryPage());
        assertTrue(pathSummary.projectName());
        pathSummary.valKDefaultAvailabilityTargetSetting();
    }

}








