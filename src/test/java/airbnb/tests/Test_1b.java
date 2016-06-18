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
public class Test_1b {
    private static WebDriver driver;
    static AirBnbComByDriver airBnb;
    static Logger log;
    static Map<String, String> data = new HashMap();
    static String appUrl;

    public Test_1b() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        airBnb = new AirBnbComByDriver(driver);
        log = Logger.getLogger(Test_1b.class);
        data = ExcelDriver.getData("src/main/resources/testData.xls", "Test_1b");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        airBnb.webElements.openURL(appUrl);
        airBnb.homePage.clickLoginButton();
        airBnb.loginPage.inputEmail((String)data.get("email"));
        airBnb.loginPage.inputPassword((String)data.get("pass"));
        airBnb.loginPage.selectRememberMeCheckBox((String)data.get("rememberMeCheckBox"));
        airBnb.loginPage.clickLoginButton();
        airBnb.loginPage.isUserLogined();
        Assert.assertTrue(airBnb.loginPage.isUserLogined());
    }

    @AfterClass
    public static void stopTest() {
        airBnb.webElements.quit();
    }
}
