package airbnb.tests;

import java.io.IOException;
import java.sql.SQLException;
import airbnb.libs.DataBaseData;
import airbnb.libs.Database;
import org.testng.log4testng.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sergio on 6/18/16.
 */
public class TestDataBase {
    static Logger log = Logger.getLogger(DataBaseData.class);
    static WebDriver driver;
    static Database dB;
    static Database dBMySQL;
    static DataBaseData dBData;

    public TestDataBase() {
    }

    @Before
    public void setUp() throws Exception {
        log.info("--- Conect MySQL DB --------");
        dBMySQL = new Database("MySQL_PADB_DB", "sqlServer");
        log.info("--- Conected to MySQL --------");
        log.info("--- Test STARTED --------");
    }

    @Test
    public void Teas1() throws SQLException, ClassNotFoundException, IOException {
        String testMySQLTable = dBMySQL.selectValue("select NAME from STUDENTS where ID=\'1\'");
        log.info("value -- " + testMySQLTable);
    }

    @After
    public void tearDown() throws Exception {
        dBMySQL.quit();
        log.info(" ----- Test END  -----");
    }
}
