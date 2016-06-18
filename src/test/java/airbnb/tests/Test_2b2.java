package airbnb.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import airbnb.libs.ConfigData;
import airbnb.libs.ExcelDriver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;
import airbnb.pagesByDriver.AirBnbComByDriver;

/**
 * Created by Sergio on 6/18/16.
 */
public class Test_2b2 {
    private static WebDriver driver;
    static AirBnbComByDriver airBnb;
    static Logger log;
    static Map<String, String> data = new HashMap();
    static String appUrl;

    public Test_2b2() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        airBnb = new AirBnbComByDriver(driver);
        log = Logger.getLogger(Test_2b2.class);
        data = ExcelDriver.getData("src/main/resources/testData.xls", "Test_2b2");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        airBnb.webElements.openURL(appUrl);
        airBnb.homePage.clickSignUpButton();
        airBnb.registrationPage.clickSignUpWithFacebookButton();
        airBnb.registrationPage.inputEmailWithFacebook((String)data.get("email"));
        airBnb.registrationPage.inputPasswordWithFacebook((String)data.get("pass"));
        airBnb.registrationPage.selectFacebookRememberMeCheckBox((String)data.get("rememberMeCheckBox"));
        airBnb.registrationPage.clickFacebookLoginButton();
        airBnb.registrationPage.isUserCreated();
        Assert.assertTrue(airBnb.registrationPage.isUserCreated());
    }

    @AfterClass
    public static void stopTest() {
        airBnb.webElements.quit();
    }
}
