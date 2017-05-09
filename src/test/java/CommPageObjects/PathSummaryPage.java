package CommPageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathSummaryPage extends BasePage {

    //Path Headings
    By projectTitleName = By.xpath("//*[@class=\"project-summary-overview\"]/p[1]/span[2]");
    By projectTitle = By.className("project-summary-overview");
    By totalPathAmount = By.xpath("//*[@class=\"project-summary-overview\"]/p[3]/span[2]");
    By deleteConfirmationTitle = By.id("delete-paths-modal-success-heading");
    By deleteConfirmationSubText = By.id("delete-paths-modal-success-message");
    By headerLOSInactive = By.xpath("//*[@id='project-summary-sort-los' and @class='"+INACTIVE_POINTER+"']");
    By headerAvailabilityInactive = By.xpath("//*[@id='project-summary-sort-avail' and @class='"+INACTIVE_POINTER+"']");
    By headerValidationInactive = By.xpath("//*[@id='project-summary-sort-valid' and @class='"+INACTIVE_POINTER+"']");
    By headerLOSActive = By.xpath("//*[@id='project-summary-sort-los' and @class='"+DOWN_POINTER+"']");
    By headerAvailabilityActive = By.xpath("//*[@id='project-summary-sort-avail' and @class='"+DOWN_POINTER+"']");
    By headerValidationActive = By.xpath("//*[@id='project-summary-sort-valid' and @class='"+DOWN_POINTER+"']");
    By headerLOSValues1 = By.className("path-los-value");
    By headerAvailabilityValues = By.className("path-avail-value");
    By headerValidValues = By.className("path-valid-value");
    By deletePathPopupTitle = By.className("project-summary-modal");
    By siteHeader = By.cssSelector(".bg-blue-dark.padding-half.heading-font");

    //Path Buttons
    By searchButton = By.id("project-summary-filter-apply");
    By selectAllButton = By.cssSelector(".heading-font.btn.btn-md.btn-skinny.bg-white.btn-border.margin-left-1");
    By deselectAllButton = By.cssSelector(".heading-font.btn.btn-md.btn-skinny.bg-white.btn-border.margin-left-1");
    By SortNum = By.id("project-summary-sort-index");
    By SortBand = By.id("project-summary-sort-band");
    By SortPath = By.id("project-summary-sort-pathname");
    By actionArrow = By.cssSelector(".fa.fa-caret-down");
    By deleteButton = By.id("delete-paths-modal-delete-apply");
    By deletePathsButton = By.id("delete-paths-modal-delete-apply");
    By deselectPathForDeletion = By.xpath("//*[contains(@id,'project-summary-modal-remove-path-2')]");
    By hamburgerSettings = By.id("project-summary-settings-trigger");
    By uSUnit = By.xpath("//*[@id=\"project-summary-settings\"]/form/ul/li[1]/div/div/div[1]/label/p");
    By sIUnit = By.id("project-summary-settings-unit-SI-label-bottom");
    By showSiteLocationCheckBox = By.id("project-summary-settings-summary-display-show");
    //TODO the current Id is making tests flaky
    By closeSettings = By.xpath("//*[@id=\"project-summary-settings-trigger\"]/span");
    By saveButton = By.id("project-summary-settings-submit");
    By pathsNoFreqCheckBox = By.id("project-summary-filter-checkbox");
    //TODO need locator that will see the text of Show all check box under the filter box
    By pathsNoFreqCheckBoxText = By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/p[2]/label");
    By deselectSplitPath = By.xpath("//*[contains(@id,'project-summary-modal-remove-path')]");
    By splitProjectButton = By.xpath("//*[contains(@id,'project-summary-modal-split-project-apply')]");
    By pathDetailButton = By.id("project-summary-quick-add-path-details");
    By intraPathDetailButton = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-path-details-button')]");



    //Drop down options
    By deleteOptionForPath1 = By.id("path-menu-delete-0");
    //TODO refactor
    By copyOption = By.xpath("//*[@id=\"path-menu-0\"]/li[2]");
    By deletePopup = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
    By hamburgerDeletePaths = By.id("project-settings-delete-paths-modal-trigger");
    By hamburgerSplitPathsDisabled = By.xpath("//*[@id='project-settings-delete-paths-modal-trigger' and @class='disable-button']");
    By hamburgerSplitPathsEnabled = By.xpath("//*[@id='project-settings-split-project-modal-trigger']");

    //Path Entry Fields - Able to use the type method
    By targetAvailability = By.id("project-summary-settings-target-availability");
    By filterSelectionInput = By.id("project-summary-filter-input");
    By defaultLicenseeField = By.id("project-summary-settings-default-company");
    By fresnelZoneRadiusPercentField = By.id("project-summary-settings-freznel-zone-radius");
    By kFactorField = By.id("project-summary-settings-k-factor");
    By minClearence = By.id("project-summary-settings-minimum-clearance");
    By fieldChange = By.xpath("//*[contains(@placeholder, 'Minimum Clearance (m)')]");
    By splitProjectModalNewProjectNameField = By.id("split-project-project-name");//split-project-project-name


    //Path hovers -- Able to use the hover method
    By passiveRepeaterIcon = By.xpath("//*[contains(@id, 'passive-repeater-tooltip-path')]");
    By siteLocationIcon = By.id("site-tooltip-trigger-path-0-site-2");
    By siteLocationIcon1 = By.id("site-tooltip-trigger-path");
    By hoverSite = By.cssSelector(".__react_component_tooltip.place-bottom.type-light.project-summary-tooltip");

    //Path Data Fields - Element is read only and can use getFieldText method
    By licenseeName = By.xpath("//*[@class=\"project-summary-overview\"]/p[2]/span[2]");
    By passiveRepeaterHoverSiteNameField = By.xpath("//*[text() = 'Site Name' and @class = 'uppercase']");
    By passiveRepeaterHoverLatitudeField = By.xpath("//*[text() = 'Latitude' and @class = 'uppercase']");
    By passiveRepeaterHoverLongitudeField = By.xpath("//*[text() = 'Longitude' and @class = 'uppercase']");
    By passiveRepeaterHoverAntennaField = By.xpath("//*[text() = 'Antennas' and @class = 'uppercase']");
    By bandValue = By.cssSelector(".pull-right");
    By pathName1 = By.xpath("//*[@id=\"" + PROJECT_ROW + "0\"]/td[1]/div/div[1]/span[2]");
    By pathName2 = By.xpath("//*[@id=\"" + PROJECT_ROW + "1\"]/td[1]/div/div[1]/span[2]");
    By pathName3 = By.xpath("//*[@id=\"" + PROJECT_ROW + "2\"]/td[1]/div/div[1]/span[2]");
    By pathName4 = By.xpath("//*[@id=\"" + PROJECT_ROW + "3\"]/td[1]/div/div[1]/span[2]");
    By pathName5 = By.xpath("//*[@id=\"" + PROJECT_ROW + "4\"]/td[1]/div/div[1]/span[2]");
    By allPaths = By.xpath("//*[contains(@id, 'project-summary-path-row')]");
    By allPathsNew = By.className("path-name-value");
    By pathsSelectedByArray = By.xpath("//*[@class='path-info-td td-border-transparent selected']");
    By deleteCandidate = By.tagName("td");//Need more specific locator
    By paths = By.className("pull-left");
    By groundElevation = By.xpath("//*[contains(@title, 'Ground Elevation')]");
    By warnFresnelZoneRadius = By.className("error-message");
    //TODO need locator for TOTAL PATHS count #
    By totalPathsCount = By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[1]/p[3]/span[2]");
    By minimumClearance = By.id("project-summary-settings-minimum-clearance-label");
    By remainingDeletePaths = By.xpath("//*[contains(@id, 'project-summary-modal-path-')]");
    By remainingSlipPaths = By.xpath("//*[contains(@id, 'project-summary-modal-path-')]");
    By splitProjectModalTitle = By.xpath("//*[text() = 'Split Project' and @class = 'uppercase']");
    By splitProjectModalSubTitle = By.xpath("//*[text() = 'Move selected Paths to a New Project.' and @class = 'padding-top-1']");
    By pathDetailSiteNameField1 = By.id("path-details-site[0]siteName");



    //Path DropDown Fields -- Does it contain a list that has options that can be selected
    By filterSelection = By.id("project-summary-filter-select");
    By hamburgerDropDownInactive = By.xpath("//*[@id='project-summary-menu-toggle' and @class='pull-right pointer ']");
    By hamburgerDropDownActive = By.xpath("//*[@id='project-summary-menu-toggle' and @class='pointer pull-right active']");

    //Index List -- Can you used an array to select item
    By pathNameIndexValue = By.className("path-name-value");
    By pathNumberIndexValue = By.cssSelector(".path-index-value");
    By pathModValue = By.cssSelector(".tooltip-trigger-decoration.show-decoration.acm-tooltip-decoration.uppercase");
    By pathDetailsIndex = By.cssSelector(".path-details-button.pointer");
    By pathSiteIndex = By.id("path-2-site-1-siteName");
    By site1 = By.id("quick-add-site[0]siteName");
    By site2 = By.id("quick-add-site[1]siteName");
    By siteName1 = By.xpath(""+PATH_VAL+" '-site-1-siteName')]");
    By siteName2 = By.xpath(""+PATH_VAL+" '-site-2-siteName')]");


    By pathSiteIndex1 = By.xpath(""+PATH_VAL+" '-site-1-siteName')]");
    By pathSiteIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-siteName')]");
    By pathBandValueIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-bandwidth')]");
    By pathBandValueIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-bandwidth')]");
    By pathCallsignValueIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-callsign')]");
    By pathCallsignValueIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-callsign')]");

    By pathLatitudeValueIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-lat')]");
    By pathLatitudeValueIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-lat')]");
    By pathLongitudeValueIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-long')]");
    By pathLongitudeValueIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-long')]");
    By pathGroundElevationValueIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-ge')]");
    By pathGroundElevationValueIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-ge')]");
    By pathAntennaValueIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-antenna')]");
    By pathAntennaValueIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-antenna')]");
    By pathDiversityToolTipIndex1 = By.xpath("//*[contains(@id, 'diversity-tooltip-trigger-path-') and contains(@id, '-site-1')]");
    By pathDiversityToolTipIndex2 = By.xpath("//*[contains(@id, 'diversity-tooltip-trigger-path-') and contains(@id, '-site-2')]");
    By pathACMIndex1 = By.xpath("//*[contains(@id, 'acm-tooltip-trigger-path-') and contains(@id, '-site-1')]");
    By pathACMIndex2 = By.xpath("//*[contains(@id, 'acm-tooltip-trigger-path-') and contains(@id, '-site-2')]");
    By pathRadioIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-radio-summary')]");
    By pathRadioIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-radio-summary')]");
    By pathBandwidthIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-bandwidth')]");
    By pathBandwidthIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-bandwidth')]");
    By pathFreqIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-frequencies')]");
    By pathFreqIndex2 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-2-frequencies')]");
    By listNumPaths = By.xpath("//*[contains(@class, 'pull-left')]");
    By listNumBands = By.xpath("//*[contains(@class, 'path-band-value pull-right')]");
    By listNamePaths = By.cssSelector(".path-name-value.margin-right-auto");
    By allPathsNotSelected = By.xpath("//*[contains(@class, 'path-info-td td-border-transparent')]");
    By pathsToBeDeletedFromModal = By.xpath("//*[contains(@class,'delete-paths-modal-path')]");

    //Modal -- Does it pop up over current window
    By deleteConfirmation = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
    By deleteModal = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
    By deleteConfirmationNew = By.cssSelector(".display-flex.justify-content-center");
    By projectSettingsPanel = By.cssSelector(".active.project-summary-settings.bg-grey-gadient");
    By projectSettingsPanelNotClosed = By.cssSelector(".project-summary-settings.bg-grey-gadient");
    By splitProjectConfirmationModal = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
    By splitProjectConfirmationModalSubText = By.cssSelector(".padding-1");
    By stayInCurrentProjectButton = By.xpath("//*[@id=\"project-summary-modal-split-project\"]/div/div/button[1]/small");
    By goToNewProjectButton = By.xpath("//*[@id=\"project-summary-modal-split-project\"]/div/div/button[2]/small");
    By option =By.className("suggestion-element");



    public PathSummaryPage(WebDriver driver) {
        super(driver);
        visit("/");
    }
    public void openSettings()
    {
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project K Factor field is not present", isDisplayed(kFactorField, 10));
    }
    public void checkSiteSuggestionQuickAdd(String site1val, String site2val){
        assertTrue(isDisplayed(site1,20));
        assertTrue(isDisplayed(site2,20));
        type(site1val,site1);
        assertFalse(isDisplayed(option,8));
        type(site2val,site2);
        assertFalse(isDisplayed(option,8));
    }

    public void openPathDetailForAddingPath(){
        assertTrue(isDisplayed(pathDetailButton,8));
        click(pathDetailButton);
        assertTrue(isDisplayed(pathDetailSiteNameField1,8));

    }

    public void openPathDetails(int i) {
        isDisplayed(intraPathDetailButton,20);
        click(intraPathDetailButton,i);
        isDisplayed(pathDetailSiteNameField1,20);
    }

    public void openSettingMenuValDisabledSplitOption(){
        isDisplayed(hamburgerDropDownInactive,30);
        click(hamburgerDropDownInactive);
        isDisplayed(hamburgerSplitPathsDisabled,20);
        click(closeSettings);
    }

    public void selectCopyFromPath() {
        click(actionArrow);
        isDisplayed(deleteOptionForPath1,10);
        isDisplayed(copyOption,3);
        click(copyOption);
    }
    //TODO antenna section is not complete at the moment will revisit once implemented
    public void pathWithSameConfig_OneRadio(){
        String ant1;
        String ant2;
        String oneRadio;
        String displayedRadio;
        assertTrue("path Ant1 Value is not present",isDisplayed(pathAntennaValueIndex1,8));
        ant1 = getTextPlural(pathAntennaValueIndex1,2);
        ant2 = getTextPlural(pathAntennaValueIndex2,2);
        assertEquals(ant2, ant1);
        oneRadio =  getTextPlural(pathRadioIndex1,1);
        assertEquals(oneRadio,"");
        displayedRadio = getTextPlural(pathRadioIndex2,1);
        assertEquals(displayedRadio,"3fsd");
    }

    public boolean showAllPathsWithNoAssignedFrequencyBandsPresent(){
        return isDisplayed(pathsNoFreqCheckBox);
    }

    public boolean showAllPathsWithNoAssignedRadio(){
        return isDisplayed(pathsNoFreqCheckBox);
    }

    public String showAllCheckBoxText() {
        return getText(pathsNoFreqCheckBoxText);//
    }

    public void viewPathBlueSection(int rowIndex, String Name, String Num,String Mod,String Band,String Details){
        String rowOneName;
        String rowOneNum;
        String rowOneMod;
        String rowOneBand;
        String rowOneDetails;

        assertTrue("path Name Value is not present",isDisplayed(pathNameIndexValue,8));
        assertTrue("path Number Value is not present",isDisplayed(pathNumberIndexValue,8));
        assertTrue("path MOD Value is not present",isDisplayed(pathModValue,8));
        assertTrue("path band Value is not present",isDisplayed(bandValue,8));
        assertTrue("path detail Value is not present",isDisplayed(pathDetailsIndex,8));

        click(actionArrow);
        isDisplayed(deleteOptionForPath1,10);
        isDisplayed(copyOption,3);

        rowOneName = getTextPlural(pathNameIndexValue,rowIndex);
        rowOneNum = getTextPlural(pathNumberIndexValue,rowIndex);
        rowOneMod = getTextPlural(pathModValue,rowIndex);
        rowOneBand = getTextPlural(bandValue,rowIndex);
        rowOneDetails = getTextPlural(pathDetailsIndex,rowIndex);
        //hoverPassiveRepeaterValSiteInfo();TODO FeTURE NOT IMPLEMENTED YET

        assertEquals(rowOneName, Name);
        assertEquals(rowOneNum, Num);
        assertEquals(rowOneMod, Mod);
        assertEquals(rowOneBand, Band);
        assertEquals(rowOneDetails, Details);

    }

    public void splitProject(String projectName){
        assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPathsNew,10));
        click(allPathsNew,3);
        click(allPathsNew,4);
        click(allPathsNew,5);
        assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive,10));
        click(hamburgerDropDownInactive);
        assertTrue("Split Paths option is not present", isDisplayed(hamburgerSplitPathsEnabled,10));
        click(hamburgerSplitPathsEnabled);

        assertTrue(isDisplayed(splitProjectModalTitle,30));
        assertTrue(isDisplayed(splitProjectModalSubTitle,30));
        assertTrue(isDisplayed(splitProjectModalNewProjectNameField,30));
        assertTrue(isDisplayedArray(remainingSlipPaths,0));
        assertTrue(isDisplayedArray(remainingSlipPaths,1));
        assertTrue(isDisplayedArray(remainingSlipPaths,2));
        assertTrue(isDisplayedArray(deselectSplitPath,0));
        assertTrue(isDisplayedArray(deselectSplitPath,1));
        assertTrue(isDisplayedArray(deselectSplitPath,2));
        assertTrue(isDisplayed(splitProjectButton,10));

        type(projectName, splitProjectModalNewProjectNameField);
        click(splitProjectButton);

        assertTrue(isDisplayed(splitProjectConfirmationModal,30));//class="ReactModal__Content ReactModal__Content--after-open"
        //TODO update locators once Nemo updates
        assertTrue(isDisplayed(splitProjectConfirmationModalSubText,30));//class="padding-1"
        assertTrue(isDisplayed(stayInCurrentProjectButton,30));//class="display-flex justify-content-between"
        assertTrue(isDisplayed(goToNewProjectButton,30));//class="btn bg-green hover-inverse btn-md"
        click(goToNewProjectButton);

        String nameOfProject;
        isDisplayed(projectTitleName,20);
        nameOfProject = getText(projectTitleName);
        assertEquals("project name is not correct", nameOfProject, projectName);
    }
    public void splitProjectStay(String projectName){
        assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPathsNew,10));
        click(allPathsNew,3);
        click(allPathsNew,4);
        click(allPathsNew,5);
        assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive,10));
        click(hamburgerDropDownInactive);
        assertTrue("Split Paths option is not present", isDisplayed(hamburgerSplitPathsEnabled,10));
        click(hamburgerSplitPathsEnabled);

        assertTrue(isDisplayed(splitProjectModalTitle,30));
        assertTrue(isDisplayed(splitProjectModalSubTitle,30));
        assertTrue(isDisplayed(splitProjectModalNewProjectNameField,30));
        assertTrue(isDisplayedArray(remainingSlipPaths,0));
        assertTrue(isDisplayedArray(remainingSlipPaths,1));
        assertTrue(isDisplayedArray(remainingSlipPaths,2));
        assertTrue(isDisplayedArray(deselectSplitPath,0));
        assertTrue(isDisplayedArray(deselectSplitPath,1));
        assertTrue(isDisplayedArray(deselectSplitPath,2));
        assertTrue(isDisplayed(splitProjectButton,10));

        type(projectName, splitProjectModalNewProjectNameField);
        click(splitProjectButton);

        assertTrue(isDisplayed(splitProjectConfirmationModal,30));//class="ReactModal__Content ReactModal__Content--after-open"
        //TODO update locators once Nemo updates
        assertTrue(isDisplayed(splitProjectConfirmationModalSubText,30));//class="padding-1"
        assertTrue(isDisplayed(stayInCurrentProjectButton,30));//class="display-flex justify-content-between"
        assertTrue(isDisplayed(goToNewProjectButton,30));//class="btn bg-green hover-inverse btn-md"
        click(stayInCurrentProjectButton);

        String nameOfProject;
        isDisplayed(projectTitleName,20);
    }

    public void splitProjectStayAlt(String projectName){
        assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPathsNew,10));
        click(allPathsNew,0);
        assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive,10));
        click(hamburgerDropDownInactive);
        assertTrue("Split Paths option is not present", isDisplayed(hamburgerSplitPathsEnabled,10));
        click(hamburgerSplitPathsEnabled);

        assertTrue(isDisplayed(splitProjectModalTitle,30));
        assertTrue(isDisplayed(splitProjectModalNewProjectNameField,30));
        assertTrue(isDisplayedArray(remainingSlipPaths,0));
        assertTrue(isDisplayedArray(deselectSplitPath,0));
        assertTrue(isDisplayed(splitProjectButton,10));

        type(projectName, splitProjectModalNewProjectNameField);
        click(splitProjectButton);

        assertTrue(isDisplayed(splitProjectConfirmationModal,30));//class="ReactModal__Content ReactModal__Content--after-open"
        //TODO update locators once Nemo updates
        assertTrue(isDisplayed(splitProjectConfirmationModalSubText,30));//class="padding-1"
        assertTrue(isDisplayed(stayInCurrentProjectButton,30));//class="display-flex justify-content-between"
        assertTrue(isDisplayed(goToNewProjectButton,30));//class="btn bg-green hover-inverse btn-md"
        click(stayInCurrentProjectButton);

        String nameOfProject;
        isDisplayed(projectTitleName,20);
    }


    public void viewSiteCallSignLatLongGeColumns1(int rowIndex, String siteIndex, String callSign, String lat, String longi, String elev){
        String rowOneSite;
        String rowOneCallsign;
        String rowOneLatitude;
        String rowOneLongitude;
        String rowOneGroundElevation;

        slowDown(6);

        assertTrue("path Site Value is not present",isDisplayed(pathSiteIndex2,20));
        assertTrue("path Lat Value is not present",isDisplayed(pathLatitudeValueIndex2,8));
        assertTrue("path Long Value is not present",isDisplayed(pathLongitudeValueIndex2,8));
        assertTrue("path GE Value is not present",isDisplayed(pathGroundElevationValueIndex2,8));
        slowDown(4);

        rowOneSite = getTextPlural(pathSiteIndex1,rowIndex);
        rowOneCallsign = getTextPlural(pathCallsignValueIndex1,rowIndex);
        rowOneLatitude = getTextPlural(pathLatitudeValueIndex1,rowIndex);
        rowOneLongitude = getTextPlural(pathLongitudeValueIndex1,rowIndex);
        rowOneGroundElevation = getTextPlural(pathGroundElevationValueIndex1,rowIndex);

        slowDown(4);

        assertEquals(rowOneSite, siteIndex);
        assertEquals(rowOneCallsign, callSign);
        assertEquals(rowOneLatitude, lat);
        assertEquals(rowOneLongitude, longi);
        assertEquals(rowOneGroundElevation, elev);
    }

    public void viewSiteCallSignLatLongGeColumns2(int rowIndex, String siteIndex, String callSign, String lat, String longi, String elev){
        String rowOneSite;
        String rowOneCallsign;
        String rowOneLatitude;
        String rowOneLongitude;
        String rowOneGroundElevation;

        assertTrue("path Site Value is not present",isDisplayed(pathSiteIndex2,8));
        assertTrue("path Lat Value is not present",isDisplayed(pathLatitudeValueIndex2,8));
        assertTrue("path Long Value is not present",isDisplayed(pathLongitudeValueIndex2,8));
        assertTrue("path GE Value is not present",isDisplayed(pathGroundElevationValueIndex2,8));

        slowDown(5);
        rowOneSite = getTextPlural(pathSiteIndex1,rowIndex);
        rowOneCallsign = getTextPlural(pathCallsignValueIndex2,rowIndex);
        rowOneLatitude = getTextPlural(pathLatitudeValueIndex2,rowIndex);
        rowOneLongitude = getTextPlural(pathLongitudeValueIndex2,rowIndex);
        rowOneGroundElevation = getTextPlural(pathGroundElevationValueIndex2,rowIndex);

        assertEquals(rowOneSite, siteIndex);
        slowDown(5);
        assertEquals(rowOneCallsign, callSign);
        assertEquals(rowOneLatitude, lat);
        assertEquals(rowOneLongitude, longi);
        //assertEquals(rowOneGroundElevation, elev);
    }

    public void viewAntennaRadioBandwidthFreq(){
        String rowOneAntenna;
        String rowOneRadio;
        String rowOneBandwidth;
        String rowOneFreq;

        //assertTrue("path Antenna is not present",isDisplayed(pathAntennaValueIndex1,8));TODO feature not ready
        //assertTrue("path Radio is not present",isDisplayed(pathRadioIndex1,8));TODO feature not ready
        assertTrue("path Band is not present",isDisplayed(pathBandValueIndex1,8));
        assertTrue("path Freq is not present",isDisplayed(pathFreqIndex1,8));

        //rowOneAntenna = getTextPlural(pathAntennaValueIndex1,0);TODO feature not ready
        //rowOneRadio = getTextPlural(pathRadioIndex1,0);TODO feature not ready
        rowOneBandwidth = getTextPlural(pathBandValueIndex1,0);
        rowOneFreq = getTextPlural(pathFreqIndex1,0);

        //assertEquals(rowOneAntenna, "ZOOOOOANT");TODO feature not ready
        //assertEquals(rowOneRadio, "RAD5000\n" +TODO feature not ready
        //        "256 QAM - 128 QAM / Max 25.1 dBm");TODO feature not ready
        assertEquals(rowOneBandwidth, "");
        assertEquals(rowOneFreq, "0");
    }

    public void viewDiversityAntAmcPassFail(){
        String rowOneDiversityAntenna;
        String rowOneAcm;
        assertTrue("path Diversity Tool is not present",isDisplayed(pathDiversityToolTipIndex2,8));
        assertTrue("path ACM is not present",isDisplayed(pathACMIndex1,8));
        rowOneDiversityAntenna = getTextPlural(pathDiversityToolTipIndex2,0);
        rowOneAcm = getTextPlural(pathACMIndex1,0);
        assertEquals(rowOneDiversityAntenna, "D");
        assertEquals(rowOneAcm, "ACM");
        validatePresenceOfLOSAvailVal();
    }

    public void valKDefaultAvailabilityTargetSetting() {
        String a;
        String defaultTargetAvailability;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        slowDown(4);
        click(hamburgerDropDownInactive);
        slowDown(2);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 30));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
        defaultTargetAvailability = getFieldText(targetAvailability);
        assertEquals("The Target Avail default val is not correct", defaultTargetAvailability, "99.995");
        clear(targetAvailability);
        type("w", targetAvailability);

        assertTrue("saveButton not present", isDisplayed(saveButton, 10));
        click(saveButton);
        assertTrue(isDisplayed(warnFresnelZoneRadius,30));
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(targetAvailability);
        type("1001", targetAvailability);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 50 AND 100");

        clear(targetAvailability);
        type("-1001", targetAvailability);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 50 AND 100");

        clear(targetAvailability);
        type("100", targetAvailability);
        click(saveButton);
        slowDown(3);

        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 30));
        click(hamburgerDropDownInactive);
