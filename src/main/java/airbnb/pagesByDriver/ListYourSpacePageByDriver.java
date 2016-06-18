package airbnb.pagesByDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import airbnb.libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import airbnb.pagesByDriver.LoginPageByDriver;

/**
 * Created by Sergio on 6/18/16.
 */
public class ListYourSpacePageByDriver {
    WebDriver driver;
    WebElements web;
    Logger log;
    WebDriverWait waitForCondition;

    public ListYourSpacePageByDriver(WebDriver driver) throws IOException {
        this.driver = driver;
        this.web = new WebElements(driver);
        this.log = Logger.getLogger(LoginPageByDriver.class);
        this.waitForCondition = new WebDriverWait(driver, 5L);
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    public void clickHomeTypeListButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("ListYourSpace.HomeTypeApartmentButton");
        this.log.info("Apartment is choosen from Home Type button");
    }

    public void clickRoomTypeListButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("ListYourSpace.RoomTypeEntireHomeButton");
        this.log.info("Entire home is choosen from Room Type button");
    }

    public void clickOnFocusedList() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.selectItemFromDropDownListByFocus("ListYourSpace.AccommodatesDropDownList", "ListYourSpace.AccommodateDropDownList16", "+16");
        this.log.info("Item is choosen from dropdown list");
    }

    public void inputCity(String city) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("ListYourSpace.CityField", city);
        this.log.info(city + "was inputed into City field");
    }

    public void clickContinueButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("ListYourSpace.ContinueButton");
        this.log.info("Continue button was clicked");
    }
}
