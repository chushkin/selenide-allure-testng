package com.google.gmail;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gmail.pageobject.GoogleLoginPage;

public class GMailAuthorizationTest extends CommonSteps{
	
	
	
	@Test
	@Parameters({"login", "password", "nickname" })
	public void login(String login, String password, String nickname) {
		GoogleLoginPage loginPage = mainPage.goToLoginPage();
		loginPage.verify();
		mainPage = loginPage.login(login, password);
		Assert.assertEquals(nickname, mainPage.getLoginName(), "User names are not equal");
	}
	
	@Test
	@Parameters({"login", "password", "nickname" })
	public void logOut(String login, String password, String nickname) {
		login(login, password, nickname);
	//	GoogleBasePage mainPage = open(url, GoogleBasePage.class);
		mainPage.logout();
		Assert.assertNotNull(mainPage.goToLoginPage());
	}
	
}
