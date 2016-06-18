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
import airbnb.pagesByAnnotation.AirBnbComByAnnotation;

/**
 * Created by Sergio on 6/18/16.
 */
public class Test_2a2 {
    private static WebDriver driver;
    static AirBnbComByAnnotation airBnb;
    static Logger log;
    static Map<String, String> data = new HashMap();
    static String appUrl;

    public Test_2a2() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        airBnb = new AirBnbComByAnnotation(driver);
        log = Logger.getLogger(Test_2a2.class);
        data = ExcelDriver.getData("src/main/resources/testData.xls", "Test_2a2");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        airBnb.homePage.openURL(appUrl);
        airBnb.homePage.clickRegistrationButton();
        airBnb.registrationPage.registrationUserWithFacebook((String)data.get("email"), (String)data.get("pass"), (String)data.get("rememberMeComboBox"));
        airBnb.registrationPage.isUserCreated();
        Assert.assertTrue(airBnb.registrationPage.isUserCreated());
    }

    @AfterClass
    public static void stopTest() {
        airBnb.homePage.quit();
    }
}
