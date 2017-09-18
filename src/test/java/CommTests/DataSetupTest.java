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

 public class DataSetupTest extends BaseTest {
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;
    private PathDetailPage pathDetail;


    @Before
    public void Setup() {
        if(host != "localhost"){
            driver.manage().window().maximize();
        }
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
        createPath.fillOutCompanyFilter("VZW333","", "",0);

        pathSummary.valSiteLocationToggleOn();


        siteExist = quickAdd.checkForExistingSite("New York2");
        if (siteExist == true){quickAdd.cancelPathCreation();
        } else {
            quickAdd.cancelPathCreation();
            quickAdd.quickAddInitPathDataSetup1("Not York", "940 MHz", "NY SUPPORT DATA", "40 44 44 N", "73 59 5 W", "0.98", "KA20003");
            quickAdd.quickAddInitPathDataSetup2("New York2", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");}

        siteExist = quickAdd.checkForExistingSite("SITE1");
        if (siteExist == true){quickAdd.cancelPathCreation();
        } else {
            //quickAdd.quickAddPathDataSetup("SITE1 SUPPORT DATA", "4.0 GHz", "SITE1", "35-30-4.683 N", "110-9-35.684 W", "98", "KA20003");
            quickAdd.cancelPathCreation();
            quickAdd.quickAddInitPathDataSetup1("SITE1", "4.0 GHz", "SITE1 SUPPORT DATA", "35 30 4.68 N", "110 9 35.68 W", "98", "KA20003");
            quickAdd.quickAddInitPathDataSetup2("New York2", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");
        }

        siteExist = quickAdd.checkForExistingSite("Tonto Mtn");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();
        } else {
            //quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", "940 MHz", "Tonto Mtn", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
            quickAdd.cancelPathCreation();
            quickAdd.quickAddInitPathDataSetup1("Tonto Mtn", "940 MHz", "TM SUPPORT DATA", "34 37 42.1 N", "112 39 26.2 W", "1542.29", "KBY45");
            quickAdd.quickAddInitPathDataSetup2("New York2", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");
        }
        siteExist = quickAdd.checkForExistingSite("SYNRAMS STATION");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();
        } else {
            //quickAdd.quickAddPathDataSetup("SS SUPPORT DATA", "940 MHz", "SYNRAMS STATION", "40 34 10 N", "122 26 14 W", "250", "1208837");
            quickAdd.cancelPathCreation();
            quickAdd.quickAddInitPathDataSetup1("SYNRAMS STATION", "940 MHz", "SS SUPPORT DATA", "40 34 10 N", "122 26 14 W", "250", "1208837");
            quickAdd.quickAddInitPathDataSetup2("New York2", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");
        }
        siteExist = quickAdd.checkForExistingSite("CAMSLANT STATION");
        if (siteExist == true) {
            quickAdd.cancelPathCreation();
        } else {
            //quickAdd.quickAddPathDataSetup("CAM SUPPORT DATA", "940 MHz", "CAMSLANT STATION", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
            quickAdd.cancelPathCreation();
            quickAdd.quickAddInitPathDataSetup1("CAMSLANT STATION", "940 MHz", "CAM SUPPORT DATA", "35 12 26.7 N", "78 3 21.2 W", "48.69", "1241006");
            quickAdd.quickAddInitPathDataSetup2("New York2", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");
        }
        siteExist = quickAdd.checkForExistingSite("New Yor");
        if (siteExist == true){quickAdd.cancelPathCreation();
        } else {
            quickAdd.quickAddPathDataSetup("NY SUPPORT DATA", "940 MHz", "New York", "40 44 54 N", "73 59 9 W", "0.98", "KA20003");}

    }

 }
