package airbnb.pagesByDriver;

import java.io.IOException;
import airbnb.libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

/**
 * Created by Sergio on 6/18/16.
 */
public class HelpPageByDriver {
    WebDriver driver;
    WebElements web;
    Logger log;

    public HelpPageByDriver(WebDriver driver) throws IOException {
        this.driver = driver;
        this.web = new WebElements(driver);
        this.log = Logger.getLogger(HelpPageByDriver.class);
    }

    public void clickTop10HelpLink() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickLink("HelpPage.Top10TipsForSuccessfulHostingLink");
        this.log.info("Link is clicked");
    }

    public void clickHowMuchHelpLink() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        this.web.clickLink("HelpPage.HowMuchDoIPayForReservationLink");
        this.log.info("Link is clicked");
    }
}
