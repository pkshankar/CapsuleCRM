package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.capsulecrm.base.TestBase;
import com.qa.capsulecrm.util.TestUtil;

public class LoginPage extends TestBase {

	@FindBy(id = "login:usernameDecorate:username")
	WebElement userName;

	@FindBy(id = "login:passwordDecorate:password")
	WebElement passWord;

	@FindBy(id = "login:login")
	WebElement loginBtn;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public HomePage loginToCapsuleCrm(String uname, String pwd) {

		TestUtil.performSendKeys(userName, uname);
		TestUtil.performSendKeys(passWord, pwd);
		TestUtil.performClick(loginBtn);
		return new HomePage();
	}

}
