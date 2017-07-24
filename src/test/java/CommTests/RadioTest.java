package CommTests;


import CommPageObjects.QuickAddPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathDetailAntennaPage;
import CommPageObjects.RadioPage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by ehend on 2/25/2017.
 */
public class RadioTest extends BaseTest{
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
     *COM-486
     Fields displayed	Given a user on the Path Details page,
     When user is looking at the Radio section,
     Then the following fields will be displayed:
     Radio Model; Radio Code; Company; Radio Family; Bandwidth; Max Power; ATPC; Coordinated Power; and an Adaptive Power and Modulations table
     All interactive elements have ID	Given all UI elements are in place as expected,
     When inspecting the elements,
     Then an ID will be included with all interactive elements in the section.     *
     *
     *
     * COM-490
     * Radio Model via lookup only
     * Given a user wants to find a radio model,
       When clicking on the Radio Model field,
       Then it is inactive
       AND as a result, users cannot enter a radio directly.

       Radio Model value - First modulation
       Given a user is in the Radio section of Path Details,
       When the Radio Model field contains a value,
       Then it is based on the Radio Model of the first modulation (the enabled modulation with highest throughput)
     *******  (Note: this can be verified by checking in the GET /radios/{radioId} API for the "modelNumber" value of the first modulation in the selected radio.)

       Radio Code - minimum characters
       Given user is searching for a radio code,
       When valid data is entered in Radio Code field,
       Then only =>6 characters will be accepted.

       Radio Code
       Given user wants to select a Radio to include in a Path,
       When valid information is entered into the Radio Code field
       AND the field is onBlurred,
       Then it auto validates when a match is found
       AND populates the Radio Model, Company, Radio Family, Bandwidth, Max Power, and Coordinated Power fields and the whole modulations table with all possible modulations selected

