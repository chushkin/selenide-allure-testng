package com.google.gmail;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.WebDriverRunner;

@Listeners({ ScreenShooter.class })
public class TestCase {
    
	@AfterMethod(alwaysRun = true)
	public void clearBrowserCookies(ITestResult result) {
		WebDriverRunner.clearBrowserCache();
	}


}
