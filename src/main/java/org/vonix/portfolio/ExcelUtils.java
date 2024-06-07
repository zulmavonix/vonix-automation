package org.vonix.portfolio;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static String dataReadSheetBankName() throws IOException {

        // Load the Excel workbook
        Workbook workbook = new XSSFWorkbook("C:\\Users\\zulma\\Documents\\Project\\Vonix\\web-automation\\public\\assets\\addBankAccountBulk.xlsx");

        // Assuming data is in the first sheet and starts from the second row
        Sheet sheet = workbook.getSheetAt(0);

        // Assuming data is in a single column starting from the second row
        int numRows = sheet.getPhysicalNumberOfRows();
        List<String> data = new ArrayList<>();
        for (int i = 1; i < numRows; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0); // Assuming data is in the first column
            data.add(cell.getStringCellValue());
        }
        workbook.close();
        for (String value : data) {
            // Fill the variable with data
            String variable = value;
            return variable;
        }
        return null;
    }
    public static String dataReadSheetBankAccount() throws IOException {

        // Load the Excel workbook
        Workbook workbook = new XSSFWorkbook("C:\\Users\\zulma\\Documents\\Project\\Vonix\\web-automation\\public\\assets\\addBankAccountBulk.xlsx");

        // Assuming data is in the first sheet and starts from the second row
        Sheet sheet = workbook.getSheetAt(0);

        // Assuming data is in a single column starting from the second row
        int numRows = sheet.getPhysicalNumberOfRows();
        List<String> data = new ArrayList<>();
        List<String> data2 = new ArrayList<>();
        for (int i = 1; i < numRows; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(1); // Assuming data is in the first column
            data.add(cell.getStringCellValue());
        }
        workbook.close();
        for (String value : data) {
            // Fill the variable with data
            String variable = value;
            return variable;
        }
        return null;
    }
}
