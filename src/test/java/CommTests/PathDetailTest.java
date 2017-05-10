package CommTests;

import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ehend on 2/25/2017.
 */
public class PathDetailTest extends BaseTest{
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;
    private PathDetailPage pathDetail;

    @Before
    public void Setup(){
        createPath = new CreateNewPathPage(driver);
        quickAdd = new QuickAddPage(driver);
        pathSummary = new PathSummaryPage(driver);
        pathDetail = new PathDetailPage(driver);
        if(host != "localhost"){
            driver.manage().window().maximize();
        }


    }
    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    /**COM-316 Site lookup (without radius)
     * "Given a user clicks the Site lookup icon in the Path Details screen
     When user enters Site Name, Call Sign, and/or ASR,
     AND clicks the search button,
     IF sites exist which match the search criteria
     AND their first character(s) match the first character(s) in the search criteria,
     Then a selection of sites will be displayed."

     "Given a selection of sites is displayed,
     When a user selects a site,
     Then the Site Name, Lat, Long, Elevation, Call Sign, ASR and Company Code fields auto-populate with information (when it exists) for that site
     AND the lookup closes."

     "Given a site is being created,
     When a user searches for an existing site via the Path Details Site lookup,
     Then all sites in LEGO segment end info (not from FCC) that match the search criteria are displayed, regardless of the company to which they are registered."

     "Given a new site is created,
     When it is created from existing site information,
     Then it will not inherit any regulatory values."
     "Given a user is searching for a Site using the site lookup,
     When multiple parameters are used for finding a Site,
     Then the Site search order is 1.Site Name; 2.ASR; 3.Call Sign.

     STEPS FOR MANUAL TESTING:
     Navigate to Path Details>Site, and click on the company lookup icon.
     Enter an existing Site's name and ASR into the search fields.
     Click the search button (magnifying glass icon).
     EXPECTED RESULTS:
     The search results will return only the matching site,
     AND the sorting caret will be visible to the right side of the Site Name results header (the results are sorted by the column by which this caret is displayed).

     Next, in Path Details>Site, enter an existing ASR and Call Sign into their respective fields (delete the Site Name if one auto fills)
     AND note down the ASR and Call Sign.
     Click on the Site Name lookup icon.
     In the lookkp modal, enter both the Call Sign and the ASR that were noted down.
     Click the search button (magnifying glass icon).
     EXPECTED RESULTS:
     The search results will return only the matching site,
     AND the sorting caret will be visible to the right side of the ASR results header."
     */

    @Test//https://www.screencast.com/t/tKXfSNK0CkY
    public void pathDetailSiteSearch_searchResultsShouldContainAppropriateSite_whenSearchingBySiteName() {
        createPath.createBrandNewProjectPath("Path Detail elev SI range test" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
        pathSummary.changeToUs();
        pathSummary.openPathDetailForAddingPath();

        pathDetail.siteSearch1("New York","","","","","");
        pathDetail.siteSearchResults(0,"New York","KA20003","","40 44 54 N","73 59 9 W","-");

        pathDetail.closeSiteLookup();

        pathDetail.siteSearch2("SITE1","KA20003","","","","");
        pathDetail.siteSearchResults(0,"SITE1","KA20003","","40 44 54 N","73 59 9 W","-");
    }

    @Test
    public void pathDetailSiteSearch_searchResultsShouldContainAppropriateSite_whenSearchingBySiteNameAndCallSign() {
        createPath.createBrandNewProjectPath("Path Detail elev SI range test" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
        pathSummary.changeToUs();
        pathSummary.openPathDetailForAddingPath();

        pathDetail.siteSearch1("New York","KA20003","","","","");
        pathDetail.siteSearchResults(0,"New  York","KA20003","","40 44 54 N","73 59 9 W","-");

        pathDetail.closeSiteLookup();

        pathDetail.siteSearch2("SITE1","KA20003","","","","");
        pathDetail.siteSearchResults(0,"SITE1","KA20003","","40 44 54 N","73 59 9 W","-");
    }

    @Test
    public void pathDetailValidateExistingFieldValues() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Validate Path from Path details" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPathSimple("Ton", "5.8 GHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "98");
        pathSummary.openPathDetails(0);
        pathDetail.viewPathDetailValue1("Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29","940 MHz");
        pathDetail.viewPathDetailValues2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "0.98","940 MHz");

        pathDetail.closePathDetails();

