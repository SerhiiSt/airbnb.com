package airbnb.libs;

import java.io.IOException;
import java.sql.SQLException;
//import org.apache.log4j.Logger;
import org.testng.log4testng.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sergio on 6/18/16.
 */
public class DataBaseData {
    static Logger log = Logger.getLogger(DataBaseData.class);
    static WebDriver driver;
    static Database dB;

    public DataBaseData() {
    }

    public void dataBaseData(WebDriver driver) throws ClassNotFoundException, IOException, SQLException {
        driver = driver;
    }

    public String getSomeValue(String someData) throws SQLException, ClassNotFoundException, IOException {
        log.info("someData = " + someData);
        dB = new Database("PADB_DB", "Oracle");
        String someValue1 = dB.selectValue("select HASH,CREATE_DATE from cs_check_portal where " + someData);
        return someValue1;
    }
}
