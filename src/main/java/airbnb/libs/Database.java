package airbnb.libs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import org.apache.log4j.Logger;
import org.testng.log4testng.Logger;

/**
 * Created by Sergio on 6/18/16.
 */
public class Database {
    private Connection connection = null;
    private String url;
    static Logger log = Logger.getLogger(Database.class);

    public Database(String db, String driver) throws IOException, ClassNotFoundException, SQLException {
        this.url = ConfigData.getCfgValue(db);
        log.info("Р”Р°РЅРЅС‹Рµ СЃС‡РёС‚Р°РЅС‹ url database: " + this.url);
        Class.forName(ConfigData.getCfgValue(driver));
        log.info("РЎС‡РёС‚Р°Р»Рё SQL РґСЂР°Р№РІРµСЂ ");
        String user_name = ConfigData.getCfgValue(db + "_USER");
        String user_pass = ConfigData.getCfgValue(db + "_PASSWORD");
        log.info(" user - " + user_name + " pass " + user_pass);
        this.connection = DriverManager.getConnection(this.url, ConfigData.getCfgValue(db + "_USER"), ConfigData.getCfgValue(db + "_PASSWORD"));
        log.info("РґР°Р»СЊС€Рµ РѕРїСЏС‚СЊ" + this.connection);
    }

    public boolean isRowPresent(String query) throws SQLException {
        Statement stm = this.connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);

        int rowNumber;
        for(rowNumber = 0; rSet.next(); ++rowNumber) {
            ;
        }

        stm.close();
        return rowNumber != 0;
    }

    public String selectValue(String query) throws SQLException {
        Statement stm = this.connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        String value = "";
        if(rSet.next() && rSet.getObject(1) != null) {
            value = rSet.getObject(1).toString();
            if(meta.getColumnType(1) == 93) {
                value = value.substring(0, value.length() - 2);
            }
        }

        stm.close();
        value = value.trim();
        return value;
    }

    public List selectResultSet(String query) throws SQLException {
        Statement stm = this.connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        ArrayList resultSet = new ArrayList();

        while(rSet.next()) {
            String value = "";
            if(rSet.getObject(1) != null) {
                value = rSet.getObject(1).toString();
                if(meta.getColumnType(1) == 93) {
                    value = value.substring(0, value.length() - 2);
                }
            }

            value = value.trim();
            resultSet.add(value);
        }

        stm.close();
        return resultSet;
    }

    public List selectTable(String query) throws SQLException {
        Statement stm = this.connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        int columnNumber = meta.getColumnCount();
        ArrayList resultTable = new ArrayList();
        ArrayList columnNameSet = new ArrayList();
        columnNameSet.add("");

        int resultSize;
        for(resultSize = 0; resultSize < columnNumber; ++resultSize) {
            columnNameSet.add(meta.getColumnName(resultSize + 1));
        }

        resultTable.add(columnNameSet);
        resultSize = 0;

        while(rSet.next()) {
            ArrayList resultSet = new ArrayList();
            ++resultSize;
            resultSet.add(String.valueOf(resultSize));

            for(int k = 1; k < columnNumber + 1; ++k) {
                String value = "";
                if(rSet.getObject(k) != null) {
                    value = rSet.getObject(k).toString();
                    if(meta.getColumnType(k) == 93) {
                        value = value.substring(0, value.length() - 2);
                    }
                }

                value = value.trim();
                resultSet.add(value);
            }

            resultTable.add(resultSet);
        }

        stm.close();
        return resultTable;
    }

    public int getRowNumber(String query) throws SQLException {
        Statement stm = this.connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        int rowCount = 0;
        if(rSet.next() && rSet.getObject(1) != null) {
            rowCount = Integer.parseInt(rSet.getObject(1).toString());
        }

        stm.close();
        return rowCount;
    }

    public String randDbValue(String query) throws SQLException {
        Statement stm = this.connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();
        String value = "";
        if(rSet.next() && rSet.getObject(1) != null) {
            value = rSet.getObject(1).toString();
            if(meta.getColumnType(1) == 93) {
                value = value.substring(0, value.length() - 2);
            }
        }

        stm.close();
        value = value.trim();
        return value;
    }

    public void quit() throws SQLException {
        this.connection.close();
    }
}