        quickAdd.quickAddPath("SYNRA", "940 MHz", "Best Path", "40 34 10 N", "122 26 14 W", "250", "1208837");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SYNRAMS STATION", "", "40 34 10 N", "122 26 14 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "98");

        pathSummary.openPathDetails(1);

        pathDetail.viewPathDetailValue1("SYNRAMS STATION", "", "40 34 10 N", "122 26 14 W", "250","940 MHz");
        pathDetail.viewPathDetailValues2("Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98","940 MHz");

        pathDetail.closePathDetails();

        quickAdd.quickAddPath("CAM", "940 MHz", "Best Path", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "CAMSLANT STATION", "", "35 12 26.7 N", "78 3 21.2 W", "48.69");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "98");
        pathSummary.openPathDetails(2);
        pathDetail.viewPathDetailValue1("CAMSLANT STATION", "", "35 12 26.7 N", "78 3 21.2 W", "48.69","940 MHz");
        pathDetail.viewPathDetailValues2("Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "48.69","940 MHz");

    }

    /**COM-325 Path Details Form - Elevation
     Given Unit is set to SI in Project Settings,
     When the entry in Path Details>Elevation field is <-304.495 OR >30,479.695,
     Then an error is displayed stating, "Must be between -304.495 and 30,479.695 meters."

     Given Unit is set to US in Project Settings,
     When the entry in Path Details>Elevation field is <-999 OR >99,999,
     Then an error is displayed stating, "Must be between -999 and 99,999 feet."
     */

    @Test
    public void pathDetailElevation_shouldError_whenOutsideNeg304dot495And30479dot695Meters() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Path Detail elev SI range test" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addCallSignPathViaPathDetail1("SYNRAMS STATION", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "-305.001","1");
        pathDetail.pathDetailErrors("Must be between -304.495 and 30,479.695 meters.");
        pathDetail.addCallSignPathViaPathDetail2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "30479.696");
        pathDetail.pathDetailErrors("Must be between -304.495 and 30,479.695 meters.");
        pathDetail.viewPathDetailValue1("Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "-305.001","1");
        pathDetail.viewPathDetailValues2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "30479.696","1");
        pathDetail.closePathDetails();    }

    /**
     * "Given a user is on the Path Details screen,
     When s/he views the License Basis dropdown selector,
     Then it will be defaulted to ""Primary""."


     "Given the License Basis dropdown selector is clicked,
     When the dropdown options are fully displayed,
     Then the following options will be included:
     * Primary
     * Secondary"
     */

    @Test
    public void pathDetailLicBasis_shouldDisplayLicOptions_whenSelectingLicDropdown() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Path Detail Lic Basis" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addCallSignPathViaPathDetail1("SYNRAMS STATION", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "-200.012","1");
        pathDetail.licSelection1("1","Secondary");
        pathDetail.licSelection2("1","Secondary");
        pathDetail.addCallSignPathViaPathDetail2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "21000.124");
        pathDetail.saveDetails();
         }

    @Test
    public void pathDetailRadioService_shouldSaveRecord_whenSelectingRadioEntries() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Path Detail Radio Service" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addCallSignPathViaPathDetail1("SYNRAMS STATION", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "-200.012","1");
        pathDetail.licSelection1("1","Secondary");
        pathDetail.licSelection2("1","Secondary");
        pathDetail.radioService1("5","AB—Aural Microwave Booster");
        pathDetail.radioService2("5","MW—Microwave Public Safety Pool");
        pathDetail.addCallSignPathViaPathDetail2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "21000.124");
        pathDetail.saveDetails();
    }

    /**COM-318 Support Regulatory Fields
     * "Given a user is on the Path Details screen in a new path,
     When s/he views the License Basis dropdown selector,
     Then it will be defaulted to ""Primary""."
     "Given the License Basis dropdown selector is clicked,
     When the dropdown options are fully displayed,
     Then the following options will be included:
     * Primary
     * Secondary"
     "Given a user is on the Path Details screen,
     When s/he views the Radio Service dropdown selector,
     Then it will be defaulted to ""CF-Common Carrier Fixed Point to Point Microwave""."
     "Given the Radio Service dropdown is clicked by a user,
     When site fields are being populated (e.g. from site API),
     Then the following options will be included:
     * User sets Radio Service (Defaults to CF) which will be added to the segment ends - Field is defined by the FCC and is mandatory for Licensing.
     * AB—Aural Microwave Booster
     * AI—Aural Intercity Relay
     * AS—Aural Studio Transmitter Link
     * CARS—Cable Antenna Relay System
     * CF—Common Carrier Fixed Point to Point Microwave
     * CT—Local Television Transmission
     * MG—Microwave Industrial/Business Pool
     * MW—Microwave Public Safety Pool
     * PW—Public Safety Pool, Conventional
     * TB—TV Microwave Booster
     * TI—TV Intercity Relay
     * TP—TV Pickup
     * TS—TV Studio Transmitter Link
     * TT—TV Translator Relay
     * WA— Microwave Aviation
     * WM— Microwave Marine
     * WR— Microwave Radiolocation
     * None
     "
     "Given Site section fields are being filled in,
     When they are populated using existing Site data,
     Then Radio Service data will not transfer to the Radio Service field. "
     "Given a user is on the Path Details screen,
     When s/he views the License Basis dropdown selector,
     Then it will be defaulted to ""FXO Fixed""."
     "Given the Station Class dropdown is clicked by a user,
     When site fields are being populated (e.g. from site API),
     Then the following options will be included:
     * FX5 Temporary Fixed
     * FXO Fixed
     * MO Mobile
     * MO5 Mobile and Temporary Fixed"
     */
    @Test
    public void pathDetailRadioService_shouldSaveRecord_whenSelectingEachRadioOption() {
        boolean siteExist;
        String[] array = {"AB—Aural Microwave Booster",
                "AI—Aural Intercity Relay",
                "AS—Aural Studio Transmitter Link",
                "CARS—Cable Antenna Relay System",
                "CF—Common Carrier Fixed Point to Point Microwave",
                "CT—Local Television Transmission",
                "MG—Microwave Industrial/Business Pool",
                "MW—Microwave Public Safety Pool",
                "PW—Public Safety Pool, Conventional",
                "TB—TV Microwave Booster",
                "TI—TV Intercity Relay",
                "TP—TV Pickup","TS—TV Studio Transmitter Link",
                "TT—TV Translator Relay"};

        createPath.createBrandNewProjectPath("Path Detail Radio Service" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111", "", "", 0);
        pathSummary.valSiteLocationToggleOn();

        pathSummary.changeToSi();
        for (String value : array) {
            pathSummary.openPathDetailForAddingPath();
            pathDetail.addCallSignPathViaPathDetail1("Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "-200.012", "1");
            pathDetail.licSelection1("1", "Secondary");
            pathDetail.licSelection2("1", "Secondary");
            pathDetail.radioServiceLoop1(value);
            pathDetail.radioServiceLoop2(value);
            pathDetail.addCallSignPathViaPathDetail2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "21000.124");
            pathDetail.saveDetails();
        }

    }

    /**COM-325 Path Details Form - Elevation
     * "Given Unit is set to US in Project Settings,
     When the entry in Path Details>Elevation field is <-999 OR >99,999,
     Then an error is displayed stating, ""Must be between -999 and 99,999 feet."""
     */

    @Test
    public void pathDetailElevation_shouldError_whenOutsideNeg999And99999Feet() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Path Detail elev US range test"  + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.changeToUs();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addCallSignPathViaPathDetail1("SYNRAMS STATION", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "-1000","1");
        pathDetail.pathDetailErrors("Must be between -999 and 99,999 feet.");
        pathDetail.addCallSignPathViaPathDetail2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "100000");
        pathDetail.pathDetailErrors("Must be between -999 and 99,999 feet.");
        pathDetail.closePathDetails();    }

    /**COM-276 Path Details - Site section UI
     * Given a Site option is displayed,
     When user clicks on a Site to select it,
     Then the fields Lat, Long, Gr. Elev and Company (if available) will auto-populate with the Site's information,
     AND the Site field will auto-populate with the completed value that the user started to type,
     AND the Call Sign field will be auto populated with the site's Call Sign if one is associated with this site.

     Given there is existing Site data in a Path,
     When user enters the Path Details page for that Path,
     Then the Site section will auto populate with pre-existing data.

     Given there is existing Site data in a Path,
     When user enters the Path Details page for that Path,
     Then the Site section will auto populate with pre-existing data.
     */

    @Test
    public void addArsPathViaPathDetail() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Best Project Ever" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();

        pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", "1241006", "35 12 26.7 N", "78 3 21.2 W", "48.7","1");
        createPath.fillOutCompanyFilterFromDetails("VZW111","", "",0);

        pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "1208837", "40 34 10 N", "122 26 14 W", "250");
        createPath.fillOutCompanyFilterFromDetails("VZW111","", "",1);
    }

    @Test
    public void addCallSignPathViaPathDetail() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Best Project Ever" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();

        pathDetail.addCallSignPathViaPathDetail1("SITE1", "KA20003", "40 44 54 N", "73 59 9 W", "98","1");
        createPath.fillOutCompanyFilterFromDetails("VZW111","", "",0);

        pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.3");
        createPath.fillOutCompanyFilterFromDetails("VZW111","", "",1);
    }

    /**COM-276 Path Details - Site section UI
     "Given no default company is assigned to a project,
     AND a new site is created that has no associated company,
     Then the new site will not have a company associated with it. "
     */
    //TODO Flaky test 277 No FILTER FIELD
    @Test
    public void addCallSignPathViaPathDetailNoDefaultCompany() {
        boolean siteExist;
        createPath.createBrandNewProjectPathNoCompany("PathDetailNoDefaultCompany" + randomNumber, "This is the Default");
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.checkSiteSuggestion("SITE1","Tonto Mtn");
        pathDetail.closeDetailsOpenQuickAdd();
        pathSummary.checkSiteSuggestionQuickAdd("SITE1","Tonto Mtn");
    }

    /**COM-276 Path Details - Site section UI
     "Given a default company is assigned to a project,
     When a user is searching for a site in the Site section of the Path Details screen,
     Then Site auto suggest will only populate sites that are associated with the project's default company."

     Given a user is searching for a site in the Site section of the Path Details screen,
     When the user begins typing a valid site name,
     AND after the 1st character is typed,
     Then the browser will fetch for all sites which contain the input's value in their Site Name,
     AND they will display beneath the input field.

     Given the browser is displaying all fetched site names,
     When the user hovers on a site name,
     Then available site information (e.g. lat, long, G.E., ASR) will display on the side.

     Given that a Call Sign is a maximum of 8 characters,
     When a Call Sign with up to 8 characters is entered,
     AND the Call Sign is in the database,
     Then the Site Name, Latitude, Longitude, Elevation and (if there is an associated) Company, will auto-fill.
     */

    @Test
    public void addCallSignPathViaPathDetailWithDefaultCompany() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("PathDetailWithDefaultCompany" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.checkSiteSuggestionTrue("SITE1","Tonto Mtn");
    }


    /**COM-276 Path Details - Site section UI
     * Given that a Site Name can be a maximum of 20 characters,
     When a Site Name has 21+ characters,
     Then a graceful error will be displayed.
     */

    @Test
    public void siteWith21characters() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("PathDetailWithDefaultCompany" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.checkSiteSuggestion("The Site has more than 21 char","The Site has more than 21 char");
        pathDetail.pathDetailErrors("SITE NAME CANNOT BE LONGER THAN 20 CHARACTERS.");
    }

    /**COM-276 Path Details - Site section UI
     * Given that a Call Sign is 8 characters,
     When >8 characters is entered,
     Then a graceful error message will be displayed.
     */

    @Test
    public void CallSignWith9characters() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("PathDetailWithDefaultCompany" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.checkCallSignEntry("455654655","546546546546");
        pathDetail.pathDetailErrors("CALL SIGN IS A MAXIMUM OF 8 CHARACTERS.");
    }
    //COM-335 Create UI pieces for Path Detail's Antenna section
    /**
     * "Given a user is on the Path Details screen,
     When s/he views the Antenna section,
     The the base components for Antenna will be displayed, including the following fields:
     Antenna Model, Centerline, Antenna Code, Gain, Mode (dropdown selector), and label for Beamwidth Manufacturer, and Tilt"

     "Given a user is viewing the Path Details Antenna section,
     When the Diversity Antenna icon is clicked,
     Then the following felds will be displayed:
     Antenna Model, Centerline, Antenna Code, Gain, Mode (dropdown selector), and label for Beamwidth and Manufacturer."
     */

    @Test
    public void pathDetail_whenOpening_ShouldSeeAntennaFields() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Best Project Ever" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();

        pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", "1241006", "35 12 26.7 N", "78 3 21.2 W", "48.7","1");
        createPath.fillOutCompanyFilterFromDetails("VZW111","", "",0);

        pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "1208837", "40 34 10 N", "122 26 14 W", "250");
        createPath.fillOutCompanyFilterFromDetails("VZW111","", "",1);

        pathDetail.antennaFieldValidation();
    }



}
