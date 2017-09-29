package CommTests;

import CommPageObjects.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ehend on 2/25/2017.
 */
public class PathDetailAntennaTest extends BaseTest {
    private PathDetailAntennaPage pathDetailAnt;
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;
    private PathDetailPage pathDetail;

    @Before
    public void Setup() {
        pathDetailAnt = new PathDetailAntennaPage(driver);
        quickAdd = new QuickAddPage(driver);
        pathSummary = new PathSummaryPage(driver);
        createPath = new CreateNewPathPage(driver);
        pathDetail = new PathDetailPage(driver);    }

    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    @Ignore//TODO Waiting on COM-464 Antenna Lookup for Passive Repeater, should filter antennas by passive type
    public void pathDetailAntennaSearch_shouldReturnRows_whenValidSearchCriteriaIsEntered() {
        createPath.createBrandNewProjectPath("Add Antenna" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333","", "",0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("SrchRetRows1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66","1");
        pathDetail.addPathViaPathDetailBasicSetup2("SrchRetRows2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.addAntennaToPath("P8F-9","txrx","02306A","3.2°","20.3","P8F-9","txrx","02306A","3.2°","20.3" );
        pathDetailAnt.clickSaveDetails();
    }

    /**COM-340 UX/UI: Antenna Section of Path Details
     * Given an antenna code has been entered into the Antenna Code field,
     When the field is unfocused,
     Then the application will check for an exact match in the Antenna Spec Resource API.

     When an exact match is found in the API,
     Then Antenna Model, Beam-width and Manufacturer fields will populate.
     Tilt (degrees)	(This value will not be populated during this sprint)
     Invalid Antenna Code error	Given an invalid Antenna Code has been entered in the Antenna Code Field or the Antenna lookup,
     */

    @Test
    public void pathDetailAntenna_willAutoFill_whenThereIsAMatchOnAntennaCode() {
        createPath.createBrandNewProjectPath("Antenna Code onBlur" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("MatchOnAntCode1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "11.0 GHz");
        pathDetail.addPathViaPathDetailBasicSetup2("MatchOnAntCode2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaDataAndonBlurRelatedFieldsPopulate("VHLPX2-11", "Tx/Rx", "77100A", "3.4°", "34.4", "VHLPX2-11", "Tx/Rx", "77100A", "3.4°", "34.4");
        pathDetailAnt.clickSaveDetails();
    }


//    Search results COM-398
//    Given a user clicks the ASR lookup icon in the Path Details screen
//    When user enters a valid ASR Number (or at least the first several numbers),
//    AND clicks the search button,
//    IF ASR numbers exist which match the search criteria
//    AND character(s) match the character(s) in the search criteria,
//    Then a selection of ASRs will be displayed.

//    Search results
//    Given a user clicks the ASR lookup icon in the Path Details screen,
//    When user enters too few numbers of a valid ASR Number (typically 2 characters, but this varies depending on the number),
//    AND clicks the search button,
//    Then an error is displayed that says, "Too many results returned. Please refine your search."

//    FCC matches are displayed
//    Given a site is being created,
//    When a user searches for an existing ASR via the Path Details ASR lookup,
//    Then the site(s) from the FCC that match the search criteria are displayed in the lookup search results.
//
//    Site fields auto-populate
//    Given a selection of ASR numbers is displayed,
//    When a user clicks on an ASR row from the search results,
//    Then the Lat, Long, Elevation and ASR fields auto-populate with information (when it exists) for that site
//    AND the lookup closes.
//    Unit of measurement	Given the ASR Lookup is used to search for an ASR,
//    When search results are returned,
//    Then the Unit for Ground Elevation and Overall Height should match the user default (units can be superseded by project settings).
    @Test
    public void pathDetailAntenna_willAutoFill_whenThereIsAMatchOnASR() {
        createPath.createBrandNewProjectPath("ASR onBlur" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailASR1("1300000", "35 57 12 N", "85 2 6.7 W", "170.658", "ASR Created2");
        pathDetail.addPathViaPathDetailASR2("1200000", "39 58 38.7 N", "95 0 49.1 W", "97.17" ,"ASR Created2");
        pathDetailAnt.clickSaveDetails();
    }

    @Test
    public void pathDetailAntenna_willError_whenThereIsNotAMatchOnASR() {
        createPath.createBrandNewProjectPath("ASR onBlur" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailASR1Error("6fg6hg64");
        pathDetailAnt.clickSaveDetails();
    }

    /**
     When the entry has <6 or >8 characters,
     Then a graceful error will be displayed.
     Antenna Model field Deletion 'X'	Given the antenna model input field has a value,

     When user hovers cursor over the value,
     Then an X will appear on the right hand side of the field,
     Clearing All Antenna fields	Given cursor hovers over the value in the Antenna Model field,

     When user clicks the X on the right hand side of the field,
     Then all fields in that antenna section will be cleared.
     */

    @Ignore //TODO can't get the intra field clear to work
    public void pathDetailAntenna_allAntennaFieldCleared_WhenClickingTheDeleteX() {
        createPath.createBrandNewProjectPath("Antenna Code onBlur" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("MatchOnAntCode1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("MatchOnAntCode2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaDataAndonBlurRelatedFieldsPopulate("VHLPX2-11", "Tx/Rx", "77100A", "3.4°", "34.4", "VHLPX2-11", "Tx/Rx", "77100A", "3.4°", "34.4");
        pathDetailAnt.clearAntennaField();
        pathDetailAnt.clickSaveDetails();
    }

    /**COM-341 UI/UX: Antenna Lookup
     * Given a user clicks on the Antenna lookup icon,
         When valid search criteria are entered,
         AND an antenna is selected from search results,
         Then the selected antenna's info will auto fill in path details sheet
         AND the antenna lookup modal will close after an antenna is selected
     */
    @Test//
    public void pathDetailAntModle_shouldAutoFill_whenExistingAntennaIsFoundOnSearch() {
        createPath.createBrandNewProjectPath("Add Antenna" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("MatchOnExistAnt1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "11.0 GHz");
        pathDetail.addPathViaPathDetailBasicSetup2("MatchOnExistAnt2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.addAntennaToPath("77100A", "Tx/Rx","VHLPX2-11" , "3.4°", "34.4","VHLPX2-11", "Tx/Rx","77100A", "3.4°", "34.4");
        pathDetailAnt.clickSaveDetails();
    }

    /**COM-341 UI/UX: Antenna Lookup
     * Given a valid code is entered into the Antenna Code field,
     When 3+ characters are entered,
     Then an 'Include Revisions' checkbox will be displayed.
     Include Revisions Checkbox	Given the 'Include Revisions' checkbox is displayed,
     When it is checked,
     Then the results will include all matched radios plus any and all revisions they may have.
     */

    @Ignore// TODO COM-400 takes this functionality out for the time being
    public void pathDetailAntModal_includeRevisionsShouldAppear_when3charsAreEnteredInAntennaCode() {
        createPath.createBrandNewProjectPath("3Char" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("3Char1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("3Char2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.antennaCode3CharTriggersIncludeRevisions("023");
    }

    /**COM-341 UI/UX: Antenna Lookup
     * Given the 'Include Revisions' checkbox is displayed,
        When it is checked,
        Then the results will include all matched radios plus any and all revisions they may have.

        Given valid search parameters are entered in any of the search fields,
        When results are returned,
        Then the following columns will display results pulled from the database:
        Code, Manufacturer, Model/Family, Diameter (m/ft), Frequency MHz), Gain (dBi), Beamwidth, Pattern Date and Status.

        Given an antenna is revised,
        When it is displayed in Antenna lookup search results,
        Then an "R" will appear to the right side of the Status column,
        AND hovering the cursor over the "R" will bring up a tooltip indicating that it's a Revised Model,
        AND the tooltip will contain a link to see more recent revisions of the antenna.
     */
    @Ignore// TODO this feature is being removed COM-400
    public void pathDetailAntModal_allRevisionsShouldAppear_whenAntennaModelContainsRevisions() {
        createPath.createBrandNewProjectPath("Revision results" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Revisions1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Revisions2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.antennaCodeListsRevisions("02306A");
    }

    /**COM-340 UX/UI: Antenna Section of Path Details

     When an exact match is NOT found in the API,
     Then an error will be displayed stating that it was an invalid antenna code.
     Antenna Code - 8 characters	Given an antenna code has been entered into the Antenna Code field or the Antenna lookup,
     */
     @Test
     public void pathDetailAntenna_willError_whenThereIsNoAMatchOnAntennaCode() {
     createPath.createBrandNewProjectPath("ErrorNoAnt Match" + randomNumber, "This is the Default");
     createPath.fillOutCompanyFilter("VZW333","", "",0);
     pathSummary.changeToSi();
     pathSummary.openPathDetailForAddingPath();
     pathDetail.addPathViaPathDetailBasicSetup1("ErrNoMatch1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66","11.0 GHz");
     pathDetail.addPathViaPathDetailBasicSetup2("ErrNoMatch1", "KA20003", "40 44 54 N", "73 59 9 W", "55");
     pathDetailAnt.enterBadAntennaDataAndonBlurError("2145", "No match found for Antenna Code.","5854", "No match found for Antenna Code.");

    }

}


