package CommTests;

import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
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


    @Before
    public void Setup() {
        quickAdd = new QuickAddPage(driver);
        pathSummary = new PathSummaryPage(driver);
    }

    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

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
        quickAdd.slowDown(5);

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KA95314");
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KA95347");
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KAH72");
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KAC87");

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
        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35.5013009N", "110.1599121W", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(7, "SITE1", "", "35 30 04.68 N", "110 09 35.68 W", "98");

        quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", "4.0 GHz", "SITE1", "35.5013009", "-110.1599121", "98", "");
        pathSummary.viewSiteCallSignLatLongGeColumns1(8, "SITE1", "", "35 30 04.68 N", "110 09 35.68 W", "98");

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
        String invalidFormat1;
        String invalidFormat2;
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
            quickAdd.quickAddPathGeneralNoSave("Elevation Autofill User Can Overwrite", "4.0 GHz", "app", "45 26 47.70 N", "4 7 12.00 W", "98", "Td5G43s");
            quickAdd.updateElevation("230");
            quickAdd.savePath();
            pathSummary.viewSiteCallSignLatLongGeColumns1(5, "Apple", "Td5G43s", "45 26 47.70 N", "4 07 12.00 W", "230");

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

        //GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E]	35:30:4.683N 110:9:35.684W
        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","55", "KA3982");
        pathSummary.viewSiteCallSignLatLongGeColumns1(5, "ASR-Call", "KA3982", "32 47 16.4 N", "96 47 59 W", "55");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","99", "KBM40");
        pathSummary.viewSiteCallSignLatLongGeColumns1(6, "ASR-Call", "KBM40", "38 37 28.9 N", "90 11 16.7 W", "99");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","1.2", "KBM93");
        pathSummary.viewSiteCallSignLatLongGeColumns1(7, "ASR-Call", "KBM93", "44 27 31 N", "85 42 02 W", "1.2");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","8", "KA44228");
        pathSummary.viewSiteCallSignLatLongGeColumns1(8, "ASR-Call", "KA44228", "40 39 33 N", "112 12 08 W", "8");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "KA44228");
        pathSummary.viewSiteCallSignLatLongGeColumns1(9, "ASR-Call", "KA44228", "40 39 33 N", "112 12 08 W", "4");

        quickAdd.quickAddPathGeneral2("ASR field Autofill", "4.0 GHz", "ASR-Call","", "","4", "NoFound");
        quickAdd.slowDown(2);
        FCCError1 = quickAdd.projectFieldError(1);

        assertEquals(FCCError1,"No FCC record of this Call Sign.");


    }
}