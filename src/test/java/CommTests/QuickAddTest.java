package CommTests;

import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ehend on 2/25/2017.
 */
public class QuickAddTest extends BaseTest {
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;


    @Before
    public void Setup() {
        quickAdd = new QuickAddPage(driver);
        pathSummary = new PathSummaryPage(driver);
    }

    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(3);

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
     */
    @Test
    public void quickAddSiteNameSuggest() {
        quickAdd.quickAddPath("ban", "940 MHz", "Best Path", "10 26 47.70 N", "45 27 07.20 W", "78.74", "V43Sf");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "Banana", "V43Sf", "10 26 47.70 N", "45 27 07.20 W", "78.74");
        pathSummary.viewSiteCallSignLatLongGeColumns2(5, "Apple", "Td5G43s", "45 26 47.70 N", "4 07 12.00 W", "9.84");

        quickAdd.quickAddPath("ki", "940 MHz", "Best Path", "60 26 47.70 N", "4 07 12.00 W", "88.58", "FT3g3s");
        pathSummary.viewSiteCallSignLatLongGeColumns1(6, "Kiwi", "FT3g3s", "60 26 47.70 N", "4 07 12.00 W", "88.58");
        pathSummary.viewSiteCallSignLatLongGeColumns2(6, "Apple", "Td5G43s", "45 26 47.70 N", "4 07 12.00 W", "9.84");

