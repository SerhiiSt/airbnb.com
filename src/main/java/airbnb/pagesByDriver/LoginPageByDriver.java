package airbnb.pagesByDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import airbnb.libs.ConfigData;
import airbnb.libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

/**
 * Created by Sergio on 6/18/16.
 */
public class LoginPageByDriver {
    WebDriver driver;
    WebElements web;
    Logger log;
    WebDriverWait waitForCondition;

    public LoginPageByDriver(WebDriver driver) throws IOException {
        this.driver = driver;
        this.web = new WebElements(driver);
        this.log = Logger.getLogger(LoginPageByDriver.class);
        this.waitForCondition = new WebDriverWait(driver, 30L);
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

    public void inputEmail(String email) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("LoginPage.EmailField", email);
        this.log.info(email + "was inputed into EmailField");
    }

    public void inputPassword(String pass) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("LoginPage.PassField", pass);
        this.log.info(pass + " was inputed into PasswordField");
    }

    public void selectRememberMeCheckBox(String checkBoxState) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(this.web.isElementPresent("LoginPage.RememberMeCheckbox")) {
            this.web.selectCheckBox("LoginPage.RememberMeCheckbox", checkBoxState);
            this.log.info(checkBoxState + "is a state of checkBox for remember of password");
        } else {
            this.log.error("Unfortunately, no such element");
        }

    }

    public void clickLoginButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("LoginPage.LoginButton");
        this.log.info("Login button was clicked");
        this.waitForCondition.until(ExpectedConditions.visibilityOfElementLocated(ConfigData.ui("LoginPage.UserElement")));
    }

    public boolean isUserLogined() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(this.web.isElementPresent("LoginPage.UserElement")) {
            this.log.info("User is log in");
            return true;
        } else {
            this.log.error("User is not log in");
            return false;
        }
    }
}
