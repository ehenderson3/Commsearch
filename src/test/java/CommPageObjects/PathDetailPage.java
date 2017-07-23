package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PathDetailPage extends BasePage {


    //Headings
    By pIcon = By.id("path-details-passive-repeater-tooltip-trigger");

    //Buttons
    By pathDetailNewButton = By.id("path-details-path-new-mod-icon");
    By pathDetailSaveDetailsButton = By.cssSelector(".heading-font.btn.btn-md.hover-inverse.bg-green");
    By pathDetailDiscardButton = By.id("path-details-discard-button");
    By quickAdd = By.id("project-summary-quick-add-open");
    By siteLookUpSearchButtonModal = By.id("site-lookup-submit");
    By siteSearchLookUpButton1 = By.id("path-details-site-0-lookup-trigger");
    By siteSearchLookUpButton2 = By.id("path-details-site-1-lookup-trigger");
    By closeSiteLookUpMotal = By.id("site-lookup-modal-heading-close");

    By addDiversity = By.cssSelector(".fa.fa-plus-circle");
    By pathDetailAsrSearch1 = By.id("path-details-asr-0-lookup-trigger");
    By asrLookUpSearchButton = By.id("asr-lookup-submit");
    By pathDetailAsrSearch2 = By.id("path-details-asr-1-lookup-trigger");
    By pathDetailCopyButton = By.id("path-details-footer-copy-path-button");
    By pathDetailFlipButton = By.cssSelector(".heading-font.btn.btn-md.hover-inverse.bg-blue.margin-left-1");
    By leaveWithoutSavingConfirmButton = By.cssSelector(".bg-blue.btn.btn-md.hover-inverse.margin-left-1.margin-right-1.heading-font");
    By activePathDetailNextArrowButton = By.id("path-details-footer-next-path-button");
    By passiveRepeaterTrigger = By.id("path-details-passive-repeater-trigger");

    By passiveRepeaterSiteSearchButton = By.id("path-details-passive-site-0-lookup-trigger");
    By passiveRepeaterRemoveButton = By.id("path-details-passive-repeaters-0-remove");
    By passiveRepeaterSaveButton = By.id("path-details-passive-repeater-save");
    By passiveRepeaterAddPassiveRepeaterTrigger = By.id("path-details-passive-repeater-add-repeater");
    By passiveRepeaterAntennaModelSearchButton = By.id("path-details-passive-repeaters-0-antennas-0-antenna-lookup-trigger");
    By passiveRepeaterAntennaModelSearchButtonPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-antenna-lookup-trigger')]");
    By activePathDetailPreviousArrowButton = By.id("path-details-footer-previous-path-button");


    //DropDown Fields -- Does it contain a list that has options that can be selected
    By pathDetailRadioServiceDropDownField1 = By.id("path-details-site-0-radio-service");
    By pathDetailStationClassDropDownField1 = By.id("path-details-site-0-station-class");
    By pathDetailLicenseBasisDropDownField1 = By.id("path-details-site-0-license-basis");
    By pathDetailFrequencyBandDropDownField1 = By.id("path-details-band");


    By pathDetailRadioServiceDropDownField2 = By.id("path-details-site-1-radio-service");
    By pathDetailStationClassDropDownField2 = By.id("path-details-site-1-station-class");
    By pathDetailLicenseBasisDropDownField2 = By.id("path-details-site-1-license-basis");

    By licBasis1 = By.id("path-details-site-0-license-basis");
    By licBasis2 = By.id("path-details-site-1-license-basis");

    By overLay = By.cssSelector(".ReactModal__Overlay.ReactModal__Overlay--after-open");


    //Drop down options

    //Entry Fields - Able to use the type method
    By pathDetailSiteNameField1 = By.id("path-details-site[0]siteName");
    By pathDetailLatitudeField1 = By.id("path-details-site-0-latitude");
    By pathDetailLongitudeField1 = By.id("path-details-site-0-longitude");
    By pathDetailGroundElevationField1 = By.id("path-details-site-0-elevation");
    By pathDetailCompanyNameField1 = By.id("path-details-site-0-company-name");
    By pathDetailCallSignField1 = By.id("path-details-site-0-callSign");
    By pathDetailAsrField1 = By.id("path-details-site-0-asr");


    By pathDetailSiteNameField2 = By.id("path-details-site[1]siteName");
    By pathDetailLatitudeField2 = By.id("path-details-site-1-latitude");
    By pathDetailLongitudeField2 = By.id("path-details-site-1-longitude");
    By pathDetailGroundElevationField2 = By.id("path-details-site-1-elevation");
    By pathDetailCompanyNameField2 = By.id("path-details-site-1-company-name");
    By pathDetailCallSignField2 = By.id("path-details-site-1-callSign");
    By pathDetailAsrField2 = By.id("path-details-site-1-asr");
    By pathDetailSuggested1 = By.className("react-autosuggest__suggestion");
    By error = By.className("error-message");
    By pathDetailSuccessfulCopyMessage = By.className("path-details-footer-modal");

    By pathDetailSiteLookUpSiteName = By.id("site-lookup-site-name");
    By pathDetailSiteLookUpCallSign = By.id("site-lookup-call-sign");
    By pathDetailSiteLookUpAsr = By.id("site-lookup-asr");
    By pathDetailSiteLookUpLatitude = By.id("path-details-site-0-latitude");
    By pathDetailSiteLookUpLongitude = By.id("site-lookup-longitude");
    By pathDetailSiteLookUpRadius = By.id("site-lookup-radius");

    By antennaModel_1  = By.xpath("//*[contains(@id, 'path-details-antennas-0-') and contains(@id, '-antenna-model')]");
    By antennaCenterline_1  = By.xpath("//*[contains(@id, 'path-details-antennas-0-') and contains(@id, '-centerline')]");
    By antennaMode_1  = By.xpath("//*[contains(@id, 'path-details-antennas-0-') and contains(@id, '-mode')]");
    By antennaCode_1  = By.xpath("//*[contains(@id, 'path-details-antennas-0-') and contains(@id, '-antenna-code')]");
    By antennaGain_1  = By.xpath("//*[contains(@id, 'path-details-antennas-0-') and contains(@id, '-gain')]");
    By antennaModel_2  = By.xpath("//*[contains(@id, 'path-details-antennas-1-') and contains(@id, '-antenna-model')]");
    By antennaCenterline_2  = By.xpath("//*[contains(@id, 'path-details-antennas-1-') and contains(@id, '-centerline')]");
    By antennaMode_2  = By.xpath("//*[contains(@id, 'path-details-antennas-1-') and contains(@id, '-mode')]");
    By antennaCode_2  = By.xpath("//*[contains(@id, 'path-details-antennas-1-') and contains(@id, '-antenna-code')]");
    By antennaGain_2  = By.xpath("//*[contains(@id, 'path-details-antennas-1-') and contains(@id, '-gain')]");

    By asrLookUpAsrNumberField = By.id("asr-lookup-asr");
    By passiveRepeaterSiteNameField = By.id("asr-lookup-asr");
    By passiveRepeaterTypeField = By.id("path-details-passive-repeaters-0-passive-repeater-type");
    By passiveRepeaterLatitudeField = By.id("path-details-passive-repeaters-0-latitude");
    By passiveRepeaterLongitudeField = By.id("path-details-passive-repeaters-0-longitude");
    By passiveRepeaterGroundElevField = By.id("path-details-passive-repeaters-0-elevation");
    By passiveRepeaterAntennaCodeFieldPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-antenna-code')]");

    By passiveRepeaterAntennaModelField = By.id("path-details-passive-repeaters-0-antennas-0-antenna-model");
    By passiveRepeaterAntennaModelFieldPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-antenna-model')]");

    By passiveRepeaterAntennaCodeField = By.id("path-details-passive-repeaters-0-antennas-0-antenna-code");
    By passiveRepeaterCenterlineField = By.id("path-details-passive-repeaters-0-antennas-0-centerline");
    By passiveRepeaterCenterlineField2 = By.id("path-details-passive-repeaters-0-antennas-1-centerline");

    By passiveRepeaterCenterlineFieldPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-centerline')]");

    By passiveRepeaterCommonLossField = By.id("path-details-passive-repeaters-0-back-to-back-0-commonLoss");
    By lookUpAntennaCode = By.id("antenna-lookup-antenna-code");
    By lookUpSearchButton = By.id("antenna-lookup-submit");



    //hovers -- Able to use the hover method

    //Data Fields - Element is read only and can use getFieldText method
    By pathDetailSiteLookUpSiteNameResults = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-siteName')]/span");
    By pathDetailSiteLookUpCallSignResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-callSign')]/span");
    By pathDetailSiteLookUpAsrResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-asr')]/span");
    By pathDetailSiteLookUpLatitudeResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-latitude')]/span");
    By pathDetailSiteLookUpLongitudeResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-longitude')]/span");
    By pathDetailSiteLookUpRadiusResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-distance')]/span");
    By asrLookUpResultRow  = By.xpath("//*[contains(@id, 'asr-lookup-modal-table-data-asr-') and contains(@id, '-entityName')]");

    By pdError = By.id("path-details-site-0-asr-error-message");
    By successHeadingText = By.className("path-details-footer-modal");
    By editDetailsLink = By.id("path-0-path-details-button");
    By leaveWithoutSavingText = By.cssSelector(".padding-half.center-text");
    By siteRowItem = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-')]");
    By antResultListItem = By.xpath("//*[contains(@id, 'antenna-lookup-modal-table-data-antennaCode-') and contains(@id, 'antenna-lookup-modal-table-data-antennaCode-')]");

    //Index List -- Can you used an array to select item

    //Modal -- Does it pop up over current window
    By doYouWantToLeaveModal = By.className("path-details-footer-modal");
    By rowItems = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-')and contains(@id, '-siteName')]");


    public PathDetailPage(WebDriver driver) {
        super(driver);
        visit("/");
    }

    public int getRows(){
        int rows =  finds(rowItems).size();
        return rows;
    }



    public void checkForBlankPassiveRepeaterFields(){
        click(passiveRepeaterTrigger);
        String blankAntCode = getFieldText(passiveRepeaterAntennaCodeField);
        String blankCommonLoss = getFieldText(passiveRepeaterCommonLossField);
        String blankAntennaModel = getFieldText(passiveRepeaterAntennaModelField);
        String blankAntennaModel2 = getFieldTextPlural(passiveRepeaterAntennaModelFieldPlural,1);
        String blankAntCode2 = getFieldTextPlural(passiveRepeaterAntennaCodeFieldPlural,1);
        String centerLine1 = getFieldTextPlural(passiveRepeaterCenterlineFieldPlural,1);
        String centerLine2 = getFieldTextPlural(passiveRepeaterCenterlineFieldPlural,1);
        assertEquals(blankAntCode,"");
        //assertEquals(blankCommonLoss,"");
        assertEquals(blankAntennaModel,"");
        assertEquals(blankAntennaModel2,"");
        assertEquals(blankAntCode2,"");
        //assertEquals(centerLine1,"");
        //assertEquals(centerLine2,"");


    }

    public void savePassiveRepeater(){
        isDisplayed(passiveRepeaterSaveButton,10);
        click(passiveRepeaterSaveButton);
        isDisplayed(pIcon,7);
    }

    public void changeFrequency(String freq){
        assertTrue("No Drop down field",isDisplayed(pathDetailFrequencyBandDropDownField1,12));
        selectFromDropdown(pathDetailFrequencyBandDropDownField1,freq);
    }


    /**COM-494
     * When passive repeater is Billboard type, Antenna lookup in Passive Repeater modal should only show Billboard antenna options.
     When passive repeater is Back to Back type, Antenna lookup should NOT show Billboard antenna options.
     */

    public void addBillboardPassiveRepeater(){
        //Is the Passive Repeater trigger pressent and active
        assertTrue(isDisplayed(passiveRepeaterTrigger,10));
        assertTrue(isDisplayedAndClickable(passiveRepeaterTrigger,10));
        //Click Passive Repeater trigger
        click(passiveRepeaterTrigger);
        //Change to Back to Back
        isDisplayed(passiveRepeaterTypeField,20);
        selectFromDropdown(passiveRepeaterTypeField, "Billboard");
        //Click the Site search button
        isDisplayed(passiveRepeaterSiteSearchButton,10);
        click(passiveRepeaterSiteSearchButton);
        //Wait for the Site Look Up popup
        isDisplayed(pathDetailSiteLookUpSiteName,10);
        //Enter Site Name
        type("New York",pathDetailSiteLookUpSiteName);
        click(siteLookUpSearchButtonModal);
        //Validate that at least one row
        isDisplayed(pathDetailSiteLookUpRadiusResults,10);
        click(pathDetailSiteLookUpRadiusResults);
        //Click Antenna Model search button
        click(passiveRepeaterAntennaModelSearchButton);
    }

    public void removePassiveRepeater(){
        assertTrue(isDisplayed(passiveRepeaterTrigger,10));
        click(passiveRepeaterTrigger);
        isDisplayed(passiveRepeaterRemoveButton,10);
        click(passiveRepeaterRemoveButton);
        assertTrue(!isDisplayed(pIcon,7));

    }

    public void returnFromAntennaLookUp(String antModel, String antCode){
        isDisplayed(passiveRepeaterAntennaModelField, 10);
        String antModFieldText = getFieldText(passiveRepeaterAntennaModelField);
        String antModCodeText = getFieldText(passiveRepeaterAntennaCodeField);
        assertEquals(antModFieldText,antModel);
        assertEquals(antModCodeText,antCode);
        type("12",passiveRepeaterCenterlineField);
    }

    public void setAntennaOnPassiveRepeater(int i, String antCode){
        isDisplayed(passiveRepeaterAntennaModelSearchButton,10);
        isDisplayedArray(passiveRepeaterAntennaModelSearchButtonPlural,i);
        click(passiveRepeaterAntennaModelSearchButtonPlural, i);
        isDisplayed(lookUpAntennaCode,10);
        type(antCode, lookUpAntennaCode);
        isDisplayed(lookUpSearchButton,8);
        click(lookUpSearchButton);
        isDisplayed(antResultListItem,8);
        click(antResultListItem);
/*        String antCodeTextPlural = getFieldTextPlural(passiveRepeaterAntennaCodeFieldPlural,i);
        assertEquals(antCode,antCodeTextPlural);*/
        type("12",passiveRepeaterCenterlineField2);
    }

    public void addBackToBackPassiveRepeater(){
        //Is the Passive Repeater trigger pressent and active
        assertTrue(isDisplayed(passiveRepeaterTrigger,10));
        assertTrue(isDisplayedAndClickable(passiveRepeaterTrigger,10));
        //Click Passive Repeater trigger
        click(passiveRepeaterTrigger);
        //Change to Back to Back
        isDisplayed(passiveRepeaterTypeField,20);
        selectFromDropdown(passiveRepeaterTypeField, "Back to Back");
        //Click the Site search button
        isDisplayed(passiveRepeaterSiteSearchButton,10);
        click(passiveRepeaterSiteSearchButton);
        //Wait for the Site Look Up popup
        isDisplayed(pathDetailSiteLookUpSiteName,10);
        //Enter Site Name
        type("New York",pathDetailSiteLookUpSiteName);
        isDisplayed(siteLookUpSearchButtonModal,10);
        click(siteLookUpSearchButtonModal);
        //Validate that at least one row
        isDisplayed(pathDetailSiteLookUpRadiusResults,10);
        click(pathDetailSiteLookUpRadiusResults);
        //Enter common loss
        type("12",passiveRepeaterCommonLossField);
        //Click Antenna Model search button
        click(passiveRepeaterAntennaModelSearchButton);
    }

    public void addBackToBackPassiveRepeater(String passiveType, String siteName ){
        //Is the Passive Repeater trigger pressent and active
        assertTrue(isDisplayed(passiveRepeaterTrigger,10));
        assertTrue(isDisplayedAndClickable(passiveRepeaterTrigger,10));
        //Click Passive Repeater trigger
        click(passiveRepeaterTrigger);
        //Change to Back to Back
        isDisplayed(passiveRepeaterTypeField,20);
        selectFromDropdown(passiveRepeaterTypeField,passiveType );//"Back to Back"
        //Click the Site search button
        isDisplayed(passiveRepeaterSiteSearchButton,10);
        click(passiveRepeaterSiteSearchButton);
        //Wait for the Site Look Up popup
        isDisplayed(pathDetailSiteLookUpSiteName,10);
        //Enter Site Name
        type(siteName,pathDetailSiteLookUpSiteName);//"New York"
        isDisplayed(siteLookUpSearchButtonModal,10);
        click(siteLookUpSearchButtonModal);
        //Validate that at least one row
        isDisplayed(pathDetailSiteLookUpRadiusResults,10);
        click(pathDetailSiteLookUpRadiusResults);
        //Enter common loss
        type("12",passiveRepeaterCommonLossField);
        //Click Antenna Model search button
        click(passiveRepeaterAntennaModelSearchButton);
    }


    public void openPassiveRepeaterAndValidateFieldsAndButtons(){
        //Is the Passive Repeater trigger pressent and active
        assertTrue(isDisplayed(passiveRepeaterTrigger,10));
        assertTrue(isDisplayedAndClickable(passiveRepeaterTrigger,10));
        //Click Passive Repeater trigger
        click(passiveRepeaterTrigger);
        //Validate all fields are available
        isDisplayed(passiveRepeaterSiteNameField,3);
        isDisplayed(passiveRepeaterTypeField,3);
        isDisplayed(passiveRepeaterLatitudeField,3);
        isDisplayed(passiveRepeaterLongitudeField,3);
        isDisplayed(passiveRepeaterGroundElevField,3);
        isDisplayed(passiveRepeaterAntennaModelField,3);
        isDisplayed(passiveRepeaterAntennaCodeField,3);
        isDisplayed(passiveRepeaterCenterlineField,3);
        //Validate All buttons and Triggers
        isDisplayed(passiveRepeaterSiteSearchButton,3);
        isDisplayed(passiveRepeaterRemoveButton,3);
        isDisplayed(passiveRepeaterSaveButton,3);
        isDisplayed(passiveRepeaterAddPassiveRepeaterTrigger,3);
        isDisplayed(passiveRepeaterAntennaModelSearchButton,3);
    }


    public void navBack() {
        goBack();
    }

    public void clickInactivePassiveRepeaterTrigger(){
        //p-icon not in place
        assertTrue(!isDisplayed(pIcon,6));
        //Passive repeater trigger inactive
        isDisplayed(passiveRepeaterTrigger,12);
        //Is not clickable
        click(passiveRepeaterTrigger);
        //Passive repeater does not appear
        assertTrue(!isDisplayed(passiveRepeaterLatitudeField,3));
    }

    public void flipPath(){
        //Are you on the Path Detail page?
        assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,8));
        //Is the copy button present?
        assertTrue("pathDetailCopyButton did not appear",isDisplayed(pathDetailFlipButton,8));
        //Select the copy button
        click(pathDetailFlipButton,1);
        //A Modal will appear success
        slowDown(9);
    }


    public void copyPathViaPathDetails(){
        //Are you on the Path Detail page?
        assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,8));
        //Is the copy button present?
        assertTrue("pathDetailCopyButton did not appear",isDisplayed(pathDetailCopyButton,8));
        //Select the copy button
        click(pathDetailCopyButton);
        //A Modal will appear success
        isDisplayed(pathDetailSuccessfulCopyMessage,10);
        String copySuccessMessage = getText(pathDetailSuccessfulCopyMessage);
        assertEquals(copySuccessMessage,"PATH COPIED SUCCESSFULLY\n" +
                "You have successfully copied SYNRAMS STATION - New York");
        //Click away
        isDisplayed(overLay,30);
        click(overLay);
        //retun to original
        isDisplayed(pathDetailAsrField1,8);
    }

    public void nextArrow(){
        isDisplayed(activePathDetailNextArrowButton,8);//path-details-footer-next-path-button
        click(activePathDetailNextArrowButton);
        closeConfirmation();
    }

    public void previousArrow(){
        isDisplayed(activePathDetailPreviousArrowButton,8);//path-details-footer-next-path-button
        slowDown(3);
        click(activePathDetailPreviousArrowButton);
        closeConfirmation();
    }

    public void saveAndValidateRequiredMessage(String requiredMessage){
        //Are you on the Path Detail page
        assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,8));
        //Is the save button present
        assertTrue("Save button is not present", isDisplayed(pathDetailSaveDetailsButton));
        //click the save button
        click(pathDetailSaveDetailsButton);
        //validate that all required fields Warn required
        isDisplayed(error,5);
        String pathDetailSiteRequiredError1 = getTextPlural(error ,0);
        String pathDetailLatError1 = getTextPlural(error ,1);
        String pathDetailLongRequiredError1 = getTextPlural(error ,2);
        String pathDetailElevRequiredError1 = getTextPlural(error ,3);
        String pathDetailSiteRequiredError2 = getTextPlural(error ,4);
        String pathDetailLatError2 = getTextPlural(error ,5);
        String pathDetailLongRequiredError2 = getTextPlural(error ,6);
        String pathDetailElevRequiredError2 = getTextPlural(error ,7);
        assertEquals(pathDetailSiteRequiredError1,requiredMessage);
        assertEquals(pathDetailLatError1,requiredMessage);
        assertEquals(pathDetailLongRequiredError1,requiredMessage);
        assertEquals(pathDetailElevRequiredError1,requiredMessage);
        assertEquals(pathDetailSiteRequiredError2,requiredMessage);
        assertEquals(pathDetailLatError2,requiredMessage);
        assertEquals(pathDetailLongRequiredError2,requiredMessage);
        assertEquals(pathDetailElevRequiredError2,requiredMessage);
    }

    public void savedPathInfoPersists1(String siteName, String callSign, String latitude,String longitude, String elevation, String frequencyBand){
        isDisplayed(pathDetailAsrField1,10);

        String siteNameValue = getFieldText(pathDetailSiteNameField1);
        String callSignValue = getFieldText(pathDetailCallSignField1);
        String latitudeValue = getFieldText(pathDetailLatitudeField1);
        String longitudeValue = getFieldText(pathDetailLongitudeField1);
        String elevationValue = getFieldText(pathDetailGroundElevationField1);
        String bandValue = getFieldText(pathDetailFrequencyBandDropDownField1);
        assertEquals("Site Name is incorrect",siteNameValue,siteName);
        assertEquals("call Sign is incorrect",callSignValue,callSign);
        assertEquals("call Sign is incorrect",latitudeValue,latitude);
        assertEquals("call Sign is incorrect",longitudeValue,longitude);
        assertEquals("call Sign is incorrect",elevationValue,elevation);
        assertEquals("call Sign is incorrect",bandValue,frequencyBand);
    }

    public void savedPathInfoPersists2(String siteNameVal2,String asr2,String latitude2,String longitude2,String elevation2){
        isDisplayed(pathDetailAsrField1,10);

        String asrValue2 = getFieldText(pathDetailCallSignField2);
        String latitudeValue2 = getFieldText(pathDetailLatitudeField2);
        String longitudeValue2 = getFieldText(pathDetailLongitudeField2);
        String elevationValue2 = getFieldText(pathDetailGroundElevationField2);
        assertEquals("asr2 is incorrect",asrValue2,asr2);
        assertEquals("latitudeValue2 is incorrect",latitudeValue2,latitude2);
        assertEquals("longitudeValue2 is incorrect",longitudeValue2,longitude2);
        assertEquals("elevationValue2 is incorrect",elevationValue2,elevation2);

    }

    public void openPathDetailViaDetails(){
        //Make sure that the Details link is present
        assertTrue("DetailsLink is not present",isDisplayed(editDetailsLink,30));
        //Click the Details link from the saved path
        click(editDetailsLink);
        //Verify that the path detail form opens
        assertTrue("The path details form did not open",isDisplayed(pathDetailAsrField1,5));
    }

    public void saveAndValidateSuccessMessage(String saveSuccessMessage){
        //Verify that the save button is present
        isDisplayed(pathDetailSaveDetailsButton,6);
        //Click the Save button
        click(pathDetailSaveDetailsButton);
        //Validate that the success message appears
        assertTrue(isDisplayed(successHeadingText,10));
        String saveSuccessVal = getText(successHeadingText);
        assertEquals(saveSuccessVal,saveSuccessMessage);
        //Validate that the success message disappears after 3 seconds
        waitUntilNotPresent(successHeadingText,8);
        //validate that the user is returned to the
        assertTrue(isDisplayed(quickAdd,10));
    }

