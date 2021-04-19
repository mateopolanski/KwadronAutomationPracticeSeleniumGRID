import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.*;
import org.testng.annotations.*;
import utility.*;

public class SignInToAccountTest extends BaseTest{

    private static final String USER_MAIL = PropertyManager.getProperty( "sign.email" );
    private static final String USER_AUTH = PropertyManager.getProperty( "sign.pass" );

    @FindBy (xpath = "//span[@class=\"icon-user\"]")
    private static WebElement accountIcon;

    @FindBy (xpath = "//*[@id=\"blockUserAccount\"]/p/a[1]/text()")
    private static  WebElement verificationData;

    @Test
    public void addItemtoCart() throws Exception {

        homePage.open()
                .click(accountIcon);
        signIn.enterUsername(USER_MAIL);
        signIn.enterPassword(USER_AUTH);
        signIn.clickLogin();
        Assert.assertEquals (verificationData , "WELCOME TATTOO TEST");

    }
}