package com.google.gmail;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.google.gmail.pageobject.GoogleLoginPage;

public class GMailAuthorizationTest extends CommonSteps {

	@Test
	@Parameters({ "login", "password", "nickname" })
	public void login(String login, String password, String nickname) {
		GoogleLoginPage loginPage = mainPage.goToLoginPage();
		loginPage.verify();
		loginPage.login(login, password);
		Assert.assertFalse(loginPage.isCurrent(), "not left the page");
		Assert.assertTrue(mainPage.isLoggedIn(), "not logged in");
		Assert.assertEquals(nickname, mainPage.getLoginName(), "User names are not equal");
	}

	@Test
	@Parameters({"login", "password", "nickname" })
	public void logOut(String login, String password, String nickname) {
		login(login, password, nickname);
		mainPage.logout();
		Assert.assertFalse(mainPage.isLoggedIn(), "not logged in");
		Assert.assertNotNull(mainPage.goToLoginPage());
	}

}
