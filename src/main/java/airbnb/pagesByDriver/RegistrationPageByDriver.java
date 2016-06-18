package airbnb.pagesByDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import airbnb.libs.ConfigData;
import airbnb.libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import airbnb.pagesByDriver.LoginPageByDriver;

/**
 * Created by Sergio on 6/18/16.
 */
public class RegistrationPageByDriver {
    static WebDriver driver;
    WebElements web;
    Logger log;
    WebDriverWait waitForCondition;

    public RegistrationPageByDriver(WebDriver driver) throws IOException {
        driver = driver;
        this.web = new WebElements(driver);
        this.log = Logger.getLogger(LoginPageByDriver.class);
        this.waitForCondition = new WebDriverWait(driver, 5L);
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    public void clickSignUpWithEmailButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("RegistrationPage.SignUpWithEmailButton");
        this.log.info("SignUpWithEmail button was clicked");
    }

    public void inputFirstName(String firstName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("RegistrationPage.FirstNameField", firstName);
        this.log.info(firstName + "was inputed into First name field");
    }

    public void inputLastName(String lastName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("RegistrationPage.LastNameField", lastName);
        this.log.info(lastName + "was inputed into Last name field");
    }

    public void inputEmail(String email) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("RegistrationPage.EmailAddressField", email);
        this.log.info(email + "was inputed into Email Address field");
    }

    public void inputPassword(String pass) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("RegistrationPage.PasswordField", pass);
        this.log.info(pass + "was inputed into Password field");
    }

    public void inputConfirmPassword(String pass) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("RegistrationPage.ConfirmPasswordField", pass);
        this.log.info(pass + "was inputed into Confirm Password field");
    }

    public void selectRememberMeCheckBox() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(this.web.isElementPresent("RegistrationPage.RememberMeCheckbox")) {
            this.web.selectCheckBox("RegistrationPage.RememberMeCheckbox", "NO");
            this.log.info("Checkbox has been choosen");
        } else {
            this.log.error("Unfortunately, no such element");
        }

    }

    public void clickSignUpButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("RegistrationPage.SignUpButton");
        this.log.info("Sign up button was clicked");
    }

    public void clickSignUpWithFacebookButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("RegistrationPage.SignUpWithFacebook");
        this.log.info("SignUpWithFacebook button was clicked");
        this.web.switchToNewWindow();
    }

    public void inputEmailWithFacebook(String email) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("RegistrationPage.EmailWithFacebookField", email);
        this.log.info(email + "was inputed into Email or Phone field");
    }

    public void inputPasswordWithFacebook(String pass) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.inputText("RegistrationPage.PasswordWithFacebookField", pass);
        this.log.info(pass + "was inputed into Password field");
    }

    public void selectFacebookRememberMeCheckBox(String checkBoxState) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(this.web.isElementPresent("RegistrationPage.FacebookRememberMeCheckbox")) {
            this.web.selectCheckBox("RegistrationPage.FacebookRememberMeCheckbox", checkBoxState);
            this.log.info(checkBoxState + "is a state of Facebook checkBox for remember of password");
        } else {
            this.log.error("Unfortunately, no such element");
        }

    }

    public void clickFacebookLoginButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("RegistrationPage.FacebookLoginButton");
        this.log.info("Log In button was clicked");
        this.web.switchWindow(0);
        this.waitForCondition.until(ExpectedConditions.visibilityOfElementLocated(ConfigData.ui("RegistrationPage.IsUserCreated")));
    }

    public boolean isUserCreated() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(this.web.isElementPresent("RegistrationPage.IsUserCreated")) {
            this.log.info("User is registered");
            return true;
        } else {
            this.log.error("User is not registered");
            return false;
        }
    }
}
