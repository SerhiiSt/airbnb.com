package airbnb.pagesByAnnotation;

import java.io.IOException;
import java.util.Iterator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;


/**
 * Created by Sergio on 6/18/16.
 */
public class RegistrationPageByAnnotation {
    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;
    @FindBy(
            xpath = ".//a[@href=\'/signup_login?sm=2\']"
    )
    WebElement emailButton;
    @FindBy(
            xpath = ".//input[@name=\'user[first_name]\'] "
    )
    WebElement firstNameField;
    @FindBy(
            xpath = ".//input[@name=\'user[last_name]\'] "
    )
    WebElement lastNameField;
    @FindBy(
            xpath = ".//input[@name=\'user[email]\']"
    )
    WebElement emailField;
    @FindBy(
            xpath = ".//input[@name=\'user[password]\']"
    )
    WebElement passField;
    @FindBy(
            xpath = ".//input[@name=\'user[password_confirmation]\']"
    )
    WebElement passConfirmField;
    @FindBy(
            xpath = ".//input[@type=\'checkbox\'][@name=\'user_profile_info[receive_promotional_email]\']"
    )
    WebElement rememberMeCheckBox;
    @FindBy(
            xpath = ".//button[@class=\'btn btn-primary btn-block btn-large large padded-btn-block\'][@type=\'submit\'] "
    )
    WebElement signUpButton;
    @FindBy(
            xpath = ".//span[@class=\'value_name\']"
    )
    WebElement isUserCreated;
    @FindBy(
            xpath = ".//a[@class=\'fb-button fb-blue btn icon-btn btn-block padded-btn-block row-space-1 btn-large large btn-facebook\']"
    )
    WebElement facebookButton;
    @FindBy(
            xpath = ".//input[@id=\'email\'][@name=\'email\']"
    )
    WebElement emailFacebookField;
    @FindBy(
            xpath = ".//input[@id=\'pass\']"
    )
    WebElement passwordFacebookField;
    @FindBy(
            xpath = ".//*[@id=\'persist_box\']"
    )
    WebElement rememberMeCheckBoxFaceBook;
    @FindBy(
            xpath = ".//*[@id=\'loginbutton\']"
    )
    WebElement loginFacebookButton;

    public RegistrationPageByAnnotation(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.log = Logger.getLogger(LoginPageByAnnotation.class);
        this.waitForCondition = new WebDriverWait(driver, 5L);
    }

    public void clearCookies() throws Exception {
        this.driver.manage().deleteAllCookies();
    }

    public void clickRegistrationWithEmailButton() {
        this.emailButton.click();
        this.log.info("Registration with email button was clicked");
    }

    public void inputFirstName(String firstName) {
        this.firstNameField.clear();
        this.firstNameField.sendKeys(new CharSequence[]{firstName});
        this.log.info(firstName + "was inputed into firstNameField");
    }

    public void inputLastName(String lastName) {
        this.lastNameField.clear();
        this.lastNameField.sendKeys(new CharSequence[]{lastName});
        this.log.info(lastName + "was inputed into lastNameField");
    }

    public void inputEmail(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(new CharSequence[]{email});
        this.log.info(email + "was inputed into emailField");
    }

    public void inputPassword(String pass) {
        this.passField.clear();
        this.passField.sendKeys(new CharSequence[]{pass});
        this.log.info(pass + "was inputed into passField");
    }

    public void inputConfirmPassword(String pass) {
        this.passConfirmField.clear();
        this.passConfirmField.sendKeys(new CharSequence[]{pass});
        this.log.info(pass + "was inputed into passConfirmField");
    }

