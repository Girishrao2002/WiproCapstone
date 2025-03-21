package com.utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

public class ExcelUtils {
	private static final String FILE_PATH = "src/test/resources/ExcelSheet/LoginData.xlsx"; // Update path as needed

    public static String getCellValue(String sheetName, int row, int col) throws IOException {
        FileInputStream file = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row sheetRow = sheet.getRow(1);
        Cell cell = sheetRow.getCell(0);
        String value = cell.getStringCellValue();
        workbook.close();
        return value;
    }
}