        quickAdd.quickAddPath("app", "940 MHz", "Best Path", "45 26 47.70 N", "4 07 12.00 W", "9.84", "Td5G43s");
        pathSummary.viewSiteCallSignLatLongGeColumns1(7, "Apple", "Td5G43s", "45 26 47.70 N", "4 07 12.00 W", "9.84");
        pathSummary.viewSiteCallSignLatLongGeColumns2(7, "Apple", "Td5G43s", "45 26 47.70 N", "4 07 12.00 W", "9.84");
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
        quickAdd.quickAddPath("ban", "940 MHz", "", "10 26 47.70 N", "45 27 07.20 W", "78.74", "V43Sf");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "Banana", "V43Sf", "10 26 47.70 N", "45 27 07.20 W", "78.74");
        pathSummary.viewSiteCallSignLatLongGeColumns2(5, "Apple", "Td5G43s", "45 26 47.70 N", "4 07 12.00 W", "9.84");
        pathName = pathSummary.projectNameSite1Site2Text(5);
        assertEquals(pathName, "Banana - Apple");
        quickAdd.quickAddPath("app", "940 MHz", "", "45 26 47.70 N", "4 07 12.00 W", "9.84", "Td5G43s");
        pathName = pathSummary.projectNameSite1Site2Text(6);
        assertEquals(pathName, "Apple - Apple");

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
        quickAdd.quickAddPath("ban", "940 MHz", "12345678912345678912345678912345678912345678", "10 26 47.70 N", "45 27 07.20 W", "78.74", "V43Sf");
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
        String pathError;
        quickAdd.quickAddPathNoBand("ban", "", "Path 6", "10 26 47.70 N", "45 27 07.20 W", "78.74", "V43Sf");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "Banana", "V43Sf", "10 26 47.70 N", "45 27 07.20 W", "78.74");

    }
    /*COM-100
    Given that a user wants to add a new path to a project,
    When valid entries are added into EITHER the Site 1 & Site 2 fields, OR the ASR/Call Sign field for Site 1 & Site 2,
    AND when the user clicks the ADD PATH button,
    Then a new path will be saved.
     */

    @Test
    public void quickAddInvalidChars() {
        quickAdd.quickAddPathInvalidChar();
        quickAdd.quickAddPathCallSignInvalidChar();
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
        quickAdd.callSignErrorChecking("888888888", "888888888", "ASR must be 7 numbers long.", "ASR must be 7 numbers long.");
        quickAdd.callSignErrorChecking("55555", "55555", "ASR must be 7 numbers long.", "ASR must be 7 numbers long.");
        quickAdd.quickAddPath("ban", "940 MHz", "Best Path", "10 26 47.70 N", "45 27 07.20 W", "78.74", "V43Sf");

    }

     /*TODO will wait for end point to be ready as suggested by Nemo
    Given that an ASR (Antenna Structure Registration) is 7 characters (US),
    When an ASR with 7 characters is entered,
    AND the ASR is in the database,
    Then the Latitude, Longitude and Elevation will auto-fill
    AND the Site Name will still need to be entered.
     */



     //------------------------------------------------------//
    /*COM-100
    Given that Lat/Long are optional,
    When no lat/long coordinates are set,
    Then a Path will still save as expected.
    */
    @Test
    public void quickAddWithoutLatOrLong(){
        String pathError;
        String pathError2;
        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude","4.0 GHz","SITE1","", "","98","");
        pathError = quickAdd.projectFieldError(0);
        pathError2 = quickAdd.projectFieldError(1);
        assertEquals(pathError, "Required");
        assertEquals(pathError2, "Required");
    }

    /*COM-100
    (Enrique)used http://www.sunearthtools.com/dp/tools/conversion.php find out if this is valid...do they hav a tool that they use?
        "35-30-4.683 N", "110-9-35.684 W"
        "35 30 4.683", "-110 9 35.684"
        "35.5013009N", "110.1599121W"
        "35.5013009", "-110.1599121"

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
    @Test//TODO used http://www.sunearthtools.com/dp/tools/conversion.php find out if this is valid...do they hav a tool that they use?
    public void quickAddLatOrLongFormat() {
        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35-30-4.683 N", "110-9-35.684 W", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "SITE1", "", "35 30 04.68 N", "110 09 35.68 W", "98");

        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35 30 4.683", "-110 9 35.684", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(6, "SITE1", "", "35 30 04.68 N", "110 09 35.68 W", "98");
//TODO//// FIXME: 3/2/2017 Ithink it fails because it is off screen
//        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35.5013009N", "110.1599121W", "98", "");
//        pathSummary.viewSiteCallSignLatLongGeColumns1(7, "SITE1", "", "35 30 04.68 N", "110 09 35.68 W", "98");

//        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35.5013009", "-110.1599121", "98", "");
//        pathSummary.viewSiteCallSignLatLongGeColumns1(8, "SITE1", "", "35 30 04.68 N", "110 09 35.68 W", "98");

    }

    /*COM-100
    (Enrique)Using the following format as a NON-Preferred that should convert to a preferred (using spaces instead of colons)
        GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]        35:30:4.683N 110:9:35.684W
        Would like a list of non-preferred formats that will convert, also the rules as to which of the 3 accepted formats that
        the non-preferred will predictably convert


    Given that a user enters a valid format that isn't the preferred format (DD MM SS.SS N/S, DDD MM SS.SS E/W),
    When the field is onBlurred,
    Then the value is converted to the preferred format.
     */
    @Test//TODO used http://www.sunearthtools.com/dp/tools/conversion.php find out if this is valid...do they hav a tool that they use?
    public void quickAddLatOrLongNotPerferredFormatConvertToPerferred() {
        //GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]	35:30:4.683N 110:9:35.684W
        quickAdd.quickAddPathGeneral1("Not Perferred to Convert To Perferred", "4.0 GHz", "SITE1", "76.446584", "-43.312", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "SITE1", "", "76 26 47.7 N", "43 18 43.2 W", "98");

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
        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35:30:4.683N", "110:9:35.684W", "98", "Td5G43s");


    }
    /*COM-100
    Given that the ground Elevation auto-fills,
    When the user wants to change the elevation,
    Then s/he can manually overwrite the existing number.
     */

    @Test
    public void quickAddElevationAutofillUserCanOverwrite() {
        //GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]	35:30:4.683N 110:9:35.684W
            quickAdd.quickAddPathGeneralNoSave("Elevation Autofill User Can Overwrite", "4.0 GHz", "app", "45 26 47.70 N", "4 7 12.00 W", "98", "Td5G43s");
            quickAdd.updateElevation("230");
            quickAdd.savePath();
            pathSummary.viewSiteCallSignLatLongGeColumns1(5, "Apple", "Td5G43s", "45 26 47.70 N", "4 07 12.00 W", "230");

    }

}