/*        if(isDisplayed(closeSettings,30)){
            isDisplayed(hamburgerDropDownInactive,30);
            click(hamburgerDropDownInactive);
            assertTrue("IF Settings menu option is not present", isDisplayed(hamburgerSettings, 30));
            click(hamburgerSettings);
            defaultTargetAvailability = getFieldText(targetAvailability);
            assertEquals("IF The Target Avail default val is not correct", "100",defaultTargetAvailability);

        }*/
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 30));
        click(hamburgerSettings);
        defaultTargetAvailability = getFieldText(targetAvailability);
        assertEquals("The Target Avail default val is not correct", "100",defaultTargetAvailability);
    }

    public void valKMinClearanceSetting() {
        String a;
        String defaultMinimumClearance;

        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        isDisplayed(minClearence,10);
        defaultMinimumClearance = getFieldText(minClearence);
        assertEquals("The defaultMinimumClearance default val is not correct", defaultMinimumClearance, "0");

        clear(minClearence);
        type(".1", minClearence);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(minClearence);
        type("w", minClearence);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(minClearence);
        type("3280.85", minClearence);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN -3,280.84 AND 3,280.84 FEET");

        clear(minClearence);
        type("-3280.85", minClearence);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN -3,280.84 AND 3,280.84 FEET");

        clear(minClearence);
        type("-3280.84", minClearence);

        clear(minClearence);
        type("3280.84", minClearence);
        click(saveButton);
    }

    public void valKFactorSetting() {

        String defaultKFactor;
        String a;

        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project K Factor field is not present", isDisplayed(kFactorField, 10));
        defaultKFactor = getFieldText(kFactorField);
        assertEquals("The defaultKFactor default val is not correct", defaultKFactor, "1");

        clear(kFactorField);
        type(".1", kFactorField);
        click(saveButton);

        clear(kFactorField);
        type("wuu ", kFactorField);
        click(minClearence);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(kFactorField);
        type("!", kFactorField);
        click(minClearence);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(kFactorField);
        type("100000", kFactorField);
        click(minClearence);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 0.01 AND 10,000");

        clear(kFactorField);
        type("0", kFactorField);
        click(minClearence);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 0.01 AND 10,000");

        clear(kFactorField);
        type("0.0003", kFactorField);
        click(minClearence);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 0.01 AND 10,000");

        clear(kFactorField);
        type("10000", kFactorField);
        click(saveButton);
    }

    public void valFresnelZoneRadius() {

        String defaultCompany;
        String defaultFresnelZoneRadius;
        String a;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project Fresnel Zone Radius (%) is not present", isDisplayed(fresnelZoneRadiusPercentField, 10));
        assertTrue("Default Company is not present", isDisplayed(defaultLicenseeField, 10));
        defaultCompany = getFieldText(defaultLicenseeField);
        defaultFresnelZoneRadius = getFieldText(fresnelZoneRadiusPercentField);
        assertEquals("The defaultLic default val is not correct", defaultCompany, "Verizon");
        assertEquals("The defaultFresnelZoneRadius default val is not correct", defaultFresnelZoneRadius, "60");

        clear(fresnelZoneRadiusPercentField);
        type(".1", fresnelZoneRadiusPercentField);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(fresnelZoneRadiusPercentField);
        type("w", fresnelZoneRadiusPercentField);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(fresnelZoneRadiusPercentField);
        type("1001", fresnelZoneRadiusPercentField);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 0 AND 1,000");

        clear(fresnelZoneRadiusPercentField);
        type("1000", fresnelZoneRadiusPercentField);
        click(saveButton);
    }


    public void valSiteLocationToggle()  {
        String a;
        assertTrue(isDisplayed(siteHeader, 20));
        a = getText(siteHeader);
/*        assertEquals(a, "#\n" +
                "Path\n" +
                "Band\n" +
                "Site Call Sign Antenna Radio Bandwidth # Freq\n" +
                "LOS\n" +
                "Avail\n" +
                "Valid");*/
        isDisplayed(siteLocationIcon, 30);
        hover(siteLocationIcon);
        hoverSiteLocationValSiteInfo(0);
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 15));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project US Unit is not present", isDisplayed(uSUnit, 10));
        assertTrue("Project settings is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project Site Location is not present", isDisplayed(showSiteLocationCheckBox, 30));
        isDisplayed(saveButton, 10);
        slowDown(3);
        click(showSiteLocationCheckBox);

        click(saveButton);
        assertTrue(isDisplayed(siteHeader, 20));
