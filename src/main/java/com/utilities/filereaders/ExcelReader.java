package com.utilities.filereaders;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    private File excelFile;
    private Sheet currentSheet;
    private Map<String, Integer> columns;

    public ExcelReader(File file) {
        excelFile = file;
        columns = new HashMap<>();
    }

    public void selectSheet(String name) {
        try {
            Workbook currentWorkBook = WorkbookFactory.create(excelFile);
            currentSheet = currentWorkBook.getSheet(name);
            currentSheet.getRow(0).forEach(cell -> columns.put(cell.getStringCellValue(), cell.getColumnIndex()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String  getCellData(String column, int row) {
        Row dataRow = currentSheet.getRow(row);
        return getCellDataAsString(dataRow.getCell(columns.get(column)));
    }

    private String getCellDataAsString(Cell cell) {
        switch(cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int)cell.getNumericCellValue());
            default:
                return "";
        }
    }

}
