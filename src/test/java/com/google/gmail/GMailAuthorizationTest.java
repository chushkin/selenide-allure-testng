package com.google.gmail;

import static com.codeborne.selenide.Selenide.open;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gmail.pageobject.GoogleLoginPage;
import com.google.gmail.pageobject.GoogleMainPage;

public class GMailAuthorizationTest extends TestCase{
	
	@Test
	@Parameters({ "url", "login", "password", "nickname" })
	public void login(String url, String login, String password, String nickname) {
		GoogleMainPage mainPage = open(url, GoogleMainPage.class);
		GoogleLoginPage loginPage = mainPage.goToLoginPage();
		mainPage = loginPage.login(login, password);
		Assert.assertEquals(nickname, mainPage.getLoginName());
	}
	
	@Test
	@Parameters({ "url", "login", "password", "nickname" })
	public void logOut(String url, String login, String password, String nickname) {
		login(url, login, password, nickname);
		GoogleMainPage mainPage = open(url, GoogleMainPage.class);
		mainPage.logout();
		Assert.assertNotNull(mainPage.goToLoginPage());
	}
	
}
