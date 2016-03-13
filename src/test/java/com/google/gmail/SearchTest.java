package com.google.gmail;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gmail.pageobject.GoogleResultsPage;
import com.google.gmail.pageobject.GoogleSearchPage;

public class SearchTest extends TestCase{
	@Test
	@Parameters({ "url", "value", "result"})
	public void search(String url, String value, String result) {
		GoogleSearchPage searchPage = open(url, GoogleSearchPage.class);
		GoogleResultsPage resultsPage = searchPage.search(value);
		resultsPage.results().get(0).shouldHave(text(result));
	}
}