/*        a = getText(siteHeader);
        assertEquals(a, "#\n" +
                "Path\n" +
                "Band\n" +
                "Site Call Sign Antenna Radio Bandwidth # Freq\n" +
                "LOS\n" +
                "Avail\n" +
                "Valid");*/
    }

    public void changeUnitsFromSiToUs(String editValMinClearence, String valPostSiSwitch) {
        String postSiSwitchValue;
        String changedMinClearence;
        String minimumClearanceLable;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
        assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
        assertTrue("minClearence",isDisplayed(minClearence,30));
        assertTrue("sIUnit",isDisplayed(sIUnit,10));
        click(sIUnit);

        minimumClearanceLable = getText(minimumClearance);
        assertTrue(minimumClearanceLable.contains("Minimum Clearance (m)"));
        clear(minClearence);
        type(editValMinClearence,minClearence);
        assertTrue(isDisplayed(sIUnit));
        assertTrue(isDisplayed(saveButton,10));
        changedMinClearence = getFieldText(minClearence);
        assertEquals("Min clearence did not change", changedMinClearence,editValMinClearence);
        slowDown(4);
        click(saveButton);
        slowDown(4);

        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
        assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
        assertTrue("minClearence",isDisplayed(minClearence,30));
        assertTrue("sIUnit",isDisplayed(uSUnit,10));
        click(uSUnit);

        assertTrue(isDisplayed(saveButton, 10));
        postSiSwitchValue = getFieldText(minClearence);
        assertEquals("Min clearence did not change", postSiSwitchValue,valPostSiSwitch);

        postSiSwitchValue= getFieldText(minClearence);
        assertEquals("Min clearence did not change", postSiSwitchValue,valPostSiSwitch);
        minimumClearanceLable = getText(minimumClearance);
        assertTrue(minimumClearanceLable.contains("(ft)"));
    }


    public void changeUnitsFromUsToSi(String editValMinClearence, String valPostSiSwitch) {
        String postSiSwitchValue;
        String changedMinClearence;
        String minimumClearanceLable;


        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
        assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
        assertTrue("minClearence",isDisplayed(minClearence,30));
        assertTrue("sIUnit",isDisplayed(uSUnit,10));
        click(uSUnit);

        clear(minClearence);
        type(editValMinClearence,minClearence);
        assertTrue("Can't find save button",isDisplayed(saveButton,8));
        click(saveButton);
        slowDown(4);
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
        assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
        assertTrue("sIUnit",isDisplayed(sIUnit,10));
        click(sIUnit);
        assertTrue("minClearence",isDisplayed(minClearence,30));
        postSiSwitchValue = getFieldText(minClearence);
        assertEquals("Min clearence did not change", postSiSwitchValue,valPostSiSwitch);




    }





    public void changeToSi(){
        String minimumClearanceLable;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
        assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
        assertTrue("minClearence",isDisplayed(minClearence,30));
        assertTrue("sIUnit",isDisplayed(sIUnit,10));
        click(sIUnit);
        minimumClearanceLable = getText(minimumClearance);
        assertTrue(minimumClearanceLable.contains("Minimum Clearance (m)"));
        click(saveButton);
        slowDown(2);
    }

    public void changeToUs(){
        String minimumClearanceLable;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
        assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
        assertTrue("minClearence",isDisplayed(minClearence,30));
        assertTrue("sIUnit",isDisplayed(uSUnit,10));
        click(uSUnit);
        minimumClearanceLable = getText(minimumClearance);
        assertTrue(minimumClearanceLable.contains("Minimum Clearance (ft)"));
        click(saveButton);
        slowDown(2);
    }





    public void viewDefaultSettings() {

        String defaultLic;
        String defaultFresnelZoneRadius;
        String defaultKFactor;
        String defaultMinimumClearance;
        String defaultTargetAvailability;

        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project US Unit is not present", isDisplayed(uSUnit, 10));
        assertTrue("Project SI unit is not present", isDisplayed(sIUnit, 10));
        assertTrue("Project Default Licensee is not present", isDisplayed(defaultLicenseeField, 10));
        assertTrue("Project Panel is not present", isDisplayed(showSiteLocationCheckBox, 10));
        assertTrue("Project Fresnel Zone Radius (%) is not present", isDisplayed(fresnelZoneRadiusPercentField, 10));
        assertTrue("Project K Factor field is not present", isDisplayed(kFactorField, 10));
        assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
        defaultLic = getFieldText(defaultLicenseeField);
        defaultFresnelZoneRadius = getFieldText(fresnelZoneRadiusPercentField);
        defaultKFactor = getFieldText(kFactorField);
        defaultMinimumClearance = getFieldText(minClearence);
        defaultTargetAvailability = getFieldText(targetAvailability);
        assertEquals("The defaultLic default val is not correct", defaultLic, "Verizon");
        assertEquals("The defaultFresnelZoneRadius default val is not correct", defaultFresnelZoneRadius, "60");
        assertEquals("The defaultKFactor default val is not correct", defaultKFactor, "1");
        assertEquals("The defaultMinimumClearance default val is not correct", defaultMinimumClearance, "0");
        assertEquals("The Target Avail default val is not correct", defaultTargetAvailability, "99.995");
    }



    public void selectAndViewSettingsFromHamburgerMenu() {
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project US Unit is not present", isDisplayed(uSUnit, 10));
        assertTrue("Project SI unit is not present", isDisplayed(sIUnit, 10));
        assertTrue("Project Default Company is not present", isDisplayed(defaultLicenseeField, 10));
        assertTrue("Project Panel is not present", isDisplayed(showSiteLocationCheckBox, 10));
        assertTrue("Project Fresnel Zone Radius (%) is not present", isDisplayed(fresnelZoneRadiusPercentField, 10));
        assertTrue("Project K Factor field is not present", isDisplayed(kFactorField, 10));
        assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
    }

    public void highlightSinglePathDeselectAndValidate() {
        assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data", isDisplayed(allPathsNew, 10));
        click(allPathsNew, 1);
        click(allPathsNew, 2);
        assertTrue("The path is not selected",isDisplayedArray(pathsSelectedByArray, 0));
        click(allPathsNew, 1);
        click(allPathsNew, 2);
        assertTrue("The path is not selected",isDisplayedArray(allPathsNotSelected, 0));
    }

    public void highlightPathAndSelectDeleteFromHamburger(){
        assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPathsNew,10));
        click(allPathsNew,1);
        click(allPathsNew,2);
        assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive,10));
        click(hamburgerDropDownInactive);
        assertTrue("Delete Paths option is not present", isDisplayed(hamburgerDeletePaths,10));
        click(hamburgerDeletePaths);
        assertTrue("Delete modal is not present", isDisplayed(deleteModal,10));
        //TODO Can't get to title or sub title for Delete Path popup
        //assertTrue("Delete Path pop up sub title is not present", isDisplayed(deletePathPopupTitle,10));
        //assertTrue("There are no paths to be deleted, please select at least one path", isDisplayed(pathsToBeDeletedFromModal,10));
        assertTrue("Delete button is not present", isDisplayed(deletePathsButton,10));
        assertTrue("Delete button is not present", isDisplayed(deselectPathForDeletion,10));
        click(deselectPathForDeletion);
        List<WebElement> a;
        a = finds(remainingDeletePaths);
        assertEquals("Path was not removed", a.size() ,1);
        click(deletePathsButton);
        assertTrue("Delete confirmation is not present", isDisplayed(deleteConfirmationNew,10));
        isDisplayed(allPaths);
        List<WebElement> b;
        b = finds(allPaths);
        assertEquals("Path was not removed", b.size() ,4);
        String c;
        c = getText(totalPathsCount);
        //COM 102
        assertEquals("TOTAL PATHS do not match actual number of paths", c, "4");
    }

    public void validateSortOfLOSAvailVal(){
        assertTrue(isDisplayed(headerLOSInactive, 10));
        assertTrue(isDisplayed(headerAvailabilityInactive, 10));
        assertTrue(isDisplayed(headerValidationInactive, 10));
        click(headerLOSInactive);
        sortAttributeByColorValidationAscending(headerLOSValues1, "style");
        click(headerValidationInactive);
        assertTrue("LOS is still sorted, may need more of a wait here", isDisplayed(headerLOSInactive,3));
        sortAttributeByColorValidationAscending(headerAvailabilityValues, "style");
        click(headerValidationActive);
        assertTrue("Valid is still sorted, may need more of a wait here",isDisplayed(headerAvailabilityInactive,3));
        sortAttributeByColorValidationAscending(headerValidValues, "style");

    }

    public void validatePresenceOfLOSAvailVal(){
        assertTrue(isDisplayed(headerLOSInactive, 10));
        assertTrue(isDisplayed(headerAvailabilityInactive, 10));
        assertTrue(isDisplayed(headerValidationInactive, 10));
        click(headerLOSInactive);
        assertTrue(isDisplayed(headerLOSActive, 10));
        click(headerAvailabilityInactive);
        assertTrue(isDisplayed(headerAvailabilityActive, 10));
        click(headerValidationInactive);
        assertTrue(isDisplayed(headerValidationActive, 10));
    }

    public void deleteSinglePath(){
        click(pathName1);
        click(actionArrow);
        assertTrue("Delete option did not appear for path 1", isDisplayed(deleteOptionForPath1,3));
        click(deleteOptionForPath1);
        assertTrue("Delete pop up did not appear", isDisplayed(deletePopup,3));
        String deletePathPopupTitleq = getText(deletePathPopupTitle);
/*
        assertEquals(deletePathPopupTitleq, "X\n" +
                "DELETE PATH\n" +
                "Are you sure you want to delete the selected Path from this project?\n" +
                "Path\n" +
                "1 Test Path 1\n" +
                "KDFW Studio\n" +
                "KOTA TX - Skyline\n" +
                "X\n" +
                "DELETE PATH");
*/

        assertTrue("Delete button is not present", isDisplayed(deleteButton,3));
        click(deleteButton);

        assertTrue("Delete confirmation not present", isDisplayed(deleteConfirmation,30));
        assertTrue("deleteConfirmationTitle not present", isDisplayed(deleteConfirmationTitle,30));

        String DeleteConfirmationTitle = getText(deleteConfirmationTitle);
        assertEquals(DeleteConfirmationTitle, "Delete Path Confirmation");

        assertTrue("deleteConfirmationSubText not present", isDisplayed(deleteConfirmationSubText,30));
        String DeleteConfirmationSubtext = getText(deleteConfirmationSubText);
        assertEquals(DeleteConfirmationSubtext, "You have successfully deleted 1 path.");
    }

    public  void checkPathNumForAscend(){
        checkForAscend(SortNum);
        sortValidationAscending(listNumPaths);
    }

    public void checkBandForAcend() {
        checkForAscend(SortBand);
        sortValidationAscending(listNumBands);
    }

    public void checkPathNameForAcend() {
        checkForAscend(SortPath);
        sortValidationAscending(listNamePaths);
    }

    public  void checkPathNumForDescend(){
        checkForDescend(SortNum);
        sortValidationDescending(listNumPaths);
    }

    public void checkBandForDescend() {
        checkForDescend(SortBand);
        sortValidationDescending(listNumBands);
    }


    public void checkPathNameForDescend() {
        checkForDescend(SortPath);
        sortValidationDescending(listNamePaths);
    }


    public String defaultFilterValue() {
        String  band;
        isDisplayed(filterSelection);
        band = getFieldText(filterSelection);
        return  band;
    }

    public void hoverPassiveRepeaterValSiteInfo(){
        String filterEntryField;
        isDisplayed(passiveRepeaterIcon,10);
        hover(passiveRepeaterIcon);
        assertTrue("Can't Find Site Name",isDisplayed(passiveRepeaterHoverSiteNameField,3));
        assertTrue("Can't Find Site Lat",isDisplayed(passiveRepeaterHoverLatitudeField,3));
        assertTrue("Can't Find Site Long",isDisplayed(passiveRepeaterHoverLongitudeField,3));
        assertTrue("Can't Find Site Ant",isDisplayed(passiveRepeaterHoverAntennaField,3));
    }

    public void hoverSiteLocationValSiteInfo(int i){
        isDisplayed(siteLocationIcon,3);
        hover(siteLocationIcon,i);
       //TODO// 2/18 locators for site hover https://www.screencast.com/t/Xm2xznLn0C
    }

    public void valSiteLocationToggleOn(){
        String a;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive,10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings,10));
        slowDown(2);
        click(hamburgerSettings);
        //assertTrue("Project Panel is not present", waitUntilNotPresent(hamburgerSettings,10));
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel,10));
        assertTrue("Project US Unit is not present", isDisplayed(uSUnit,10));
        assertTrue("Project Site is not present", isDisplayed(showSiteLocationCheckBox,10));
        isDisplayed(saveButton,10);
        slowDown(6);
        click(showSiteLocationCheckBox);
        click(saveButton);
        assertTrue(isDisplayed(siteHeader,20));
        /**
         * the cause for 20 errors in browserstack looking for better implementation
         */
