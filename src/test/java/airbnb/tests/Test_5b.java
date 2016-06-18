package airbnb.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import airbnb.libs.ExcelDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;
import airbnb.pagesByDriver.AirBnbComByDriver;

/**
 * Created by Sergio on 6/18/16.
 */
public class Test_5b {
    private static WebDriver driver;
    static AirBnbComByDriver airBnb;
    static Logger log;
    static Map<String, String> data = new HashMap();

    public Test_5b() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        airBnb = new AirBnbComByDriver(driver);
        log = Logger.getLogger(Test_5b.class);
        data = ExcelDriver.getData("src/main/resources/testData.xls", "Test_5b");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        airBnb.webElements.openURL((String)data.get("url"));
        airBnb.homePage.clickHelpLink();
        airBnb.helpPage.clickHowMuchHelpLink();
    }

    @AfterClass
    public static void stopTest() {
        airBnb.webElements.quit();
    }
}
