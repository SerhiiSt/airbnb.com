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
import airbnb.pagesByAnnotation.AirBnbComByAnnotation;


/**
 * Created by Sergio on 6/18/16.
 */
public class Test_5a {
    private static WebDriver driver;
    static AirBnbComByAnnotation airBnb;
    static Logger log;
    static Map<String, String> data = new HashMap();

    public Test_5a() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        airBnb = new AirBnbComByAnnotation(driver);
        log = Logger.getLogger(Test_5a.class);
        data = ExcelDriver.getData("src/main/resources/testData.xls", "Test_5a");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        airBnb.homePage.openURL((String)data.get("url"));
        airBnb.homePage.selectFromListByFocus();
        airBnb.helpPage.clickHowMuchDoIPayForReservationLink();
    }

    @AfterClass
    public static void stopTest() {
        airBnb.homePage.quit();
    }
}
