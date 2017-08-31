package CommTests;


import CommPageObjects.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by ehend on 2/25/2017.
 */
public class A_TestTemplate extends BaseTest{
    private PathDetailAntennaPage pathDetailAnt;
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;
    private PathDetailPage pathDetail;
    private RadioPage pathDetailRadio;


    @Before
    public void Setup() {
        pathDetailAnt = new PathDetailAntennaPage(driver);
        quickAdd = new QuickAddPage(driver);
        pathSummary = new PathSummaryPage(driver);
        createPath = new CreateNewPathPage(driver);
        pathDetail = new PathDetailPage(driver);
        pathDetailRadio = new RadioPage(driver);

    }
        Random rndNum = new Random();
        int randomNumber = rndNum.nextInt(100000);



    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    /**

     */
    @Test
    public void pathDetailRadio_shouldCreateRadio_whenEnteringValidRadioData() {
        createPath.createBrandNewProjectPath("Add Radio" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW333", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66",  "11.0 GHz");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("77100A", "12");

    }


}