       Given a valid Radio Code has been entered in the Radio Code Field,
       When an exact match is found in the API,
       Then the Radio Family section will populate based on the selected radio, with a concatenation of Radio Family, architecture name and power type name.
       (NOTE: Power Type is hard coded intentionally for now, and will read SHP, even though it reads 'null' in the API.)
       AND Bandwidth data will be based on bandwidth of first modulation
       AND they will both be non-editable sections
     */
    @Test
    public void pathDetailRadio_shouldCreateRadio_whenEnteringValidRadioData() {
        createPath.createBrandNewProjectPath("Add Radio" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.setupRightRadio("X11A22");

        pathDetailRadio.leftModulationValidation(0, "256 QAM", "40","20");
        pathDetailRadio.leftModulationValidation(1, "256 QAM", "40","20");
        pathDetailRadio.leftModulationValidation(2, "128 QAM", "40","21");
        pathDetailRadio.leftModulationValidation(3, "128 QAM", "40","21");
        pathDetailRadio.leftModulationValidation(4, "64 QAM", "40","21");
        pathDetailRadio.leftModulationValidation(5, "64 QAM", "40","21");
        pathDetailRadio.leftModulationValidation(6, "32 QAM", "40","23");
        pathDetailRadio.leftModulationValidation(7, "32 QAM", "40","23");
        pathDetailRadio.leftModulationValidation(8, "16 QAM", "40","24");
        pathDetailRadio.leftModulationValidation(9, "16 QAM", "40","24");
        pathDetailRadio.leftModulationValidation(10, "QPSK", "40","26");
        pathDetailRadio.leftModulationValidation(11, "QPSK", "40","26");

        pathDetailRadio.rightModulationValidation(0, "256 QAM", "40","20");
        pathDetailRadio.rightModulationValidation(1, "256 QAM", "40","20");
        pathDetailRadio.rightModulationValidation(2, "128 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(3, "128 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(4, "64 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(5, "64 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(6, "32 QAM", "40","23");
        pathDetailRadio.rightModulationValidation(7, "32 QAM", "40","23");
        pathDetailRadio.rightModulationValidation(8, "16 QAM", "40","24");
        pathDetailRadio.rightModulationValidation(9, "16 QAM", "40","24");
        pathDetailRadio.rightModulationValidation(10, "QPSK", "40","26");
        pathDetailRadio.rightModulationValidation(11, "QPSK", "40","26");

        pathDetailAnt.clickSaveDetails();
    }

    /**COM-490
     * Radio Code - minimum characters
       Given user is searching for a radio code,
       When < 6 chars are entered in Radio Code field,
       Then a graceful error will be displayed "Radio Code is 6 characters minimum".
     */
    @Test
    public void pathDetailRadio_shouldError_whenEnteringLessThanSixCharsLeft() {
        createPath.createBrandNewProjectPath("6 characters" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A2");
        pathDetailRadio.errorCorrectionLeft("Radio Code is 6 characters minimum.");
    }

    @Test
    public void pathDetailRadio_shouldError_whenEnteringLessThanSixCharsRight() {
        createPath.createBrandNewProjectPath("6 characters" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupRightRadio("X11A2");
        pathDetailRadio.errorCorrectionRight("Radio Code is 6 characters minimum.");
    }

    /**COM-490
     * Change Modulation power	(Radio Code X11A23 was used for the following power/modulation test cases.)
       Given the greatest power of active modulations is 26
       AND the radio's max power is 26
       When user decreases the modulations' greatest power to 24
       Then the radio's Max Power and Coordinated Power change to 24.
       Decrease Max Power

       Given user decreases a Radio Max Power with a valid value,
       When Radio Max Power changes,
       Then the value of coordinated power decreases to the same amount
       AND all enabled modulations' Max Power decrease to the same amount.

       Increase Max Power Error
       Given user increases Radio Max Power,
       When the new value is more than a given radio's greatest modulation power,
       Then an error message is displayed, "Cannot exceed enabled modulations' greatest power."
     */
    @Test
    public void pathDetailRadio_GreatestPowerOfActiveModulationsWillUpdateToMaxPower_whenChangingModulation() {
        createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.setupRightRadio("X11A22");
        pathDetailRadio.maxPowerDefault("26");
        pathDetailRadio.changeGreatestPower("24");
        String maxPower = pathDetailRadio.findMaxPower();
        assertEquals(maxPower,"24");
        pathDetailRadio.leftModulationValidation(8, "16 QAM", "40","24");
        pathDetailRadio.leftModulationValidation(9, "16 QAM", "40","24");
        pathDetailRadio.leftModulationValidation(10, "QPSK", "40","24");
        pathDetailRadio.leftModulationValidation(11, "QPSK", "40","24");

        pathDetailRadio.changeGreatestPower("23");
        maxPower = pathDetailRadio.findMaxPower();
        assertEquals(maxPower,"23");
        pathDetailRadio.leftModulationValidation(6, "32 QAM", "40","23");
        pathDetailRadio.leftModulationValidation(7, "32 QAM", "40","23");
        pathDetailRadio.leftModulationValidation(8, "16 QAM", "40","23");
        pathDetailRadio.leftModulationValidation(9, "16 QAM", "40","23");
        pathDetailRadio.leftModulationValidation(10, "QPSK", "40","23");
        pathDetailRadio.leftModulationValidation(11, "QPSK", "40","23");

        pathDetailRadio.changeGreatestPower("22");
        maxPower = pathDetailRadio.findMaxPower();
        assertEquals(maxPower,"22");
        pathDetailRadio.leftModulationValidation(6, "32 QAM", "40","22");
        pathDetailRadio.leftModulationValidation(7, "32 QAM", "40","22");
        pathDetailRadio.leftModulationValidation(8, "16 QAM", "40","22");
        pathDetailRadio.leftModulationValidation(9, "16 QAM", "40","22");
        pathDetailRadio.leftModulationValidation(10, "QPSK", "40","22");
        pathDetailRadio.leftModulationValidation(11, "QPSK", "40","22");

        pathDetailRadio.changeGreatestPower("26");
        pathDetailRadio.errorCorrectionLeftModExceeded("Cannot exceed enabled modulations' greatest power: 22dBm");

        pathDetailAnt.clickSaveDetails();
    }

    /**COM-490
     * 	 Eng Ref leaves disabled Modulation
     * 	 Given only Modulations #1 & #2 are active,
         AND both modulations have the same Max Power,
         AND the Engineering Reference is placed on Modulation #1
         When modulation #1 is inactivated,
         Then the Eng Ref will jump to modulation #2.
         Eng Ref jumps to enabled Modulation

         Given only Modulations #1 is disabled
         AND Modulation #2 is active,
         AND both modulations have the same Max Power,
         AND the Engineering Reference is placed on Modulation #2
         When Modulation #1 is activated,
         Then the Eng Ref will jump to Modulation #1
     */

    @Test
    public void pathDetailRadio_EngineeringReferencePlacedOnModulation1_whenEngRefJumpToModulation2() {
        createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.setupRightRadio("X11A22");
        for (int i = 0; i < 10; i++) {
            {
                pathDetailRadio.deactivateModulation(2);
            }
        }
        pathDetailRadio.checkRefPosition1();
        pathDetailRadio.deactivateModulation(0);
        pathDetailRadio.checkRefPosition2();
        pathDetailAnt.clickSaveDetails();
    }

/*  COM-490
    Given a disabled modulation has default Max Power greater than the current highest modulation,
    When the greater powered disabled Modulation is enabled,
    Then the radio Max Power will change to match the greatest modulation Max Power
    AND Coordinated Power will change to match the greatest modulation Max Power.
    Restoring default Radio Code settings

    Given one or more Modulations are enabled,
    AND a valid Radio Code exists in the Radio Code field,
    When user clicks in the Radio Code field,
    AND then unfocuses the Radio Code field,
    Then all Modulations are enabled with their default Max Power
    AND the radio Max Power will match the highest Modulation Power
    AND the Coordinated Power will match the radio Max Power*/
@Test
public void pathDetailRadio_DisabledModEnabledNewMaxWillBeTheNewllyEnabled_whenDisabledModWithHigherMaxPowerThanCurrMax() {
    createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
    createPath.fillOutCompanyFilter("VZW222", "", "", 0);
    pathSummary.changeToSi();
    pathSummary.openPathDetailForAddingPath();
    pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
    pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
    pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
    pathDetailRadio.setupLeftRadio("X11A22");
    pathDetailRadio.setupRightRadio("X11A22");
    pathDetailRadio.deactivateModulation(10);
    pathDetailRadio.deactivateModulation(10);
    pathDetailRadio.validateCurrentMaxPowerAndCoordinatedPower("24","24");
    pathDetailRadio.resetModulation();
    pathDetailRadio.validateCurrentMaxPowerAndCoordinatedPower("26","26");
  }
    /**COM-490
     * Max Power cannot be less than -20	Given a modulation's Max Power is >= -20,
     AND it's txPowerMin is -20 (e.g. Radio X11A23, as seen in the API)
     When radio Max Power is changed to <= -21
     Then all activated modulations' power will change to match the radio Max Power
     AND a graceful error will be displayed indicating that modulation Max Power cannot be less than -20.
     */
    @Test
    public void pathDetailRadio_UserWillRecieveErrorMessageMaxPowerCannotBeLessThanNegTwenty_whenMaxPowerNegTwenty() {
        createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.setupRightRadio("X11A22");
        pathDetailRadio.changeGreatestPower("-21");
        pathDetailRadio.errorCorrectionLeftModExceededNegTwenty("CANNOT BE LESS THAN -20");
    }


    /**COM-490
     * 	Given a different Radio Model than the left-side column is displayed in the right-side column of the Path Details>Radio section,
     When user clicks the blue right-pointing arrow next to the 'Radio' section header,
     Then all of the fields from the selected radio in the left-side column will be copied over to the fields on the right side
     AND the enabled modulations from the original radio will be enabled in the copied radio
     AND the disabled modulations from the original radio will be disabled in the copied radio.
     */
    @Test
    public void pathDetailRadio_LeftRadioWillBeCopiedOverRightRadio_whenRightRadioDiffThanLeftAndTheCopyRadioIsTriggered() {
        createPath.createBrandNewProjectPath("Copy Radio" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.copyRadio();
        pathDetailRadio.rightModulationValidation(0, "256 QAM", "40","20");
        pathDetailRadio.rightModulationValidation(1, "256 QAM", "40","20");
        pathDetailRadio.rightModulationValidation(2, "128 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(3, "128 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(4, "64 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(5, "64 QAM", "40","21");
        pathDetailRadio.rightModulationValidation(6, "32 QAM", "40","23");
        pathDetailRadio.rightModulationValidation(7, "32 QAM", "40","23");
        pathDetailRadio.rightModulationValidation(8, "16 QAM", "40","24");
        pathDetailRadio.rightModulationValidation(9, "16 QAM", "40","24");
        pathDetailRadio.rightModulationValidation(10, "QPSK", "40","26");
        pathDetailRadio.rightModulationValidation(11, "QPSK", "40","26");


    }

    /**COM-491
     * 	 Given user is viewing the Radio section of Path Details
         AND modulations are displayed
         AND the ATPC modal is not open,
         When a Frequency Band has been selected
         AND a Radio has been selected,
         AND the Passive Repeater modal is closed,
         Then clicking on the ATPC "ADD" button will open the ATPC modal.

         Given user is viewing the Radio section of Path Details,
         When the ATPC modal is open but not saved,
         Then the following fields will be displayed:
         Power Increase (radio button); Trigger Level (input); Nominal Power (input); Coordinated Power (input); and 5 Minute Alarm (radio button).
         AND "Coordinated Max Power" will default to match the set Max Power
     */

    @Test
    public void pathDetailRadio_ATPCModalWillOpen_whenClickingAddATPCButton() {
        createPath.createBrandNewProjectPath("Open ATPC" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
    }

    /**COM-491
     * 	Given user is viewing the Radio section of Path Details
        When the Passive Repeater modal is open,
        Then the Radio section will be disabled.

        Given user is viewing the Radio section of Path Details,
        When ATPC is enabled,
        AND the Passive Repeater modal is closed,
        Then the ATPC button is displayed as a lightning bolt
        AND clicking on the lightning bolt button will open the ATPC modal.
     */
    @Test
    public void pathDetailRadio_RadioSectionWillBeDisabled_whenPassiveRepeaterModalOpen() {
        createPath.createBrandNewProjectPath("Copy Radio" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetail.openPassiveRepeaterAndValidateFieldsAndButtons();
        pathDetailRadio.isRadioSectionAvailable();

    }
    /**COM-491
     * 	 Given user is viewing the Radio section of Path Details,
         When ATPC is enabled,
         AND the Passive Repeater modal is closed,
         Then the ATPC button is displayed as a lightning bolt
         AND clicking on the lightning bolt button will open the ATPC modal.

     */

    @Test
    public void pathDetailRadio_LightningBoltWillAppear_whenATPCIsEnabled() {
        createPath.createBrandNewProjectPath("Copy Radio" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        pathDetailRadio.createATPC();
        pathDetailRadio.openATPCViaLighteningBolt();

    }


    /**491
     * 	 Given user is viewing the Radio section of Path Details,
         When the ATPC modal is open
         AND the ATPC hasn't been saved yet,
         AND the radio has 5 minute alarm ("atpcAlarmFlag" in API) set to false,
         Then the 5 Minute Alarm will be set to Off in the UI.
         BUT when "atpcAlarmFlag" is set to true,
         Then the 5 Minute Alarm will be set to On in the UI.

         Given user is viewing the Radio section of Path Details,
         When the ATPC modal is open
         AND the ATPC hasn't been saved yet,
         AND the radio has no ATPC type defined,
         Then the Power Increase button will default to "Ramp".

         Given user is viewing the Radio section of Path Details,
         When the ATPC modal is open
         AND the ATPC hasn't been saved yet,
         Then the Power Increase button will default to the Radio's default

         Given user is viewing the Radio section of Path Details,
         When the ATPC modal is open AND enabled,
         The these fields are displayed:
         (Power Increase (radio button); Trigger Level (input); Nominal Power (input); Coordinated Power (input); and 5 Minute Alarm (radio button).)
         AND a "Remove" button is also displayed.
     */
    @Test
    public void pathDetailRadio_whenRadioHas5MinAlarmSetToON_ATPCRadioHasFiveMinuteAlarmSetToTrue(){
        createPath.createBrandNewProjectPath("5MinuteAndRampON" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min ON", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X06356 ");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        assertTrue(pathDetailRadio.isRampCheckedDefault());
        assertTrue(pathDetailRadio.is5MinAlarmCheckedDefault());

    }

    @Test
    public void pathDetailRadio_whenRadioHas5MinAlarmSetToOFF_ATPCRadioHasFiveMinuteAlarmSetToFalse(){
        createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        assertTrue(pathDetailRadio.isRampCheckedDefault());
        assertFalse(pathDetailRadio.is5MinAlarmCheckedDefault());
    }

    @Test
    public void pathDetailRadio_whenRadioHas5MinAlarmSetToOFF1_ATPCRadioHasFiveMinuteAlarmSetToFalse1(){
        createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("TEMX95");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        assertFalse(pathDetailRadio.isRampCheckedDefault());
        assertTrue(pathDetailRadio.is5MinAlarmCheckedDefault());
    }
        /**
         * Given Radio Code X11A22 is selected
         AND the first modulation is enabled
         AND the radio's "minAtpcTrigger" = null
         AND the "rxThreshold = -64.5
         AND the ATPC modal is open
         When a Trigger Level of -64.6 is entered,
         Then a graceful error is displayed indicating that the Trigger Level "Cannot be less than -64.5".
         */

        @Test
        public void pathDetailRadio_whenTriggerLevelminAtpcTriggernull_ATPCRadioHasFiveMinuteAlarmSetToFalse1(){
            createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
            createPath.fillOutCompanyFilter("VZW222", "", "", 0);
            pathSummary.changeToSi();
            pathSummary.openPathDetailForAddingPath();
            pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
            pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
            pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
            pathDetailRadio.setupLeftRadio("X11A22");
            pathDetailRadio.copyRadio();
            pathDetailRadio.openATPC();
            pathDetailRadio.enterValuesInATPCForm("-64.6","","");
            pathDetailRadio.atpcError("Cannot be less than -64.5");

        }

    /**
     *   Given Radio Code X11A22 is selected
         AND the first modulation is enabled
         AND the radio's "maxAtpcTrigger" = null
         AND the ATPC modal is open
         When a Trigger Level > 0 is entered,
         Then a graceful error is displayed indicating that the Trigger Level "Cannot be greater than 0".
     */

    @Test
    public void pathDetailRadio_whenTriggerLevelMoreThanZero_Error(){
        createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X11A22");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        pathDetailRadio.enterValuesInATPCForm("0.0003","","");
        pathDetailRadio.atpcError("Cannot be greater than 0");

    }

    /**
     *   Given Radio Code X06356 is selected
         AND the first modulation is enabled
         AND the radio's "minAtpcTrigger" = -58.5
         AND the ATPC modal is open
         When a Trigger Level -55.4 is entered,
         Then a graceful error is displayed indicating that the Trigger Level "Cannot be greater than -55.5".
     */
    @Test
    public void pathDetailRadio_whenTriggerLevelNegativeFiftyFivePointFour_Error(){
        createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X06356");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        pathDetailRadio.enterValuesInATPCForm("-55.4","","");
        pathDetailRadio.atpcError("Cannot be greater than -55.5");

    }
    /*  Nominal Power	Given that maximum Nominal Power cannot be greater than radio's max power,
        When an integer greater than radio's Max Power is entered,
        Then an error displays: “Cannot be greater than Radio’s MaxPower”
        Coordinated Power	Given Coordinated Power max value is equal to the current value of Max Power
        When a user enters a value greater than radio's Max Power (at the time ATPC was enabled) into the Coordinated Power field,
        Then an error displays: “Cannot be greater than Radio’s MaxPower".*/

    @Test
    public void pathDetailRadio_whenNominalPowerLevelHigherThanMax_Error(){
        createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X06356");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        pathDetailRadio.enterValuesInATPCForm("-55.5","36","");
        pathDetailRadio.atpcErrorNominalPowerLevel("Cannot be greater than radio's max power");

    }

    /*
    Coordinated Power	Given Coordinated Power max value is equal to the current value of Max Power
    When a user enters a value greater than radio's Max Power (at the time ATPC was enabled) into the Coordinated Power field,
    Then an error displays: “Cannot be greater than Radio’s MaxPower".*/
    @Test
    public void pathDetailRadio_whenCoordinatedPowerLevelHigherThanMax_Error() {
        createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X06356");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        pathDetailRadio.enterValuesInATPCForm("-55.5", "34", "56");
        pathDetailRadio.atpcErrorCoordinatedPowerLevel("Cannot be greater than radio's max power");
    }
    /*
    Given the ATPC modal is open,
    AND trigger level, nominal power and coordinated power are valid values,
    When the Save button is clicked,
    Then all edits to the settings will be saved.

    Given that ATPC has been saved in a path,
    When user returns to Project Summary screen,
    Then an ACM icon is displayed in that path's row, within the Radio column.*/
    @Test
    public void pathDetailRadio_whenValidInputsForNominalCoordinatedTtigger_ThenEditsAreSaved() {
        createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
        createPath.fillOutCompanyFilter("VZW222", "", "", 0);
        pathSummary.changeToSi();
        pathSummary.openPathDetailForAddingPath();
        pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", "KBY45", "34 37 42.1 N", "112 39 26.2 W", "66", "1");
        pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", "KA20003", "40 44 54 N", "73 59 9 W", "55");
        pathDetailAnt.enterAntennaCodeAndBlur("02306AX", "12");
        pathDetailRadio.setupLeftRadio("X06356");
        pathDetailRadio.copyRadio();
        pathDetailRadio.openATPC();
        pathDetailRadio.enterValuesInATPCForm("-55.5", "34", "6");
        pathDetailRadio.saveATPC();

    }

}