/*    public void saveAndValidateRequiredMessage(String reqiredMessage){
        //Verify that the save button is present
        isDisplayed(pathDetailSaveDetailsButton,6);
        //Click the Save button
        click(pathDetailSaveDetailsButton);
        //Validate that the success message appears
        assertTrue(isDisplayed(successHeadingText,5));
        String saveSuccessVal = getText(successHeadingText);
        assertEquals(saveSuccessVal,reqiredMessage);
        //Validate that the success message disappears after 3 seconds
        //validate that the user is returned to the
    }*/

    public void addPathViaPathDetailASR1(String asr, String latitude, String longitude, String elevation, String siteNameVal) {
        //Prove that you've arrived on the PathDetail page
        assertTrue("Did not land on path detail", isDisplayed(pathDetailCallSignField1, 5));
        //Verify that the ASR search button is present
        assertTrue("Can't find the ASR search button", isDisplayed(pathDetailAsrSearch1, 5));//path-details-asr-0-lookup-trigger
        //Click the ASR search button
        clickJS(pathDetailAsrSearch1);
        //Verify that the ASR look up appears
        assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpAsrNumberField, 5));
        //Enter 1300000 in the ASR Number field
        type(asr,asrLookUpAsrNumberField);//asr-lookup-asr
        //Click the search button
        clickJS(asrLookUpSearchButton);//asr-lookup-submit
        //Click the result row
        assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpResultRow, 20));

        click(asrLookUpResultRow, 0);
        //validate that the appropriate fields1 are populated
        String asrValue = getFieldText(pathDetailAsrField1);
        String latitudeValue = getFieldText(pathDetailLatitudeField1);
        String longitudeValue = getFieldText(pathDetailLongitudeField1);
        String elevationValue = getFieldText(pathDetailGroundElevationField1);
        String bandValue = getFieldText(pathDetailFrequencyBandDropDownField1);
        assertEquals("call Sign is incorrect", asrValue, asr);
        assertEquals("latitudeValue is incorrect", latitudeValue, latitude);
        assertEquals("longitudeValue is incorrect", longitudeValue, longitude);
        assertEquals("elevationValue is incorrect", elevationValue, elevation);
        //assertEquals("bandValue is incorrect", bandValue, frequencyBand);
        //enter a site name
        type(siteNameVal,pathDetailSiteNameField1);
    }

    public void addPathViaPathDetailASR1Error(String asr) {
        //Prove that you've arrived on the PathDetail page
        assertTrue("Did not land on path detail", isDisplayed(pathDetailCallSignField1, 5));
        //Verify that the ASR search button is present
        assertTrue("Can't find the ASR search button", isDisplayed(pathDetailAsrSearch1, 5));//path-details-asr-0-lookup-trigger
        type(asr, pathDetailAsrField1);//asr-lookup-asr
        //Click the search button
        click(pathDetailCallSignField1);
        slowDown(5);
        String invalidInput = getText(pdError);
        assertEquals(invalidInput,"Invalid input.");
    }

      public void addPathViaPathDetailASR2(String asr2,String latitude2,String longitude2,String elevation2,String siteNameVal2){
        assertTrue("Can't find the ASR search button",isDisplayed(pathDetailAsrSearch2,5));
        //Click the ASR2 search button
        clickJS(pathDetailAsrSearch2);//path-details-asr-1-lookup-trigger
        //Verify that the ASR look up appears
        assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpAsrNumberField, 5));

        //Enter 1200000 in the ASR Number field
        type(asr2, asrLookUpAsrNumberField);
        //Click the search button
        click(asrLookUpSearchButton);//asr-lookup-submit
          //Click the result row
          assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpResultRow, 20));
          click(asrLookUpResultRow, 0);
        //validate that the appropriate fields2 are populated
        String asrValue2 = getFieldText(pathDetailAsrField2);
        String latitudeValue2 = getFieldText(pathDetailLatitudeField2);
        String longitudeValue2 = getFieldText(pathDetailLongitudeField2);
        String elevationValue2 = getFieldText(pathDetailGroundElevationField2);
        assertEquals("asr2 is incorrect",asrValue2,asr2);
        assertEquals("latitudeValue2 is incorrect",latitudeValue2,latitude2);
        assertEquals("longitudeValue2 is incorrect",longitudeValue2,longitude2);
        assertEquals("elevationValue2 is incorrect",elevationValue2,elevation2);
        //enter a site name2
        type(siteNameVal2, pathDetailSiteNameField2);
    }


    public void antennaFieldValidation(){
        assertTrue(isDisplayed(antennaModel_1,8));
        assertTrue(isDisplayed(antennaCenterline_1,8));
        assertTrue(isDisplayed(antennaMode_1,8));
        assertTrue(isDisplayed(antennaCode_1,8));
        assertTrue(isDisplayed(antennaGain_1,8));
        assertTrue(isDisplayed(antennaModel_2,8));
        assertTrue(isDisplayed(antennaCenterline_2,8));
        assertTrue(isDisplayed(antennaMode_2,8));
        assertTrue(isDisplayed(antennaCode_2,8));
        assertTrue(isDisplayed(antennaGain_2,8));
        assertTrue(isDisplayed(addDiversity,8));
    }

    public void antennaFieldFieldEntry1(){
        assertTrue(isDisplayed(antennaModel_1,8));
        assertTrue(isDisplayed(antennaCenterline_1,8));
        assertTrue(isDisplayed(antennaMode_1,8));
        assertTrue(isDisplayed(antennaCode_1,8));
        assertTrue(isDisplayed(antennaGain_1,8));
        assertTrue(isDisplayed(addDiversity,8));
    }

    public void antennaFieldFieldEntry2(){
        assertTrue(isDisplayed(antennaModel_2,8));
        assertTrue(isDisplayed(antennaCenterline_2,8));
        assertTrue(isDisplayed(antennaMode_2,8));
        assertTrue(isDisplayed(antennaCode_2,8));
        assertTrue(isDisplayed(antennaGain_2,8));
        assertTrue(isDisplayed(addDiversity,8));
    }

    public void closeSiteLookup(){
        isDisplayed(closeSiteLookUpMotal,8);
        click(closeSiteLookUpMotal);
        isDisplayed(pathDetailSiteLookUpLatitude,8);

    }


    public void siteSearchResults(int i,String siteName,String callSign,String asr,String lat,String longi,String radius){

        String siteNameResults;
        String callSignResults;
        String asrResults;
        String latResults;
        String longiResults;
        String radiusResults;

        slowDown(4);
        siteNameResults = getTextPlural(pathDetailSiteLookUpSiteNameResults,i);
        callSignResults = getTextPlural(pathDetailSiteLookUpCallSignResults,i);
        //asrResults = getTextPlural(pathDetailSiteLookUpAsrResults,i);
        latResults = getTextPlural(pathDetailSiteLookUpLatitudeResults,i);
        longiResults = getTextPlural(pathDetailSiteLookUpLongitudeResults,i);
        radiusResults = getTextPlural(pathDetailSiteLookUpRadiusResults,i);
        //TODO can't search by latitude

        assertEquals("Site siteNameResults is not correct",siteNameResults,siteName);
        assertEquals("Site callSignResults is not correct",callSignResults,callSign);
        //assertEquals("Site asrResults is not correct",asrResults,asr);
        assertEquals("Site latResults is not correct",latResults,lat);
        assertEquals("Site longiResults is not correct",longiResults,longi);
        assertEquals("Site radiusResults is not correct",radiusResults,radius);

    }

    /**
     *
     * @param i selects the row to validate
     * @param siteName validates that the site entered in search is present in the search result
     * @param callSign validates that the callSign entered in search is present in the search result
     * @param asr validates that the asr entered in search is present in the search result
     * @param lat validates that the latitude entered in search is present in the search result
     * @param longi validates that the longitude entered in search is present in the search result
     * @param radius validates that the radius entered in search is present in the search result
     */

    public void siteSearchResultWithASR(int i,String siteName,String callSign,String asr,String lat,String longi,String radius){

        String siteNameResults;
        String callSignResults;
        String asrResults;
        String latResults;
        String longiResults;
        String radiusResults;

        slowDown(4);
        siteNameResults = getTextPlural(pathDetailSiteLookUpSiteNameResults,i);
        callSignResults = getTextPlural(pathDetailSiteLookUpCallSignResults,i);
        asrResults = getTextPlural(pathDetailSiteLookUpAsrResults,i);
        latResults = getTextPlural(pathDetailSiteLookUpLatitudeResults,i);
        longiResults = getTextPlural(pathDetailSiteLookUpLongitudeResults,i);
        radiusResults = getTextPlural(pathDetailSiteLookUpRadiusResults,i);

        assertEquals("Site siteNameResults is not correct",siteNameResults,siteName);
        assertEquals("Site callSignResults is not correct",callSignResults,callSign);
        assertEquals("Site asrResults is not correct",asrResults,asr);
        assertEquals("Site latResults is not correct",latResults,lat);
        assertEquals("Site longiResults is not correct",longiResults,longi);
        assertEquals("Site radiusResults is not correct",radiusResults,radius);
    }

    public void siteSearch1(String siteName,String callSign,String asr,String lat,String longi,String radius){
        assertTrue("Cannot find path detail site look up search button",isDisplayed(siteSearchLookUpButton1,8));
        slowDown(2);
        click(siteSearchLookUpButton1);
        assertTrue("Cannot find Site Lookup modal",isDisplayed(pathDetailSiteLookUpSiteName,8));
        type(siteName,pathDetailSiteLookUpSiteName);
        type(callSign, pathDetailSiteLookUpCallSign);
        type(asr, pathDetailSiteLookUpAsr);
        //type(lat,pathDetailSiteLookUpLatitude);
        //type(longi,pathDetailSiteLookUpLongitude);
        //type(radius, pathDetailSiteLookUpRadius);
        click(siteLookUpSearchButtonModal);
        slowDown(3);


    }



    public void siteSearch2(String siteName,String callSign,String asr,String lat,String longi,String radius){
        assertTrue("Cannot find path detail site look up search button",isDisplayed(siteSearchLookUpButton1,8));
        click(siteSearchLookUpButton2);
        assertTrue("Cannot find Site Lookup modal",isDisplayed(pathDetailSiteLookUpSiteName,8));
        type(siteName,pathDetailSiteLookUpSiteName);
        type(callSign, pathDetailSiteLookUpCallSign);
        type(asr, pathDetailSiteLookUpAsr);
        type(lat,pathDetailSiteLookUpLatitude);
        //type(longi,pathDetailSiteLookUpLongitude);
        //type(radius, pathDetailSiteLookUpRadius);
        clickJS(siteLookUpSearchButtonModal);
        slowDown(5);
    }

    public void radioService1(String defaultRadio, String radioSelection){
        String radio;
        assertTrue("Can't find Path Details (1) Radio field",isDisplayed(pathDetailRadioServiceDropDownField1,30));

        radio = getFieldText(pathDetailRadioServiceDropDownField1);
        assertEquals(radio,defaultRadio);
        selectFromDropdown(pathDetailRadioServiceDropDownField1,radioSelection );
    }
    public void radioService2(String defaultRadio, String radioSelection){
        assertTrue("Can't find Path Details (2) Radio field",isDisplayed(pathDetailRadioServiceDropDownField2,30));
        selectFromDropdown(pathDetailRadioServiceDropDownField2,radioSelection );

    }

    public void radioServiceLoop1( String radioSelection){
        String radio;
        assertTrue("Can't find Path Details (1) Radio field",isDisplayed(pathDetailRadioServiceDropDownField1,30));

        radio = getFieldText(pathDetailRadioServiceDropDownField1);
        selectFromDropdown(pathDetailRadioServiceDropDownField1,radioSelection );
    }
    public void radioServiceLoop2( String radioSelection){
        assertTrue("Can't find Path Details (2) Radio field",isDisplayed(pathDetailRadioServiceDropDownField2,30));
        selectFromDropdown(pathDetailRadioServiceDropDownField2,radioSelection );

    }


    public void saveDetails(){
        assertTrue("The Save button is not present",isDisplayed(pathDetailSaveDetailsButton,5));
        click(pathDetailSaveDetailsButton);
        slowDown(3);
    }

    public void licSelection1(String defaultLic, String licSelection){
        String lic;

        lic = getFieldText(licBasis1);assertEquals("Default Lic is not correct",lic,defaultLic);
        selectFromDropdown(licBasis1,licSelection);
        lic = getFieldText(licBasis1);
        assertEquals("Default Lic is not correct",lic,"2");

    }

    public void licSelection2(String defaultLic, String licSelection){
        String lic;
        lic = getFieldText(licBasis2);
        assertEquals("Default Lic is not correct",lic,defaultLic);
        selectFromDropdown(licBasis2,licSelection);
        lic = getFieldText(licBasis2);
        assertEquals("Default Lic is not correct",lic,"2");

    }
    public void pathDetailErrors(String errorText ){
        String errors = getText(error);
        assertTrue(errors.equalsIgnoreCase(errorText));
    }

    public void closeDetailsOpenQuickAdd(){
        isDisplayed(pathDetailDiscardButton,10);
        click(pathDetailDiscardButton);
        closeConfirmation();
        assertTrue(isDisplayed(quickAdd,12));
        click(quickAdd);
    }

    public void closeConfirmation(){
        assertTrue(isDisplayed(doYouWantToLeaveModal,8));
        String leaveWithoutSavingPathMessageText = getText(leaveWithoutSavingText);
        assertEquals(leaveWithoutSavingPathMessageText,"DO YOU WANT TO LEAVE?");
        click(leaveWithoutSavingConfirmButton);
    }

    public void checkSiteSuggestion(String siteName,String siteName2 ){
        isDisplayed(pathDetailSiteNameField1,8);
        type(siteName,pathDetailSiteNameField1);
        assertFalse(isDisplayed(pathDetailSuggested1,8));
        click(pathDetailCallSignField1);
        type(siteName2,pathDetailSiteNameField2);
        assertFalse(isDisplayed(pathDetailSuggested1,20));
        click(pathDetailCallSignField1);
    }



    public void checkCallSignEntry(String siteName,String siteName2 ){
        isDisplayed(pathDetailCallSignField1,8);
        type(siteName,pathDetailSiteNameField1);
        click(pathDetailAsrField1);
        type(siteName2,pathDetailCallSignField2);
        click(pathDetailCallSignField1);
    }


    public void checkSiteSuggestionTrue(String siteName,String siteName2 ){
        isDisplayed(pathDetailSiteNameField1,20);
        type(siteName,pathDetailSiteNameField1);
        if (browser.equals("IE")){
            click(pathDetailAsrField1);
            click(pathDetailSiteNameField1);
        }
        assertTrue("suggested dropdown did not appear",isDisplayed(pathDetailSuggested1,20));
        hover(pathDetailSuggested1);
        slowDown(3);
        type(siteName2,pathDetailSiteNameField2);
        assertTrue(isDisplayed(pathDetailSuggested1,20));

    }

    public void addCallSignPathViaPathDetail1(String siteName, String callSign, String latitude,String longitude, String elevation, String frequencyBand){
        isDisplayed(pathDetailSiteNameField1,20);
        type(siteName,pathDetailSiteNameField1);
        assertTrue(isDisplayed(pathDetailCallSignField1,10));
        type(callSign,pathDetailCallSignField1);
        assertTrue(isDisplayed(pathDetailLatitudeField1,10));
        assertTrue(isDisplayed(pathDetailLongitudeField1,10));
        assertTrue(isDisplayed(pathDetailGroundElevationField1,10));
        assertTrue(isDisplayed(pathDetailSiteNameField1,10));
        assertTrue(isDisplayed(pathDetailFrequencyBandDropDownField1,10));
        selectFromDropdown(pathDetailFrequencyBandDropDownField1,"940 MHz");
        String siteNameValue = getFieldText(pathDetailSiteNameField1);
        String callSignValue = getFieldText(pathDetailCallSignField1);
        slowDown(2);
        clear(pathDetailGroundElevationField1);
        slowDown(2);
        type(elevation,pathDetailGroundElevationField1);
        clear(pathDetailSiteNameField1);
        type(siteName,pathDetailSiteNameField1);
        String latitudeValue = getFieldText(pathDetailLatitudeField1);
        String longitudeValue = getFieldText(pathDetailLongitudeField1);
        String elevationValue = getFieldText(pathDetailGroundElevationField1);
        String bandValue = getFieldText(pathDetailFrequencyBandDropDownField1);
        click(pathDetailLatitudeField1);
        assertEquals("Site Name is incorrect",siteNameValue,siteName);
        assertEquals("call Sign is incorrect",callSignValue,callSign);
        assertEquals("call Sign is incorrect",latitudeValue,latitude);
        assertEquals("call Sign is incorrect",longitudeValue,longitude);
        assertEquals("call Sign is incorrect",elevationValue,elevation);
        assertEquals("call Sign is incorrect",bandValue,frequencyBand);

    }

    public void addPathViaPathDetailBasicSetup1(String siteName, String callSign, String latitude,String longitude, String elevation, String frequencyBand){
        isDisplayed(pathDetailSiteNameField1,20);
        type(callSign,pathDetailCallSignField1);
        click(pathDetailAsrField1);


        waitForFieldToBeNotNull(pathDetailLatitudeField1);
        clear(pathDetailSiteNameField1);
        clear(pathDetailSiteNameField1);
        click(pathDetailAsrField1);
        clear(pathDetailGroundElevationField1);
        click(pathDetailAsrField1);
        clear(pathDetailLatitudeField1);
        click(pathDetailAsrField1);
        clear(pathDetailLongitudeField1);
        click(pathDetailAsrField1);

        clear(pathDetailSiteNameField1);
        clear(pathDetailSiteNameField1);
        click(pathDetailAsrField1);
        clear(pathDetailGroundElevationField1);
        clear(pathDetailGroundElevationField1);

        click(pathDetailAsrField1);
        clear(pathDetailLatitudeField1);
        click(pathDetailAsrField1);
        clear(pathDetailLongitudeField1);
        click(pathDetailAsrField1);


        type(latitude,pathDetailLatitudeField1);
        type(longitude,pathDetailLongitudeField1);
        type(elevation,pathDetailGroundElevationField1);
        type(siteName,pathDetailSiteNameField1);

        assertTrue(isDisplayed(pathDetailCallSignField1,10));
        selectFromDropdown(pathDetailFrequencyBandDropDownField1,"940 MHz");
        String siteNameValue = getFieldText(pathDetailSiteNameField1);
        String callSignValue = getFieldText(pathDetailCallSignField1);
        String latitudeValue = getFieldText(pathDetailLatitudeField1);
        String longitudeValue = getFieldText(pathDetailLongitudeField1);
        String elevationValue = getFieldText(pathDetailGroundElevationField1);
        String bandValue = getFieldText(pathDetailFrequencyBandDropDownField1);
        click(pathDetailLatitudeField1);
        assertEquals("Site Name is incorrect",siteNameValue,siteName);
        assertEquals("call Sign is incorrect",callSignValue,callSign);
        assertEquals("call Sign is incorrect",latitudeValue,latitude);
        assertEquals("call Sign is incorrect",longitudeValue,longitude);
        assertEquals("call Sign is incorrect",elevationValue,elevation);
        assertEquals("call Sign is incorrect",bandValue,frequencyBand);

    }

    public void addPathPathDetailWithAsrAndCall1(String siteName, String callSign, String asr, String latitude,String longitude, String elevation, String frequencyBand){
        isDisplayed(pathDetailSiteNameField1,20);
        type(callSign,pathDetailCallSignField1);
        click(pathDetailAsrField1);


        waitForFieldToBeNotNull(pathDetailLatitudeField1);
        clear(pathDetailSiteNameField1);
        clear(pathDetailSiteNameField1);
        click(pathDetailAsrField1);
        clear(pathDetailGroundElevationField1);
        click(pathDetailAsrField1);
        clear(pathDetailLatitudeField1);
        click(pathDetailAsrField1);
        clear(pathDetailLongitudeField1);
        click(pathDetailAsrField1);

        clear(pathDetailSiteNameField1);
        clear(pathDetailSiteNameField1);
        click(pathDetailAsrField1);
        clear(pathDetailGroundElevationField1);
        clear(pathDetailGroundElevationField1);

        click(pathDetailAsrField1);
        clear(pathDetailLatitudeField1);
        click(pathDetailAsrField1);
        clear(pathDetailLongitudeField1);
        click(pathDetailAsrField1);


        type(latitude,pathDetailLatitudeField1);
        type(longitude,pathDetailLongitudeField1);
        type(elevation,pathDetailGroundElevationField1);
        type(siteName,pathDetailSiteNameField1);
        type(asr,pathDetailAsrField1);

        assertTrue(isDisplayed(pathDetailCallSignField1,10));
        selectFromDropdown(pathDetailFrequencyBandDropDownField1,"940 MHz");
        click(pathDetailLatitudeField1);
    }

    public void addPathPathDetailWithAsrAndCall2(String siteName2, String callSign2, String asr2,String latitude2,String longitude2, String elevation2){
        isDisplayed(pathDetailSiteNameField2,20);
        type(callSign2,pathDetailCallSignField2);
        click(pathDetailAsrField2);


        waitForFieldToBeNotNull(pathDetailLatitudeField2);
        clear(pathDetailSiteNameField2);
        clear(pathDetailSiteNameField2);
        click(pathDetailAsrField2);
        clear(pathDetailGroundElevationField2);
        click(pathDetailAsrField2);
        clear(pathDetailLatitudeField2);
        click(pathDetailAsrField2);
        clear(pathDetailLongitudeField2);
        click(pathDetailAsrField2);

        clear(pathDetailSiteNameField2);
        clear(pathDetailSiteNameField2);
        click(pathDetailAsrField2);
        clear(pathDetailGroundElevationField2);
        clear(pathDetailGroundElevationField2);

        click(pathDetailAsrField2);
        clear(pathDetailLatitudeField2);
        click(pathDetailAsrField2);
        clear(pathDetailLongitudeField2);
        click(pathDetailAsrField2);


        type(latitude2,pathDetailLatitudeField2);
        type(longitude2,pathDetailLongitudeField2);
        type(elevation2,pathDetailGroundElevationField2);
        type(siteName2,pathDetailSiteNameField2);
        type(asr2,pathDetailAsrField2);


        assertTrue(isDisplayed(pathDetailCallSignField2,10));
        selectFromDropdown(pathDetailFrequencyBandDropDownField1,"940 MHz");
        click(pathDetailLatitudeField1);
        click(pathDetailSaveDetailsButton);
    }

    public void addPathViaPathDetailBasicSetup2(String siteName2, String callSign2, String latitude2,String longitude2, String elevation2){
        isDisplayed(pathDetailSiteNameField2,20);
        type(callSign2,pathDetailCallSignField2);
        click(pathDetailAsrField2);


        waitForFieldToBeNotNull(pathDetailLatitudeField2);
        clear(pathDetailSiteNameField2);
        clear(pathDetailSiteNameField2);
        click(pathDetailAsrField2);
        clear(pathDetailGroundElevationField2);
        click(pathDetailAsrField2);
        clear(pathDetailLatitudeField2);
        click(pathDetailAsrField2);
        clear(pathDetailLongitudeField2);
        click(pathDetailAsrField2);

        clear(pathDetailSiteNameField2);
        clear(pathDetailSiteNameField2);
        click(pathDetailAsrField2);
        clear(pathDetailGroundElevationField2);
        clear(pathDetailGroundElevationField2);

        click(pathDetailAsrField2);
        clear(pathDetailLatitudeField2);
        click(pathDetailAsrField2);
        clear(pathDetailLongitudeField2);
        click(pathDetailAsrField2);


        type(latitude2,pathDetailLatitudeField2);
        type(longitude2,pathDetailLongitudeField2);
        type(elevation2,pathDetailGroundElevationField2);
        type(siteName2,pathDetailSiteNameField2);

        assertTrue(isDisplayed(pathDetailCallSignField2,10));
        selectFromDropdown(pathDetailFrequencyBandDropDownField1,"940 MHz");
        String siteNameValue2 = getFieldText(pathDetailSiteNameField2);
        String callSignValue2 = getFieldText(pathDetailCallSignField2);
        String latitudeValue2 = getFieldText(pathDetailLatitudeField2);
        String longitudeValue2 = getFieldText(pathDetailLongitudeField2);
        String elevationValue2 = getFieldText(pathDetailGroundElevationField2);
        String bandValue = getFieldText(pathDetailFrequencyBandDropDownField1);
        click(pathDetailLatitudeField1);
        assertEquals("Site Name is incorrect",siteNameValue2,siteName2);
        assertEquals("call Sign is incorrect",callSignValue2,callSign2);
        assertEquals("call Sign is incorrect",latitudeValue2,latitude2);
        assertEquals("call Sign is incorrect",longitudeValue2,longitude2);
        assertEquals("call Sign is incorrect",elevationValue2,elevation2);

    }




    public void addCallSignPathViaPathDetail2(String siteName2, String callSign2, String latitude2,String longitude2, String elevation2){
        type(siteName2,pathDetailSiteNameField2);
        assertTrue(isDisplayed(pathDetailCallSignField2,10));
        type(callSign2,pathDetailCallSignField2);
        click(pathDetailLongitudeField2);
        slowDown(4);
        assertTrue(isDisplayed(pathDetailLatitudeField2,10));
        assertTrue(isDisplayed(pathDetailLongitudeField2,10));
        assertTrue(isDisplayed(pathDetailGroundElevationField2,10));
        assertTrue(isDisplayed(pathDetailSiteNameField2,10));
        String siteNameValue = getFieldText(pathDetailSiteNameField2);
        String callSignValue = getFieldText(pathDetailCallSignField2);
        clear(pathDetailGroundElevationField2);
        type(elevation2,pathDetailGroundElevationField2);
        click(pathDetailCallSignField2);
        slowDown(3);
        String latitudeValue = getFieldText(pathDetailLatitudeField2);
        String longitudeValue = getFieldText(pathDetailLongitudeField2);
        String elevationValue = getFieldText(pathDetailGroundElevationField2);
        assertEquals("Site Name is incorrect",siteNameValue,siteName2);
        assertEquals("call Sign is incorrect",callSignValue,callSign2);
        assertEquals("call Sign is incorrect",latitudeValue,latitude2);
        assertEquals("call Sign is incorrect",longitudeValue,longitude2);
        assertEquals("call Sign is incorrect",elevationValue,elevation2);


    }

    public void addAsrPathViaPathDetail1(String siteName, String asr, String latitude,String longitude, String elevation, String frequencyBand){
        type(siteName,pathDetailSiteNameField1);
        assertTrue(isDisplayed(pathDetailCallSignField1,10));
        type(asr,pathDetailAsrField1);
        click(pathDetailLongitudeField1);
        slowDown(2);
        assertTrue(isDisplayed(pathDetailLatitudeField1,10));
        assertTrue(isDisplayed(pathDetailLongitudeField1,10));
        assertTrue(isDisplayed(pathDetailGroundElevationField1,10));
        assertTrue(isDisplayed(pathDetailSiteNameField1,10));
        assertTrue(isDisplayed(pathDetailFrequencyBandDropDownField1,10));
        selectFromDropdown(pathDetailFrequencyBandDropDownField1,"940 MHz");
        String siteNameValue = getFieldText(pathDetailSiteNameField1);
        String asrValue = getFieldText(pathDetailAsrField1);
        slowDown(2);
        String latitudeValue = getFieldText(pathDetailLatitudeField1);
        String longitudeValue = getFieldText(pathDetailLongitudeField1);
        String elevationValue = getFieldText(pathDetailGroundElevationField1);
        String bandValue = getFieldText(pathDetailFrequencyBandDropDownField1);
        assertEquals("Site Name is incorrect",siteNameValue,siteName);
        assertEquals("call Sign is incorrect",asrValue,asr);
        assertEquals("call Sign is incorrect",latitudeValue,latitude);
        assertEquals("call Sign is incorrect",longitudeValue,longitude);
        assertEquals("call Sign is incorrect",elevationValue,elevation);
        assertEquals("call Sign is incorrect",bandValue,frequencyBand);

    }

    public void addAsrPathViaPathDetail2(String siteName2, String asr2,  String latitude2,String longitude2, String elevation2){
        type(siteName2,pathDetailSiteNameField2);
        assertTrue(isDisplayed(pathDetailCallSignField2,10));
        type(asr2,pathDetailAsrField2);
        click(pathDetailLatitudeField2);
        slowDown(8);
        assertTrue(isDisplayed(pathDetailLatitudeField2,10));
        assertTrue(isDisplayed(pathDetailLongitudeField2,10));
        assertTrue(isDisplayed(pathDetailGroundElevationField2,10));
        assertTrue(isDisplayed(pathDetailSiteNameField2,10));
        String siteNameValue = getFieldText(pathDetailSiteNameField2);
        String asrValue = getFieldText(pathDetailAsrField2);
        String latitudeValue = getFieldText(pathDetailLatitudeField2);
        String longitudeValue = getFieldText(pathDetailLongitudeField2);
        String elevationValue2 = getFieldText(pathDetailGroundElevationField2);
        assertEquals("Site Name is incorrect",siteNameValue,siteName2);
        assertEquals("call Sign is incorrect",asrValue,asr2);
        assertEquals("call Sign is incorrect",latitudeValue,latitude2);
        assertEquals("call Sign is incorrect",longitudeValue,longitude2);
        assertEquals("call Sign is incorrect",elevationValue2,elevation2);
    }
    public void closePathDetails(){
        assertTrue(isDisplayed(pathDetailDiscardButton,10));
        click(pathDetailDiscardButton);
    }

    public void viewPathDetailValue1(String siteName, String callSign,  String latitude,String longitude, String elevation, String frequencyBand){
        String site = getFieldText(pathDetailSiteNameField1);
        String call = getFieldText(pathDetailCallSignField1);
        String longi = getFieldText(pathDetailLongitudeField1);
        String lati = getFieldText(pathDetailLatitudeField1);
        String elev = getFieldText(pathDetailGroundElevationField1);


        assertTrue(isDisplayed(pathDetailRadioServiceDropDownField1,6));
        assertTrue(isDisplayed(pathDetailStationClassDropDownField1,6));
        assertTrue(isDisplayed(pathDetailLicenseBasisDropDownField1,6));
        assertTrue(isDisplayed(pathDetailFrequencyBandDropDownField1,6));
        assertTrue(isDisplayed(pathDetailSiteNameField1,6));
        assertTrue(isDisplayed(pathDetailLatitudeField1,6));
        assertTrue(isDisplayed(pathDetailLongitudeField1,6));
        assertTrue(isDisplayed(pathDetailGroundElevationField1,6));
        assertTrue(isDisplayed(pathDetailCompanyNameField1,6));
        assertTrue(isDisplayed(pathDetailCallSignField1,6));
        assertTrue(isDisplayed(pathDetailAsrField1,6));

        assertEquals(site,siteName);
        assertEquals(call,callSign);
        assertEquals(longi,longitude);
        assertEquals(lati,latitude);
        assertEquals(elev,elevation);

    }

    public void viewPathDetailValues2(String siteName, String callSign, String longitude, String latitude, String elevation, String frequencyBand){
        assertTrue(isDisplayed(pathDetailRadioServiceDropDownField2,6));
        assertTrue(isDisplayed(pathDetailStationClassDropDownField2,6));
        assertTrue(isDisplayed(pathDetailLicenseBasisDropDownField2,6));
        assertTrue(isDisplayed(pathDetailFrequencyBandDropDownField1,6));
        assertTrue(isDisplayed(pathDetailSiteNameField2,6));
        assertTrue(isDisplayed(pathDetailLatitudeField2,6));
        assertTrue(isDisplayed(pathDetailLongitudeField2,6));
        assertTrue(isDisplayed(pathDetailGroundElevationField2,6));
        assertTrue(isDisplayed(pathDetailCompanyNameField2,6));
        assertTrue(isDisplayed(pathDetailCallSignField2,6));
        assertTrue(isDisplayed(pathDetailAsrField2,6));

    }
}
