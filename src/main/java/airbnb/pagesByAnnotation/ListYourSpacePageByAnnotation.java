package airbnb.pagesByAnnotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.io.IOException;

/**
 * Created by Sergio on 6/18/16.
 */
public class ListYourSpacePageByAnnotation {
    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;
    @FindBy(
            xpath = ".//button[@data-name=\'Apartment\']"
    )
    WebElement apartmentButton;
    @FindBy(
            xpath = ".//button[@data-name=\'House\']"
    )
    WebElement houseButton;
    @FindBy(
            xpath = ".//button[@data-name=\'Bed & Breakfast\']"
    )
    WebElement bedAndBreakfastButton;
    @FindBy(
            xpath = ".//option[@selected=\'\'][contains(text(),\'Other\')"
    )
    WebElement otherList;
    @FindBy(
            xpath = ".//button[@data-name=\'Entire home/apt\']"
    )
    WebElement entireHomeButton;
    @FindBy(
            xpath = ".//button[@data-name=\'Private room\']"
    )
    WebElement privateRoomButton;
    @FindBy(
            xpath = ".//button[@data-name=\'Shared room\'] "
    )
    WebElement shareRoomButton;
    @FindBy(
            xpath = ".//*[@id=\'accomodates-select\']"
    )
    WebElement accommodatesList;
    @FindBy(
            xpath = ".//select/*[@data-accommodates=\'16+\']"
    )
    WebElement accommodatesList16;
    @FindBy(
            xpath = ".//*[@id=\'location_input\']"
    )
    WebElement cityField;
    @FindBy(
            xpath = ".//button[contains(text(),\'Continue\')]"
    )
    WebElement continueButton;

    public ListYourSpacePageByAnnotation(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.log = Logger.getLogger(LoginPageByAnnotation.class);
        this.waitForCondition = new WebDriverWait(driver, 5L);
    }

    public void clickApartmentButton() {
        this.apartmentButton.click();
        this.log.info("Apartment button was clicked");
    }

    public void clickEntireHomeButton() {
        this.entireHomeButton.click();
        this.log.info("Entire home button was clicked");
    }

    public void selectItemFromDropDownListByFocus(String itemName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.accommodatesList.click();
        (new Actions(this.driver)).moveToElement(this.accommodatesList16).perform();
        this.accommodatesList16.sendKeys(new CharSequence[]{itemName});
        this.accommodatesList16.click();
    }

    public void inputCity(String city) {
        this.cityField.clear();
        this.cityField.sendKeys(new CharSequence[]{city});
        this.log.info(city + "was inputed into cityField");
    }

    public void clickContinueButton() {
        this.continueButton.click();
        this.log.info("Continue button was clicked");
    }

    public void searchListYourSpace(String itemName, String city) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.clickApartmentButton();
        this.clickEntireHomeButton();
        this.selectItemFromDropDownListByFocus(itemName);
        this.inputCity(city);
        this.clickContinueButton();
    }
}
