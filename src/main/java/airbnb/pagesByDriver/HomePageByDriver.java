package airbnb.pagesByDriver;

import java.io.IOException;
import airbnb.libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

/**
 * Created by Sergio on 6/18/16.
 */
public class HomePageByDriver {
    WebDriver driver;
    WebElements web;
    Logger log;

    public HomePageByDriver(WebDriver driver) throws IOException {
        this.driver = driver;
        this.web = new WebElements(driver);
        this.log = Logger.getLogger(HomePageByDriver.class);
    }

    public void clickLoginButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("HomePage.LoginLink");
        this.log.info("Log In button is clicked");
    }

    public void clickSignUpButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("HomePage.SignUpLink");
        this.log.info("Sign Up button is clicked");
    }

    public void clickHelpLink() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.selectFromListByFocus("HomePage.HelpLinkText", "HomePage.HelpLink");
        this.log.info("Help link is clicked ");
    }

    public void clickListYouSpaceButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickButton("HomePage.ListYourSpace");
        this.log.info("List Your Space button is clicked");
    }
}
