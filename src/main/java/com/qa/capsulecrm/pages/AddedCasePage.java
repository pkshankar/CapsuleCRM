package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class AddedCasePage extends TestBase {
	
	@FindBy(xpath="//div[@class='entity-details__title']")
	WebElement caseName;
	
	@FindBy(xpath="//div[@class='entity-details__party']/descendant::a")
	WebElement personName;
	
	@FindBy(xpath="//div[@class='panel']/div[contains(text(),'Case status is ')]/span")
	WebElement caseStatus;
	
	public AddedCasePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getCaseName() {
		
		return TestUtil.getText(caseName);
	}
	
	public String getPersonName() {
		
		return TestUtil.getText(personName);
	}
	
	public String getCaseStatus() {
		
		return TestUtil.getText(caseStatus);
	}

}
