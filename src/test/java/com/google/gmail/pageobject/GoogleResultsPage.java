package com.google.gmail.pageobject;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

public class GoogleResultsPage extends GoogleMainPage{
	
	public ElementsCollection results() {
	    return $$(".r>a");
	  }
}
