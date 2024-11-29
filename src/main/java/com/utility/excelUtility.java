package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
	
	 private static final String FILE_NAME = "C:\\testing_RTP\\my-app\\AutomationSheet.xlsx"; // Name of your Excel file

	    // Read data from Excel file and return as a List of Map
	    public static List<Map<String, String>> readExcelData() {
	        List<Map<String, String>> excelData = new ArrayList<>();
	        try (FileInputStream inputStream = new FileInputStream(FILE_NAME)) {
	            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	            XSSFSheet sheet = workbook.getSheet(utility.readProperties("sheetname"));
	            XSSFRow headerRow = (XSSFRow) sheet.getRow(0);
	            int rowCount = sheet.getLastRowNum()+1;
	            for (int i = 1; i < rowCount; i++) {
	                XSSFRow currentRow = (XSSFRow) sheet.getRow(i);
	                Map<String, String> rowData = new HashMap<>();
	                System.out.println(headerRow.getLastCellNum());
	                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
	                    XSSFCell currentCell = currentRow.getCell(j);
	                    XSSFCell headerCell = headerRow.getCell(j);
	                    
	                    if(currentCell!=null)
	                    {
	                    rowData.put(headerCell.getStringCellValue(), currentCell.getStringCellValue());
	                    }
	                }
	                System.out.println(rowData);
	                excelData.add(rowData);
	            }
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return excelData;
	    }

	    public static List<Map<String, String>> WriteExcelData(String Message) {
	        List<Map<String, String>> excelData = new ArrayList<>();
	        try (FileInputStream inputStream = new FileInputStream(FILE_NAME)) {
	            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	            XSSFSheet sheet = workbook.getSheet(utility.readProperties("sheetname"));
	            XSSFRow headerRow = (XSSFRow) sheet.getRow(0);
	            int rowCount = sheet.getLastRowNum()+1;
	            int validationMessageIndex = headerRow.getLastCellNum();
	            for (int i = 1; i < rowCount; i++) {
	                XSSFRow currentRow = (XSSFRow) sheet.getRow(i);
	                if(currentRow!=null)
	                {
	                	currentRow.createCell(validationMessageIndex).setCellValue(Message);
	                }
	                }
	            try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME)) {
	                workbook.write(fileOut);

	            }  
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return excelData;
	    }



}
