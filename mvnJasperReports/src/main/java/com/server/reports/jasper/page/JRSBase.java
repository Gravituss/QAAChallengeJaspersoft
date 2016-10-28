package com.server.reports.jasper.page;


import java.util.Random;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class JRSBase {
	
	// This method receives coordinates of a cell (in Excel file)
	// as parameters and returns String value of the cell 
	// 
	public static String readExcelFile(int iRow, int jCell) throws IOException {
		String readCell = "";
	
		final String FILE_LOCATOR ="src/main/resources/File.xlsx";
		
		InputStream ExcelFileToRead = new FileInputStream(FILE_LOCATOR);
		XSSFWorkbook workbook = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		readCell = sheet.getRow(iRow).getCell(jCell).getStringCellValue();
		workbook.close();
		return readCell;
	}
	
	

	// This method generates a random ID/password starting with X
	public static String generateRandomStr(){
		
		final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
		final int N = ALPHABET.length();
		String nickname = "X";
		
		Random r = new Random();
		
		for (int i = 0; i < 10; i++){
			nickname = nickname + ALPHABET.charAt(r.nextInt(N));
		}
		return nickname;
	}	
	
	// This method generates random email with @gmail.com
	// It's not a real working email, it's just a String value
	public static String generateRandomEmail(){
		
		final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
		final int N = ALPHABET.length();
		String email = "";
		
		Random r = new Random();
		
		for (int i = 0; i < 14; i++){
			email = email + ALPHABET.charAt(r.nextInt(N));
		}
		
		email = email + "7@gmail.com";
		return email;
	}	

}
