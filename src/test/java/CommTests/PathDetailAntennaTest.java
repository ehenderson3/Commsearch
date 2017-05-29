package CommTests;

import CommPageObjects.*;
import org.junit.Before;
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

    @Test
    public void pathDetailAntennaSearch_shouldReturnRows_whenValidSearchCriteriaIsEntered() {
        createPath.createBrandNewProjectPath("Add Antenna" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
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
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("MatchOnAntCode1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("MatchOnAntCode2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaDataAndonBlurRelatedFieldsPopulate("P8F-9", "txrx", "02306A", "3.2°", "20.3", "P8F-9", "txrx", "02306A", "3.2°", "20.3");
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

    /**COM-341 UI/UX: Antenna Lookup
     * Given a user clicks on the Antenna lookup icon,
         When valid search criteria are entered,
         AND an antenna is selected from search results,
         Then the selected antenna's info will auto fill in path details sheet
         AND the antenna lookup modal will close after an antenna is selected
     */
    @Test
    public void pathDetailAntModle_shouldAutoFill_whenExistingAntennaIsFoundOnSearch() {
        createPath.createBrandNewProjectPath("Add Antenna" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("MatchOnExistAnt1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("MatchOnExistAnt2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.addAntennaToPath("P8F-9", "txrx", "02306A", "3.2°", "20.3", "P8F-9", "txrx", "02306A", "3.2°", "20.3");
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

    @Test
    public void pathDetailAntModal_includeRevisionsShouldAppear_when3charsAreEnteredInAntennaCode() {
        createPath.createBrandNewProjectPath("Add Antenna" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
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
    @Test
    public void pathDetailAntModal_allRevisionsShouldAppear_whenAntennaModelContainsRevisions() {
        createPath.createBrandNewProjectPath("Revision results" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Revisions1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Revisions2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.antennaCodeListsRevisions("02306AX");
    }

    /**COM-340 UX/UI: Antenna Section of Path Details

     When an exact match is NOT found in the API,
     Then an error will be displayed stating that it was an invalid antenna code.
     Antenna Code - 8 characters	Given an antenna code has been entered into the Antenna Code field or the Antenna lookup,
     */
     @Test
     public void pathDetailAntenna_willError_whenThereIsNoAMatchOnAntennaCode() {
     createPath.createBrandNewProjectPath("Error No Ant Match" + randomNumber, "This is the Default");
     createPath.fillOutCompanyFilter("VZW111","", "",0);
     pathSummary.changeToSi();
     pathSummary.openPathDetailForAddingPath();
     pathDetail.addPathViaPathDetailBasicSetup1("ErrNoMatch1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66","1");
     pathDetail.addPathViaPathDetailBasicSetup2("ErrNoMatch1", "KA20003", "40 44 54 N", "73 59 9 W", "55");
     pathDetailAnt.enterBadAntennaDataAndonBlurError("2145", "No match found for Antenna Code.","5854", "No match found for Antenna Code.");

    }














}


