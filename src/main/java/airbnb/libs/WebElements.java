package airbnb.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by Sergio on 6/16/16.
 */
public class WebElements {

    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;

    public WebElements(WebDriver driver){

        this.driver = driver;
        log = Logger.getLogger(WebElements.class);
        waitForCondition = new WebDriverWait(driver,5);

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This methos is used to click on the button
    * */
    public void clickButton(String buttonLocator ) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException {

        WebElement button;
        button = driver.findElement(By.xpath(buttonLocator));
        button.click();
        log.debug("Button click");
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to click on link by text
    * */
    public void clickLink(String linkText) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException {

        WebElement link;
        link = driver.findElement(By.xpath(linkText));
        link.click();
        log.debug("The link is clicked");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to click on radio-button
    * */
    public void selectRadioButton(String radioButtonLocator) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException {

        WebElement radioButton;
        radioButton = driver.findElement(By.xpath(radioButtonLocator));
        radioButton.click();
        log.debug("Radio Button is selected");
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to input some text into textField
    * */
    public void inputText(String fieldLocator, String text) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        WebElement textField;
        textField = driver.findElement(By.xpath(fieldLocator));
        textField.click();
        textField.clear();

        textField.sendKeys(text);
        log.debug("The text is inputted into textFiled");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This methos is used to select or deselect checkBox
    * checkBoxState should correspond to next format "YES/NO"
    * */
    public void selectCheckBox(String checkBoxLocator, String checkBoxState) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException {

        WebElement checkBox;
        checkBox = driver.findElement(By.xpath(checkBoxLocator));

        if(checkBox.isSelected() && checkBoxState.equals("YES")){

            waitForCondition.until(ExpectedConditions.elementToBeSelected(By.xpath(checkBoxLocator)));
            log.debug("checkBox is already selected");

        }

        if(checkBox.isSelected() && checkBoxState.equals("NO")){

            checkBox.click();
            waitForCondition.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.xpath(checkBoxLocator))));
            waitForCondition.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(checkBoxLocator),false));
            log.debug("checkBox 'NO' has been selected");

        }

        if(!checkBox.isSelected() && checkBoxState.equals("YES")){

            checkBox.click();
            waitForCondition.until(ExpectedConditions.elementToBeSelected(By.xpath(checkBoxLocator)));
            log.debug("checkBox 'YES' has been choosen");

        }

        if(!checkBox.isSelected() && checkBoxState.equals("NO")){

            log.debug("checkBox is already deselected");

        }

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to clear TextField
    * */
    public void clearTextField(String textFieldLocator) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        WebElement textField;
        textField = driver.findElement(By.xpath(textFieldLocator));
        textField.clear();
        log.debug("Clear textField");
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to input text and click enter
    * */
    public void inputSomeTextAndClickEnter(String textFieldLocator, String text) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        WebElement textField;
        textField = driver.findElement(By.xpath(textFieldLocator));
        driver.findElement(By.xpath(textFieldLocator)).sendKeys(Keys.ENTER);
        log.debug("Inputted text and clicked enter");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to click ALT + TAB
    * */
    public void clickALTTAB() throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ALT).sendKeys(Keys.TAB).perform();
        log.debug("Clicked ALT + TAB");


    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to open site URL
    * */
    public void openURL(String url){

        driver.manage().window().maximize();
        driver.get(url);
        log.debug("Opened URL' site");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used for select radio-button from block by value
    * */
    public void selectRadioButtonFromBlockByValue(String blockLocator, String radioButtonValue) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        String radioBtnXpath = blockLocator + "[@value='"+radioButtonValue+"']";
        WebElement radioButton;
        radioButton = driver.findElement(By.xpath(blockLocator));
        radioButton.click();
        log.debug("Selected radioButton from block by value");
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used for refresh page
    * */
    public void refreshPage() throws Exception{

        driver.navigate().refresh();

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used for clear cache
    * */
    public void clearCache() throws Exception{

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used for clear cookies
    * */
    public void clearCookies() throws  Exception{

        driver.manage().deleteAllCookies();

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used for select item from dropDownList
    * */
    public void selectItemFromDropDownList(String listLocator, String itemName) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException {

        WebElement list;
        list = driver.findElement(By.xpath(listLocator));
        list.click();
        Select select = new Select(list);
        select.selectByVisibleText(itemName);
        log.debug("itemName was choosen from dropDownList");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used for focus on the element
    * */
    public void focusOnElement(String elementLocator) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        WebElement element;
        element = driver.findElement(By.xpath(elementLocator));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        log.debug("Focus on the element");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used for select item from drop-down list by focus
    * */
    public void selectItemFromDropDownListByFocus(String listLocator, String sublistLocator, String itemName) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        WebElement list;
        list = driver.findElement(By.xpath(listLocator));
        list.click();
        WebElement sublist;
        sublist = driver.findElement(By.xpath(sublistLocator));
        new Actions(driver).moveToElement(sublist).perform();
        sublist.sendKeys(itemName);
        sublist.click();
        log.debug("itemName is selected item from dropDownlist by focus");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used to select item from dropDown list
    * */
    public void selectItemFromDropDownListByFocus(String listLocator, String itemName) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        WebElement list;
        list = driver.findElement(By.xpath(listLocator));
        focusOnElement(listLocator);
        Select select = new Select(list);
        select.selectByVisibleText(itemName);
        log.debug("DropDownlist was selected");

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used to check that element is present on the page
    * */
    public boolean isElementPresent(String elementLocator) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        try{

            driver.findElement(By.xpath(elementLocator));
            log.info("Element is present");
        }

        catch (org.openqa.selenium.NoSuchElementException Ex) {

            log.info("Element is not present");
            return  false;

        }

        return true;

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used for quit from browser
    * */
    public void quit(){

        driver.quit();
        log.debug("Quit from the browser");
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to switch another window
    * */
    public void switchWindow(int numberOfWindow){

        String handle = driver.getWindowHandles().toArray()[numberOfWindow].toString();
        driver.switchTo().window(handle);

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used to switch to opened window
    * */
    public void switchToNewWindow(){

        String parentHandle = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){

            driver.switchTo().window(winHandle);

        }
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This is method is used to select from drop-dow list by first focus on list
    * */
    public  void selectFromListByFocus(String listValue, String listLocator) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        WebElement list;
        list = driver.findElement(By.xpath(listLocator));
        new Actions(driver).moveToElement(list).perform();
        WebElement subList;
        subList = driver.findElement(By.xpath(listValue));
        new Actions(driver).moveToElement(subList).perform();
        subList.click();

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    * This method is used for switch to another element
    * */
    public  void moveToAnotherElement(String winLocator) throws ClassNotFoundException, IllegalAccessException,InstantiationException,IOException{

        driver.switchTo().activeElement().findElement(By.xpath(winLocator));

    }

    //------------------------------------------------------------------------------------------------------------------

}






