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
    By saveFavButton = By.cssSelector(".fa.fa-lg.fa-heart ");
    By radioModelSearchButton = By.id("path-details-radio-0-lookup-trigger");
    By radioLookupSearchButton = By.id("site-lookup-submit");


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



    By commonLossFieldLeft = By.id("path-details-losses-0-common-loss");
    By transmitLossFieldLeft = By.id("path-details-losses-0-transmit-loss");
    By recieveLossFieldLeft = By.id("path-details-losses-0-receive-loss");
    By commonLossFieldRight = By.id("path-details-losses-1-common-loss");
    By transmitLossFieldRight = By.id("path-details-losses-1-transmit-loss");
    By recieveLossFieldRight = By.id("path-details-losses-1-receive-loss");


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

    By radioLookupRadioCode = By.id("radio-lookup-radio-code");
    By radioLookupRadioCompany = By.id("radio-lookup-radio-company");
    By radioLookupRadioFamily = By.id("radio-lookup-radio-family");
    By radioLookupRadioModel = By.id("radio-lookup-model-number");
    By radioLookupEmissionBandwidth = By.id("radio-lookup-model-number");
    By radioLookupModulationType = By.id("radio-lookup-modulation-type");
    By radioLookupModulation = By.id("radio-lookup-throughput");
    By radioLookupThroughput = By.id("radio-lookup-throughput");
    By radioLookupPower = By.id("radio-lookup-power");
    By radioLookupArchitecture = By.id("radio-lookup-architecture-type");
    By radioLookupRows = By.id("radio-lookup-modal-table");
    By aCMToolTip = By.cssSelector(".__react_component_tooltip.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper");//.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper
    By aCMToolTip1 = By.cssSelector(".tooltip-trigger-decoration.show-decoration.acm-tooltip-decoration");//.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper


    By aCMToolTip5 = By.cssSelector(".__react_component_tooltip.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper");
    By aCMToolTip6 = By.xpath("//*[contains(@data-class, 'project-summary-tooltip tooltip-wrapper')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"

    //radio-lookup-modal-table


    //Index List -- Can you used an array to select item
    By referrencePosition1 = By.xpath("//*[@id=\"path-details-radios-0-modulations-0-label\"]");
    By referrencePosition2 = By.xpath("//*[@id=\"path-details-radios-0-modulations-1-label\"]");
    By activeModLeft = By.xpath("//*[contains(@class, 'modulation-row position-relative enabled') and contains(@id, 'path-details-radios-0-modulations-')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"
    By activeModRight = By.xpath("//*[contains(@class, 'modulation-row position-relative enabled') and contains(@id, 'path-details-radios-1-modulations-')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"

    By inactiveModLeft = By.xpath("//*[@class='modulation-row position-relative') and contains(@id, 'path-details-radios-0-modulations-')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"

    //Modal -- Does it pop up over current window
    By atpcErrorMsg = By.id("atpc-settings-trigger-level-error-message");


    By atpcModalTitle = By.cssSelector("padding-left-half margin-left-half");

    By commonLossErrorMsgLeft = By.id("path-details-losses-0-common-loss-error-message");
    By transmitLossErrorMsgLeft = By.id("path-details-losses-0-transmit-loss-error-message");
    By recieveLossErrorMsgLeft = By.id("path-details-losses-0-receive-loss-error-message");
    By commonLossErrorMsgRight = By.id("path-details-losses-1-common-loss-error-message");
    By transmitLossErrorMsgRight = By.id("path-details-losses-1-transmit-loss-error-message");
    By recieveLossErrorMsgRight = By.id("path-details-losses-1-receive-loss-error-message");

    By toolTipValidation = By.id("//*[@id='radio-lookup-modal-table-data-radioCode-X11A22-modulationName']/span");

    public RadioPage(WebDriver driver) {
        super(driver);
        visit("/");
    }



    public void hoverAndValidate(){
        //select the radio search button
        assertTrue("cant find radioModelSearchButton",isDisplayed(radioModelSearchButton,10));
        //scroll(radioModelSearchButton);
        clickJS(radioModelSearchButton);
        //validate the radio search opened
        assertTrue("cant find radioLookupRadioCode",isDisplayed(radioLookupRadioCode,10));
        //select the search button
        assertTrue("cant find radioLookupRadioCode",isDisplayed(radioLookupSearchButton,5));
        clickJS(radioLookupSearchButton);
        //find the row
        isDisplayed(radioLookupRows,10);
        String radioRow = getText(radioLookupRows);
        //hover acm
        assertTrue("cant find aCMToolTip",isDisplayed(aCMToolTip1,30));
        hoverElement(aCMToolTip6);

    }




    public void clearAllLossFields() {
        clear(commonLossFieldRight);
        click(transmitLossFieldRight);

        clear(transmitLossFieldRight);
        click(recieveLossFieldRight);

        clear(recieveLossFieldRight);
        click(commonLossFieldLeft);

        clear(commonLossFieldLeft);
        click(transmitLossFieldRight);

        clear(transmitLossFieldLeft);
        click(transmitLossFieldRight);

        clear(recieveLossFieldLeft);
        click(transmitLossFieldRight);

    }

    public void lossErrorLeft(String commonLossErrorLeft,String transmitLossErrorLeft,String recieveLossErrorLeft){
        isDisplayed(commonLossFieldLeft,6);
        slowDown(2);
        String commonLossErrorValue = getText(commonLossErrorMsgLeft);
        String transmitLossErrorValue = getText(transmitLossErrorMsgLeft);
        String recieveLossErrorValue = getText(recieveLossErrorMsgLeft);
        assertEquals(commonLossErrorLeft,commonLossErrorValue);
        assertEquals(transmitLossErrorLeft,transmitLossErrorValue);
        assertEquals(recieveLossErrorLeft,recieveLossErrorValue);
    }

    public void lossErrorRight(String commonLossErrorRight,String transmitLossErrorRight,String recieveLossErrorRight){
        isDisplayed(commonLossFieldRight,6);
        slowDown(2);
        String commonLossErrorValue = getText(commonLossErrorMsgRight);
        String transmitLossErrorValue = getText(transmitLossErrorMsgRight);
        String recieveLossErrorValue = getText(recieveLossErrorMsgRight);
        assertEquals(commonLossErrorRight,commonLossErrorValue);
        assertEquals(transmitLossErrorRight,transmitLossErrorValue);
        assertEquals(recieveLossErrorRight,recieveLossErrorValue);
    }

    public void validateLossLeft(String commonLossLeft,String transmitLossLeft,String recieveLossLeft){
        assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldLeft));
        assertTrue("Cant find Common Loss field",isDisplayed(transmitLossFieldLeft));
        assertTrue("Cant find Common Loss field",isDisplayed(recieveLossFieldLeft));
        String commonLossFieldValue = getFieldText(commonLossFieldLeft);
        String transmitLossFieldValue = getFieldText(transmitLossFieldLeft);
        String recieveLossFieldValue = getFieldText(recieveLossFieldLeft);
        assertEquals(commonLossLeft,commonLossFieldValue);
        assertEquals(transmitLossLeft,transmitLossFieldValue);
        assertEquals(recieveLossLeft,recieveLossFieldValue);
    }

    public void validateLossRight(String commonLossRight,String transmitLossRight,String recieveLossRight){
        assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldRight));
        assertTrue("Cant find Common Loss field",isDisplayed(transmitLossFieldRight));
        assertTrue("Cant find Common Loss field",isDisplayed(recieveLossFieldRight));
        String commonLossFieldValue = getFieldText(commonLossFieldRight);
        String transmitLossFieldValue = getFieldText(transmitLossFieldRight);
        String recieveLossFieldValue = getFieldText(recieveLossFieldRight);
        assertEquals(commonLossRight,commonLossFieldValue);
        assertEquals(transmitLossRight,transmitLossFieldValue);
        assertEquals(recieveLossRight,recieveLossFieldValue);
    }

    public void addLossLeft(String commonLossLeft,String transmitLossLeft,String recieveLossLeft){
        assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldLeft));
        assertTrue("Cant find transmit Loss field",isDisplayed(transmitLossFieldLeft));
        assertTrue("Cant find recieve Loss field",isDisplayed(recieveLossFieldLeft));
        type(commonLossLeft,commonLossFieldLeft);
        type(transmitLossLeft,transmitLossFieldLeft);
        type(recieveLossLeft,recieveLossFieldLeft);

    }

    public void addLossRight(String commonLossRight,String transmitLossRight,String recieveLossRight){
        assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldRight));
        assertTrue("Cant find Common Loss field",isDisplayed(transmitLossFieldRight));
        assertTrue("Cant find Common Loss field",isDisplayed(recieveLossFieldRight));
        type(commonLossRight,commonLossFieldRight);
        type(transmitLossRight,transmitLossFieldRight);
        type(recieveLossRight,recieveLossFieldRight);

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
        type("1",commonLossFieldLeft);
        click(radioCodeFieldLeft);
        slowDown(2);
        click(radioMaxPowerLeft);

        slowDown(2);
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

    public void saveFavRadioCodeEnterNewCode(){
        type("1",commonLossFieldLeft);
        assertTrue("cnanot find fav button",isDisplayed(saveFavButton,5));//fa fa-lg fa-heart
        click(saveFavButton);
        click(radioMaxPowerLeft);
        clear(radioCodeFieldRight);
        clear(radioCodeFieldRight);
        click(radioMaxPowerLeft);
        String getFavCode = getFieldText(radioCodeFieldLeft);
        type(getFavCode,radioCodeFieldRight);
        click(radioMaxPowerRight);
    }

    public void activeModItemsLeft(int lineItem) {
        assertTrue(isDisplayed(activeModLeft, 3));        //class="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"
        int rows =  finds(activeModLeft).size();
        assertTrue(isDisplayedArray(activeModLeft, lineItem));
    }
    public void activeModItemsRight(int lineItem) {
        assertTrue(isDisplayed(activeModLeft, 3));        //class="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"
        int rows =  finds(activeModLeft).size();
        assertTrue(isDisplayedArray(activeModLeft, lineItem));
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
