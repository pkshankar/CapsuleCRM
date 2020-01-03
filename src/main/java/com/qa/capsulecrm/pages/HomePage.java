package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@aria-label='People & Organisations']")
	WebElement peopleOrganisationLink;
	
	@FindBy(xpath="//a[@aria-label='Cases']")
	WebElement casesLink;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public CreatePersonPage clickpeopleOrganisationLink() {

		TestUtil.performClick(peopleOrganisationLink);
		return new CreatePersonPage();
	}
	
	public CasesPage clickCasesLink() {

		TestUtil.performClick(casesLink);
		return new CasesPage();
	}


}
