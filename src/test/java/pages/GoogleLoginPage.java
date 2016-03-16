package pages;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import ru.yandex.qatools.allure.annotations.Step;

public class GoogleLoginPage extends GoogleBasePage{
	
public static final String PAGE_URL = "/ServiceLogin";
	
	public GoogleLoginPage(){
		super(PAGE_URL);
	}
	
	@FindBy(how = How.ID, using = "Email")
	private SelenideElement emailInput;
	
	@FindBy(how = How.ID, using = "next")
	private SelenideElement nextButton;
	
	@FindBy(how = How.ID, using = "Passwd")
	private SelenideElement passwordInput;
	
	@FindBy(how = How.ID, using = "signIn")
	private SelenideElement signInButton;
	
	public void enterEmail(String email){
		emailInput.setValue(email);
	}
	
	public void clickNext(){
		nextButton.shouldBe(Condition.visible).click();
	}
	
	public void enterPassword(String password){
		passwordInput.shouldBe(Condition.visible).setValue(password);
	}
	
	public void clickSignIn(){
		signInButton.shouldBe(Condition.visible).click();
	}
	
	@Step("Login by email:{0}, password {1}")
	public GoogleBasePage login(String email, String password){
		enterEmail(email);
		clickNext();
		enterPassword(password);
		clickSignIn();
		return page(GoogleBasePage.class);
	}
}
