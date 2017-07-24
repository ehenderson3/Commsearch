package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PathDetailAntennaPage extends BasePage {


    //Headings

    //Buttons
    By antennaModelSearch1 = By.id("path-details-antenna-0-0-lookup-trigger");
    By antennaModelSearch2 = By.id("path-details-antenna-1-0-lookup-trigger");
    By lookUpSearchButton = By.id("antenna-lookup-submit");
    By saveDetailsButton = By.id("path-details-footer-save-path-button");
    By antennaClearX = By.cssSelector(".fa.fa-spinner.fa-pulse.fa-fw");
    By antennaClearX2 = By.className("clear-input-button");
    By antennaClearX3 = By.className("pointer");
    By antennaClearX4 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[3]/div/div[1]/div[1]/ul/li[4]/div/div/span");
    //Path DropDown Fields -- Does it contain a list that has options that can be selected

    //Drop down options

    //Path Entry Fields - Able to use the type method
    By antennaModel1 = By.id("path-details-site-0-0-antenna-model");
    By antennaModel1B = By.id("path-details-antennas-0-0-antenna-model");



    By lookUpAntennaModel = By.id("antenna-lookup-antenna-model");
    By pathDetail = By.id("antenna-lookup-antenna-model");
    By centerlineField = By.id("path-details-antennas-0-0-centerline");
    By antennaModelField = By.id("path-details-antennas-0-0-antenna-model");
    By modeField = By.id("path-details-antennas-0-0-mode");
    By antennaCodeField = By.id("path-details-antennas-0-0-antenna-code");
    By beamwithField = By.id("path-details-antennas-0-0-beamwidth");
    By gainField = By.id("path-details-antennas-0-0-gain");

    By antennaModel2 = By.id("path-details-antennas-1-0-antenna-model");
    By centerlineField2 = By.id("path-details-antennas-1-0-centerline");
    By antennaModelField2 = By.id("path-details-antennas-1-0-antenna-model");
    By modeField2 = By.id("path-details-antennas-1-0-mode");
    By antennaCodeField2 = By.id("path-details-antennas-1-0-antenna-code");
    By beamwithField2 = By.id("path-details-antennas-1-0-beamwidth");
    By gainField2 = By.id("path-details-antennas-1-0-gain");

    By antennaModelForTextField = By.name("antennas[0][0]modelNumber");
    By includeRevisionsCheckBox = By.id("antenna-lookup-include-revisions-include");
    By lookUpAntennaCode = By.id("antenna-lookup-antenna-code");

    //Path hovers -- Able to use the hover method
    By revisionIcon = By.className("revisions-icon");
    By revisionIconText = By.cssSelector(".text-blue.center-text");

    //Path Data Fields - Element is read only and can use getFieldText method
    By antResultListEven = By.cssSelector(".react-grid-Row.react-grid-Row--even");
    By antResultListOdd = By.cssSelector(".react-grid-Row.react-grid-Row--even");
    By antResultListItem = By.xpath("//*[contains(@id, 'antenna-lookup-modal-table-data-antennaCode-') and contains(@id, 'antenna-lookup-modal-table-data-antennaCode-')]");
    By antCodeErrorText = By.id("path-details-antennas-0-0-antenna-code-error-message");
    By antCodeErrorText2 = By.id("path-details-antennas-1-0-antenna-code-error-message");
    By tempAntennaCodeArray = By.xpath("//*[@id=\"antenna-lookup-modal\"]/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/div/span/div");

//

    //Index List -- Can you used an array to select item

    //Modal -- Does it pop up over current window


    public PathDetailAntennaPage(WebDriver driver) {
        super(driver);
        visit("/");
    }

    public void enterAntennaCodeAndBlur(String antCode, String antCenterLine){
        //enter antenna code
        assertTrue(isDisplayed(antennaCodeField,8));
        type(antCode, antennaCodeField);
        //click a field other than antenna
        assertTrue(isDisplayed(gainField,8));
        click(gainField);
        //validate that the autopopulate fields
        waitForFieldToBeNotNull(gainField);
        //enter the centerline
        type(antCenterLine, centerlineField);
        //enter antenna code
        assertTrue(isDisplayed(antennaCodeField,8));
        type(antCode, antennaCodeField2);
        //click a field other than antenna
        assertTrue(isDisplayed(gainField2,8));
        click(gainField2);
        //validate that the autopopulate fields
        isDisplayed(gainField2,10);
        //enter the centerline
        type(antCenterLine, centerlineField2);
    }


    public void antennaLookUpFromPassiveRepeater(String codeText){
        isDisplayed(lookUpAntennaCode,10);
        type(codeText,lookUpAntennaCode);
        isDisplayed(lookUpSearchButton,10);
        click(lookUpSearchButton);
        isDisplayed(antResultListItem,8);
        clickJS(antResultListItem);
    }


    public void addAntennaToPath(String luAntMod, String mode, String antCode, String beamwith, String gain,String luAntMod2,String mode2, String antCode2, String beamwith2, String gain2){
        //Verify that the Antenna Model field is present (that tells us that we are on the Antenna module)
        isDisplayed(antennaModel1,30);

        //******************LEFT ANTENNA*************************************************

        // Click the antenna model 1 search button
        clickJS(antennaModelSearch1);

        //Verify that the Antenna Lookup pop up appears (We will use the Antenna Model field)
      assertTrue(isDisplayed(lookUpAntennaModel,6));

        //type P8F-9 in the Antenna Model field
        type(luAntMod,lookUpAntennaModel);

        //Click the search button
        click(lookUpSearchButton);

        //Verify that there is at least one search result
        isDisplayed(antResultListItem,8);

        //Click on the first row
        clickJS(antResultListItem);

        //Verify that we have returned to the Path Detail page
        isDisplayed(pathDetail,8);

        //Validate that the values are correct for Antenna Model, Mode, Antenna code, Beamwith and Gain
        String antennaModelFieldText;
        String modeFieldText;
        String antennaCodeFieldText;
        String beamwithFieldText;
        String gainFieldText;

        antennaModelFieldText = getFieldText(antennaModelField);
        modeFieldText = getFieldText(modeField,"value");
        antennaCodeFieldText = getFieldText(antennaCodeField);
        beamwithFieldText = getFieldText(beamwithField);
        gainFieldText = getFieldText(gainField);

        assertEquals(antennaModelFieldText,luAntMod);
        assertEquals(modeFieldText, mode);
        assertEquals(antennaCodeFieldText, antCode);
        assertEquals(beamwithFieldText, beamwith);
        assertEquals(gainFieldText, gain);

        //Enter a valid value in the Centerline field
        type("10",centerlineField);

        // *************RIGHT ANTENNA**********************************************
        // Click the antenna model 1 search button
        click(antennaModelSearch2);

        //Verify that the Antenna Lookup pop up appears (We will use the Antenna Model field)
        assertTrue(isDisplayed(lookUpAntennaModel,6));

        //type P8F-9 in the Antenna Model field
        type("P8F-9",lookUpAntennaModel);

        //Click the search button
        click(lookUpSearchButton);

        //Verify that there is at least one search result
        isDisplayed(antResultListItem,8);

        //Click on the first row
        click(antResultListItem);

        //Verify that we have returned to the Path Detail page
        isDisplayed(centerlineField2);

        //Validate that the values are correct for Antenna Model, Mode, Antenna code, Beamwith and Gain
        String antennaModelFieldText2;
        String modeFieldText2;
        String antennaCodeFieldText2;
        String beamwithFieldText2;
        String gainFieldText2;

        antennaModelFieldText2 = getFieldText(antennaModelField2);
        modeFieldText2 = getFieldText(modeField2);
        antennaCodeFieldText2 = getFieldText(antennaCodeField2);
        beamwithFieldText2 = getFieldText(beamwithField2);
        gainFieldText2 = getFieldText(gainField2);

        assertEquals(antennaModelFieldText2,luAntMod2);
        assertEquals(modeFieldText2, mode2);
        assertEquals(antennaCodeFieldText2, antCode2);
        assertEquals(beamwithFieldText2, beamwith2);
        assertEquals(gainFieldText2, gain2);

        //Enter a valid value in the Centerline field
        type("10",centerlineField2);
        //Select Save button
        isDisplayed(saveDetailsButton,8);

    }

    public void enterAntennaDataAndonBlurRelatedFieldsPopulate(String luAntMod, String mode, String antCode, String beamwith, String gain,String luAntMod2,String mode2, String antCode2, String beamwith2, String gain2){
        //enter valid or invalid Antenna Code
        type(antCode,antennaCodeField);

        //re-focus to field other than Antenna Code
        isDisplayed(gainField,20);
        click(gainField);
        waitForFieldToBeNotNull(gainField);

        //validate the related values populate
        String antennaModelFieldText;
        String modeFieldText;
        String antennaCodeFieldText;
        String beamwidthFieldText;
        String gainFieldText;

        antennaModelFieldText = getFieldText(antennaModelForTextField);
        modeFieldText = getFieldText(modeField);
        antennaCodeFieldText = getFieldText(antennaCodeField);
        beamwidthFieldText = getFieldText(beamwithField);
        gainFieldText = getFieldText(gainField);

        assertEquals(antennaModelFieldText,luAntMod);
        assertEquals(modeFieldText, mode);
        assertEquals(antennaCodeFieldText, antCode);
        assertEquals(beamwidthFieldText, beamwith);
        assertEquals(gainFieldText, gain);
        //enter valid or invalid Antenna Code
        type(antCode,antennaCodeField2);
        //re-focus to field other than Antenna Code
        click(gainField2);
        waitForFieldToBeNotNull(gainField2);
        //validate the related values populate
        String antennaModelFieldText2;
        String modeFieldText2;
        String antennaCodeFieldText2;
        String beamwithFieldText2;
        String gainFieldText2;

        antennaModelFieldText2 = getFieldText(antennaModelField2);
        modeFieldText2 = getFieldText(modeField2);
        antennaCodeFieldText2 = getFieldText(antennaCodeField2);
        beamwithFieldText2 = getFieldText(beamwithField2);
        gainFieldText2 = getFieldText(gainField2);

        assertEquals(antennaModelFieldText2,luAntMod2);
        assertEquals(modeFieldText2, mode2);
        assertEquals(antennaCodeFieldText2, antCode2);
        assertEquals(beamwithFieldText2, beamwith2);
        assertEquals(gainFieldText2, gain2);
    };

    public void enterBadAntennaDataAndonBlurError(String badCode1, String antError1, String badCode2, String antError2){
        //flow control a field on Antenna panel
        isDisplayed(antennaModel1,6);
        //enter an invalid Antenna Code 1
        type(badCode1, antennaCodeField);
        //focus on another field
        click(gainField);
        //validate that there is an error in place
        isDisplayed(antCodeErrorText,12);
        String antCodeError = getText(antCodeErrorText);
        assertEquals(antCodeError, antError1);
        //enter an invalid Antenna Code 2
        type(badCode2, antennaCodeField2);
        //focus on another field
        click(gainField2);
        //validate error2
        assertTrue("Error did not appear after 3 seconds pleas increase time",isDisplayed(antCodeErrorText2,3));
        String antCodeError2 = getText(antCodeErrorText2);
        assertEquals(antCodeError2, antError2);

    }

    public void clearAntennaField(){
        assertTrue("Can't see the antenna X",isDisplayed(antennaClearX2,30));
        slowDown(2);
        click(antennaClearX);
        waitForText(null,antennaModel1);
    }

    public void antennaCode3CharTriggersIncludeRevisions(String antennaCodeText){
        //Verify that the Antenna Model field is present (that tells us that we are on the Antenna module)
        isDisplayed(antennaModel1,8);
        // Click the antenna model 1 search button
        isDisplayed(antennaModelSearch1,8);
        click(antennaModelSearch1);
        //Verify that the Antenna Lookup pop up appears (We will use the Antenna Model field)
        assertTrue(isDisplayed(lookUpAntennaModel,6));
        //check that Include Revisions check box is not present
        assertFalse(isDisplayed(includeRevisionsCheckBox,8));
        //Type 3 chars
        type(antennaCodeText, lookUpAntennaCode);
        //Validate that the check box appears
        assertTrue(isDisplayed(includeRevisionsCheckBox,8));

    }

    public void antennaCodeListsRevisions(String antennaCodeText){
        //Verify that the Antenna Model field is present (that tells us that we are on the Antenna module)
        isDisplayed(antennaModel1,10);
        //Click the antenna model 1 search button
        clickJS(antennaModelSearch1);
        //Verify that the Antenna Lookup pop up appears (We will use the Antenna Model field)
        assertTrue(isDisplayed(lookUpAntennaModel,6));
        //check that Include Revisions check box is not present
        assertFalse(isDisplayed(includeRevisionsCheckBox,8));
        //Type valid Antenna Code
        type(antennaCodeText, lookUpAntennaCode);
        //Validate that the check box appears
        assertTrue(isDisplayed(includeRevisionsCheckBox,8));
        //Click the search button
        click(lookUpSearchButton);
        //Validate results
        //TODO add id's to antenna lookup headings
        isDisplayed(antResultListEven,8);
        isDisplayed(revisionIcon,8);
        //Place a check in the Include Revisions
        click(includeRevisionsCheckBox);
        //Click the search button
        click(lookUpSearchButton);
        slowDown(3);
        //Validate that the revision for the given code appears
        assertTrue(isDisplayed(antResultListEven,8));
        assertTrue(isDisplayed(antResultListOdd,8));
        assertTrue(isDisplayed(tempAntennaCodeArray,8));
        String list = getText(tempAntennaCodeArray);
        assertEquals(list,"02306A");
    }

    public void clickSaveDetails(){
        isDisplayed(saveDetailsButton,8);
        click(saveDetailsButton);

    }


}
