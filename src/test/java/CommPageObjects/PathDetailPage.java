package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PathDetailPage extends BasePage {


    //Headings

    //Buttons
    By pathDetailNewButton = By.id("path-details-path-new-mod-icon");
    By pathDetailSaveDetailsButton = By.cssSelector(".heading-font.btn.btn-md.hover-inverse.bg-green");
    By pathDetailDiscardButton = By.cssSelector(".heading-font.btn.btn-md.hover-inverse.bg-blue.margin-left-1");
    By quickAdd = By.id("project-summary-quick-add-open");
    By siteLookUpSearchButtonModal = By.id("site-lookup-submit");
    By siteSearchLookUpButton1 = By.id("path-details-site-0-lookup-trigger");
    By siteSearchLookUpButton2 = By.id("path-details-site-1-lookup-trigger");
    By closeSiteLookUpMotal = By.id("site-lookup-modal-heading-close");

    By addDiversity = By.cssSelector(".fa.fa-plus-circle");



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

    By pathDetailSiteLookUpSiteName = By.id("site-lookup-site-name");
    By pathDetailSiteLookUpCallSign = By.id("site-lookup-call-sign");
    By pathDetailSiteLookUpAsr = By.id("site-lookup-asr");
    By pathDetailSiteLookUpLatitude = By.id("path-details-site-0-latitude");
    By pathDetailSiteLookUpLongitude = By.id("site-lookup-longitude");
    By pathDetailSiteLookUpRadius = By.id("site-lookup-radius");

    By antennaModel_1  = By.xpath("//*[contains(@id, 'path-details-site-0-') and contains(@id, '-antenna-model')]");
    By antennaCenterline_1  = By.xpath("//*[contains(@id, 'path-details-site-0-') and contains(@id, '-centerline')]");
    By antennaMode_1  = By.xpath("//*[contains(@id, 'path-details-site-0-') and contains(@id, '-mode')]");
    By antennaCode_1  = By.xpath("//*[contains(@id, 'path-details-site-0-') and contains(@id, '-antenna-code')]");
    By antennaGain_1  = By.xpath("//*[contains(@id, 'path-details-site-0-') and contains(@id, '-gain')]");





    By antennaModel_2  = By.xpath("//*[contains(@id, 'path-details-site-1-') and contains(@id, '-antenna-model')]");
    By antennaCenterline_2  = By.xpath("//*[contains(@id, 'path-details-site-1-') and contains(@id, '-centerline')]");
    By antennaMode_2  = By.xpath("//*[contains(@id, 'path-details-site-1-') and contains(@id, '-mode')]");
    By antennaCode_2  = By.xpath("//*[contains(@id, 'path-details-site-1-') and contains(@id, '-antenna-code')]");
    By antennaGain_2  = By.xpath("//*[contains(@id, 'path-details-site-1-') and contains(@id, '-gain')]");


    //hovers -- Able to use the hover method

    //Data Fields - Element is read only and can use getFieldText method
    By pathDetailSiteLookUpSiteNameResults = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-siteName')]/span");
    By pathDetailSiteLookUpCallSignResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-callSign')]/span");
    By pathDetailSiteLookUpAsrResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-asr')]/span");
    By pathDetailSiteLookUpLatitudeResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-latitude')]/span");
    By pathDetailSiteLookUpLongitudeResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-longitude')]/span");
    By pathDetailSiteLookUpRadiusResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-distance')]/span");


    //Index List -- Can you used an array to select item

    //Modal -- Does it pop up over current window


    public PathDetailPage(WebDriver driver) {
        super(driver);
        visit("/");
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

        assertEquals("Site siteNameResults is not correct",siteNameResults,siteName);
        assertEquals("Site callSignResults is not correct",callSignResults,callSign);
        //assertEquals("Site asrResults is not correct",asrResults,asr);
        assertEquals("Site latResults is not correct",latResults,lat);
        assertEquals("Site longiResults is not correct",longiResults,longi);
        assertEquals("Site radiusResults is not correct",radiusResults,radius);

    }

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
        //type(lat,pathDetailSiteLookUpLatitude);
        //type(longi,pathDetailSiteLookUpLongitude);
        //type(radius, pathDetailSiteLookUpRadius);
        click(siteLookUpSearchButtonModal);
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
        assertTrue(isDisplayed(quickAdd,12));
        click(quickAdd);
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
