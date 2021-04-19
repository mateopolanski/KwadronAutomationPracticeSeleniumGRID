package pageObject;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import pageObject.pages.*;
import utility.*;


public class SignIn extends BasePage {

    private static final String KWADRON_HOMEPAGE = PropertyManager.getProperty( "page.homepage" );
    protected SignIn signIn;
    @FindBy(xpath = "//input[@id=\"email\"]")
    private static WebElement userEmail;

    @FindBy(xpath = "//input[@id=\"passwd\"]")
    private static WebElement authPassword;

    @FindBy(xpath = "//button[@id=\"SubmitLogin\"]/span")
    private static WebElement submitBtn;


    public SignIn(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SignIn enterUsername(String userMail) {
        userEmail.sendKeys(userMail);
        return this;
    }

    public SignIn enterPassword(String password) {
        authPassword.sendKeys(password);
        return this;
    }

    public SignIn clickLogin() throws Exception {
        submitBtn.click();
        return this;
    }
    @Step("Open home page")
    public SignIn open() {
        openWebPage(KWADRON_HOMEPAGE);
        return this;
    }


}
