package com.qa.capsulecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.pages.AddedPersonPage;
import com.qa.capsulecrm.pages.CreatePersonDetailPage;
import com.qa.capsulecrm.pages.CreatePersonPage;
import com.qa.capsulecrm.pages.HomePage;
import com.qa.capsulecrm.pages.LoginPage;
import com.qa.capsulecrm.testdata.FilePath;
import com.qa.capsulecrm.util.TestUtil;

public class AddedPersonPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CreatePersonPage createPersonPage;
	CreatePersonDetailPage createPersonDetailPage;
	AddedPersonPage addedPersonPage;

	public AddedPersonPageTest() {

		super();
	}

	@DataProvider
	public String[][] getData() {

		return TestUtil.getDataExcel(FilePath.TEST_DATA_FILE_PATH, FilePath.PERSON_DETAILS_SHEETNAME);

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToCapsuleCrm(prop.getProperty("username"), prop.getProperty("password"));
		createPersonPage = homePage.clickpeopleOrganisationLink();
		createPersonDetailPage = createPersonPage.clickAddPersonLink();
	}

	@Test(dataProvider = "getData")
	public void validateAddedPersonTest(String firstName, String lastName) {

		addedPersonPage = createPersonDetailPage.addPersonDetails(firstName, lastName);
		Assert.assertEquals(addedPersonPage.getPersonName(), firstName + " " + lastName);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
