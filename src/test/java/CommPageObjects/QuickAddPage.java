package CommPageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class QuickAddPage extends BasePage {


    //Headings

    //Buttons
    //By quickAddButton = By.cssSelector(".btn.bg-green.hover-inverse");
    //By quickAddButton = By.xpath("//*[contains(@class, 'btn bg-green hover-inverse')]");
    //btn bg-green hover-inverse
    By addPathButton = By.cssSelector(".btn.bg-green.hover-inverse");
    By addPathDetails = By.cssSelector(".btn.bg-blue.hover-inverse");
    By cancelButton = By.cssSelector(".btn.text-red.inverse-default");


    By quickAddButton = By.xpath("//span[@class='btn bg-green hover-inverse' and contains(text(), 'Quick Add')]");


    //Path DropDown Fields -- Does it contain a list that has options that can be selected
    By optionanBandDropDown = By.id("quick-add-path-band");


    //Drop down options
    By option =By.className("suggestion-element");

    //Path Entry Fields - Able to use the type method
    ///Path 1
    By pathName = By.id("quick-add-path-path-name");
    By latitude = By.id("quick-add-site[0]lat");
    By longitude = By.xpath("//*[contains(@name, 'sites[0]longitude') and contains(@id, 'quick-add-site[0]long')]");
    By callSign = By.id("quick-add-site[0]callSignOrASR");//Had to correct this had wrong
    By elevation = By.xpath("//*[contains(@name, 'elevation') and contains(@id, 'quick-add-site')]");
    By siteField = By.id("quick-add-site[0]siteName");
    ///Path2
    By siteField2 = By.id("quick-add-site[1]siteName");  By latitude2 = By.id("quick-add-site[1]lat");
    By longitude2 = By.id("quick-add-site[1]long");
    By callSign2 = By.id("quick-add-site[1]callSignOrASR");//Had to correct this had wrong
    By elevation2 = By.xpath("//*[contains(@name, 'sites[1]elevation') and contains(@id, 'quick-add-site[1]')]");


    //Path hovers -- Able to use the hover method

    //Path Data Fields - Element is read only and can use getFieldText method
    By errorMessage = By.className("error-message");


    //Index List -- Can you used an array to select item

    //Modal -- Does it pop up over current window
    By addNewPathSlideOutClosed = By.className("quick-add-container ");


    public QuickAddPage(WebDriver driver) {
        super(driver);
        visit("project-summary/1234");
    }

    public void quickAddPath(String sitePartialText, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText,  String Asr){

        String lat;
        String longs;
        String asr;
        String elev;

        waitForIsDisplayed(quickAddButton,6);
        isDisplayed(quickAddButton,6);
        slowDown(20);
        click(quickAddButton);
        waitForIsDisplayed(pathName,6);
        type(PathNameText, pathName);
        selectFromDropdown(optionanBandDropDown, BandDropDown);
        type(sitePartialText,siteField);
        isDisplayed(option,6);
        click(option);
        lat = getFieldText(latitude);
        longs = getFieldText(longitude);
        asr = getFieldText(callSign);
        elev = getFieldText(elevation);
        assertEquals(lat, LatitudeText);
        assertEquals(elev, ElevationText);
        assertEquals(longs,Longitude);
        assertEquals(asr,Asr);
        isDisplayed(addPathButton,6);
        type("App",siteField2);
        isDisplayed(option,6);
        click(option);
        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);

    }

    public void quickAddPathNoBand(String sitePartialText, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText,  String Asr){

        String lat;
        String longs;
        String asr;
        String elev;

        waitForIsDisplayed(quickAddButton,6);
        isDisplayed(quickAddButton,6);
        click(quickAddButton);
        waitForIsDisplayed(pathName,6);
        type(PathNameText, pathName);
        type(sitePartialText,siteField);
        isDisplayed(option,6);
        click(option);
        lat = getFieldText(latitude);
        longs = getFieldText(longitude);
        asr = getFieldText(callSign);
        elev = getFieldText(elevation);
        assertEquals(lat, LatitudeText);
        assertEquals(elev, ElevationText);
        assertEquals(longs,Longitude);
        assertEquals(asr,Asr);

        isDisplayed(addPathButton,6);
        type("App",siteField2);
        isDisplayed(option,6);
        click(option);
        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);
    }

    public void quickAddPathInvalidChar( ){
        click(quickAddButton);
        String[] values = new String[15];
        values[0] = "!";
        values[1] = "@";
        values[2] = "#";
        values[3] = "$";
        values[4] = "%";
        values[5] = "^";
        values[6] = "&";
        values[7] = "*";
        values[8] = "(";
        values[9] = ")";
        values[10] = "+";
        values[11] = "=";
        values[12] = ";";
        values[13] = ":";
        values[14] = "~";

        for (String value : values) {
            String pathError;
            String pathError1;

            waitForIsDisplayed(pathName, 6);
            type(value, siteField);
            type(value, siteField2);
            click(pathName);
            pathError = projectFieldError(0);
            pathError1 = projectFieldError(1);

            assertEquals(pathError, "Site Name contains invalid characters.");
            assertEquals(pathError1, "Site Name contains invalid characters.");

            clear(siteField);
            clear(siteField2);
            click(pathName);

            pathError = projectFieldError(0);
            pathError1 = projectFieldError(1);
            assertEquals(pathError, "Required");
            assertEquals(pathError1, "Required");
        }
    }


    public void quickAddPathCallSignInvalidChar(){
        String[] array = {"!","@","#","$","%","&","*","(",")","+","=",";",":","~"};

        for (String invalidChars : array) {
            quickAddInvalidCharChecker(invalidChars,callSign,callSign2,pathName);
        }

    }

    private void quickAddInvalidCharChecker(String invalidChars,By field1, By field2, By field3){

            String pathError;
            String pathError1;
            String pathError2;

            waitForIsDisplayed(field3, 6);
            type(invalidChars, field1);
            type(invalidChars, field2);
            click(field3);
            pathError = projectFieldError(0);
            pathError1 = projectFieldError(1);
            pathError2 = projectFieldError(2);

            assertEquals(pathError, "Required");
            assertEquals(pathError1, "Required");
            assertEquals(pathError2, "Invalid input.");
            clear(field2);
            clear(field1);

            click(field3);
            pathError = projectFieldError(0);
            pathError1 = projectFieldError(1);
            assertEquals(pathError, "Required");
            assertEquals(pathError1, "Required");
            assertEquals(pathError2, "Invalid input.");
        }

    public void callSignErrorChecking(String badEntry1,String badEntry2,String Error1, String Error2){
        quickAddErrorChecking(badEntry1, badEntry2, callSign, callSign2, Error1,  Error2);
    }

    private void quickAddErrorChecking(String invalidEntry1, String invalidEntry2, By element1, By element2, String Error1, String Error2 ){

        String pathError;
        assertTrue(waitForIsDisplayed(addNewPathSlideOutClosed,10));
        assertTrue(isDisplayedAndClickable(quickAddButton,10));
        isDisplayed(quickAddButton);
        slowDown(10);
        click(quickAddButton,0);
        waitForIsDisplayed(pathName, 6);
        type(invalidEntry1, element1);
        type(invalidEntry2, element2);
        assertTrue(isDisplayedAndClickable(pathName,10));
        click(pathName);
        pathError = projectFieldError(0);
        assertEquals(pathError, Error1);
        assertEquals(pathError, Error2);
        clear(element2);
        clear(element1);
        click(cancelButton);
        assertTrue(isDisplayed(addPathDetails,10));
        assertTrue(isDisplayed(quickAddButton,10));
    }

    public void updateElevation(String feet){
        updateExistingValueGeneric(feet,elevation);
        updateExistingValueGeneric(feet,elevation2);
    }

    private void updateExistingValueGeneric(String textUpdate, By fieldLocator){
        String postChangeFieldValue;
        clear(fieldLocator);
        type(textUpdate,fieldLocator);
        postChangeFieldValue = getFieldText(fieldLocator);
        assertEquals(postChangeFieldValue,textUpdate);
    }

    public void savePath(){
        isDisplayedArray(addPathButton,1);
        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);
    }

    public void quickAddPathSiteName21Plus(String siteName){
        waitForIsDisplayed(quickAddButton,6);
        isDisplayed(quickAddButton,6);
        click(quickAddButton);
        waitForIsDisplayed(pathName, 6);
        type(siteName, siteField);
        type(siteName, siteField2);
        click(pathName);
    }
    public void quickAddPathGeneral1(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr){

        waitForIsDisplayed(quickAddButton,10);
        isDisplayedAndClickable(quickAddButton,10);
        isDisplayed(quickAddButton,10);
        click(quickAddButton,0);
        waitForIsDisplayed(pathName,6);
        type(PathNameText, pathName);
        selectFromDropdown(optionanBandDropDown, BandDropDown);
        type(sitePartialText,siteField);
        type(LatitudeText,latitude);
        type(Longitude,longitude);
        type(Asr,callSign);
        type(ElevationText,elevation);

        isDisplayed(addPathButton,6);
        type("App",siteField2);
        isDisplayed(option,6);
        click(option);
        click(latitude);
        click(longitude);
        click(pathName);
        slowDown(1);

        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);

    }

    public void quickAddPathGeneral2(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr){

        waitForIsDisplayed(quickAddButton,10);
        isDisplayedAndClickable(quickAddButton,10);
        click(quickAddButton);

        waitForIsDisplayed(pathName,6);
        type(PathNameText, pathName);
        selectFromDropdown(optionanBandDropDown, BandDropDown);
        type(sitePartialText,siteField);
        type(LatitudeText,latitude);
        type(Longitude,longitude);
        type(Asr,callSign);
        type(ElevationText,elevation);

        isDisplayed(addPathButton,6);
        type("App",siteField2);
        isDisplayed(option,6);
        click(option);
        click(latitude);
        click(longitude);
        click(pathName);

        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);

    }

    public void quickAddPathGeneralNoSave(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr){

        String lat;
        String longs;
        String asr;
        String elev;

        waitForIsDisplayed(quickAddButton,6);
        isDisplayed(quickAddButton,6);
        click(quickAddButton);

        waitForIsDisplayed(pathName,6);
        type(PathNameText, pathName);
        selectFromDropdown(optionanBandDropDown, BandDropDown);
        type(sitePartialText,siteField);
        isDisplayed(option,6);
        click(option);

        lat = getFieldText(latitude);
        longs = getFieldText(longitude);
        asr = getFieldText(callSign);
        elev = getFieldText(elevation);

        isDisplayed(addPathButton,6);
        type("App",siteField2);
        isDisplayed(option,6);
        click(option);
    }

    public String projectFieldError(int i){
        return getTextPlural(errorMessage,i);
    }
}
