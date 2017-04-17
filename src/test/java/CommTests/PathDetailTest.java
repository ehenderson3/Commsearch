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

    }
    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    @Test
    public void pathDetailValidateExistiingFieldValues() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("Validate Path from Path details" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);
        pathSummary.valSiteLocationToggleOn();
        quickAdd.quickAddPath("Ton", "5.8 GHz", "Best Path", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
        pathSummary.openPathDetails(0);
        pathDetail.viewPathDetailValue1("Tonto Mtn", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "1542.29","940 MHz");
        pathDetail.viewPathDetailValues2("New York", "KA20003", "40 44 54 N", "73 59 9 W", "0.98","940 MHz");

        pathDetail.closePathDetails();


        quickAdd.quickAddPath("SYNRA", "940 MHz", "Best Path", "40 34 10 N", "122 26 14 W", "250", "1208837");
        pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SYNRAMS STATION", "", "40 34 10 N", "122 26 14 W", "250");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");

        pathSummary.openPathDetails(1);
        pathDetail.viewPathDetailValue1("SYNRAMS STATION", "", "40 34 10 N", "122 26 14 W", "250","940 MHz");
        pathDetail.viewPathDetailValues2("Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98","940 MHz");
        pathDetail.closePathDetails();


        quickAdd.quickAddPath("CAM", "940 MHz", "Best Path", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        pathSummary.viewSiteCallSignLatLongGeColumns1(2, "CAMSLANT STATION", "", "35 12 26.7 N", "78 3 21.2 W", "48.69");
        pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "0.98");
        pathSummary.openPathDetails(2);
        pathDetail.viewPathDetailValue1("CAMSLANT STATION", "", "35 12 26.7 N", "78 3 21.2 W", "48.69","940 MHz");
        pathDetail.viewPathDetailValues2("Tonto Mtn", "KA20003", "40 44 54 N", "73 59 9 W", "48.69","940 MHz");

    }

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
    @Test
    public void addCallSignPathViaPathDetailNoDefaultCompany() {
        boolean siteExist;
        createPath.createBrandNewProjectPathNoCompany("PathDetailNoDefaultCompany" + randomNumber, "This is the Default");
        pathSummary.valSiteLocationToggleOn();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.checkSiteSuggestion("SITE1","Tonto Mtn");
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
