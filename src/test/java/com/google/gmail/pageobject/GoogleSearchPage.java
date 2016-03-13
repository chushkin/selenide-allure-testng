package com.google.gmail.pageobject;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.SelenideElement;

public class GoogleSearchPage extends GoogleMainPage{
	@FindBy(how = How.NAME, using = "q")
	private SelenideElement searchBox;

	public GoogleResultsPage search(String query) {
		searchBox.setValue(query).pressEnter();
		return page(GoogleResultsPage.class);
	}
}
