package CommPageObjects;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

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

    By manufaturerFieldSuggestion = By.xpath("//*[contains(@id, 'antenna-details-antenna-company-suggestion-')]");//antenna-details-antenna-company-suggestion-Commscope
    By modelFamilyFieldSuggestion = By.xpath("//*[contains(@id, 'antenna-details-antenna-model-family-suggestion-')]");//antenna-details-antenna-company-suggestion-Commscope
    By modelFamilyFieldSuggestionCommscopeFamily = By.xpath("//*[contains(@id, 'antenna-db-search-antenna-model-family-suggestion-')and contains(text(), 'Commscope Family')]");//antenna-details-antenna-company-suggestion-Commscope

    //By.xpath( "//li[contains(text(), 'Second')]" )
    //antenna-details-front-to-back-error-message
    By basicInforStatusGreen = By.cssSelector(".database-search-status-icon.margin-left-1.bg-green");
    By basicInforStatusYellow = By.cssSelector(".database-search-status-icon.margin-left-1.bg-yellow");
    By basicInforStatusRed = By.cssSelector(".database-search-status-icon.margin-left-1.bg-red");
    By selMeter = By.id("antenna-details-diameter-unit-SI-label-bottom");
    By selFeet = By.id("antenna-details-diameter-unit-US-label-bottom");
    By modelFamilyFieldError = By.id("antenna-details-antenna-model-error-message");

    //Headings
    By radioImage = By.id("path-details-section-header-radio-icon");

    //Buttons
    By dataBaseManagementButton = By.id("database-management-link");
    By antennaDataBaseLink = By.id("antenna-database-summary-link");
    By antennaPlaceHolder = By.xpath("//*[@id=\"app\"]/div/div/div");
    By createAntButton = By.cssSelector(".btn.search-button.big-button.bg-blue");

    By saveAntenna = By.cssSelector(".heading-font.btn.btn-md.hover-inverse.bg-green");
    By associatedAntCodeLookUpButton = By.id("antenna-details-lookup-trigger");

    By antDbAdvancedDiameterUnitSIButton = By.id("antenna-db-search-create");
    By antDbAdvancedDiameterUnitUSButton = By.id("antenna-db-search-create");

    By antDbCreateButton = By.id("antenna-db-search-create");
    By antDbSearchButton = By.id("antenna-db-search-submit");
    By antDbExportButton = By.cssSelector(".btn.search-button.big-button.bg-grey-dark.false");



    By antDbAntModelLeftRadioDial = By.id("project-summary-settings-unit-LF-label-bottom");
    By antDbAntModelRightRadioDial = By.id("project-summary-settings-unit-RF-label-bottom");
    By antDbAntModelAnyRadioDial = By.id("project-summary-settings-unit-(none)-label-bottom");

    By antDbAdvancedSearchLink = By.xpath("//*[@id=\"antenna-db-search\"]/div[1]/div/label/span");
    By antDbDiscriminationCalcLink = By.cssSelector(".disc-calc-modal-trigger.pointer");
    By antDbDiscriminationCalcButton = By.cssSelector(".disc-calc-btn.btn.btn-sm.bg-blue");
    By antDbDiscriminationCalcCloseXButton = By.id("disc-calc-modal-close");


    //Drop down options
    //Path Entry Fields - Able to use the type method
    By antDbAntCodeField = By.id("antenna-db-search-antenna-code");
    By antDbAntCompanyField = By.id("antenna-db-search-antenna-company");
    By antDbModelFamilyField = By.id("antenna-db-search-antenna-model-family");
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
    By antDbDiscriminationCalcField = By.id("discrimination-calculator-discrimination-angle");
    By lookUpAntennaCode = By.id("antenna-lookup-antenna-code");
    By lookUpSearchButton = By.id("antenna-lookup-submit");
    By antResultListItem = By.xpath("//*[contains(@id, 'antenna-lookup-modal-table-data-antennaCode-') and contains(@id, 'antenna-lookup-modal-table-data-antennaCode-')]");

    By copyPatterns = By.cssSelector(".fa.fa-files-o");
    By commentsIcon = By.className("new-comment-trigger");
    By commentsField = By.id("db-details-comments-comment");
    By saveCommentsButton = By.cssSelector(".btn.btn-sm.bg-green.hover-inverse.margin-top-1");
    By commentsListItem = By.id("antenna-details-comments-table-data-antennaSpecCommentId-1-comment");
    By firstAntField = By.id ("antenna-details-patterns[VV][0]-angle");
    By deletePaternButton = By.cssSelector(".btn.btn-sm.hover-inverse.bg-white.btn-border.text-blue-dark");
    By angleFieldValue = By.xpath("//*[contains(@id, 'antenna-details-patterns[VV][') and contains(@id, ']-angle')]");
    By discriminationFieldValue = By.xpath("//*[contains(@id, 'antenna-details-patterns[VV][') and contains(@id, ']-discrimination')]");
    By flipPatternButton = By.cssSelector(".btn.btn-sm.bg-blue.hover-inverse");
    By flipWarning= By.className("padding-left-half");
    By flipWarningButton= By.cssSelector(".btn.btn-md.bg-blue.margin-top-1.heading-font.hover-inverse.display-inline-block");

    By commentRow = By.xpath("//*[contains(@id, 'antenna-details-comments-table-data-antennaSpecCommentId-') and contains(@id, '-comment')]");

    /**
     * This method takes in a string to compare the comment to the actual comment field value
     * @param CommentTitle
     */
    public void evaluateComments(String CommentTitle){
        assertTrue(isDisplayed(commentRow,1));
        isDisplayedArray(commentRow,1);
        String comment = getText(commentRow);
        assertEquals(CommentTitle, comment);
    }

    /**
     * This method will flip the pattern and interact with the warning message
     */
    public void submitFlipPattern(){
        assertTrue(isDisplayed(flipPatternButton,5));
        clickJS(flipPatternButton);
        assertTrue(isDisplayed(flipWarning,5));
        assertTrue(isDisplayed(flipWarningButton,5));
        clickJS(flipWarningButton);
    }

    /**
     * Takes an integer that selects the row, also discrimination and angle string values for comparison to actual field values
     * @param patRow
     * @param angle
     * @param discrimination
     */
    public void valPattern(int patRow, String angle, String discrimination){
        String angleVal = getFieldTextPlural(angleFieldValue, patRow);
        String discriminationVal = getFieldTextPlural(discriminationFieldValue, patRow);

        assertEquals(angle, angleVal);
        assertEquals(discrimination,discriminationVal);

    }


    /**
     * Opens the comments tool
     */
    public void openComments(){
        clickJS(commentsIcon);
        assertTrue(isDisplayed(commentsField,6));
    }

    /**
     * Takes the copied pattern (String)and enters it into the given location
     * @param pattern
     */
    public void enterPaternInComments(String pattern){
        assertTrue(isDisplayed(commentsField,6));
        type(pattern,commentsField);

    }

    /**
     * copies a given pattern into systems clipboard
     */
    public void copyPatternText(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        clipboard.setContents(new StringSelection(find(commentsField).getAttribute("value")), null);
    }

    /**
     * Save the comment
     */
    public void saveComments(){
        assertTrue(isDisplayed(saveCommentsButton,2));
        click(saveCommentsButton);
        assertTrue(isDisplayed(commentsListItem));
    }

    /**
     * selects the copy button
     */
    public void copyPattern(){
        assertTrue(isDisplayed(copyPatterns,4));
        clickJS(copyPatterns);
        slowDown(2);
    }

    /**
     * Highlights the first cell and pastes the pattern
     */
    public void pastePattern(){
        pasteText(firstAntField);
    }

    /**
     * Selects the resulting Antenna row
     * @param row
     */
    public void selectAntennaRow(int row){
        assertTrue(isDisplayed(antCodeListResult,5));
        clickJS(antCodeListResult,row);
        assertTrue(isDisplayed(antDbbasicInformationAntennaCode,5));
        slowDown(2);
    }

    /**
     * clears the content of a pattern
     */
    public void clearPattern(){
        slowDown(6);
        clickJS(deletePaternButton);
        slowDown(6);
    }

    public void selectPolarizedEntryFromAntennaDatabase(String antPolarizedText){
        selectFromDropdown(antDbbasicInformationPolarized,antPolarizedText);
    }

    /**
     * validates associated antenna text
     * @param antCodeTextA
     * @param antCodeTextB
     */
    public void associateAntennaCode(String antCodeTextA, String antCodeTextB ){
        isDisplayed(antDbbasicInformationAntennaCode,30);
        clear(antDbbasicInformationAntennaCode);
        type(antCodeTextA,antDbbasicInformationAntennaCode);
        clear(antDbbasicInformationAntennaCode);
        clear(antDbbasicInformationAssociatedAntennaCode);
        clickJS(associatedAntCodeLookUpButton);
        isDisplayed(lookUpAntennaCode,6);
        clear(lookUpAntennaCode);
        type(antCodeTextB,lookUpAntennaCode);
        clickJS(lookUpSearchButton);
        isDisplayed(antResultListItem,8);
        clickJS(antResultListItem);
    }



    public void evaluateFieldValue(String field){
        String fieldValue = getFieldText(antDbbasicInformationClassification);
        assertEquals(field,fieldValue);
    }

    public void evaluateAntennaDatabaseModelFamilyError(String err){
        type("1",antDbTechnicalInformationLowFrequency);
        clickJS(antDbTechnicalInformationLowFrequency);
        assertTrue(isDisplayed(modelFamilyFieldError,5));
        String getErr = getText(modelFamilyFieldError);
        assertEquals(err,getErr);
    }


    public void submitModelFamilyAntennaDatabaseEntry(String antModFamText){
        isDisplayed(antDbbasicInformationAntennaModel,20);
        type(antModFamText, antDbbasicInformationAntennaModel);

    }

    public void evaluateModelFamilySuggestionListDatabaseBasicInformation(String antModelFamilyText, String isModelFamilySuggestion){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        clear(antDbbasicInformationModelFamily);
        clear(antDbbasicInformationModelFamily);
        waitForFieldText("",antDbbasicInformationModelFamily);
        type(antModelFamilyText, antDbbasicInformationModelFamily);
        slowDown(3);
        isDisplayed(modelFamilyFieldSuggestion,20);
        String getSuggestion = getText(modelFamilyFieldSuggestion);
        assertEquals(getSuggestion, isModelFamilySuggestion);
    }

    public void evaluateAntennaManufacturerSuggestionDatabaseBasicInformation(String antManufacturerText, String isManufacturerSuggestion){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        clear(antDbbasicInformationCompany);
        type(antManufacturerText, antDbbasicInformationCompany);
        String getSuggestion = getText(manufaturerFieldSuggestion);//antenna-details-antenna-company-suggestion-Commscope
        assertEquals(getSuggestion, isManufacturerSuggestion);
    }

    public void enterDiscriminationAngle(String discriminationAngleValue){
        assertTrue("antDbDiscriminationCalcLink did not appear",isDisplayed(antDbDiscriminationCalcLink,3));
        click(antDbDiscriminationCalcLink);
        assertTrue("antDbDiscriminationCalcButton did not appear",isDisplayed(antDbDiscriminationCalcButton,3));
        type(discriminationAngleValue,antDbDiscriminationCalcField);
        click(antDbDiscriminationCalcButton);
        slowDown(3);
        DealWithTheAlert();
    }
    public void closeDiscriminationAngleForm(){
        assertTrue(isDisplayed(antDbDiscriminationCalcCloseXButton,6));
    clickJS(antDbDiscriminationCalcCloseXButton,0);
    waitUntilNotPresent(antDbDiscriminationCalcCloseXButton,10);

    };
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
        isDisplayed(selFeet,3);
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
    public void evaluateErrorTextOnTechnicalInformation(String errLowFrequencyTxt, String errHighFrequencyTxt, String errMainbeamGainTxt, String errDiameterTxt, String err3dBeamwidthTxt, String errFrontToBackRadioTxt){
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
    public void evaluateErrorUniqueness(String errTxt){
        isDisplayed(errorUniqueAntCode);
        String errTxtMsg = getText(errorUniqueAntCode);
        assertEquals(errTxtMsg,errTxt);
    }

    /**
    * Method is designed to click away from a field to allow blurring
    */
    public void blurAntennaDatabase(){
        isDisplayed(antDbTechnicalInformationLowFrequency,10);
        click(antDbTechnicalInformationLowFrequency);
    }

    /**
     * Method is designed to click away from a field to allow blurring
     */
    public void blurTechAntennaDatabase(){
        isDisplayed(antDbbasicInformationCompany,10);
        click(antDbbasicInformationCompany);
    }

    /**
     * Method enterstext into earth station fields by passing strings  via parameters
     * @param antDbbasicInformationSubreflectorText
     * @param antDbbasicInformationFeedFlangeText
     */
    public void enterAntennaDatabaseEarthStationFieldValues(String antDbbasicInformationSubreflectorText, String antDbbasicInformationFeedFlangeText){
        isDisplayed(antDbbasicInformationSubreflectorDiameter,20);
        type(antDbbasicInformationSubreflectorText,antDbbasicInformationSubreflectorDiameter);
        type(antDbbasicInformationFeedFlangeText,antDbbasicInformationFeedFlangeDiameter);
    }

    /**
     * Method enters text into Reg Infomation fields by passing strings  via parameters
     * @param regInfoApplicationText
     * @param regInfoFCCComplianceText
     */
    public void enterAntennaDatabaseRegInformationEntry(String regInfoApplicationText, String regInfoFCCComplianceText){
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
    public void enterAntennaDatabTechnicalInformationEntry(String techInfoLowFreqText, String techInfoHighFreqText, String techInfoMainbeamGainText, String techInfoDiameterText, String techInfo3dBeamwidthText, String techInfoFrontToBackRadioText ){
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
    public void selectAntennaDatabaseBasicInformationChangeStatus(String antStatusText){
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
    public void enterAntennaDatabaseBasicInformationEntry(String antCodeText, String antCompanyText, String antModFamText, String antModText, String antClassificationText, String antAssociatedAntennaCodeText, String antPolarizedText, String antStatusText){
        isDisplayed(antDbbasicInformationAntennaCode,20);
        clear( antDbbasicInformationAntennaCode);
        clear( antDbbasicInformationCompany);
        clear( antDbbasicInformationModelFamily);
        clear( antDbbasicInformationAntennaModel);
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
    public void evaluateAntennaCodeError(){
        assertTrue(isDisplayed(antDbbasicInformationAntCodeError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void evaluateAntennaCompanyError(){
        assertTrue(isDisplayed(antDbbasicInformationCompanyError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void evaluateAntennaModelError(){
        assertTrue(isDisplayed(antDbbasicInformationAntModelError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void evaluateAntennaClassificationError(){
        assertTrue(isDisplayed(antDbbasicInformationClassificationError,5));
    }
    /**
     * This method verifies if an error is present
     */
    public void evaluateAntennaStatusError(){
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
    public void evaluateAntennaDatabaseRegInformation(String regInfoApplicationText, String regInfoFCCComplianceText){
        isDisplayed(antDbbasicInformationAntennaCode,20);

        String regInfoApplication = getFieldText(antDbbasicInformationApplication);
        String regInfoFCCCompliance = getFieldText(antDbbasicInformationFCCCompliance);

        if(browser.equals("firefox")){
            //TODO FIX DROPDOWNS
        }else {
        assertEquals(regInfoApplicationText,regInfoApplication);
        assertEquals(regInfoFCCComplianceText,regInfoFCCCompliance);
        }
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
    public void evaluateAntennaDatabaseTechecnicalInformation(String techInfoLowFreqText, String techInfoHighFreqText, String techInfoMainbeamGainText, String techInfoDiameterText, String techInfo3dBeamwidthText, String techInfoFrontToBackRadioText ){
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
    public void submitAdvanceSearch(String statusText, String gainText, String applicationText, String diameterText, String rPEText, String classificationText, String search3dbBeamwidthFieldText, String fCCComplianceFieldText ){
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
    public void searchAntennaDatabase(String antCodeText, String antCompanyText, String antModelFamilyText, String antModelText, String antFreqText){
        assertTrue(isDisplayed(antDbAntCodeField,5));
        type(antCodeText,antDbAntCodeField);
        type(antCompanyText,antDbAntCompanyField);
        type(antModelFamilyText,antDbModelFamilyField);
        type(antModelText,antDbAntModelField);
        type(antFreqText,antDbFrequencyField);
        click(antDbSearchButton);
    }

    /**
     * Method takes in search strings and enters in to search field and executes the search then selects suggested by text
     * @param antCodeText
     * @param antCompanyText
     * @param antModelFamilyText
     * @param antModelText
     * @param antFreqText
     */
    public void submitAntennaDataBaseSearch(String antCodeText, String antCompanyText, String antModelFamilyText, String antModelText, String antFreqText){
        assertTrue(isDisplayed(antDbAntCodeField,5));
        type(antCodeText,antDbAntCodeField);
        type(antCompanyText,antDbAntCompanyField);
        type(antModelFamilyText,antDbModelFamilyField);
        assertTrue(isDisplayed(modelFamilyFieldSuggestionCommscopeFamily,10));
        click(modelFamilyFieldSuggestionCommscopeFamily,0);
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
    public void evaluateAntennaDataSearchResult1(int row, String antCode, String antCompany, String antModelFamily, String antModel, String antPol, String antFrequency){
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
    public void evaluateAntennaDataSearchResult2(int row, String antGain, String ant3dBBW, String antDiameter, String antCompliance, String antRPE, String antPatternDate){
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
    public void evaluateCompanyRow(String antCompany) {
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
    public void evaluateCompanyFamilyRow(String antModelFamily) {
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
    public void evaluateCompanyFreqRow(int low, int high) {
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
    public void selectsLeftRadioDialAntennaDatabase() {
        slowDown(3);
        click(antDbAntModelLeftRadioDial);
    }

    /**
     * vaildates that the correct status is displayed for all search results
     */
    public void evaluateAntennaDataActiveStatusResults(){
        int rows = getRows(antDbAntStatusResultGreeen);
        for (int i = 0; i < rows; i++) {
            isDisplayed(antDbAntStatusResultGreeen,5);
            assertTrue(isDisplayedArray(antDbAntStatusResultGreeen, i));
        }
    }

    /**
     * vaildates that the correct status is displayed for all search results
     */
    public void evaluateAntennaDataObsoleteStatusResults(){
        int rows = getRows(antDbAntStatusResultOrange);
        for (int i = 0; i < rows; i++) {
            isDisplayed(antDbAntStatusResultOrange,5);
            assertTrue(isDisplayedArray(antDbAntStatusResultOrange, i));
        }
    }

    /**
     * vaildates that the correct status is displayed for all search results
     */
    public void evaluateAntennaDataInvalidStatusResults(){
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
    public void evaluateAntennaDataSearchResults(String antCode, int row){
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
    public void evaluateAntennaDataBaseCompanySearchResults(String antCompany, int row){
        assertTrue(isDisplayed(antDbAntCompanyResult,5));
        String antCompanyValue = getTextPlural(antDbAntCompanyResult,row);
        assertEquals(antCompany,antCompanyValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antModelFamily
     * @param row
     */
    public void evaluateAntennaDataBaseModelFamilySearchResults(String antModelFamily, int row){
        assertTrue(isDisplayed(antDbAntModelFamilyResult,5));
        String antModelFamilyValue = getTextPlural(antDbAntModelFamilyResult,row);
        assertEquals(antModelFamily,antModelFamilyValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antModel
     * @param row
     */
    public void compareAntennaDatabaseModelSearchResults(String antModel, int row){
        assertTrue(isDisplayed(antDbAntModelResult,5));
        String antModelValue = getTextPlural(antDbAntModelResult,row);
        assertEquals(antModel,antModelValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antPol
     * @param row
     */
    public void evaluateAntennaDatabasePolSearchResults(String antPol, int row){
        assertTrue(isDisplayed(antDbAntPolResult,5));
        String antPolValue = getTextPlural(antDbAntPolResult,row);
        assertEquals(antPol,antPolValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antFrequency
     * @param row
     */
    public void evaluateAntennaDatabaseFrequencySearchResults(String antFrequency, int row){
        assertTrue(isDisplayed(antDbAntFreqResult,5));
        String antFrequencyValue = getTextPlural(antDbAntFreqResult,row);
        assertEquals(antFrequency,antFrequencyValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antGain
     * @param row
     */
    public void evaluateAntennaDatabaseGainSearchResults(String antGain, int row){
        assertTrue(isDisplayed(antDbAntGainResult,5));
        String antGainValue = getTextPlural(antDbAntGainResult,row);
        assertEquals(antGain,antGainValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param ant3dBBW
     * @param row
     */
    public void evaluateAntennaDataBase3dBBWSearchResults(String ant3dBBW, int row){
        assertTrue(isDisplayed(antDbAnt3dBBWResult,5));
        String ant3dBBWValue = getTextPlural(antDbAnt3dBBWResult,row);
        assertEquals(ant3dBBW,ant3dBBWValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antDiameter
     * @param row
     */
    public void evaluateAntennaDataBaseDiameterSearchResults(String antDiameter, int row){
        assertTrue(isDisplayed(antDbAntDiameterResult,5));
        String antDiameterValue = getTextPlural(antDbAntDiameterResult,row);
        assertEquals(antDiameter,antDiameterValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antCompliance
     * @param row
     */
    public void evaluateAntennaDataBaseComplianceSearchResults(String antCompliance, int row){
        assertTrue(isDisplayed(antDbAntComplianceResult,5));
        String antComplianceValue = getTextPlural(antDbAntComplianceResult,row);
        assertEquals(antCompliance,antComplianceValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antRPE
     * @param row
     */
    public void evaluateAntennaDataBaseRPESearchResults(String antRPE, int row){
        assertTrue(isDisplayed(antDbAntRPEResult,5));
        String antRPEValue = getTextPlural(antDbAntRPEResult,row);
        assertEquals(antRPE,antRPEValue);
    }

    /**
     * takes in the row array and comparitive text and validates that the actual field value matches
     * @param antPatternDate
     * @param row
     */
    public void evaluateAntennaDataBasePatternDateSearchResult(String antPatternDate, int row){
        assertTrue(isDisplayed(antDbAntPatternDateResult,5));
        String antPatternDateValue = getTextPlural(antDbAntPatternDateResult,row);
        assertEquals(antPatternDate,antPatternDateValue);
    }


}
