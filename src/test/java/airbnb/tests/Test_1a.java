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
public class Test_1a {
    private static WebDriver driver;
    static AirBnbComByAnnotation airBnb;
    static Logger log;
    static Map<String, String> data = new HashMap();
    static String appUrl;

    public Test_1a() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        airBnb = new AirBnbComByAnnotation(driver);
        log = Logger.getLogger(Test_1a.class);
        data = ExcelDriver.getData("src/main/resources/testData.xls", "Test_1a");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        airBnb.homePage.openURL(appUrl);
        airBnb.homePage.clickLoginButton();
        airBnb.loginPage.loginUser((String)data.get("email"), (String)data.get("pass"), (String)data.get("rememberMeCheckBox"));
        airBnb.loginPage.isUserLogined();
        Assert.assertTrue(airBnb.loginPage.isUserLogined());
    }

    @AfterClass
    public static void stopTest() {
        airBnb.homePage.quit();
    }
}

