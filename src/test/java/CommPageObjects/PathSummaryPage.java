package CommPageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PathSummaryPage extends BasePage {

    By projectTitle = By.xpath("//span[text()='Project ']");
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
    //*[@id="project-summary-path-row-0"]/td[1]/div/div[1]/span[2]
    By paths = By.className("pull-left");
    By listNumPaths = By.xpath("//*[contains(@class, 'pull-left')]");
    By listNumBands = By.xpath("//*[contains(@class, 'pull-right')]");
    By SortNum = By.id("project-summary-sort-index");
    By SortBand = By.id("project-summary-sort-band");
    //TODO Nemo to add locator
    By siteLocationIcon = By.id("site-tooltip-trigger-path-0-site-2");

    public PathSummaryPage(WebDriver driver){
        super(driver);

    visit("project-summary/1234");
        Assert.assertTrue(driver.findElement(projectTitle).isDisplayed());
    }

    public  void checkPathNumForAscend(){
        checkForAscend(SortNum);
        sortValidationAscending(listNumPaths);
    }

    public void checkBandForAcend() {
        checkForAscend(SortBand);
        sortValidationAscending(listNumBands);
    }

    public  void checkPathNumForDescend(){
        checkForAscend(SortNum);
        sortValidationAscending(listNumPaths);
    }

    public void checkBandForDescend() {
        checkForDescend(SortBand);
        sortValidationDescending(listNumBands);
    }

    public String defaultFilterValue() {
        String  a;
        isDisplayed(filterSelection);
        a = getFieldText(filterSelection);
        return  a;
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
