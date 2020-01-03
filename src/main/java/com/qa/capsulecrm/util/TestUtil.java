package com.qa.capsulecrm.util;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

	public static void performSendKeys(WebElement element, String text) {

		element.sendKeys(text);
	}

	public static void performClick(WebElement element) {

		element.click();
	}

	public static String getText(WebElement element) {

		return element.getText();
	}

	public static String[][] getDataExcel(String excelLocation, String sheetName) {

		FileInputStream fis;
		XSSFWorkbook wb;
		XSSFSheet sh;
		String[][] data = null;

		try {

			fis = new FileInputStream(excelLocation);
			wb = new XSSFWorkbook(fis);
			sh = wb.getSheet(sheetName);
			int lastRow = sh.getLastRowNum();
			data = new String[lastRow][sh.getRow(0).getLastCellNum()];
			for (int rw = 0; rw < lastRow; rw++) {

				for (int cl = 0; cl < sh.getRow(rw).getLastCellNum(); cl++) {

					data[rw][cl] = sh.getRow(rw + 1).getCell(cl).getStringCellValue();

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}

	public static void explicitWait(WebDriver driver, WebElement element, long waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
