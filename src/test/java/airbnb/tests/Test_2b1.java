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
public class Test_2b1 {
    private static WebDriver driver;
    static AirBnbComByDriver airBnb;
    static Logger log;
    static Map<String, String> data = new HashMap();
    static String appUrl;

    public Test_2b1() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        airBnb = new AirBnbComByDriver(driver);
        log = Logger.getLogger(Test_2b1.class);
        data = ExcelDriver.getData("src/main/resources/testData.xls", "Test_2b1");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        airBnb.webElements.openURL(appUrl);
        airBnb.homePage.clickSignUpButton();
        airBnb.registrationPage.clickSignUpWithEmailButton();
        airBnb.registrationPage.inputFirstName((String)data.get("firstName"));
        airBnb.registrationPage.inputLastName((String)data.get("lastName"));
        airBnb.registrationPage.inputEmail((String)data.get("email"));
        airBnb.registrationPage.inputPassword((String)data.get("pass"));
        airBnb.registrationPage.inputConfirmPassword((String)data.get("confpass"));
        airBnb.registrationPage.selectRememberMeCheckBox();
        airBnb.registrationPage.clickSignUpButton();
        airBnb.registrationPage.isUserCreated();
        Assert.assertTrue(airBnb.registrationPage.isUserCreated());
    }

    @AfterClass
    public static void stopTest() {
        airBnb.webElements.quit();
    }
}
