package airbnb.pagesByAnnotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.io.IOException;

/**
 * Created by Sergio on 6/18/16.
 */
public class HelpPageByAnnotation {
    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;
    @FindBy(
            xpath = ".//a[@href=\'/help/article/926\']"
    )
    WebElement top10TipsForSuccessfulHostingLink;
    @FindBy(
            xpath = ".//a[@href=\'/help/article/125\']"
    )
    WebElement howMuchDoIPayForReservationLink;

    public HelpPageByAnnotation(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.log = Logger.getLogger(LoginPageByAnnotation.class);
        this.waitForCondition = new WebDriverWait(driver, 5L);
    }

    public void clickTop10TipsForSuccessfulHostingLink() {
        this.top10TipsForSuccessfulHostingLink.click();
        this.log.info("Top 10 Tips For Successful Hosting link was clicked");
    }

    public void clickHowMuchDoIPayForReservationLink() {
        this.howMuchDoIPayForReservationLink.click();
        this.log.info("How Much Do I Pay For Reservation link was clicked");
    }
}
