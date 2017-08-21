package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class DataBasePage extends BasePage {


    //Path Data Fields - Element is read only and can use getFieldText method

    //Headings
    By radioImage = By.id("path-details-section-header-radio-icon");


    //Buttons
    By dataBaseManagementButton = By.id("database-management-link");
    By antennaDataBaseLink = By.id("antenna-database-summary-link");
    By antennaPlaceHolder = By.xpath("//*[@id=\"app\"]/div/div/div");



    //Drop down options
    //Path Entry Fields - Able to use the type method
    //Path hovers -- Able to use the hover method
    //Path DropDown Fields -- Does it contain a list that has options that can be selected
    //radio-lookup-modal-table
    //Index List -- Can you used an array to select item
    //Modal -- Does it pop up over current window



    public DataBasePage(WebDriver driver) {
        super(driver);
        visit("/");
    }



    public void accessAntennaDataBase(){
        assertTrue(isDisplayed(dataBaseManagementButton,5));
        click(dataBaseManagementButton);
        assertTrue(isDisplayed(antennaDataBaseLink,5));
        click(antennaDataBaseLink);
        assertTrue(isDisplayed(antennaPlaceHolder,5));

    }


}
