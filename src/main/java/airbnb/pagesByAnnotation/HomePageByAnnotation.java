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
public class HomePageByAnnotation {
    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;
    @FindBy(
            xpath = ".//*[@id=\'login\']/a"
    )
    WebElement loginButton;
    @FindBy(
            xpath = ".//*[@id=\'sign_up\']/a"
    )
    WebElement signUpButton;
    @FindBy(
            xpath = ".//*[@id=\'header-help-trigger\']"
    )
    WebElement helpLink;
    @FindBy(
            partialLinkText = "See all FAQs"
    )
    WebElement helpLinkText;
    @FindBy(
            xpath = ".//a[contains(text(), \'List Your Space\')]"
    )
    WebElement listYourSpaceLink;

    public HomePageByAnnotation(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.log = Logger.getLogger(LoginPageByAnnotation.class);
        this.waitForCondition = new WebDriverWait(driver, 5L);
    }

    public void clickLoginButton() {
        this.loginButton.click();
        this.log.info("Login button was clicked");
    }

    public void clickRegistrationButton() {
        this.signUpButton.click();
        this.log.info("Registration button was clicked");
    }

    public void clickHelpButton() {
        this.helpLink.click();
        this.log.info("Help button was clicked");
    }

    public void selectFromListByFocus() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        (new Actions(this.driver)).moveToElement(this.helpLink).perform();
        (new Actions(this.driver)).moveToElement(this.helpLinkText).perform();
        this.helpLinkText.click();
    }

    public void clickListYourSpaceButton() {
        this.listYourSpaceLink.click();
        this.log.info("List Your Space button was clicked");
    }

    public void openURL(String url) {
        this.driver.manage().window().maximize();
        this.driver.get(url);
        this.log.debug("opened URL\' site");
    }

    public void quit() {
        this.driver.quit();
        this.log.debug("Quit from the browser");
    }
}