    public void selectRememberMeCheckBox(String checkBoxState) {
        if(this.rememberMeCheckBox.isSelected() && checkBoxState.equals("NO")) {
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

    public void clickRegistrationButton() {
        this.signUpButton.click();
        this.log.info("Sign up button  was clicked");
    }

    public void registrationUserWithEmail(String firstName, String lastName, String email, String pass, String checkBoxState) {
        this.clickRegistrationWithEmailButton();
        this.inputFirstName(firstName);
        this.inputLastName(lastName);
        this.inputEmail(email);
        this.inputPassword(pass);
        this.inputConfirmPassword(pass);
        this.selectRememberMeCheckBox(checkBoxState);
        this.clickRegistrationButton();
        this.log.info("Registration user with help email has been complited");
        this.waitForCondition.until(ExpectedConditions.visibilityOf(this.isUserCreated));
    }

    public boolean isUserCreated() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(this.isUserCreated.isDisplayed()) {
            this.log.info("User has been created");
            return true;
        } else {
            this.log.error("User  has not been created");
            return false;
        }
    }

    public void clickRegistrationWithFacebookButton() {
        this.facebookButton.click();
        this.log.info("Registration with Facebook button was clicked");
    }

    public void inputEmailWithFacebook(String email) {
        this.emailFacebookField.clear();
        this.emailFacebookField.sendKeys(new CharSequence[]{email});
        this.log.info(email + "was inputed into emailField");
    }

    public void inputPasswordWithFacebook(String pass) {
        this.passwordFacebookField.clear();
        this.passwordFacebookField.sendKeys(new CharSequence[]{pass});
        this.log.info(pass + "was inputed into passField");
    }

    public void selectFacebookRememberMeCheckBox(String checkBoxState) {
        if(this.rememberMeCheckBoxFaceBook.isSelected() && checkBoxState.equals("YES")) {
            this.waitForCondition.until(ExpectedConditions.elementSelectionStateToBe(this.rememberMeCheckBoxFaceBook, true));
            this.log.debug("checkBox is already selected");
        }

        if(this.rememberMeCheckBoxFaceBook.isSelected() && checkBoxState.equals("NO")) {
            this.rememberMeCheckBoxFaceBook.click();
            this.waitForCondition.until(ExpectedConditions.elementSelectionStateToBe(this.rememberMeCheckBoxFaceBook, false));
            this.log.debug("checkBox \'NO\' has been choosen");
        }

        if(!this.rememberMeCheckBoxFaceBook.isSelected() && checkBoxState.equals("YES")) {
            this.rememberMeCheckBoxFaceBook.click();
            this.waitForCondition.until(ExpectedConditions.elementToBeSelected(this.rememberMeCheckBoxFaceBook));
            this.log.debug("checkBox \'YES\' has been choosen");
        }

        if(!this.rememberMeCheckBoxFaceBook.isSelected() && checkBoxState.equals("NO")) {
            this.log.debug("checkBox is already deselected");
        }

    }

    public void clickFacebookRegistrationButton() {
        this.loginFacebookButton.click();
        this.log.info("Facebook Registration button  was clicked");
    }

    public void registrationUserWithFacebook(String email, String pass, String checkBoxState) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        this.clickRegistrationWithFacebookButton();
        this.swithcToNewWindow();
        this.inputEmailWithFacebook(email);
        this.inputPasswordWithFacebook(pass);
        this.selectFacebookRememberMeCheckBox(checkBoxState);
        this.clickFacebookRegistrationButton();
        this.log.info("Registration user with help facebook has been done");
        this.switchWindow(0);
        this.waitForCondition.until(ExpectedConditions.visibilityOf(this.isUserCreated));
    }

    public void swithcToNewWindow() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        String parentHandle = this.driver.getWindowHandle();
        Iterator var3 = this.driver.getWindowHandles().iterator();

        while(var3.hasNext()) {
            String winHandle = (String)var3.next();
            this.driver.switchTo().window(winHandle);
        }

    }

    public void switchWindow(int numberOfWindow) {
        String handle = this.driver.getWindowHandles().toArray()[numberOfWindow].toString();
        this.driver.switchTo().window(handle);
    }
}
