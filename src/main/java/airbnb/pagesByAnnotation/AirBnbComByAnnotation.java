package airbnb.pagesByAnnotation;

import org.openqa.selenium.WebDriver;
import airbnb.libs.WebElements;
import java.io.IOException;

/**
 * Created by Sergio on 6/18/16.
 */
public class AirBnbComByAnnotation {
    WebDriver driver;
    public WebElements webElements;
    public HelpPageByAnnotation helpPage;
    public HomePageByAnnotation homePage;
    public ListYourSpacePageByAnnotation listYourSpacePage;
    public LoginPageByAnnotation loginPage;
    public RegistrationPageByAnnotation registrationPage;

    public AirBnbComByAnnotation(WebDriver driver) throws IOException {
        this.webElements = new WebElements(driver);
        this.homePage = new HomePageByAnnotation(driver);
        this.helpPage = new HelpPageByAnnotation(driver);
        this.listYourSpacePage = new ListYourSpacePageByAnnotation(driver);
        this.loginPage = new LoginPageByAnnotation(driver);
        this.registrationPage = new RegistrationPageByAnnotation(driver);
    }
}
