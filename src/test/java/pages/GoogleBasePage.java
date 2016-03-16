package pages;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import ru.yandex.qatools.allure.annotations.Step;

public class GoogleBasePage extends Page {
	
	public static final String PAGE_BASE_URL = "https://www.google.com.ua/";
	
	public GoogleBasePage() {
		super(PAGE_BASE_URL);
	}
	
	public GoogleBasePage(String pageUrl) {
		super(pageUrl);
	}
	
	@FindBy(how = How.CSS, using = ".gb_P.gb_R")
	private SelenideElement loginName;

	@FindBy(how = How.CSS, using = "div>a[href*='ServiceLogin']")
	private SelenideElement loginButton;
	
	@FindBy(how = How.CSS, using = "a[href*='https://accounts.google.com/SignOutOptions']")
	private SelenideElement accountButton;
	

	@FindBy(how = How.CSS, using = "a[href*='https://accounts.google.com/Logout']")
	private SelenideElement logoutButton;
	
    @FindBy(css = "#gb #gbw span")
    private SelenideElement loggedInHeader;

    public boolean isLoggedIn() {
        return !loginButton.isDisplayed() && loginName.isDisplayed();
    }

	
	public String getLoginName() {
		return loginName.getText();
	}

	@Step("open login page")
	public GoogleLoginPage goToLoginPage() {
		loginButton.click();
		return page(GoogleLoginPage.class);
	}
	
	public void clickLogin(){
		loginButton.click();
	}
	
	@Step("logout")
	public void logout(){
		accountButton.click();
		logoutButton.shouldBe(Condition.visible).click();
	}

	@Override
	protected void init() {
		verify();
	}
	
	@Override
	protected void setUp() {
		
		
	}
}
