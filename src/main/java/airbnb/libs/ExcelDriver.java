package airbnb.libs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * Created by Sergio on 6/18/16.
 */
public class ExcelDriver {
    public ExcelDriver() {
    }

    public static Map getMultipleData(String dataFileName, String sheetName, int columnNumber) throws IOException {
        HashMap testData = new HashMap();
        FileInputStream input = new FileInputStream(dataFileName);
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
        HSSFSheet sheet = wb.getSheet(sheetName);
        int dataSize = sheet.getPhysicalNumberOfRows() - 2;

        for(int k = 2; k < dataSize + 2; ++k) {
            HSSFCell keyCell = sheet.getRow(k).getCell(0);
            HSSFCell valueCell = sheet.getRow(k).getCell(columnNumber);
            valueCell.setCellType(1);
            testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
        }

        input.close();
        return testData;
    }

    public static Map getData(String dataFileName, String sheetName) throws IOException {
        HashMap testData = new HashMap();
        FileInputStream input = new FileInputStream(dataFileName);
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
        HSSFSheet sheet = wb.getSheet(sheetName);
        int dataSize = sheet.getPhysicalNumberOfRows() - 1;

        for(int k = 1; k < dataSize + 1; ++k) {
            HSSFCell keyCell = sheet.getRow(k).getCell(0);
            HSSFCell valueCell = sheet.getRow(k).getCell(1);
            valueCell.setCellType(1);
            testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
        }

        input.close();
        return testData;
    }

    public static Map getDataRow(String dataFileName, String sheetName) throws IOException {
        HashMap testData = new HashMap();
        FileInputStream input = new FileInputStream(dataFileName);
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
        HSSFSheet sheet = wb.getSheet(sheetName);
        int dataSize = sheet.getRow(2).getPhysicalNumberOfCells();

        for(int k = 0; k < dataSize; ++k) {
            HSSFCell keyCell = sheet.getRow(2).getCell(k);
            HSSFCell valueCell = sheet.getRow(3).getCell(k);
            valueCell.setCellType(1);
            testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
        }

        input.close();
        return testData;
    }
}


