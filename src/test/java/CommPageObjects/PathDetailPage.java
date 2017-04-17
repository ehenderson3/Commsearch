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

    //DropDown Fields -- Does it contain a list that has options that can be selected
    By pathDetailRadioServiceDropDownField1 = By.id("path-details-site-0-radio-service");
    By pathDetailStationClassDropDownField1 = By.id("path-details-site-0-station-class");
    By pathDetailLicenseBasisDropDownField1 = By.id("path-details-site-0-license-basis");
    By pathDetailFrequencyBandDropDownField1 = By.id("path-details-band");


    By pathDetailRadioServiceDropDownField2 = By.id("path-details-site-1-radio-service");
    By pathDetailStationClassDropDownField2 = By.id("path-details-site-1-station-class");
    By pathDetailLicenseBasisDropDownField2 = By.id("path-details-site-1-license-basis");

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




    //hovers -- Able to use the hover method

    //Data Fields - Element is read only and can use getFieldText method

    //Index List -- Can you used an array to select item

    //Modal -- Does it pop up over current window


    public PathDetailPage(WebDriver driver) {
        super(driver);
        visit("/");
        //assertTrue(isDisplayed(amIInTheRightPlace,3));
    }

    public void pathDetailErrors(String errorText ){
        String errors = getText(error);
        assertEquals(errors,errorText);
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
        assertTrue(isDisplayed(pathDetailSuggested1,20));
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
        type(elevation,pathDetailGroundElevationField1);
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

    public void addCallSignPathViaPathDetail2(String siteName2, String callSign2, String latitude2,String longitude2, String elevation2){
        type(siteName2,pathDetailSiteNameField2);
        assertTrue(isDisplayed(pathDetailCallSignField2,10));
        type(callSign2,pathDetailCallSignField2);
        click(pathDetailLongitudeField2);
        assertTrue(isDisplayed(pathDetailLatitudeField2,10));
        assertTrue(isDisplayed(pathDetailLongitudeField2,10));
        assertTrue(isDisplayed(pathDetailGroundElevationField2,10));
        assertTrue(isDisplayed(pathDetailSiteNameField2,10));
        String siteNameValue = getFieldText(pathDetailSiteNameField2);
        String callSignValue = getFieldText(pathDetailCallSignField2);
        slowDown(2);
       // type(elevation2,pathDetailGroundElevationField2);
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
        assertTrue(isDisplayed(pathDetailLatitudeField2,10));
        assertTrue(isDisplayed(pathDetailLongitudeField2,10));
        assertTrue(isDisplayed(pathDetailGroundElevationField2,10));
        assertTrue(isDisplayed(pathDetailSiteNameField2,10));
        String siteNameValue = getFieldText(pathDetailSiteNameField2);
        String asrValue = getFieldText(pathDetailAsrField2);
        slowDown(2);
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
        String band = getFieldTextTitle(pathDetailFrequencyBandDropDownField1);


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
        //assertEquals(band,frequencyBand);




//        type("enter into fields", fieldIdentifiedByLocator)
//        click(quickAddbutton);
//        isDisplayed(addPathNameField);
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
//        type("enter into fields", fieldIdentifiedByLocator)
//        click(quickAddbutton);
//        isDisplayed(addPathNameField);
    }
}
