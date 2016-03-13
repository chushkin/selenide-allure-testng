package com.google.gmail.pageobject;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.SelenideElement;

public class GoogleMainPage extends Page {
	@FindBy(how = How.CSS, using = ".gb_P.gb_R")
	private SelenideElement loginName;

	@FindBy(how = How.CSS, using = "div.gb_mc>a[href*='ServiceLogin']")
	private SelenideElement loginButton;
	
	@FindBy(how = How.CSS, using = "a[href*='https://accounts.google.com']>span")
	private SelenideElement accountButton;
	

	@FindBy(how = How.CSS, using = "a[href*='https://accounts.google.com/Logout']")
	private SelenideElement logoutButton;
	
	public String getLoginName() {
		return loginName.getText();
	}

	public GoogleLoginPage goToLoginPage() {
		loginButton.click();
		return page(GoogleLoginPage.class);
	}
	
	public void logout(){
		accountButton.click();
		logoutButton.click();
	}
}
