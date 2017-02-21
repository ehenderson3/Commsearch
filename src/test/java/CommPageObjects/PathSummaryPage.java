package CommPageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class PathSummaryPage extends BasePage {

    By projectTitle = By.className("project-summary-overview");
    By projectTitleName = By.xpath("//*[@class=\"project-summary-overview\"]/p[1]/span[2]");
    By totalPathAmount = By.xpath("//*[@class=\"project-summary-overview\"]/p[3]/span[2]");
    By licenseeName = By.xpath("//*[@class=\"project-summary-overview\"]/p[2]/span[2]");

    By passiveRepeaterIcon = By.xpath("//*[contains(@id, 'passive-repeater-tooltip-path')]");
    By passiveRepeaterHoverSiteNameField = By.xpath("//*[text() = 'Site Name' and @class = 'uppercase']");
    By passiveRepeaterHoverLatitudeField = By.xpath("//*[text() = 'Latitude' and @class = 'uppercase']");
    By passiveRepeaterHoverLongitudeField = By.xpath("//*[text() = 'Longitude' and @class = 'uppercase']");
    By passiveRepeaterHoverAntennaField = By.xpath("//*[text() = 'Antennas' and @class = 'uppercase']");
    By filterSelection = By.id("project-summary-filter-select");
    By filterSelectionInput = By.id("project-summary-filter-input");
    By searchButton = By.id("project-summary-filter-apply");
    By bandValue = By.cssSelector(".pull-right");
    By pathName1 = By.xpath("//*[@id=\"project-summary-path-row-0\"]/td[1]/div/div[1]/span[2]");
    By pathName2 = By.xpath("//*[@id=\"project-summary-path-row-1\"]/td[1]/div/div[1]/span[2]");
    By pathName3 = By.xpath("//*[@id=\"project-summary-path-row-2\"]/td[1]/div/div[1]/span[2]");
    By pathName4 = By.xpath("//*[@id=\"project-summary-path-row-3\"]/td[1]/div/div[1]/span[2]");
    By pathName5 = By.xpath("//*[@id=\"project-summary-path-row-4\"]/td[1]/div/div[1]/span[2]");

    By allPaths = By.xpath("//*[contains(@id, 'project-summary-path-row')]");
    By allPathsNew = By.className("path-name-value");
    By pathsSelectedByArray = By.xpath("//*[@class='path-info-td td-border-transparent selected']");

    By selectAllButton = By.cssSelector(".heading-font.btn.btn-md.btn-skinny.bg-white.btn-border.margin-left-1");
    By deselectAllButton = By.cssSelector(".heading-font.btn.btn-md.btn-skinny.bg-white.btn-border.margin-left-1");


    By paths = By.className("pull-left");
    By listNumPaths = By.xpath("//*[contains(@class, 'pull-left')]");
    By listNumBands = By.xpath("//*[contains(@class, 'path-band-value pull-right')]");
    By listNamePaths = By.className("path-name-value");

    By allPathsNotSelected = By.xpath("//*[contains(@class, 'path-info-td td-border-transparent')]");

    By SortNum = By.id("project-summary-sort-index");
    By SortBand = By.id("project-summary-sort-band");
    By SortPath = By.id("project-summary-sort-pathname");

    //TODO Nemo to add locator -- Changed but not verified
    By siteLocationIcon = By.id("site-tooltip-trigger-path-0-site-2");

    By actionArrow = By.cssSelector(".fa.fa-caret-down");
    By deleteOptionForPath1 = By.id("path-menu-delete-0");
    By deletePopup = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
    By deletePopUpTitle = By.className("uppercase");
    By deletePopUpSubText = By.className("center-text");//Need more specific locator
    By deleteCandidate = By.tagName("td");//Need more specific locator
    By deleteButton = By.id("delete-paths-modal-delete-apply");
    By deleteConfirmation = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
    //By deleteConfirmationTitle = By.cssSelector(".display-flex.justify-content-center");
    By deleteConfirmationTitle = By.id("delete-paths-modal-success-heading");
    By deleteConfirmationSubText = By.id("delete-paths-modal-success-message");

    By headerLOSInactive = By.xpath("//*[@id='project-summary-sort-los' and @class='inactive']");
    By headerAvailabilityInactive = By.xpath("//*[@id='project-summary-sort-avail' and @class='inactive']");
    By headerValidationInactive = By.xpath("//*[@id='project-summary-sort-valid' and @class='inactive']");
    By headerLOSActive = By.xpath("//*[@id='project-summary-sort-los' and @class='active direction-down']");
    By headerAvailabilityActive = By.xpath("//*[@id='project-summary-sort-avail' and @class='active direction-down']");
    By headerValidationActive = By.xpath("//*[@id='project-summary-sort-valid' and @class='active direction-down']");
    By headerLOSValues = By.xpath("//*[@class ='path-los-value' and contains(@style,'background:')]");
    By headerLOSValues1 = By.className("path-los-value");
    By headerAvailabilityValues = By.className("path-avail-value");
    By headerValidValues = By.className("path-valid-value");

//headerAvailabilityValues

    By hamburgerDropDownInactive = By.xpath("//*[@id='project-summary-menu-toggle' and @class='pointer pull-right']");
    By hamburgerDropDownActive = By.xpath("//*[@id='project-summary-menu-toggle' and @class='pointer pull-right active']");
    By hamburgerDeletePaths = By.id("project-settings-delete-paths-modal-trigger");
    By deletePathPopupTitle0 = By.xpath("//*[@class,'uppercase') and contains(text(), 'Delete Path')]");
    By deletePathPopupTitle = By.className("project-summary-modal");
    By deletePathPopupSubTitle = By.tagName("p");
    By deleteModal = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
    //https://www.screencast.com/t/BLDu9LlDZTF
    By pathsToBeDeletedFromModal = By.xpath("//*[contains(@class,'delete-paths-modal-path')]");
    By deletePathsButton = By.id("delete-paths-modal-delete-apply");
    By deleteConfirmationNew = By.cssSelector(".display-flex.justify-content-center");
    By deleteConfirmationPathPopupSubTitle = By.xpath("//*[contains(@tag, 'span') and contains(@class, 'display-flex justify-content-center')]");
    By deselectPathForDeletion = By.xpath("//*[contains(@id,'delete-paths-modal-remove-path')]");

    By hamburgerSettings = By.id("project-summary-settings-trigger");
    By projectSettingsPanel = By.cssSelector(".active.project-summary-settings.bg-grey-gadient");
    By uSUnit = By.className("styled-radio");
    By sIUnit = By.className("styled-radio");
    By defaultLicenseeField = By.id("project-summary-settings-default-licensee");
    By showSiteLocationCheckBox = By.id("project-summary-settings-summary-display-show");
    By fresnelZoneRadiusPercentField = By.id("project-summary-settings-freznel-zone-radius");
    By kFactorField = By.id("project-summary-settings-k-factor");
    By minClearence = By.id("project-summary-settings-minimum-clearance");
    By targetAvailability = By.id("project-summary-settings-target-availability");
    By saveButton = By.id("project-summary-settings-submit");
    By groundElevation = By.xpath("//*[contains(@title, 'Ground Elevation')]");
    By fieldChange = By.xpath("//*[contains(@placeholder, 'Minimum Clearance (m)')]");
    By siteHeader = By.cssSelector(".bg-blue-dark.padding-half.heading-font");

    By siteLocationIcon1 = By.id("ssite-tooltip-trigger-path");
    By hoverSite = By.cssSelector(".__react_component_tooltip.place-bottom.type-light.project-summary-tooltip");
    By warnFresnelZoneRadius = By.className("error-message");
    //TODO need locator for TOTAL PATHS count #
    By totalPathsCount = By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[1]/div[1]/p[3]/span[2]");


    public PathSummaryPage(WebDriver driver) {
        super(driver);

        visit("project-summary/1234");
        assertTrue(isDisplayed(projectTitle,3));
    }

    public void valKDefaultAvailabilityTargetSetting() {
        String a;

        String defaultTargetAvailability;

        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
        defaultTargetAvailability = getFieldText(targetAvailability);
        assertEquals("The Target Avail default val is not correct", defaultTargetAvailability, "99.995");

        clear(targetAvailability);
        type("w", targetAvailability);
        click(saveButton);
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

        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
        defaultTargetAvailability = getFieldText(targetAvailability);
        assertEquals("The Target Avail default val is not correct", defaultTargetAvailability, "100");
    }

    public void valKMinClearanceSetting() {
        String a;
        String defaultMinimumClearance;

        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        defaultMinimumClearance = getFieldText(minClearence);
        assertEquals("The defaultMinimumClearance default val is not correct", defaultMinimumClearance, "65.61");

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
        type("1001", minClearence);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN -1000 AND 1000");

        clear(minClearence);
        type("-1001", minClearence);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN -1000 AND 1000");

        clear(minClearence);
        type("1000", minClearence);
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
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(kFactorField);
        type("w", kFactorField);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "ONLY NUMERICAL VALUES ALLOWED");

        clear(kFactorField);
        type("1001", kFactorField);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 0.01 AND 1000");

        clear(kFactorField);
        type("0", kFactorField);
        click(saveButton);
        a = getText(warnFresnelZoneRadius);
        assertEquals(a, "MUST BE BETWEEN 0.01 AND 1000");


        clear(kFactorField);
        type("1000", kFactorField);
        click(saveButton);


    }

    public void valFresnelZoneRadius() {

        String defaultLic;
        String defaultFresnelZoneRadius;
        String a;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project Fresnel Zone Radius (%) is not present", isDisplayed(fresnelZoneRadiusPercentField, 10));
        defaultLic = getFieldText(defaultLicenseeField);
        defaultFresnelZoneRadius = getFieldText(fresnelZoneRadiusPercentField);
        assertEquals("The defaultLic default val is not correct", defaultLic, "Licensee Inc");
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
        assertEquals(a, "MUST BE BETWEEN 0 AND 1000");

        clear(fresnelZoneRadiusPercentField);
        type("1000", fresnelZoneRadiusPercentField);
        click(saveButton);


    }


    public void valSiteLocationToggle() {
        String a;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project US Unit is not present", isDisplayed(uSUnit, 10));
        assertTrue("Project Site is not present", isDisplayedAndClickable(showSiteLocationCheckBox, 10));
        click(showSiteLocationCheckBox);
        isDisplayed(saveButton, 10);
        click(saveButton);
        assertTrue(isDisplayed(siteHeader, 20));
        a = getText(siteHeader);
        assertEquals(a, "#\n" +
                "Path\n" +
                "Band\n" +
                "Site Call Sign Antenna Radio Bandwidth # Freq\n" +
                "LOS\n" +
                "Avail\n" +
                "Valid");
        isDisplayed(siteLocationIcon, 30);
        // hover(siteLocationIcon);
        hoverSiteLocationValSiteInfo();
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project US Unit is not present", isDisplayed(uSUnit, 10));
        assertTrue("Project Site is not present", isDisplayedAndClickable(showSiteLocationCheckBox, 10));
        click(showSiteLocationCheckBox);
        isDisplayed(saveButton, 10);
        click(saveButton);
        assertTrue(isDisplayed(siteHeader, 20));
        a = getText(siteHeader);
        assertEquals(a, "#\n" +
                "Path\n" +
                "Band\n" +
                "Site Call Sign Latitude\n" +
                "NAD83 Longitude\n" +
                "NAD83 G.E.\n" +
                "(ft) Antenna Radio Bandwidth # Freq\n" +
                "LOS\n" +
                "Avail\n" +
                "Valid");
    }

    public void changeUnitsFromUsToSi() {
        String groundElevationHeading;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
        assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
        click(sIUnit, 1);
        isDisplayed(fieldChange, 10);
        isDisplayed(saveButton, 10);
        click(saveButton);
        isDisplayed(groundElevation, 10);
        groundElevationHeading = getText(groundElevation);
        assertTrue(groundElevationHeading.contains("(m)"));
        //TODO// assertTrue(minimumClearance.contains("(m)"));
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

        assertEquals("The defaultLic default val is not correct", defaultLic, "Licensee Inc");
        assertEquals("The defaultFresnelZoneRadius default val is not correct", defaultFresnelZoneRadius, "60");
        assertEquals("The defaultKFactor default val is not correct", defaultKFactor, "1");
        assertEquals("The defaultMinimumClearance default val is not correct", defaultMinimumClearance, "65.61");
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
        assertTrue("Project Default Licensee is not present", isDisplayed(defaultLicenseeField, 10));
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
        //a = getText(deletePathPopupTitle);
        //assertEquals(a,"pow");
        //TODO Can't get to title or sub title for Delete Path popup
        //assertTrue("Delete Path pop up sub title is not present", isDisplayed(deletePathPopupTitle,10));
        //assertTrue("There are no paths to be deleted, please select at least one path", isDisplayed(pathsToBeDeletedFromModal,10));
        assertTrue("Delete button is not present", isDisplayed(deletePathsButton,10));
        assertTrue("Delete button is not present", isDisplayed(deselectPathForDeletion,10));
        click(deselectPathForDeletion);
        List<WebElement> a;
        a = finds(deselectPathForDeletion);
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
        assertEquals(deletePathPopupTitleq, "X\n" +
                "DELETE PATH\n" +
                "Are you sure you want to delete the selected Path from this project?\n" +
                "Path\n" +
                "1 First Path\n" +
                "n/a\n" +
                "unique\n" +
                "X\n" +
                "DELETE PATH");


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

    public void hoverSiteLocationValSiteInfo(){
        isDisplayed(siteLocationIcon,2);
        hover(siteLocationIcon);
       //TODO// 2/18 locators for site hover https://www.screencast.com/t/Xm2xznLn0C
    }

    public void valSiteLocationToggleOn(){
        String a;
        assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive,10));
        click(hamburgerDropDownInactive);
        assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings,10));
        click(hamburgerSettings);
        assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel,10));
        assertTrue("Project US Unit is not present", isDisplayed(uSUnit,10));
        assertTrue("Project Site is not present", isDisplayedAndClickable(showSiteLocationCheckBox,10));
        click(showSiteLocationCheckBox);
        isDisplayed(saveButton,10);
        click(saveButton);
        assertTrue(isDisplayed(siteHeader,20));
        a = getText(siteHeader);
        assertEquals(a, "#\n" +
                "Path\n" +
                "Band\n" +
                "Site Call Sign Antenna Radio Bandwidth # Freq\n" +
                "LOS\n" +
                "Avail\n" +
                "Valid");
        isDisplayed(siteLocationIcon,30);
    }

    public void filter(String dropDown, String location){
        waitForIsDisplayed(filterSelection,10);
        clear(filterSelectionInput);
        type(location, filterSelectionInput );
        selectFromDropdown(filterSelection, dropDown);
        click(searchButton);
    }

    public void validateBandFilteredResult(String pathVal){
        //String band;
        String path;
        isDisplayed(bandValue,3);
        //band = getText(bandValue);
        //assertEquals(band, bandVal);
        isDisplayed(pathName2,3);

        path = getText(pathName2);
        assertEquals(path, pathVal);
    }

    public void validatePathNameFilteredResult(String pathVal){
        //String band;
        String path;
        //isDisplayed(bandValue,3);
        //band = getText(bandValue);
        //assertEquals(band, bandVal);
        isDisplayed(pathName1,3);
        path = getText(pathName1);
        assertEquals(path, pathVal);
    }

    public void validateSiteNameFilteredResult(String pathVal){
        //String band;
        String path;
        //isDisplayed(bandValue,3);
        //band = getText(bandValue);
        //assertEquals(band, bandVal);
        isDisplayed(pathName1,3);
        path = getText(pathName1);
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




    public void validateBlankFilteredResult (String pathVal1, String pathVal2,String pathVal3,String pathVal4,String pathVal5) {
        String path1;
        String path2;
        String path3;
        String path4;
        String path5;
        isDisplayed(pathName1,3);
        isDisplayed(pathName2,3);
        isDisplayed(pathName3,3);
        isDisplayed(pathName4,3);
        isDisplayed(pathName5,3);
        path1 = getText(pathName1);
        path2 = getText(pathName2);
        path3 = getText(pathName3);
        path4 = getText(pathName4);
        path5 = getText(pathName5);
        assertEquals(path1, pathVal1);
        assertEquals(path2, pathVal2);
        assertEquals(path3, pathVal3);
        assertEquals(path4, pathVal4);
        assertEquals(path5, pathVal5);
    }

    public void validateCallSignFilteredResult (String pathVal2, String pathVal3, String pathVal4) {
        String path2;
        String path3;
        String path4;
        isDisplayed(pathName2,3);
        isDisplayed(pathName3,3);
        isDisplayed(pathName4,3);
        path2 = getText(pathName2);
        path3 = getText(pathName3);
        path4 = getText(pathName4);
        assertEquals(path2, pathVal2);
        assertEquals(path3, pathVal3);
        assertEquals(path4, pathVal4);
    }

    public void validateASRFilteredResult (String pathVal4){
        String path4;
        isDisplayed(pathName4,3);
        path4 = getText(pathName4);
        assertEquals(path4, pathVal4);
    }

    public void validateAntennaCodeFilteredResult(String pathVal2, String pathVal3, String pathVal5){
        String path2;
        String path3;
        String path5;
        isDisplayed(pathName2,3);
        isDisplayed(pathName3,3);
        isDisplayed(pathName5,3);
        path2 = getText(pathName2);
        path3 = getText(pathName3);
        path5 = getText(pathName5);
        assertEquals(path2, pathVal2);
        assertEquals(path3, pathVal3);
        assertEquals(path5, pathVal5);
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

//    public Boolean alertMessagePresent(){
//        return waitForIsDisplayed(createButton,10);
//    }

    public Boolean landedOnPathSummaryPage(){
        return waitForIsDisplayed(projectTitle,10);
    }

    public boolean projectName() {
        return isDisplayed(projectTitleName);
    }

    public String projectNameText() {
        return getText(projectTitleName);
    }


    public String pathAmounts() {
        return getText(totalPathAmount);
    }

    public String licenseeName() {
        return getText(licenseeName);
    }
}
