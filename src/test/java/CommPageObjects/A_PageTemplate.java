package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class A_PageTemplate extends BasePage {


    //Path Data Fields - Element is read only and can use getFieldText method

    //Headings
    By radioImage = By.id("path-details-section-header-radio-icon");


    //Buttons
    //Path DropDown Fields -- Does it contain a list that has options that can be selected
    //Drop down options
    //Path Entry Fields - Able to use the type method
    //Path hovers -- Able to use the hover method
    //radio-lookup-modal-table
    //Index List -- Can you used an array to select item
    //Modal -- Does it pop up over current window



    public A_PageTemplate(WebDriver driver) {
        super(driver);
        visit("/");
    }



    public void hoverAndValidate(){


    }


}
