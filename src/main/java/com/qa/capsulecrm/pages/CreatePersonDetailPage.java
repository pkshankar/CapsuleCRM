package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class CreatePersonDetailPage extends TestBase {

	@FindBy(xpath = "//label[text()='First Name']/following-sibling::input")
	WebElement firstName;

	@FindBy(xpath = "//label[text()='Last Name']/following-sibling::input")
	WebElement lastName;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;

	public CreatePersonDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public AddedPersonPage addPersonDetails(String fName, String lName) {

		TestUtil.explicitWait(driver, firstName, Long.parseLong(prop.getProperty("firstNameWaitTime")));
		TestUtil.performSendKeys(firstName, fName);
		TestUtil.performSendKeys(lastName, lName);
		TestUtil.performClick(saveBtn);

		return new AddedPersonPage();
	}

}
