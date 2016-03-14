package com.google.gmail;


import static com.codeborne.selenide.Selenide.open;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import com.codeborne.selenide.testng.ScreenShooter;
import com.google.gmail.pageobject.GoogleBasePage;

import ru.yandex.qatools.allure.annotations.Step;

import com.codeborne.selenide.WebDriverRunner;

@Listeners({ ScreenShooter.class })
public class CommonSteps {
    
	protected GoogleBasePage mainPage;
	
	public CommonSteps(){
		this.mainPage = open(GoogleBasePage.PAGE_BASE_URL, GoogleBasePage.class);
	}
	
	@Step("clear browser cookies")
	@AfterMethod(alwaysRun = true)
	public void clearBrowserCookies(ITestResult result) {
		WebDriverRunner.clearBrowserCache();
		open(GoogleBasePage.PAGE_BASE_URL);
	}


}
