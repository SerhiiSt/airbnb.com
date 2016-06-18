package airbnb.pagesByAnnotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.io.IOException;

/**
 * Created by Sergio on 6/18/16.
 */
public class LoginPageByAnnotation {
    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;
    @FindBy(
            xpath = ".//*[@id=\'signin_email\']"
    )
    WebElement emailTextField;
    @FindBy(
            xpath = ".//*[@id=\'signin_password\'] "
    )
    WebElement passTextField;
    @FindBy(
            xpath = ".//input[@id=\'remember_me2\']"
    )
    WebElement rememberMeCheckBox;
    @FindBy(
            xpath = ".//button[contains(text(),\'Log In\')]"
    )
    WebElement loginButton;
    @FindBy(
            xpath = ".//span[@class=\'value_name\']"
    )
    WebElement loginedUser;

    public LoginPageByAnnotation(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.log = Logger.getLogger(LoginPageByAnnotation.class);
        this.waitForCondition = new WebDriverWait(driver, 5L);
    }

    public void inputEmail(String email) {
        this.emailTextField.clear();
        this.emailTextField.sendKeys(new CharSequence[]{email});
        this.log.info(email + "was inputed into emailField");
    }

    public void inputPass(String pass) {
        this.passTextField.clear();
        this.passTextField.sendKeys(new CharSequence[]{pass});
        this.log.info(pass + "was inputed into passwordField");
    }

    public void selectRememberMeCheckBox(String checkBoxState) {
        if(this.rememberMeCheckBox.isSelected() && checkBoxState.equals("YES")) {
            this.waitForCondition.until(ExpectedConditions.elementSelectionStateToBe(this.rememberMeCheckBox, true));
            this.log.debug("checkBox is already selected");
        }

        if(this.rememberMeCheckBox.isSelected() && checkBoxState.equals("NO")) {
            this.rememberMeCheckBox.click();
            this.waitForCondition.until(ExpectedConditions.elementSelectionStateToBe(this.rememberMeCheckBox, false));
            this.log.debug("checkBox \'NO\' has been choosen");
        }

        if(!this.rememberMeCheckBox.isSelected() && checkBoxState.equals("YES")) {
            this.rememberMeCheckBox.click();
            this.waitForCondition.until(ExpectedConditions.elementToBeSelected(this.rememberMeCheckBox));
            this.log.debug("checkBox \'YES\' has been choosen");
        }

        if(!this.rememberMeCheckBox.isSelected() && checkBoxState.equals("NO")) {
            this.log.debug("checkBox is already deselected");
        }

    }

    public void clickLoginButton() {
        this.loginButton.click();
        this.log.info("Login button was clicked");
    }

    public void loginUser(String email, String pass, String checkBoxState) throws InterruptedException {
        this.inputEmail(email);
        this.inputPass(pass);
        this.selectRememberMeCheckBox(checkBoxState);
        this.clickLoginButton();
        this.log.info(email + "Email was inputed  " + pass + "password was inputted " + checkBoxState + "is checkBox state  ");
        this.waitForCondition.until(ExpectedConditions.visibilityOf(this.loginedUser));
    }

    public boolean isUserLogined() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(this.loginedUser.isDisplayed()) {
            this.log.info("User is logined");
            return true;
        } else {
            this.log.error("User  is not logined");
            return false;
        }
    }

    public void logMsgExamples() {
        this.loginButton.click();
        this.log.info("Login button was clicked");
        if(!this.loginButton.isDisplayed()) {
            this.log.error("Button is not displayed");
        }

    }
}
