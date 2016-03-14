package com.google.gmail;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gmail.pageobject.GoogleResultsPage;
import com.google.gmail.pageobject.GoogleSearchPage;

public class SearchTest extends CommonSteps{
	
	protected GoogleSearchPage searchPage;
	
	protected SearchTest() {
		this.searchPage = page(GoogleSearchPage.class);
	}
	
	@Test
	@Parameters({"value", "result"})
	public void search(String value, String result) {
		GoogleResultsPage resultsPage = searchPage.search(value);
		resultsPage.verify();
		resultsPage.results().get(0).shouldHave(text(result));
	}
}
