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

    @Test//https://www.screencast.com/t/tKXfSNK0CkY
    public void pathDetailSiteSearch_searchResultsShouldContainAppropriateSite_whenSearchingBySiteName() {
        boolean siteExist;
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
        pathDetail.siteSearchResults(0,"New York","KA20003","","40 44 54 N","73 59 9 W","-");

        pathDetail.closeSiteLookup();

        pathDetail.siteSearch2("SITE1","KA20003","","","","");
        pathDetail.siteSearchResults(0,"SITE1","KA20003","","40 44 54 N","73 59 9 W","-");
    }

    @Test
    public void pathDetailValidateExiFieldValues() {
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

    /**
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

    /**
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

    /**
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

    /**
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


    /**
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

}