/*        a = getText(siteHeader);
        assertEquals(a, "#\n" +
                "Path\n" +
                "Band\n" +
                "Site Call Sign Antenna Radio Bandwidth # Freq\n" +
                "LOS\n" +
                "Avail\n" +
                "Valid");*/
        isDisplayed(siteLocationIcon,2);
    }

    public int filterForTestData(String dropDown, String location){
        String pathReturnTotal;
        int a;
        filter(dropDown,location);
        pathReturnTotal = getText(totalPathsCount);
        a = Integer.parseInt(pathReturnTotal.toString());
        return a;
    }


    public void filter(String dropDown, String location){
        isDisplayed(filterSelection,10);
        clear(filterSelectionInput);
        clear(filterSelectionInput);
        type(location, filterSelectionInput );
        selectFromDropdown(filterSelection, dropDown);
        click(searchButton);
    }

    public void validateBandFilteredResult(String pathVal){
        String path;
        isDisplayed(bandValue,0);
        isDisplayed(pathName1,0);
        path = getText(pathName1);
        assertEquals(path, pathVal);
    }

    public void validatePathNameFilteredResult(String pathVal){
        String path;
        isDisplayed(pathName3,3);
        path = getText(pathName3);
        assertEquals(path, pathVal);
    }

    public void validateSiteNameFilteredResult(String pathVal){
        String path;
        isDisplayed(pathName3,3);
        path = getText(pathName3);
        assertEquals(path, pathVal);
    }

    public void validateLicenseeFilteredResult (String pathVal2,String pathVal3,String pathVal4,String pathVal5) {

        String path2;
        String path3;
        String path4;
        String path5;
        isDisplayed(pathName2,3);
        isDisplayed(pathName3,3);
        isDisplayed(pathName4,3);
        isDisplayed(pathName5,3);
        path2 = getText(pathName2);
        path3 = getText(pathName3);
        path4 = getText(pathName4);
        path5 = getText(pathName5);
        assertEquals(path2, pathVal2);
        assertEquals(path3, pathVal3);
        assertEquals(path4, pathVal4);
        assertEquals(path5, pathVal5);
    }

    public void checkThatSelectButtonIsAvailable() {
        isDisplayed(selectAllButton, 3);
        String a = getText(selectAllButton);
        assertEquals("Select All button not present", a, "SELECT ALL");
    }

    public void clickSelectButton_CheckForDeselectButton() {
        click(selectAllButton);
        isDisplayed(selectAllButton,3);
        String a = getText(selectAllButton);
        assertEquals("Select All button not present", a,"DESELECT ALL");
    }

    public void checkThatAllPathsAreSelected() {
        List<WebElement> a;
        a = finds(allPathsNotSelected);
        assertEquals("Select All button not present", a.size() ,5);
    }

    public void clickDeselectAllButton(){
        click(deselectAllButton);
        isDisplayed(deselectAllButton,3);
        String a = getText(deselectAllButton);
        assertEquals("Select All button not present", a,"SELECT ALL");
    }

    public void checkForDeleteCandidates(String pathVal1, String pathVal2,String pathVal3){
        String path1;
        String path2;
        String path3;
        assertTrue("path 1 is not present",isDisplayed(pathName1));
        assertTrue("path 2 is not present",isDisplayed(pathName2));
        assertTrue("path 3 is not present",isDisplayed(pathName3));
        path1 = getText(pathName1);
        path2 = getText(pathName2);
        path3 = getText(pathName3);
        assertEquals(path1, pathVal1);
        assertEquals(path2, pathVal2);
        assertEquals(path3, pathVal3);
        List<WebElement> a;
        a = finds(allPaths);
        assertEquals("Select All button not present", a.size() ,5);
    }

    public void checkForDeletedPath(String pathVal1){

        List<WebElement> a;
        a = finds(allPaths);
        assertEquals("Select All button not present", a.size() ,4);
    }

    public void validateBlankFilteredResult (String pathVal1) {
        String path1;
        isDisplayed(pathName1,3);
        isDisplayed(pathName2,3);
        isDisplayed(pathName3,3);
        isDisplayed(pathName4,3);
        isDisplayed(pathName5,3);
        path1 = getText(pathName1);

        assertEquals(path1, pathVal1);

    }

    public void validateCallSignFilteredResult (String pathVal2) {
        String path2;
        isDisplayed(pathName2,3);
        path2 = getText(pathName2);
        assertEquals(path2, pathVal2);
    }

    public void validateASRFilteredResult (String pathVal4){
        String path4;
        isDisplayed(pathName4,3);
        path4 = getText(pathName4);
        assertEquals(path4, pathVal4);
    }

    public void validateAntennaCodeFilteredResult(String pathVal2, String pathVal3, String pathVal5){
//        String path2;
//        String path3;
//        String path5;
//        isDisplayed(pathName2,3);
//        isDisplayed(pathName3,3);
//        isDisplayed(pathName5,3);
//        path2 = getText(pathName2);
//        path3 = getText(pathName3);
//        path5 = getText(pathName5);
//        assertEquals(path2, pathVal2);
//        assertEquals(path3, pathVal3);
//        assertEquals(path5, pathVal5);
    }

    public void validateAntennaModelFilteredResult (String pathVal5){
        String path5;
        isDisplayed(pathName5,3);
        path5 = getText(pathName5);
        assertEquals(path5, pathVal5);
    }
    public void validateRadioCodeFilteredResult (String pathVal4){
        String path4;
        isDisplayed(pathName4,3);
        path4 = getText(pathName4);
        assertEquals(path4, pathVal4);
    }
    public void validateRadioBandwidthFilteredResult (String pathVal5){
        String path5;
        isDisplayed(pathName5,3);
        path5 = getText(pathName5);
        assertEquals(path5, pathVal5);
    }
    public void validateMaxPowerFilteredResult (String pathVal5){
        String path5;
        isDisplayed(pathName5,3);
        path5 = getText(pathName5);
        assertEquals(path5, pathVal5);
    }


    public Boolean landedOnPathSummaryPage(){
        return waitForIsDisplayed(projectTitle,10);
    }

    public boolean projectName() {
        return isDisplayed(projectTitleName);
    }

    public String projectNameText() {
        return getText(projectTitleName);
    }

    public String projectNameSite1Site2Text(int i) {
        return getTextPlural(listNamePaths, i);
    }

    public String pathAmounts() {
        return getText(totalPathAmount);
    }

    public boolean disabledSplit() {
        return isDisplayed(hamburgerSplitPathsDisabled);
    }

    public String licenseeName() {
        return getText(licenseeName);
    }
}
