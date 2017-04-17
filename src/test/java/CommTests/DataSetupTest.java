package CommTests;

import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ehend on 2/25/2017.
 */

 public class DataSetupTest extends BaseTest {
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;


    @Before
    public void Setup() {
       quickAdd = new QuickAddPage(driver);
       pathSummary = new PathSummaryPage(driver);
       createPath = new CreateNewPathPage(driver);

        }

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    Random rndNum = new Random();
    int randomNumber = rndNum.nextInt(100000);
    @Test
    public void dataAddTest() {
        boolean siteExist;
        createPath.createBrandNewProjectPath("DATA SETUP" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW111","", "",0);

        pathSummary.valSiteLocationToggleOn();


        siteExist = quickAdd.checkForExistingSite("SITE1");
        if (siteExist == true){quickAdd.cancelPathCreation();
        } else {
            quickAdd.quickAddPathDataSetup("SITE1 SUPPORT DATA", "4.0 GHz", "SITE1", "35-30-4.683 N", "110-9-35.684 W", "98", "KA20003");
        }
        siteExist = quickAdd.checkForExistingSite("Tonto Mtn");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();
        } else {
            quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "Tonto Mtn", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
        }
        siteExist = quickAdd.checkForExistingSite("SYNRAMS STATION");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();
        } else {
            quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "SYNRAMS STATION", "40 34 10 N", "122 26 14 W", "250", "1208837");
        }
        siteExist = quickAdd.checkForExistingSite("CAMSLANT STATION");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();
        } else {
            quickAdd.quickAddPathDataSetup("CAM SUPPORT DATA", "940 MHz", "CAMSLANT STATION", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
        }
        siteExist = quickAdd.checkForExistingSite("New Yor");
        if (siteExist == true){quickAdd.cancelPathCreation();
        } else {
            quickAdd.quickAddPathDataSetup("NY SUPPORT DATA", "940 MHz", "New York", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");}

    }



 }
