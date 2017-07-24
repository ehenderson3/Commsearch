package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RadioPage extends BasePage {


    //Path Data Fields - Element is read only and can use getFieldText method

    //Headings
    By radioImage = By.id("path-details-section-header-radio-icon");


    //Buttons
    By radioCopyArrowButton = By.id("path-details-section-header-radio-copy-button");
    By radioModelLeftButton1 = By.cssSelector(".lookup-trigger-icon.margin-left-half.pointer.pull-right.flex-child-1-0-auto.cursor-not-allowed");
    By radioAutoTransmitPowerControlLeftAddButton1 = By.id("path-details-radios-0--0-atpc-trigger");
    By atpcModalRampButton = By.id("atpc-settings-power-increase-Ramp-label-bottom");
    By atpcModalStepButton = By.id("atpc-settings-power-increase-Step-label-bottom");
    By atpcModalFiveMinAlarmOnButton = By.id("atpc-settings-five-minute-alarm-On-label-bottom");
    By atpcModalFiveMinAlarmOffButton = By.id("atpc-settings-five-minute-alarm-Off-label-bottom");
    By atpcModalSaveButton = By.cssSelector(".btn.btn-md.bg-green.hover-inverse.margin-left-half");
    By atpcLightingBoltButtonLeft = By.id("path-details-radios-0--0-atpc-trigger");
    By atpcModalRampOnButton = By.id("atpc-settings-power-increase-Ramp");
    By atpcModal5MinAlarmOnButton = By.id("atpc-settings-five-minute-alarm-On");

    //Path DropDown Fields -- Does it contain a list that has options that can be selected

    //Drop down options
    //Path Entry Fields - Able to use the type method
    By radioModelFieldLeft = By.id("path-details-radios-0-radio-model");
    By radioCodeFieldLeft = By.id("path-details-radios-0-radio-code");

    By radioMaxPowerLeft = By.id("path-details-radios-0--0-max-power");
    By radioModelFieldRight = By.id("path-details-radios-1-radio-model");
    By radioCodeFieldRight = By.id("path-details-radios-1-radio-code");

    By radioMaxPowerRight = By.id("path-details-radios-1--1-max-power");

    By atpcModalTriggerLevelField = By.id("atpc-settings-trigger-level");
    By atpcModalNominalPowerLevelField = By.id("atpc-settings-nominal-power");
    By atpcModalCoordinatedPowerField = By.id("atpc-settings-coordinated-power");
    By atpcNominalErrorMsg = By.id("atpc-settings-nominal-power-error-message");

    //Path hovers -- Able to use the hover method
    By radioCompanyFieldLeft = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[1]/li[1]/ul/li[3]/div/p");
    By radioFamilyFieldLeft1 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[1]/li[1]/ul/li[4]/div/p/span[1]");
    By radioFamilyFieldLeft2 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[1]/li[1]/ul/li[4]/div/p/span[2]");
    By radioBandwidthFieldLeft = By.id("path-details-radios-0-bandwidth");

    By radioCompanyFieldRight = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[2]/li[1]/ul/li[3]/div/p");
    By radioFamilyFieldRight1 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[2]/li[1]/ul/li[4]/div/p/span[1]");
    By radioFamilyFieldRight2 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[2]/li[1]/ul/li[4]/div/p/span[2]");
    By radioBandwidthFieldRight = By.id("path-details-radios-1-bandwidth");

    By radioCoordinatedPowerFieldLeft = By.id("path-details-radios-0--0-coordinated-power");
    By radioModulationArrayRowsLeft = By.xpath("//*[contains(@id, 'path-details-radios-0-modulations-') and contains(@id, '-modulationSchemeDescription')]");
    By radioModulationArrayRowsLeftSelection = By.cssSelector(".modulation-row.position-relative.enabled");
    By radioModulationArrayRowsLeftSelectionOfDisabled = By.cssSelector(".modulation-row.position-relative");


    By radioMbpsArrayRowsLeft = By.xpath("//*[contains(@id, 'path-details-radios-0-modulations-') and contains(@id, '-bandwidth')]");
    By radioModulationMaxPowerArrayRowsLeft = By.xpath("//*[contains(@id, 'path-details-radios-0-modulations-') and contains(@id, '-power')]");

    By radioCoordinatedPowerFieldRight = By.id("path-details-radios-1--1-coordinated-power");
    By radioModulationArrayRowsRight = By.xpath("//*[contains(@id, 'path-details-radios-1-modulations-') and contains(@id, '-modulationSchemeDescription')]");
    By radioMbpsArrayRowsRight = By.xpath("//*[contains(@id, 'path-details-radios-1-modulations-') and contains(@id, '-bandwidth')]");
    By radioModulationMaxPowerArrayRowsRight = By.xpath("//*[contains(@id, 'path-details-radios-1-modulations-') and contains(@id, '-power')]");
    By radioRadioErrorLeft = By.id("path-details-radios-0-radio-code-error-message");
    By radioRadioErrorRight = By.id("path-details-radios-1-radio-code-error-message");
    By radioRadioErrorExceedsModLeft = By.id("path-details-radios-0--0-max-power-error-message");
    By radioRadioErrorExceedsNegTwentyModLeft = By.className("error-message");
    By atpcCoordinatedErrorMsg = By.id("atpc-settings-coordinated-power-error-message");

    By xClearPoint = By.cssSelector(".clear-input-button.pointer");

    //Index List -- Can you used an array to select item
    By referrencePosition1 = By.xpath("//*[@id=\"path-details-radios-0-modulations-0-label\"]");
    By referrencePosition2 = By.xpath("//*[@id=\"path-details-radios-0-modulations-1-label\"]");

    //Modal -- Does it pop up over current window
    By atpcErrorMsg = By.id("atpc-settings-trigger-level-error-message");


    By atpcModalTitle = By.cssSelector("padding-left-half margin-left-half");

    public RadioPage(WebDriver driver) {
        super(driver);
        visit("/");
    }

    public void isRadioSectionAvailable(){
        assertTrue(!isDisplayedAndClickable(radioCodeFieldLeft,10));
    }


    public void enterValuesInATPCForm(String triggerLevel, String nominal, String coordinatedPower){
        assertTrue("ATPC is not open",isDisplayed(atpcModalTriggerLevelField,10));
        assertTrue("TriggerLeve is not open",isDisplayed(atpcModalTriggerLevelField,10));
        assertTrue("NominalPowerLevel is not open",isDisplayed(atpcModalNominalPowerLevelField,10));
        assertTrue("CoordinatedPower is not open",isDisplayed(atpcModalCoordinatedPowerField,10));
        clear(atpcModalTriggerLevelField);
        clear(atpcModalNominalPowerLevelField);
        clear(atpcModalCoordinatedPowerField);
        type(triggerLevel, atpcModalTriggerLevelField);
        click(atpcModalNominalPowerLevelField);
        if(isDisplayed(atpcErrorMsg,4)){
            System.out.println("Got Field error");
            }else {
            type(nominal, atpcModalNominalPowerLevelField);
            click(atpcModalCoordinatedPowerField);
            type(coordinatedPower, atpcModalCoordinatedPowerField);
            click(atpcModalTriggerLevelField);
        }

    }

    public void saveATPC(){
        isDisplayed(atpcModalSaveButton,10);
        click(atpcModalSaveButton);
        assertTrue("The Lightning bolt did no appear",isDisplayed(atpcLightingBoltButtonLeft,8));

    }

    public boolean atpcError(String errorMsg){
        String bounderyError = getText(atpcErrorMsg);
        assertEquals(bounderyError,errorMsg);
        boolean error =isDisplayed(atpcErrorMsg,10);
        return error;
    }
    public boolean atpcErrorNominalPowerLevel(String errorMsg){
        String bounderyError = getText(atpcNominalErrorMsg);//atpc-settings-nominal-power-error-message
        assertEquals(bounderyError,errorMsg);
        boolean error =isDisplayed(atpcNominalErrorMsg,10);
        return error;
    }
    public boolean atpcErrorCoordinatedPowerLevel(String errorMsg){
        String bounderyError = getText(atpcCoordinatedErrorMsg);//atpc-settings-coordinated-power-error-message
        assertEquals(bounderyError,errorMsg);
        boolean error =isDisplayed(atpcCoordinatedErrorMsg,10);
        return error;
    }

    public void openATPCViaLighteningBolt(){
        assertTrue("The Lightning bolt did no appear",isDisplayed(atpcLightingBoltButtonLeft,8));
        click(atpcLightingBoltButtonLeft);
        assertTrue("TriggerLeve is not open",isDisplayed(atpcModalTriggerLevelField,10));
        assertTrue("NominalPowerLevel is not open",isDisplayed(atpcModalNominalPowerLevelField,10));
        assertTrue("CoordinatedPower is not open",isDisplayed(atpcModalCoordinatedPowerField,10));

    }

    public void createATPC(){
        assertTrue("ATPC is not open",isDisplayed(atpcModalTriggerLevelField,10));
        type("-2",atpcModalTriggerLevelField);
        type("1",atpcModalNominalPowerLevelField);
        click(atpcModalSaveButton);
        assertTrue("The Lightning bolt did no appear",isDisplayed(atpcLightingBoltButtonLeft,8));
    }

    public void openATPC(){
        assertTrue("the ATPC add button is not present",isDisplayed(radioAutoTransmitPowerControlLeftAddButton1,10));
        click(radioAutoTransmitPowerControlLeftAddButton1);
        assertTrue("the ATPC modal is not present",isDisplayed(atpcModalCoordinatedPowerField,10));
        assertTrue("the ATPC modal is not present",isDisplayed(atpcModalRampButton,10));
        assertTrue("the ATPC modal is not present",isDisplayed(atpcModalStepButton,10));
        assertTrue("the ATPC modal is not present",isDisplayed(atpcModalTriggerLevelField,10));
        assertTrue("the ATPC modal is not present",isDisplayed(atpcModalFiveMinAlarmOnButton,10));
        assertTrue("the ATPC modal is not present",isDisplayed(atpcModalFiveMinAlarmOffButton,10));

    }

    public boolean isRampCheckedDefault() {
        isDisplayed(atpcModalRampOnButton,5);//atpc-settings-power-increase-Ramp
        boolean selected = checked(atpcModalRampOnButton);
        return selected;
    }

    public boolean is5MinAlarmCheckedDefault() {
        isDisplayed(atpcModal5MinAlarmOnButton,5);//atpc-settings-five-minute-alarm-On
        boolean selected = checked(atpcModal5MinAlarmOnButton);
        return selected;
    }
    public void copyRadio(){
        assertTrue(isDisplayed(radioCopyArrowButton,30));
        clickJS(radioCopyArrowButton);
        waitForFieldToBeNotNull(radioCodeFieldRight);
    }

    public void resetModulation(){
        click(radioCodeFieldLeft);
        slowDown(1);
        click(radioMaxPowerLeft);
        slowDown(1);
    }

    public void deactivateModulation(int i) {
        isDisplayed(radioModulationArrayRowsLeftSelection, 10);
        clickJS(radioModulationArrayRowsLeftSelection, i);
    }

    public void activateModulation(int i) {
        isDisplayed(radioModulationArrayRowsLeftSelectionOfDisabled, 10);
        clickJS(radioModulationArrayRowsLeftSelectionOfDisabled, i);
    }

    public void checkRefPosition1() {
        assertTrue(isDisplayed(referrencePosition1, 10));
    }

    public void checkRefPosition2() {
        assertTrue(isDisplayed(referrencePosition2, 10));
    }

    public void changeGreatestPower(String updateMax) {
        isDisplayed(radioMaxPowerLeft,4);
        clear(radioMaxPowerLeft);
        slowDown(4);
        clear(radioMaxPowerLeft);
        type(updateMax, radioMaxPowerLeft);
        click(radioMaxPowerRight);
    }

    public String findMaxPower() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            String rows = getFieldTextPlural(radioModulationMaxPowerArrayRowsLeft, i);
            list.add(rows);
        }
        String i = Collections.max(list);
       return i;

    }
    private String getRows(){
        String rows =  getFieldText(radioModulationMaxPowerArrayRowsRight);
        return rows;
    }

    public void validateCurrentMaxPowerAndCoordinatedPower(String maxPower, String coordinatedPower){
        assertTrue(isDisplayed(radioMaxPowerLeft));
        String currMaxPower = getFieldText(radioMaxPowerLeft);
        String currCoordinatedPower = getFieldText(radioCoordinatedPowerFieldLeft);
        assertEquals(currMaxPower,maxPower);
        assertEquals(currCoordinatedPower,coordinatedPower);
    }

    public void maxPowerDefault(String autoUpdateMax){
        String maxPowerFieldVal = getFieldText(radioMaxPowerLeft);
        assertEquals(maxPowerFieldVal,autoUpdateMax);
    }

    public void errorCorrectionLeft(String radioErrorText) {
        isDisplayed(radioRadioErrorLeft);
        String radioError = getText(radioRadioErrorLeft);
        assertEquals(radioErrorText, radioError);
    }

    public void errorCorrectionLeftModExceededNegTwenty(String radioErrorText) {
        isDisplayed(radioRadioErrorExceedsNegTwentyModLeft);
        String radioError = getText(radioRadioErrorExceedsNegTwentyModLeft);
        assertEquals(radioErrorText, radioError);
    }

    public void errorCorrectionLeftModExceeded(String radioErrorText) {
        isDisplayed(radioRadioErrorExceedsModLeft);
        String radioError = getText(radioRadioErrorExceedsModLeft);
        assertEquals(radioErrorText, radioError);
    }

    public void errorCorrectionRight(String radioErrorText) {
        isDisplayed(radioRadioErrorRight);
        String radioError = getText(radioRadioErrorRight);
        assertEquals(radioErrorText, radioError);
    }

    public void xClearText(){
        isDisplayed(xClearPoint,5);
        clickJS(radioCodeFieldLeft);
        assertTrue(isDisplayed(xClearPoint,5));
        clickJS(xClearPoint);
        click(radioAutoTransmitPowerControlLeftAddButton1);
    }

    public void setupLeftRadio(String radioCodeText){
        assertTrue(isDisplayed(radioCodeFieldLeft,6));
        type(radioCodeText, radioCodeFieldLeft);
        click(radioMaxPowerLeft);
        if (isDisplayed(radioRadioErrorLeft,5) == true) {}
        else{waitForFieldToBeNotNull(radioMaxPowerLeft);}
    }



    public void setupRightRadio(String radioCodeText){
        assertTrue(isDisplayed(radioCodeFieldRight,6));
        type(radioCodeText, radioCodeFieldRight);
        click(radioMaxPowerRight);
        if (isDisplayed(radioRadioErrorRight,5) == true) {}
        else{waitForFieldToBeNotNull(radioMaxPowerRight);}
    }

    public void leftModulationValidation(int i, String modVal, String mbpsVal,String maxPowerVal){
        isDisplayed(radioModulationArrayRowsLeft,5);
        String mod = getFieldTextPlural(radioModulationArrayRowsLeft, i);
        assertEquals(modVal,mod);

        String mbps = getFieldTextPlural(radioMbpsArrayRowsLeft, i);
        assertEquals(mbpsVal,mbps);

        String max = getFieldTextPlural(radioModulationMaxPowerArrayRowsLeft, i);
        assertEquals(maxPowerVal,max);
    }

    public void rightModulationValidation(int i, String modVal, String mbpsVal,String maxPowerVal){
        isDisplayed(radioModulationArrayRowsRight,5);
        String mod = getFieldTextPlural(radioModulationArrayRowsRight, i);
        assertEquals(modVal,mod);

        String mbps = getFieldTextPlural(radioMbpsArrayRowsRight, i);
        assertEquals(mbpsVal,mbps);

        String max = getFieldTextPlural(radioModulationMaxPowerArrayRowsRight, i);
        assertEquals(maxPowerVal,max);
    }



}
