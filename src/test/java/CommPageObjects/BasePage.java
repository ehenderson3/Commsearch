package CommPageObjects;


import CommTests.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BasePage implements Config {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        if (url.contains("http")) {
            driver.get(url);
        } else {
            driver.get(baseUrl + url);
        }
    }

    /**
     * Pauses execution to adjust to running suite in different environments.
     *
     * @param i
     */
    public void slowDown(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * finds a single element using the Selenium's findElement
     *
     * @param locator
     * @return
     */
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * finds a multiple elements using the Selenium's findElements
     * for array selection
     *
     * @param locators
     * @param i
     * @return
     */
    public WebElement find(By locators, int i) {
        return driver.findElements(locators).get(i);
    }

    /**
     * gets the field text of element(locator) being passed via parameter
     *
     * @param locator
     * @return
     */
    public String getFieldText(By locator) {
        WebElement TxtBoxContent = driver.findElement(locator);
        String s = new String();
        s = TxtBoxContent.getAttribute("value");
        return s;
    }

    /**
     * This method allows you to use the i parameter to select the element form an array of elements to get the locator's field text
     * @param locator
     * @param i
     * @return
     */
    public String getFieldTextPlural(By locator, int i) {
        WebElement TxtBoxContent = driver.findElements(locator).get(i);
        String s = new String();
        s = TxtBoxContent.getAttribute("value");
        return s;
    }

    public String getFieldText(By locator, String alt) {
        WebElement TxtBoxContent = driver.findElement(locator);
        String s = new String();
        s = TxtBoxContent.getAttribute(alt);
        return s;

    }


    /**
     * deletes  field text of element(locator) being passed via parameter
     *
     * @param locator
     */
    public void clear(By locator) {
        if(browser.equals("IE")){
            find(locator).sendKeys(Keys.CONTROL + "a");
        }
        driver.findElement(locator).clear();
    }

    /**
     * Clicks on elements that are difficult to locate
     * @param locator
     */
    public void clickJS(By locator){
        WebElement invisible = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", invisible );}

    /**
     * produces a list of elements and prints the attribute list
     *
     * @param locators
     * @return
     */
    public List<WebElement> finds(By locators) {
        List<WebElement> yourList = driver.findElements(locators);
        if (yourList != null || !yourList.isEmpty()) {
            System.out.println(yourList.size());
            for (WebElement webElement : yourList) {
                System.out.println(webElement.getAttribute("id"));
            }
        } else {

        }
        return driver.findElements(locators);
    }

    public void max(){
        driver.manage().window().maximize();
    }


    public void resizeTest() {
        ((JavascriptExecutor)driver).executeScript("window.resizeTo(1024, 768);");
    }

    /**
     * finds a single element's text using the Selenium's findElement and getText
     *
     * @param locator
     * @return
     */
    public String getText(By locator) {
        WebElement TxtBoxContent = driver.findElement(locator);
        String s = new String();
        s = TxtBoxContent.getText();
        return s;
    }

    /**
     * finds multiple element's text using the Selenium's findElements and getText
     * user may select using an array
     *
     * @param locator
     * @param i
     * @return
     */
    public String getTextPlural(By locator, int i) {
        WebElement TxtBoxContent = driver.findElements(locator).get(i);
        String s = new String();
        s = TxtBoxContent.getText();
        return s;
    }

    /**
     * finds single element using the Selenium's findElement and clicking element using the seleinium's click method
     *
     * @param locator
     */
    public void click(By locator) {
        find(locator).click();
    }


    public void waitForFieldText(String fieldTest, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementValue((locator), fieldTest));
    }

    public void waitForFieldToBeNotNull(final By locator) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(locator).getAttribute("value").length() != 0;
            }
        });
    }


    public void waitForText(String fieldTest, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated((locator), fieldTest));
    }

    public void waitForText(String fieldTest, By locator, int i) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated((locator), fieldTest));
    }
    /**
     * finds multiple elements using the Selenium's findElements and clicking element using the seleinium's click method
     *
     * @param locators
     * @param i
     */
    public void click(By locators, int i) {
        finds(locators).get(i).click();
    }

    /**
     * interacts with elements that have hover lists allows for hovering, selecting and clicking a specific option
     *
     * @param locator
     * @param i
     */
    public void hover(By locator, int i) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElements(locator).get(i);
        action.moveToElement(we).click().build().perform();
    }

    /**
     * interacts with element that have hover and allows for hovering, selecting and clicking a specific option
     *
     * @param locator
     */
    public void hover(By locator) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(locator);
        action.moveToElement(we).click().build().perform();
    }

    /**
     * inputs text(inputText)into field element(locator)
     *
     * @param inputText
     * @param locator
     */
        public void type(String inputText, By locator) {
            find(locator).sendKeys(inputText);
        }


        public void typePlural(String inputText, By locator,int i) {
        WebElement we = driver.findElements(locator).get(i);
        we.sendKeys(inputText);
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public Boolean isDisplayedArray(By locators, int i) {
        return finds(locators).get(i).isDisplayed();
    }


    /**
     * Will check to see if an element is not present Instead of returning exception this will return false
     *
     * @param locator
     * @param timeout
     * @return
     */
    public Boolean isDisplayed(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    /**
     * Waits for element to be located and clickable will timeout if element is not clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public Boolean isDisplayedAndClickable(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator));

        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    /**
     * waits until a given element is not present then allows process to conitue
     *
     * @param locator
     * @param timeout
     * @return
     */
    public Boolean waitUntilNotPresent(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    /**
     * Switches into a given frame and allows selenium to interact with elements therein
     * @param i
     */
    public void switchToFrame(int i) {
        driver.switchTo().frame(i);
    }

    /**
     *
     */
    public void switchBackToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void Maximize() {
        driver.manage().window().maximize();
    }


    /**
     * dismisses javascript alerts
     */
    public void DealWithTheAlert() {
        Alert Popup = driver.switchTo().alert();
        Popup.accept();
    }

    /**
     * Validates that an alrert is presernt
     */
    public void checkAlertAndAccept() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {

        }
    }


    public Boolean waitForIsDisplayed(By locator, Integer... timeout) {
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeout.length > 0 ? timeout[0] : null));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    /**
     * Explicit Wait specify amount of time and an action then seleinium will attempt the action
     * Until the action is completed or the process times out
     * @param condition
     * @param timeout
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 5;//if nothing is passed default wait will be 5 seconds
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public void selectFromDropdown(By location, String option) {
        WebElement dropDownListBox = driver.findElement(location);
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByVisibleText(option);
    }

    public void sortAttributeValidationAscending(By listLocator, String attributeType) {
        ArrayList<String> obtainedList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(listLocator);
        for (WebElement we : elementList) {
            obtainedList.add(we.getAttribute(attributeType));
        }
        ArrayList<String> sortedList = new ArrayList<String>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        assertEquals(sortedList, (obtainedList));
    }

    public void sortAttributeByColorValidationAscending(By listLocator, String attributeType) {
        ArrayList<String> obtainedList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(listLocator);
        for (WebElement we : elementList) {
            obtainedList.add(we.getAttribute(attributeType));
        }
        ArrayList<String> sortedList = new ArrayList<String>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.reverse(sortedList);
        Collections.reverse(sortedList);
        assertEquals(sortedList, (obtainedList));
    }

    public void sortAttributeValidationDescending(By listLocator, String attributeType) {
        ArrayList<String> obtainedList = new ArrayList<String>();
        obtainedList.removeAll(Arrays.asList("", null));
        List<WebElement> elementList = driver.findElements(listLocator);
        for (WebElement we : elementList) {
            obtainedList.add(we.getAttribute(attributeType));
        }
        ArrayList<String> sortedList = new ArrayList<String>();
        sortedList.removeAll(Arrays.asList("", null));
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.reverse(sortedList);
        assertEquals(sortedList, (obtainedList));
    }


    public void sortValidationAscending(By listLocator) {
        ArrayList<String> obtainedList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(listLocator);
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<String>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        assertTrue(sortedList.equals(obtainedList));
    }

    /**
     * Checks for elements and count and captures the element's name values
     * increments for each element and sorts in reverse then compares the list
     * @param listLocator
     */
    public void sortValidationDescending(By listLocator) {
        ArrayList<String> obtainedList = new ArrayList<String>();
        obtainedList.removeAll(Arrays.asList("", null));
        List<WebElement> elementList = driver.findElements(listLocator);
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<String>();
        sortedList.removeAll(Arrays.asList("", null));
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.reverse(sortedList);
        Collections.reverse(sortedList);
        assertTrue(sortedList.equals(obtainedList));
    }

    /**
     * Check if the sorting is by ascending by checking if the arrow is 'up'; if not click on it to sort by ascending
     * @param sortControl
     */
    public void checkForAscend(By sortControl) {
        String arrow_direction = driver.findElement(sortControl).getAttribute("class");
        if (!arrow_direction.contains("down"))
            driver.findElement(sortControl).click();
    }

    /**
     * Check if the sorting is by ascending by checking if the arrow is 'up'; if not click on it to sort by ascending
     * @param sortControl
     */
    public void checkForDescend(By sortControl) {
        String arrow_direction = driver.findElement(sortControl).getAttribute("class");
        if (!arrow_direction.contains("up"))
            driver.findElement(sortControl).click();
    }




    /**
     * Checks for elements and count and captures the element's name values
     * increments for each element and sorts then compares the list
     * @param element
     * @param listOfItems
     * @param PathList
     */
    public void sortAramma(By element, By listOfItems, By PathList) {
        int eleCount;
        List<WebElement> elements;
        List<String> customerNameA = new ArrayList();
        List<String> customerNameB = new ArrayList();
        assertTrue(isDisplayed(element));
        elements = driver.findElements(listOfItems);

        eleCount = elements.size();
        System.out.println("Element count: " + eleCount);

        for (int i = 2; i < eleCount; i++) {
            customerNameA.add(driver.findElement(PathList).getText());
            System.out.println(driver.findElement(PathList).getText());
            customerNameB.add(driver.findElement(PathList).getText());

        }
        Collections.sort(customerNameA);

        for (int i = 0; i < customerNameA.size(); i++) {
            System.out.println("Customer Name from input: " + customerNameB.get(i) + "--Customer Name from sorted input: " + customerNameA.get(i));
            if (!(customerNameA.get(i).equals(customerNameB.get(i)))) {
                System.out.println("Customer Names not sorted: " + i);
                break;

            }
        }
    }

    public static final String INACTIVE_POINTER = "inactive pointer";
    public static final String DOWN_POINTER = "active direction-down pointer";
    public static final String PROJECT_ROW = "project-summary-path-row-";
    public static final String PATH_VAL = "//*[contains(@id, 'path-') and contains(@id,";
}

