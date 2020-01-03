package com.qa.capsulecrm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.capsulecrm.testdata.FilePath;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			FileInputStream fis = new FileInputStream(FilePath.CONFIG_FILE_PATH);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void initialization() {

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("internet explorer")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageLoadTimeout")),
				TimeUnit.SECONDS);

	}

}
