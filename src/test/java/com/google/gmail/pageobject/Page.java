package com.google.gmail.pageobject;

import org.testng.Assert;

import com.codeborne.selenide.WebDriverRunner;

import ru.yandex.qatools.allure.annotations.Step;


public abstract class Page {

	private String currentPage;

	public Page(String pageUrl) {
		this.currentPage = pageUrl;
		init();
		setUp();
	}

	public String getCurrentPage() {
		return this.currentPage;
	}

	protected abstract void init();

	protected abstract void setUp();

	@Step("verify current url page")
	public void verify() {
        Assert.assertTrue(WebDriverRunner.url().contains(getCurrentPage()), "Wrong URL for page: " + this.getClass().getSimpleName());
    }

}
