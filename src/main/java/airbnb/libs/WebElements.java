package airbnb.libs;

import org.testng.log4testng.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergio on 6/16/16.
 */
public class WebElements {

    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;

    public WebElements(WebDriver driver){

        this.driver = driver;
        log = Logger.getLogger(WebElements.class);
        waitForCondition = new WebDriverWait(driver,5);

    }



}






