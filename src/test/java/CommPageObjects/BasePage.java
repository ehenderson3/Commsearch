package CommPageObjects;


        import org.openqa.selenium.Alert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.openqa.selenium.TimeoutException;
        import CommTests.Config;



public class BasePage implements Config{

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        if (url.contains("http")) {
            driver.get(url);
        }else{
          driver.get(baseUrl +url);
        }


    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public WebElement find(By locators,int i) {
        return driver.findElements(locators).get(i);
    }

    public void click(By locator) {
        find(locator).click();
    }


    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    //Will check to see if an element is not present Instead of returning exception this will return false
    public Boolean isDisplayed(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }



    public void DealWithTheAlert()
    {
        Alert Popup = driver.switchTo().alert(); Popup.accept();
    }

    public void checkAlertAndAccept() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
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

    //Explicit Wait specify amount of time and an action then seleinium will attempt the action
    //Until the action is completed or the process times out
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout){
        timeout = timeout !=null ? timeout : 5;//if nothing is passed default wait will be 5 seconds
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(condition);
    }

}



//    protected IWebElement Find(By locator)
//    {
//        return Driver.FindElement(locator);
//    }
//
//    protected IWebElement FindPlural(By locator, int i)
//    {
//        return Driver.FindElements(locator)[i];
//    }
//
//    protected IWebElement IsClickable(By locator)
//    {
//        WebDriverWait Wait = new WebDriverWait(Driver, System.TimeSpan.FromSeconds(60));
//        return Wait.Until(ExpectedConditions.ElementToBeClickable(locator));
//    }
//
//    //
//
//    protected void DealWithTheAlert()
//    {
//        IAlert Popup = Driver.SwitchTo().Alert(); Popup.Accept();
//    }
//
//    protected void SwitchToModal()
//    {
//        IAlert Popup = Driver.SwitchTo().Alert();
//    }
//
//    protected void ChangeContextToCurrentWindow()
//    {
//        var currentWindow = Driver.CurrentWindowHandle;
//        Driver.SwitchTo().Window(currentWindow);
//    }
//
//    protected string FindAndAttributesWithArray(By locator, int index)
//    {
//        var nonUniqueElement = Driver.FindElements(locator)[index];
//        string a = nonUniqueElement.GetAttribute("data-bind");
//        return a;
//    }
//
//    protected string FindTextWithArray(By locator, int index)
//    {
//        var nonUniqueElement = Driver.FindElements(locator)[index];
//        string a = nonUniqueElement.Text.Replace("$", "");
//        return a;
//    }
//
//    protected void SwitchContextToNewWindow(By locator, int index)
//    {
//        var frames = Driver.FindElements(locator);
//        Driver.SwitchTo().Frame(frames[index]);
//    }
//
//    protected void Click(By locator)
//    {
//        Find(locator).Click();
//    }
//    protected void Click(By locator, By displayed)
//    {
//        IsDisplayed(displayed, 60);
//        Find(locator).Click();
//    }
//    protected void Click(By locator, By displayed, By landing)
//    {
//        IsDisplayed(displayed, 60);
//        Find(locator).Click();
//        IsDisplayed(landing, 60);
//
//    }
//    protected bool IsDisplayedArray(By locator, int i)
//    {
//        try
//        {
//            return FindPlural(locator, i).Displayed;
//        }
//        catch (OpenQA.Selenium.NoSuchElementException)
//        {
//            return false;
//        }
//    }
//
//
//    protected void SwitchToNewWindow()
//    {
//        //Then to switch windows, use the window handles:
//        List<string> handles = Driver.WindowHandles.ToList<string>();
//        Driver.SwitchTo().Window(handles.Last());
//        Thread.Sleep(1200);
//    }
//
//
//    protected void OpenNewWindow(string url)
//    {
//        IJavaScriptExecutor jscript = Driver as IJavaScriptExecutor;
//        jscript.ExecuteScript("window.open()");
//        //Then to switch windows, use the window handles:
//        List<string> handles = Driver.WindowHandles.ToList<string>();
//        Driver.SwitchTo().Window(handles.Last());
//
//        Driver.Navigate().GoToUrl(url);
//        Thread.Sleep(1200);
//    }
//
//    //
//
//    protected void WaitUntilElementIsNoLongervisible(By locator, int maxWaitTime)
//    {
//        WebDriverWait Wait = new WebDriverWait(Driver, System.TimeSpan.FromSeconds(maxWaitTime));
//        Wait.Until(ExpectedConditions.InvisibilityOfElementLocated(locator));
//    }
//
//
//    protected void ClickArray(By locator, int array)
//    {
//        FindPlural(locator, array).Click();
//    }
//
//    protected void Type(By locator, string inputText)
//    {
//        Find(locator).SendKeys(inputText);
//
//    }
//
//    protected void Type(By locator, int array, string inputText)
//    {
//        FindPlural(locator, array).SendKeys(inputText);
//    }
//
//    public void SendKeyBoardCommands(string a)
//    {
//        Actions Builder = new Actions(Driver);
//        Builder.SendKeys(a).Build().Perform();
//
//    }
//
//    protected string GetText(By locator)
//    {
//        var text = Find(locator).Text;
//        return text.Replace("$","");
//    }
//
//    protected string GetText(By locator, int i)
//    {
//        var text = FindPlural(locator, i).Text;
//        return text;
//    }
//
//    protected string GetFieldText(By locator, int i, string value)
//    {
//        var fieldText = FindPlural(locator, i);
//        fieldText.GetAttribute(value);
//        return value;
//    }
//    protected string GetFieldText(By locator)
//    {
//        var fieldText = Find(locator);
//        var i = fieldText.GetAttribute("value");
//        return i;
//    }
//
//
//    protected string GetFieldText(By locator, int i)
//    {
//        var fieldText = FindPlural(locator, i);
//        var x = fieldText.GetAttribute("value");
//        return x;
//    }
//
//    protected string GetCheckedText(By locator, int i)
//    {
//        var fieldText = FindPlural(locator, i);
//        var x = fieldText.GetAttribute("checked");
//        return x;
//    }
//
//
//
//    protected decimal GetNumber(By locator)
//    {
//        var text = GetText(locator).Replace("-", "");
//        return decimal.Parse(text);
//    }
//
//    protected bool IsDisplayed(By locator)
//    {
//        try
//        {
//            return Find(locator).Displayed;
//        }
//        catch (OpenQA.Selenium.NoSuchElementException)
//        {
//            return false;
//        }
//    }
//    public void SelectFromDropdownTheEasyWay(By fieldLocation, string option)
//    {
//        SelectElement Dropdown = new SelectElement(Driver.FindElement(fieldLocation));
//        Dropdown.SelectByText(option);
//        // Assert.That(Dropdown.SelectedOption.Text.Equals("Option 1"));
//    }
//
//
//
//
//    public void ClearBrowserCache()
//    {
//        Driver.Manage().Cookies.DeleteAllCookies(); //delete all cookies
//        System.Threading.Thread.Sleep(10000); //wait 10 seconds to clear cookies.
//    }
//
//    public void CheckboxDiscovery(By locator)
//    {
//        IReadOnlyCollection<IWebElement> Checkboxes = Driver.FindElements(locator);
//        Console.Write("With .attribute('checked')"); foreach (IWebElement Checkbox in Checkboxes)
//        {
//            Console.WriteLine(Checkbox.GetAttribute("checked"));
//        }
//
//
//        //Console.WriteLine("With .selected?"); foreach (IWebElement Checkbox in Checkboxes)
//        //{
//        //   Console.WriteLine(Checkbox.Selected);
//        // }
//    }
//
//    public void DragAndDrop(By source, By target)
//    {
//        IWebElement e1 = Driver.FindElement(source);
//        IWebElement e2 = Driver.FindElement(target);
//        Actions ac = new Actions(Driver);
//        ac.DragAndDrop(e1, e2);
//        ac.Build().Perform();
//    }
//
//    public void JavaScriptClick(By locator)
//    {
//        IWebElement element = Driver.FindElement(locator);
//        IJavaScriptExecutor executor = (IJavaScriptExecutor)Driver;
//        executor.ExecuteScript("arguments[1].click();", element);
//    }
//
//    public void JavaScriptType(By locator, string value)
//    {
//        IWebElement searchbox = Driver.FindElement(locator);
//        IJavaScriptExecutor myExecutor = ((IJavaScriptExecutor)Driver);
//        myExecutor.ExecuteScript("arguments[0].value='"+value+"';", searchbox);
//    }
//
//    public void GetCheckBoxStatusByAttribute(By checkbox)
//    {
//
//        IWebElement Checkbox = Driver.FindElement( checkbox);
//
//        //Assert.That(Checkbox.GetAttribute("checked").Equals("true"));
//    }
//    public void MouseHoverDisplays(By location1, By location2, By destination)
//    {
//        ChangeContextToCurrentWindow();
//        IWebElement Item = Driver.FindElement(location1);
//        Actions Builder = new Actions(Driver);
//        Builder.MoveToElement(Item).Build().Perform();
//        ChangeContextToCurrentWindow();
//        IsDisplayed(location2, 800);
//        Click(location2);
//        IsDisplayed(destination, 800);
//    }
//
//    //private void TakeScreenshot()
//    //{
//    //    string SaveLocation = @"C:\Temp\" +
//    //                        "failshot_" +
//    //                        TestContext.CurrentContext.Test.FullName +
//    //                       ".png";
//    //    ITakesScreenshot ScreenshotDriver = (ITakesScreenshot)Driver;
//    //    ScreenshotDriver.GetScreenshot().SaveAsFile(SaveLocation, ImageFormat.Png);
//    //}
//    //[TearDown]
//    //public void TearDown()
//    //{
//    //    if (TestContext.CurrentContext.Result.Outcome.Status.Equals(TestStatus.Failed))
//    //        TakeScreenshot();
//    //    Driver.Quit();
//    //}
//
//
//
//    public void CloseBrowse()
//    {
//        Driver.Quit();
//    }
//
//    protected bool IsDisplayed(By locator, int maxWaitTime)
//    {
//        try
//        {
//            WebDriverWait Wait = new WebDriverWait(Driver, System.TimeSpan.FromSeconds(maxWaitTime));
//            Wait.Until(ExpectedConditions.ElementIsVisible(locator));
//
//            return true;
//        }
//        catch (OpenQA.Selenium.WebDriverTimeoutException)
//        {
//            return false;
//        }