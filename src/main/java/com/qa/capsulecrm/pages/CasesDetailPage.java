package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class CasesDetailPage extends TestBase {

	@FindBy(xpath = "//input[@data-component='input' and @placeholder='Find a person or organisation']")
	WebElement textBox;

	@FindBy(xpath = "//div[@data-component='options']/descendant::span[@class='search-select__option-text']")
	WebElement personName;

	@FindBy(xpath = "//input[@class='form-input-text']")
	WebElement caseName;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;

	public CasesDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public void addPersonCasesPage(String pName) {

		TestUtil.performSendKeys(textBox, pName);
		TestUtil.performClick(personName);

	}

	public void addCase(String addCaseName) {

		TestUtil.performSendKeys(caseName, addCaseName);

	}
	
	public void clickSave() {
		
		TestUtil.performClick(saveBtn);
	}

}
