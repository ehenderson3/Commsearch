package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class QuickAddPage extends BasePage {

    String[] array = {"!","@","#","$","%","&","*","(",")","+","=",";",":","~"};

    //Headings

    //Buttons

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
    By siteField2 = By.id("quick-add-site[1]siteName");
    By latitude2 = By.id("quick-add-site[1]lat");
    By longitude2 = By.id("quick-add-site[1]long");
    By callSign2 = By.id("quick-add-site[1]callSignOrASR");//Had to correct this had wrong
    By elevation2 = By.xpath("//*[contains(@name, 'sites[1]elevation') and contains(@id, 'quick-add-site[1]')]");

    //Path hovers -- Able to use the hover method

    //Path Data Fields - Element is read only and can use getFieldText method
    By errorMessage = By.className("error-message");


    //Index List -- Can you used an array to select item

    //Modal -- Does it pop up over current window
    By addNewPathSlideOutClosed = By.className("quick-add-container ");
    By addNewPathSlideOutOpen = By.cssSelector(".quick-add-container.active");

    By control = By.className("toSlowDown");

    public QuickAddPage(WebDriver driver) {
        super(driver);
        visit("");
    }

    public void quickAddPathInvalidChar( ){
        click(quickAddButton);

        for (String value : array) {
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

    public void quickAddPath(String sitePartialText, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText,  String Asr){

        String lat;
        String longs;
        String asr;
        String elev;

        waitForIsDisplayed(quickAddButton,10);
        isDisplayedAndClickable(quickAddButton,10);
        isDisplayed(quickAddButton,10);

        slowDown(2);
        click(quickAddButton,0);
        isDisplayed(pathName,6);
        type(PathNameText, pathName);
        selectFromDropdown(optionanBandDropDown, BandDropDown);
        type(sitePartialText,siteField);
        isDisplayed(option,6);
        if (isDisplayed(option,6) == true){
            click(option);}
        else {
            click(siteField);
            isDisplayed(option,6);
            click(option);
        }


        lat = getFieldText(latitude);
        longs = getFieldText(longitude);
        asr = getFieldText(callSign);
        elev = getFieldText(elevation);
        assertEquals(lat, LatitudeText);
        assertEquals(elev, ElevationText);
        assertEquals(longs,Longitude);
        assertEquals(asr,Asr);
        isDisplayed(addPathButton,6);
        type("New",siteField2);
        isDisplayed(option,11);
        click(option);
        click(pathName);
        click(siteField);
        isDisplayed(option,10);
        click(option);

        click(pathName);
        click(siteField);
        isDisplayed(option,10);
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
        //isDisplayed(control,4);
        slowDown(4);
        click(quickAddButton);
        waitForIsDisplayed(pathName,6);
        type(PathNameText, pathName);
        type(sitePartialText,siteField);
        isDisplayed(option,6);
        hover(option);
        lat = getFieldText(latitude);
        longs = getFieldText(longitude);
        asr = getFieldText(callSign);
        elev = getFieldText(elevation);
        assertEquals(lat, LatitudeText);
        assertEquals(elev, ElevationText);
        assertEquals(longs,Longitude);
        assertEquals(asr,Asr);
        isDisplayed(addPathButton,6);
        type("New",siteField2);
        isDisplayed(option,6);
        click(option);
        click(pathName);
        click(siteField);
        isDisplayed(option,10);
        hover(option);
        click(pathName);
        click(siteField);
        isDisplayed(option,10);
        click(option);
        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);
    }

    public void quickAddPathCallSignInvalidChar(){
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
        slowDown(8);
        click(quickAddButton,0);
        waitForIsDisplayed(pathName, 6);
        slowDown(2);
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


    public boolean checkForExistingSite(String sitePartialText) {

        waitForIsDisplayed(quickAddButton, 10);
        isDisplayedAndClickable(quickAddButton, 10);
        isDisplayed(quickAddButton, 10);
        slowDown(4);
        click(quickAddButton, 0);
        waitForIsDisplayed(pathName, 6);
        type(sitePartialText, siteField);
        isDisplayed(option, 10);
/*        if (isDisplayed(option) == false) {
            {
                click(siteField);
                isDisplayed(option, 10);
            }

        }*/
        return isDisplayed(option, 6);
            }
    public void cancelPathCreation(){
        isDisplayed(cancelButton,10);
        click(cancelButton);
    }

    public void quickAddPathDataSetup(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr){

        isDisplayed(cancelButton,10);
        click(cancelButton);


        waitForIsDisplayed(quickAddButton,10);
        isDisplayedAndClickable(quickAddButton,10);
        isDisplayed(quickAddButton,10);
        slowDown(4);
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
        type(sitePartialText,siteField2);
        type(LatitudeText,latitude2);
        type(Longitude,longitude2);
        type(Asr,callSign2);
        type(ElevationText,elevation2);
        click(latitude);
        click(longitude);
        click(pathName);
        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);
        slowDown(6);
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
        type("new",siteField2);
        isDisplayed(option,6);
        if(isDisplayed(option,10)== false){
            click(siteField2);
            isDisplayed(option,10);
        }
        click(option);
        click(latitude);
        click(longitude);
        click(pathName);
        click(addPathButton,1);
        isDisplayed(addPathDetails,6);
        isDisplayed(quickAddButton,6);
    }

    public void quickAddPathGeneral2(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr) {

        waitForIsDisplayed(quickAddButton,10);
        isDisplayedAndClickable(quickAddButton,10);
        isDisplayed(quickAddButton,10);

        slowDown(10);

        click(quickAddButton,0);

        assertTrue(isDisplayed(addNewPathSlideOutOpen, 15));
        isDisplayed(siteField, 1);
        assertTrue(isDisplayed(pathName, 6));
        type(PathNameText, pathName);
        selectFromDropdown(optionanBandDropDown, BandDropDown);
        type(sitePartialText, siteField);
        click(pathName);
        type(LatitudeText, latitude);
        type(Longitude, longitude);
        type(Asr, callSign);
        isDisplayed(addPathButton, 5);
        type("KA2124", callSign2);

        click(elevation2);
        slowDown(11);
        type("23", elevation2);
        click(pathName);
        isDisplayed(errorMessage, 6);

        type(ElevationText, elevation);
        slowDown(3);
        click(pathName);
        click(addPathButton, 1);
        assertTrue(isDisplayed(addNewPathSlideOutClosed, 15));

        if (isDisplayed(addPathDetails, 10) == false) {
            slowDown(3);
            isDisplayed(addPathDetails, 10);
        } else {
            isDisplayed(addPathDetails);
            click(addPathDetails);
            assertTrue(isDisplayed(quickAddButton, 10));

        }
    }




        public void quickAddPathGeneralError2(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr) {

            assertTrue(isDisplayed(quickAddButton, 20));
            switchBackToDefaultContent();
            assertTrue(waitUntilNotPresent(addNewPathSlideOutOpen, 30));
            isDisplayed(addNewPathSlideOutClosed, 30);
            isDisplayed(siteField, 1);
            click(quickAddButton);
            assertTrue(isDisplayed(addNewPathSlideOutOpen, 30));
            assertTrue(isDisplayed(pathName, 6));
            type(PathNameText, pathName);
            selectFromDropdown(optionanBandDropDown, BandDropDown);
            type(sitePartialText, siteField);
            click(pathName);
            type(LatitudeText, latitude);
            type(Longitude, longitude);
            type(Asr, callSign);

            isDisplayed(addPathButton, 6);
            type("new", siteField2);
            isDisplayed(option, 6);

            click(option);
            click(latitude);
            click(longitude);
            click(pathName);
            isDisplayed(errorMessage, 6);

            type(ElevationText, elevation);
            slowDown(4);
            click(pathName);

            click(addPathButton, 1);
        }



    public void siteSuggestValidation(String PathNameText,String BandDropDown,String sitePartialText, String Longitude, String ElevationText,  String Asr){
        quickAddPathSuggested(PathNameText,BandDropDown,sitePartialText, siteField, Longitude, ElevationText, Asr);
    }

    private void quickAddPathSuggested(String PathNameText,String BandDropDown,String sitePartialText,By suggestedField, String Longitude, String ElevationText,  String Asr){

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
        type(sitePartialText,suggestedField);
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
        type("new",siteField2);
        isDisplayed(option,6);
        click(option);
    }



    public String projectFieldError(int i){
        return getTextPlural(errorMessage,i);
    }
}
