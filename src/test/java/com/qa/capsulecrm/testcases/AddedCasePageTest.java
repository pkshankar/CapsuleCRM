package com.qa.capsulecrm.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.pages.CasesDetailPage;
import com.qa.capsulecrm.pages.CasesPage;
import com.qa.capsulecrm.pages.HomePage;
import com.qa.capsulecrm.pages.LoginPage;
import com.qa.capsulecrm.testdata.FilePath;
import com.qa.capsulecrm.util.TestUtil;

public class AddedCasePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CasesPage casePage;
	CasesDetailPage caseDetailPage;

	public AddedCasePageTest() {

		super();
	}

	@DataProvider
	public String[][] getPersonData() {

		return TestUtil.getDataExcel(FilePath.TEST_DATA_FILE_PATH, FilePath.PERSON_DETAILS_SHEETNAME);

	}

	@DataProvider
	public String[][] getCaseData() {

		return TestUtil.getDataExcel(FilePath.TEST_DATA_FILE_PATH, FilePath.CASE_DETAILS_SHEETNAME);

	}


	
	
	
	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToCapsuleCrm(prop.getProperty("username"), prop.getProperty("password"));
		casePage = homePage.clickCasesLink();
		caseDetailPage = casePage.clickAddCaseLink();
	}

	@Test(dataProvider = "getPersonData")
	public void validateCaseDetailsTest() {

	}
}
