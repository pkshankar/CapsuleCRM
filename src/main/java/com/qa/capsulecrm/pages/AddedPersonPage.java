package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class AddedPersonPage extends TestBase {

	@FindBy(xpath = "//div[@class='party-details-text']/span")
	WebElement addedPersonName;

	public AddedPersonPage() {

		PageFactory.initElements(driver, this);
	}

	public String getPersonName() {

		TestUtil.explicitWait(driver, addedPersonName, Long.parseLong(prop.getProperty("personNameWaitTime")));
		return TestUtil.getText(addedPersonName);
	}

}
