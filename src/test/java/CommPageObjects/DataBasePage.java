package CommPageObjects;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DataBasePage extends BasePage {

    public DataBasePage(WebDriver driver) {
        super(driver);
        visit("/");
    }

    //Path Data Fields - Element is read only and can use getFieldText method
    By antCodeListResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-')]");
    By antDbAntCodeResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-antennaCode')]");


    By antDbAntCompanyResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-company')]");
    By antDbAntModelFamilyResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-antennaFamily')]");
    By antDbAntModelResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-modelNumberAndFeedDir')]");
    By antDbAntPolResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-pol')]");
    By antDbAntFreqResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-frequencyRange')]");
    By antDbAntGainResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-gain')]");
    By antDbAnt3dBBWResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-beamwidth')]");
    By antDbAntDiameterResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-diameterMandFt')]");
    By antDbAntComplianceResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-compliance')]");
    By antDbAntRPEResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-rpeNumber')]");
    By antDbAntPatternDateResult = By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-patternDate')]");
    By antDbAntStatusResultGreeen = By.cssSelector(".database-search-status-icon.bg-green");
    By antDbAntStatusResultOrange = By.cssSelector(".database-search-status-icon.bg-orange");
    By antDbAntStatusResultRed = By.cssSelector(".database-search-status-icon.bg-red");

    By basicInformationClassification = By.id("antenna-details-classification");

    By antDbbasicInformationAntennaCode = By.id("antenna-details-antenna-code");
    By antDbbasicInformationCompany = By.id("antenna-details-antenna-company");
    By antDbbasicInformationModelFamily = By.id("antenna-details-antenna-model-family");
    By antDbbasicInformationAntennaModel = By.id("antenna-details-antenna-model");
    By antDbbasicInformationClassification = By.id("antenna-details-classification");

    By antDbbasicInformationAssociatedAntennaCode = By.id("antenna-details-associated-antenna-code");
    By antDbbasicInformationPolarized = By.id("antenna-details-polarization");
    By antDbbasicInformationStatus = By.id("antenna-details-status");

    By antDbTechnicalInformationLowFrequency = By.id("antenna-details-low-frequency");
    By antDbTechnicalInformationHighFrequency = By.id("antenna-details-high-frequency");
    By antDbTechnicalInformationMainbeamGain = By.id("antenna-details-main-beam-gain");
    By antDbTechnicalInformationDiameter= By.id("antenna-details-diameter");
    By antDbTechnicalInformation3dBeamwidth = By.id("antenna-details-beamwidth");
    By antDbTechnicalInformationFrontToBackRadio  = By.id("antenna-details-front-to-back");
    By antDbbasicInformationApplication = By.id("antenna-details-antenna-application");
    By antDbbasicInformationFCCCompliance = By.id("antenna-details-antenna-compliance");
    By antDbbasicInformationSubreflectorDiameter = By.id("antenna-details-subreflector-diameter");
    By antDbbasicInformationFeedFlangeDiameter = By.id("antenna-details-feed-flange-diameter");


    By antDbbasicInformationAntCodeError = By.id("antenna-details-antenna-code-error-message");
    By antDbbasicInformationCompanyError = By.id("antenna-details-antenna-company-error-message");
    By antDbbasicInformationAntModelError = By.id("antenna-details-antenna-model-error-message");
    By antDbbasicInformationClassificationError = By.id("antenna-details-classification-error-message");
    By antDbbasicInformationStatusError = By.id("antenna-details-status-error-message");

    By antDbTechInformationLowFreqError = By.id("antenna-details-low-frequency-error-message");
    By antDbTechInformationHighFreqError = By.id("antenna-details-high-frequency-error-message");
    By antDbTechInformationMainbeamGainError = By.id("antenna-details-main-beam-gain-error-message");
    By antDbTechInformation3DBeamwidthError = By.id("antenna-details-beamwidth-error-message");

    By antDbRegInformationApplicationError = By.id("antenna-details-antenna-application-error-message");
    By errorUniqueAntCode = By.id("antenna-details-antenna-code-error-message");
    By errorLowFrequency = By.id("antenna-details-low-frequency-error-message");
    By errorHighFrequency = By.id("antenna-details-high-frequency-error-message");
    By errorMainbeamGain = By.id("antenna-details-main-beam-gain-error-message");
    By errorDiameter = By.id("antenna-details-diameter-error-message");
    By error3dBeamwidth = By.id("antenna-details-beamwidth-error-message");
    By errorFrontToBackRadio = By.id("antenna-details-front-to-back-error-message");

    //antenna-details-front-to-back-error-message
    By basicInforStatusGreen = By.cssSelector(".database-search-status-icon.margin-left-1.bg-green");
    By basicInforStatusYellow = By.cssSelector(".database-search-status-icon.margin-left-1.bg-yellow");
    By basicInforStatusRed = By.cssSelector(".database-search-status-icon.margin-left-1.bg-red");
    By selMeter = By.id("antenna-details-diameter-unit-SI-label-bottom");
    By selFeet = By.id("antenna-details-diameter-unit-US-label-bottom");

    //Headings
    By radioImage = By.id("path-details-section-header-radio-icon");

    //Buttons
    By dataBaseManagementButton = By.id("database-management-link");
    By antennaDataBaseLink = By.id("antenna-database-summary-link");
    By antennaPlaceHolder = By.xpath("//*[@id=\"app\"]/div/div/div");
    By createAntButton = By.cssSelector(".btn.search-button.big-button.bg-blue");

    By saveAntenna = By.cssSelector(".heading-font.btn.btn-md.hover-inverse.bg-green");

    By antDbAdvancedDiameterUnitSIButton = By.id("antenna-db-search-create");
    By antDbAdvancedDiameterUnitUSButton = By.id("antenna-db-search-create");

    By antDbCreateButton = By.id("antenna-db-search-create");
    By antDbSearchButton = By.id("antenna-db-search-submit");
    By antDbExportButton = By.cssSelector(".btn.search-button.big-button.bg-grey-dark.false");

    By antDbAntModelLeftRadioDial = By.id("project-summary-settings-unit-LF-label-bottom");
    By antDbAntModelRightRadioDial = By.id("project-summary-settings-unit-RF-label-bottom");
    By antDbAntModelAnyRadioDial = By.id("project-summary-settings-unit-(none)-label-bottom");

    By antDbAdvancedSearchLink = By.xpath("//*[@id=\"antenna-db-search\"]/div[1]/div/label/span");

    //Drop down options
    //Path Entry Fields - Able to use the type method
    By antDbAntCodeField = By.id("antenna-db-search-antenna-code");
    By antDbAntCompanyField = By.id("antenna-db-search-company-name");
    By antDbModelFamilyField = By.id("antenna-db-search-antenna-family");
    By antDbAntModelField = By.id("antenna-db-search-antenna-model");
    By antDbFrequencyField = By.id("antenna-db-search-frequency");

    By antDbAdvancedSearchStatusField = By.id("antenna-db-search-status");
    By antDbAdvancedSearchGainField = By.id("antenna-db-search-gain");
    By antDbAdvancedSearchApplicationField = By.id("antenna-db-search-antenna-application");
    By antDbAdvancedSearchDiameterField = By.id("antenna-db-search-diameter");
    By antDbAdvancedSearchRPEField = By.id("antenna-db-search-rpe-number");
    By antDbAdvancedSearchClassificationField = By.id("antenna-db-search-classification");
    By antDbAdvancedSearch3dbBeamwidthField = By.id("antenna-db-search-beam-width");
    By antDbAdvancedSearchFCCComplianceField = By.id("antenna-db-search-antenna-compliance");

    public void changeDiameterMeter(){
        isDisplayed(selMeter,3);//antenna-details-diameter-unit-SI-label-bottom
        click(selMeter);
    }
    public void checkDiameterMeter(String diameter){
        isDisplayed(antDbTechnicalInformationDiameter,3);
        String informationDiameterTxt = getFieldText(antDbTechnicalInformationDiameter);
        assertEquals(diameter,informationDiameterTxt);
    }
    public void changeDiameterFeet(){
        isDisplayed(selFeet,3);//antenna-details-diameter-unit-US-label-bottom
        click(selFeet);
    }

    public void changeStatusGreen() {
        isDisplayed(basicInforStatusGreen, 3);
    }

    public void changeStatusYellow(){
        isDisplayed(basicInforStatusYellow,3);//database-search-status-icon margin-left-1 bg-yellow
    }

    public void changeStatusred(){
        isDisplayed(basicInforStatusRed,3);//database-search-status-icon margin-left-1 bg-red
    }

    /**
     * Method allows the passing of error literals and compares them to form errors on the Tech information section
     * @param errLowFrequencyTxt
     * @param errHighFrequencyTxt
     * @param errMainbeamGainTxt
     * @param errDiameterTxt
     * @param err3dBeamwidthTxt
     * @param errFrontToBackRadioTxt
     */
    public void errorTechInfoText(String errLowFrequencyTxt,String errHighFrequencyTxt,String errMainbeamGainTxt,String errDiameterTxt,String err3dBeamwidthTxt,String errFrontToBackRadioTxt){
        isDisplayed(errorLowFrequency,7);
        String errLowFrequencyTxtMsg = getText(errorLowFrequency);
        String errHighFrequencyTxtMsg = getText(errorHighFrequency);
        String errMainbeamGainTxtMsg = getText(errorMainbeamGain);
        String errDiameterTxtMsg = getText(errorDiameter);
        String err3dBeamwidthTxtMsg = getText(error3dBeamwidth);
        String errFrontToBackRadioTxtMsg = getText(errorFrontToBackRadio);

        assertEquals(errLowFrequencyTxtMsg,errLowFrequencyTxt);
        assertEquals(errHighFrequencyTxtMsg,errHighFrequencyTxt);
        assertEquals(errMainbeamGainTxtMsg,errMainbeamGainTxt);
        assertEquals(errDiameterTxtMsg,errDiameterTxt);
        assertEquals(err3dBeamwidthTxtMsg,err3dBeamwidthTxt);
        assertEquals(errFrontToBackRadioTxtMsg,errFrontToBackRadioTxt);
    }

    /**
    * Method allows the passing of error literals and compares it to form errors on the Antenna Code field

     * @param errTxt
     */
    public void errorText(String errTxt){
        isDisplayed(errorUniqueAntCode);
        String errTxtMsg = getText(errorUniqueAntCode);
        assertEquals(errTxtMsg,errTxt);
    }

    /**
    * Method is designed to click away from a field to allow blurring
    */
    public void antDbBlur(){
        isDisplayed(antDbTechnicalInformationLowFrequency,10);
        click(antDbTechnicalInformationLowFrequency);
    }

    /**
     * Method is designed to click away from a field to allow blurring
     */
    public void antDbBlurTech(){
        isDisplayed(antDbbasicInformationCompany,10);
        click(antDbbasicInformationCompany);
    }

    /**
     * Method enterstext into earth station fields by passing strings  via parameters
     * @param antDbbasicInformationSubreflectorText
     * @param antDbbasicInformationFeedFlangeText
     */
    public void antDbEarthStationEntry(String antDbbasicInformationSubreflectorText, String antDbbasicInformationFeedFlangeText){
        isDisplayed(antDbbasicInformationSubreflectorDiameter,20);
        type(antDbbasicInformationSubreflectorText,antDbbasicInformationSubreflectorDiameter);
        type(antDbbasicInformationFeedFlangeText,antDbbasicInformationFeedFlangeDiameter);
    }

    /**
     * Method enters text into Reg Infomation fields by passing strings  via parameters
     * @param regInfoApplicationText
     * @param regInfoFCCComplianceText
     */
    public void antDbRegInfoEntry(String regInfoApplicationText, String regInfoFCCComplianceText){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        type(regInfoApplicationText,antDbbasicInformationApplication);
        type(regInfoFCCComplianceText,antDbbasicInformationFCCCompliance);
    }

    /**
     * Method enters text into Tech Infomation fields by passing strings via parameters
     * @param techInfoLowFreqText
     * @param techInfoHighFreqText
     * @param techInfoMainbeamGainText
     * @param techInfoDiameterText
     * @param techInfo3dBeamwidthText
     * @param techInfoFrontToBackRadioText
     */
    public void antDbTechInfoEntry(String techInfoLowFreqText,String techInfoHighFreqText, String techInfoMainbeamGainText, String techInfoDiameterText, String techInfo3dBeamwidthText, String techInfoFrontToBackRadioText ){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        type(techInfoLowFreqText,antDbTechnicalInformationLowFrequency);
        type(techInfoHighFreqText,antDbTechnicalInformationHighFrequency);
        type(techInfoMainbeamGainText,antDbTechnicalInformationMainbeamGain);
        type(techInfoDiameterText,antDbTechnicalInformationDiameter);
        type(techInfo3dBeamwidthText,antDbTechnicalInformation3dBeamwidth);
        type(techInfoFrontToBackRadioText,antDbTechnicalInformationFrontToBackRadio);
    }

    /**
     * Method clicks the dropdown form the field and selects the item passed via parameter
     * @param antStatusText
     */
    public void antDbBasicInfoChangeStatus(String antStatusText){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        selectFromDropdown(antDbbasicInformationStatus,antStatusText);

    }

    /**
     * Method enters text into Basic Infomation fields by passing strings via parameters
     * @param antCodeText
     * @param antCompanyText
     * @param antModFamText
     * @param antModText
     * @param antClassificationText
     * @param antAssociatedAntennaCodeText
     * @param antPolarizedText
     * @param antStatusText
     */
    public void antDbBasicInfoEntry(String antCodeText, String antCompanyText, String antModFamText, String antModText, String antClassificationText, String antAssociatedAntennaCodeText, String antPolarizedText, String antStatusText){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        type(antCodeText, antDbbasicInformationAntennaCode);
        type(antCompanyText, antDbbasicInformationCompany);
        type(antModFamText, antDbbasicInformationModelFamily);
        type(antModText, antDbbasicInformationAntennaModel);
        selectFromDropdown(antDbbasicInformationClassification,antClassificationText);
        type(antAssociatedAntennaCodeText, antDbbasicInformationAssociatedAntennaCode);
        selectFromDropdown(antDbbasicInformationPolarized,antPolarizedText);
        selectFromDropdown(antDbbasicInformationStatus,antStatusText);

    }

    public void saveCreatedAntenna(){
        isDisplayed(saveAntenna,6);
        click(saveAntenna);
    }

    /**
     * This method verifies if an error is present
     */
    public void createAntAntCodeError(){
        assertTrue(isDisplayed(antDbbasicInformationAntCodeError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAntCompanyError(){
        assertTrue(isDisplayed(antDbbasicInformationCompanyError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAntAntModelError(){
        assertTrue(isDisplayed(antDbbasicInformationAntModelError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAntClassificationError(){
        assertTrue(isDisplayed(antDbbasicInformationClassificationError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAntStatusError(){
        assertTrue(isDisplayed(antDbbasicInformationStatusError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAntLoFreqError(){
        assertTrue(isDisplayed(antDbTechInformationLowFreqError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAntHiFreqError(){
        assertTrue(isDisplayed(antDbTechInformationHighFreqError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAntMainbeamGainError(){
        assertTrue(isDisplayed(antDbTechInformationMainbeamGainError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void createAnt3DBeamwidthError(){
        assertTrue(isDisplayed(antDbTechInformation3DBeamwidthError,5));
    }

    /**
     * This method verifies if an error is present
     */
    public void createAntApplicationError(){
        assertTrue(isDisplayed(antDbRegInformationApplicationError,5));
    }




    /**
     * This method clicks the Create Antenna button
     */
    public void createAnt(){
        isDisplayed(createAntButton,5);
        clickJS(createAntButton);
    }


    /**
     * Method takes in strings via parameters and compares text to field values
     * @param regInfoApplicationText
     * @param regInfoFCCComplianceText
     */
    public void antDbEarthStationVal(String regInfoApplicationText, String regInfoFCCComplianceText){
        isDisplayed(antDbbasicInformationSubreflectorDiameter,20);

        String earthStationSubreflectorDiameter = getFieldText(antDbbasicInformationSubreflectorDiameter);
        String earthStationFeedFlangeDiameter = getFieldText(antDbbasicInformationFeedFlangeDiameter);

        assertEquals(regInfoApplicationText,earthStationSubreflectorDiameter);
        assertEquals(regInfoFCCComplianceText,earthStationFeedFlangeDiameter);
    }


    /**
     * Method takes in strings via parameters and compares text to field values
     * @param regInfoApplicationText
     * @param regInfoFCCComplianceText
     */
    public void antDbRegInfoVal(String regInfoApplicationText, String regInfoFCCComplianceText){
        isDisplayed(antDbbasicInformationAntennaCode,20);

        String regInfoApplication = getFieldText(antDbbasicInformationApplication);
        String regInfoFCCCompliance = getFieldText(antDbbasicInformationFCCCompliance);

        assertEquals(regInfoApplicationText,regInfoApplication);
        assertEquals(regInfoFCCComplianceText,regInfoFCCCompliance);
    }

    /**
     * Method takes in strings via parameters and compares text to field values
     *
     * @param techInfoLowFreqText
     * @param techInfoHighFreqText
     * @param techInfoMainbeamGainText
     * @param techInfoDiameterText
     * @param techInfo3dBeamwidthText
     * @param techInfoFrontToBackRadioText
     */
    public void antDbTechInfoVal(String techInfoLowFreqText,String techInfoHighFreqText, String techInfoMainbeamGainText, String techInfoDiameterText, String techInfo3dBeamwidthText, String techInfoFrontToBackRadioText ){
        isDisplayed(antDbbasicInformationAntennaCode,20);

        String techInfoLowFrequency = getFieldText(antDbTechnicalInformationLowFrequency);
        String techInfoHighFrequency = getFieldText(antDbTechnicalInformationHighFrequency);
        String techInfoMainbeamGain = getFieldText(antDbTechnicalInformationMainbeamGain);
        String techInfoDiameter = getFieldText(antDbTechnicalInformationDiameter);
        String techInfo3dBeamwidth = getFieldText(antDbTechnicalInformation3dBeamwidth);
        String techInfoFrontToBackRadio = getFieldText(antDbTechnicalInformationFrontToBackRadio);

        assertEquals(techInfoLowFreqText,techInfoLowFrequency);
        assertEquals(techInfoHighFreqText,techInfoHighFrequency);
        assertEquals(techInfoMainbeamGainText,techInfoMainbeamGain);
        assertEquals(techInfoDiameterText,techInfoDiameter);
        assertEquals(techInfo3dBeamwidthText,techInfo3dBeamwidth);
        assertEquals(techInfoFrontToBackRadioText,techInfoFrontToBackRadio);
    }


    /**
     *      * Method takes in strings via parameters and compares text to field values
     * @param antCodeText
     * @param antCompanyText
     * @param antModFamText
     * @param antModText
     * @param antClassificationText
     * @param antAssociatedAntennaCodeText
     * @param antPolarizedText
     * @param antStatusText
     */
    public void antDbBasicInfoVal(String antCodeText, String antCompanyText, String antModFamText, String antModText, String antClassificationText, String antAssociatedAntennaCodeText, String antPolarizedText, String antStatusText){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        String antCode = getFieldText(antDbbasicInformationAntennaCode);
        String antCompany = getFieldText(antDbbasicInformationCompany);
        String antModFam = getFieldText(antDbbasicInformationModelFamily);
        String antMod = getFieldText(antDbbasicInformationAntennaModel);
        String antClassification = getFieldText(antDbbasicInformationClassification);
        String antAssociatedAntennaCode = getFieldText(antDbbasicInformationAssociatedAntennaCode);
        String antPolarized = getFieldText(antDbbasicInformationPolarized);
        String antStatus= getFieldText(antDbbasicInformationStatus);

        assertEquals(antCode,antCodeText);
        assertEquals(antCompany,antCompanyText);
        assertEquals(antModFam,antModFamText);
        assertEquals(antMod,antModText);
        assertEquals(antClassification,antClassificationText);
        assertEquals(antAssociatedAntennaCode,antAssociatedAntennaCodeText);
        assertEquals(antPolarized,antPolarizedText);
        assertEquals(antStatus,antStatusText);
    }

    /**
     * Method clicks the export button
     */
    public void export(){
        isDisplayed(antDbExportButton,20);
        clickJS(antDbExportButton);
        slowDown(6);
    }

    /**
     * Method clears the Diameter field
     */
    public void clearDiameter(){
        clear(antDbAdvancedSearchDiameterField);
        clear(antDbAdvancedSearchDiameterField);
    }

    /**
     * Method compares RPE to string passed via parameter
     * @param rpeNumber
     */
    public void RPEVal(String rpeNumber){
        isDisplayed(antDbAntRPEResult,5);
        String rPE = getText(antDbAntRPEResult);
        assertEquals(rPE,rpeNumber);
    }

    /**
     * Compares field value to the text being passed via  parameter
     * @param classifications
     */
    public void clickAndVal(String classifications){
        isDisplayed(antDbAntCodeResult,3);
        click(antDbAntCodeResult);
        isDisplayed(basicInformationClassification,10);
        String classification = getFieldText(basicInformationClassification);
        assertEquals(classifications,classification);

    }

    /**
     * Method opens the Advanced search section
     */
    public void openAdvancedSearch(){
        isDisplayed(antDbAdvancedSearchLink,5);
        slowDown(3);
        click(antDbAdvancedSearchLink);
    }

    /**
     * Method enters text into advanced search fields via parameters
     * @param statusText
     * @param gainText
     * @param applicationText
     * @param diameterText
     * @param rPEText
     * @param classificationText
     * @param search3dbBeamwidthFieldText
     * @param fCCComplianceFieldText
     */
    public void advanceSearch(String statusText, String gainText, String applicationText, String diameterText,String rPEText, String classificationText, String search3dbBeamwidthFieldText, String fCCComplianceFieldText ){
        assertTrue("antDbAdvancedSearchStatusField is not present",isDisplayed(antDbAdvancedSearchStatusField,5));
        assertTrue("antDbAdvancedSearchGainField is not present",isDisplayed(antDbAdvancedSearchGainField,5));
        assertTrue("antDbAdvancedSearchApplicationField is not present",isDisplayed(antDbAdvancedSearchApplicationField,5));
        assertTrue("antDbAdvancedSearchDiameterField is not present",isDisplayed(antDbAdvancedSearchDiameterField,5));
        assertTrue("antDbAdvancedSearchRPEField is not present",isDisplayed(antDbAdvancedSearchRPEField,5));
        assertTrue("antDbAdvancedSearchClassificationField is not present",isDisplayed(antDbAdvancedSearchClassificationField,5));
        assertTrue("antDbAdvancedSearch3dbBeamwidthField is not present",isDisplayed(antDbAdvancedSearch3dbBeamwidthField,5));
        assertTrue("antDbAdvancedSearchFCCComplianceField is not present",isDisplayed(antDbAdvancedSearchFCCComplianceField,5));

        selectFromDropdown(antDbAdvancedSearchStatusField,statusText);
        type(gainText,antDbAdvancedSearchGainField);
        selectFromDropdown(antDbAdvancedSearchApplicationField,applicationText);
        type(diameterText,antDbAdvancedSearchDiameterField);
        type(rPEText,antDbAdvancedSearchRPEField);
        selectFromDropdown(antDbAdvancedSearchClassificationField,classificationText);
        type(search3dbBeamwidthFieldText,antDbAdvancedSearch3dbBeamwidthField);
        selectFromDropdown(antDbAdvancedSearchFCCComplianceField,fCCComplianceFieldText);
        click(antDbSearchButton);
    }

    /**
     * Opens the Antenna Db module
     */
    public void accessAntennaDataBase(){
        assertTrue(isDisplayed(dataBaseManagementButton,5));
        click(dataBaseManagementButton);
        assertTrue(isDisplayed(antennaDataBaseLink,5));
        click(antennaDataBaseLink);
        assertTrue(isDisplayed(antennaPlaceHolder,5));
    }

    /**
     * Method takes in search strings and enters in to search field and executes the search
     * @param antCodeText
     * @param antCompanyText
     * @param antModelFamilyText
     * @param antModelText
     * @param antFreqText
     */
    public void antennaDataBaseSearch(String antCodeText,String antCompanyText,String antModelFamilyText,String antModelText,String antFreqText){
        assertTrue(isDisplayed(antDbAntCodeField,5));
        type(antCodeText,antDbAntCodeField);
        type(antCompanyText,antDbAntCompanyField);
        type(antModelFamilyText,antDbModelFamilyField);
        type(antModelText,antDbAntModelField);
        type(antFreqText,antDbFrequencyField);
        click(antDbSearchButton);
    }

    /**
     * Method takes in search strings and enters in to search field and executes the search
     * @param row
     * @param antCode
     * @param antCompany
     * @param antModelFamily
     * @param antModel
     * @param antPol
     * @param antFrequency
     */
    public void antennaDataSearchResult1(int row, String antCode,String antCompany,String antModelFamily,String antModel,String antPol,String antFrequency){
        assertTrue(isDisplayed(antCodeListResult,5));
        String rawAntCode = getTextPlural(antDbAntCodeResult,row);
        String antCodeValue = rawAntCode.substring(0,6);
        assertEquals(antCode,antCodeValue);
        assertTrue(isDisplayed(antDbAntCompanyResult,5));
        String antCompanyValue = getTextPlural(antDbAntCompanyResult,row);
        assertEquals(antCompany,antCompanyValue);
        assertTrue(isDisplayed(antDbAntModelFamilyResult,5));
        String antModelFamilyValue = getTextPlural(antDbAntModelFamilyResult,row);
        assertEquals(antModelFamily,antModelFamilyValue);
        assertTrue(isDisplayed(antDbAntModelResult,5));
        String antModelValue = getTextPlural(antDbAntModelResult,row);
        assertEquals(antModel,antModelValue);
        assertTrue(isDisplayed(antDbAntPolResult,5));
        String antPolValue = getTextPlural(antDbAntPolResult,row);
        assertEquals(antPol,antPolValue);
        assertTrue(isDisplayed(antDbAntFreqResult,5));
        String antFrequencyValue = getTextPlural(antDbAntFreqResult,row);
        assertEquals(antFrequency,antFrequencyValue);
    }

    /**
     * Method takes in search strings and enters in to search field and executes the search
     * @param row
     * @param antGain
     * @param ant3dBBW
     * @param antDiameter
     * @param antCompliance
     * @param antRPE
     * @param antPatternDate
     */
    public void antennaDataSearchResult2(int row, String antGain,String ant3dBBW,String antDiameter,String antCompliance,String antRPE,String antPatternDate){
        assertTrue(isDisplayed(antDbAntGainResult,5));
        String antGainValue = getTextPlural(antDbAntGainResult,row);
        assertEquals(antGain,antGainValue);
        assertTrue(isDisplayed(antDbAnt3dBBWResult,5));
        String ant3dBBWValue = getTextPlural(antDbAnt3dBBWResult,row);
        assertEquals(ant3dBBW,ant3dBBWValue);
        assertTrue(isDisplayed(antDbAntDiameterResult,5));
        String antDiameterValue = getTextPlural(antDbAntDiameterResult,row);
        assertEquals(antDiameter,antDiameterValue);
        assertTrue(isDisplayed(antDbAntComplianceResult,5));
        String antComplianceValue = getTextPlural(antDbAntComplianceResult,row);
        assertEquals(antCompliance,antComplianceValue);
        assertTrue(isDisplayed(antDbAntRPEResult,5));
        String antRPEValue = getTextPlural(antDbAntRPEResult,row);
        assertEquals(antRPE,antRPEValue);
        assertTrue(isDisplayed(antDbAntPatternDateResult,5));
        String antPatternDateValue = getTextPlural(antDbAntPatternDateResult,row);
        assertEquals(antPatternDate,antPatternDateValue);
    }

    /**
     * Method loops though a list of antennas and validates that the value passed via the parameter is represented for the given column
     * @param antCompany
     */
    public void companyRowVal(String antCompany) {
        int rows = getRows(antDbAntCompanyResult);
        for (int i = 0; i < rows; i++){
             assertTrue(isDisplayed(antDbAntCompanyResult, 5));
             String antCompanyValue = getTextPlural(antDbAntCompanyResult, rows - 1);
             assertEquals(antCompany, antCompanyValue);}

    }

    /**
     * Method loops though a list of antennas and validates that the value passed via the parameter is represented for the given column
     * @param antModelFamily
     */
    public void companyFamilyRowVal(String antModelFamily) {
        int rows = getRows(antDbAntModelFamilyResult);
        for (int i = 0; i < rows; i++) {
             assertTrue(isDisplayed(antDbAntModelFamilyResult,5));
             String antModelFamilyValue = getTextPlural(antDbAntModelFamilyResult,i);
             assertEquals(antModelFamily,antModelFamilyValue);
        }

    }

    /**
     * Method loops though a list of antennas and validates that the value passed via the parameter is represented for the given column
     * @param low
     * @param high
     */
    public void companyFreqRowVal(int low, int high) {
        int rows = getRows(antDbAntFreqResult);
        for (int i = 0; i < rows; i++) {
            assertTrue(isDisplayed(antDbAntFreqResult,5));
            String antFreqValue = getTextPlural(antDbAntFreqResult,i);
            int numLow = NumberUtils.toInt(antFreqValue.substring(0,3));
            int numHigh = NumberUtils.toInt(antFreqValue.substring(6));
            assertTrue(numLow <=  low);
            assertTrue(numHigh <=  high);}
    }


    /**
     * Selects the Left Radio dialon Antenna Database
     */
    public void selectLF() {
        slowDown(3);
        click(antDbAntModelLeftRadioDial);
    }

    /**
     * vaildates that the correct status is displayed for all search results
     */
    public void antennaDataActiveStatusResult(){
        int rows = getRows(antDbAntStatusResultGreeen);
        for (int i = 0; i < rows; i++) {
            isDisplayed(antDbAntStatusResultGreeen,5);
            assertTrue(isDisplayedArray(antDbAntStatusResultGreeen, i));
        }
    }

    /**
     * vaildates that the correct status is displayed for all search results
     */
    public void antennaDataObsoleteStatusResult(){
        int rows = getRows(antDbAntStatusResultOrange);
        for (int i = 0; i < rows; i++) {
            isDisplayed(antDbAntStatusResultOrange,5);
            assertTrue(isDisplayedArray(antDbAntStatusResultOrange, i));
        }
    }

    /**
     * vaildates that the correct status is displayed for all search results
     */
    public void antennaDataInvalidStatusResult(){
        int rows = getRows(antDbAntStatusResultRed);
        for (int i = 0; i < rows; i++) {
            isDisplayed(antDbAntStatusResultRed,5);
            assertTrue(isDisplayedArray(antDbAntStatusResultRed, i));
        }
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antCode
     * @param row
     */
    public void antennaDataSearchResult(String antCode, int row){
        assertTrue(isDisplayed(antCodeListResult,5));
        String rawAntCode = getTextPlural(antDbAntCodeResult,row);
        String antCodeValue = rawAntCode.substring(0,6);
        assertEquals(antCode,antCodeValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antCompany
     * @param row
     */
    public void antennaDataBaseCompanySearchResult(String antCompany,int row){
        assertTrue(isDisplayed(antDbAntCompanyResult,5));
        String antCompanyValue = getTextPlural(antDbAntCompanyResult,row);
        assertEquals(antCompany,antCompanyValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antModelFamily
     * @param row
     */
    public void antennaDataBaseModelFamilySearchResult(String antModelFamily,int row){
        assertTrue(isDisplayed(antDbAntModelFamilyResult,5));
        String antModelFamilyValue = getTextPlural(antDbAntModelFamilyResult,row);
        assertEquals(antModelFamily,antModelFamilyValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antModel
     * @param row
     */
    public void antennaDataBaseModelSearchResult(String antModel,int row){
        assertTrue(isDisplayed(antDbAntModelResult,5));
        String antModelValue = getTextPlural(antDbAntModelResult,row);
        assertEquals(antModel,antModelValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antPol
     * @param row
     */
    public void antennaDataBasePolSearchResult(String antPol,int row){
        assertTrue(isDisplayed(antDbAntPolResult,5));
        String antPolValue = getTextPlural(antDbAntPolResult,row);
        assertEquals(antPol,antPolValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antFrequency
     * @param row
     */
    public void antennaDataBaseFrequencySearchResult(String antFrequency,int row){
        assertTrue(isDisplayed(antDbAntFreqResult,5));
        String antFrequencyValue = getTextPlural(antDbAntFreqResult,row);
        assertEquals(antFrequency,antFrequencyValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antGain
     * @param row
     */
    public void antennaDataBaseGainSearchResult(String antGain,int row){
        assertTrue(isDisplayed(antDbAntGainResult,5));
        String antGainValue = getTextPlural(antDbAntGainResult,row);
        assertEquals(antGain,antGainValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param ant3dBBW
     * @param row
     */
    public void antennaDataBase3dBBWSearchResult(String ant3dBBW,int row){
        assertTrue(isDisplayed(antDbAnt3dBBWResult,5));
        String ant3dBBWValue = getTextPlural(antDbAnt3dBBWResult,row);
        assertEquals(ant3dBBW,ant3dBBWValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antDiameter
     * @param row
     */
    public void antennaDataBaseDiameterSearchResult(String antDiameter,int row){
        assertTrue(isDisplayed(antDbAntDiameterResult,5));
        String antDiameterValue = getTextPlural(antDbAntDiameterResult,row);
        assertEquals(antDiameter,antDiameterValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antCompliance
     * @param row
     */
    public void antennaDataBaseComplianceSearchResult(String antCompliance,int row){
        assertTrue(isDisplayed(antDbAntComplianceResult,5));
        String antComplianceValue = getTextPlural(antDbAntComplianceResult,row);
        assertEquals(antCompliance,antComplianceValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antRPE
     * @param row
     */
    public void antennaDataBaseRPESearchResult(String antRPE,int row){
        assertTrue(isDisplayed(antDbAntRPEResult,5));
        String antRPEValue = getTextPlural(antDbAntRPEResult,row);
        assertEquals(antRPE,antRPEValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antPatternDate
     * @param row
     */
    public void antennaDataBasePatternDateSearchResult(String antPatternDate,int row){
        assertTrue(isDisplayed(antDbAntPatternDateResult,5));
        String antPatternDateValue = getTextPlural(antDbAntPatternDateResult,row);
        assertEquals(antPatternDate,antPatternDateValue);
    }


}
