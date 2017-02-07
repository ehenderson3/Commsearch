package CommTests;

import CommPageObjects.PathSummaryPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ehend on 2/4/2017.
 */
public class PathSummary extends BaseTest {

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

    //    Given a user wants to filter a project via one output field,
    //    When a filter field is selected,
    //    AND search parameters are typed in the search field,
    //    AND the magnifying glass is clicked,
    //    Then relevant results will come up as a result.
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
    }
    //  Given the user wants to search by an unassigned value,
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
    //  Given the user types something for which there are no search results,
    //  When results come back,
    //  Then there is is an appropriate result or message about no search results

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
}




















//        Given the user wants to sort by LOS, Avail or Valid columns,
//        When user clicks on one of these sortable column headers: LOS, Avail, Valid,
//        Then the table will sort only in descending order (Red - Orange - Grey - Green) even when clicking multiple times.







