package pages;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.SelenideElement;

import ru.yandex.qatools.allure.annotations.Step;

public class GoogleSearchPage extends GoogleBasePage{
	
	public static final String PAGE_URL = "https://www.google.com.ua/";
	
	public GoogleSearchPage(){
		super(PAGE_URL);
	}
	@FindBy(how = How.NAME, using = "q")
	private SelenideElement searchBox;

	@Step("search {0}")
	public GoogleResultsPage search(String query) {
		searchBox.setValue(query).pressEnter();
		return page(GoogleResultsPage.class);
	}
}
