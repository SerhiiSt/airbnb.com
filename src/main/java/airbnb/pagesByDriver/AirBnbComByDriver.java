package airbnb.pagesByDriver;

import java.io.IOException;
import airbnb.libs.WebElements;
import org.openqa.selenium.WebDriver;
import airbnb.pagesByDriver.HelpPageByDriver;
import airbnb.pagesByDriver.HomePageByDriver;
import airbnb.pagesByDriver.ListYourSpacePageByDriver;
import airbnb.pagesByDriver.LoginPageByDriver;
import airbnb.pagesByDriver.RegistrationPageByDriver;

/**
 * Created by Sergio on 6/18/16.
 */
public class AirBnbComByDriver {
    WebDriver driver;
    public WebElements webElements;
    public HelpPageByDriver helpPage;
    public HomePageByDriver homePage;
    public ListYourSpacePageByDriver listYourSpacePage;
    public LoginPageByDriver loginPage;
    public RegistrationPageByDriver registrationPage;

    public AirBnbComByDriver(WebDriver driver) throws IOException {
        this.webElements = new WebElements(driver);
        this.homePage = new HomePageByDriver(driver);
        this.helpPage = new HelpPageByDriver(driver);
        this.listYourSpacePage = new ListYourSpacePageByDriver(driver);
        this.loginPage = new LoginPageByDriver(driver);
        this.registrationPage = new RegistrationPageByDriver(driver);
    }
}
