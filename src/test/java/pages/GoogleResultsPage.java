package pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

import ru.yandex.qatools.allure.annotations.Step;

public class GoogleResultsPage extends GoogleBasePage{
	
	public static final String PAGE_URL = "/#q";
	
	public GoogleResultsPage(){
		super(PAGE_URL);
	}
	
	@Step("get results")
	public ElementsCollection results() {
	    return $$(".r>a");
	  }
}
