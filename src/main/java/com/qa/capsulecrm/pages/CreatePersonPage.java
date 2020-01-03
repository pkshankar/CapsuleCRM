package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class CreatePersonPage extends TestBase {

	@FindBy(xpath = "//a[text()='Add Person']")
	WebElement addPersonLink;

	public CreatePersonPage() {

		PageFactory.initElements(driver, this);
	}

	public CreatePersonDetailPage clickAddPersonLink() {

		TestUtil.explicitWait(driver, addPersonLink, Long.parseLong(prop.getProperty("addPersonWaitTime")));
		TestUtil.performClick(addPersonLink);
		return new CreatePersonDetailPage();
	}

}
