package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class CasesPage extends TestBase {

	@FindBy(xpath = "//a[text()='Add Case']")
	WebElement addCaseLink;

	public CasesPage() {

		PageFactory.initElements(driver, this);
	}

	public CasesDetailPage clickAddCaseLink() {

		TestUtil.performClick(addCaseLink);
		return new CasesDetailPage();
	}

}
