package pageObject.pages;

import io.qameta.allure.*;
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utility.*;

public class HomePage extends BasePage {

    private static final Logger LOG = LogManager.getLogger(HomePage.class.getSimpleName());
    protected final String KWADRON_HOMEPAGE = PropertyManager.getProperty( "page.homepage" );

    @FindBy(xpath = "//div[@class=\"header_top\"]/div/div")
    public static WebElement searchBarText;

    @FindBy(xpath = "//i[@class=\"icon-search\"]")
    public static WebElement searchBarIcon;

    @FindBy (xpath = "//a[@title=\"View my shopping cart\"]")
    public static WebElement cartButton;


    public HomePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }


    @Step("Go to the home page")
    public HomePage open() {
        LOG.info( "Open Home Webpage" );
        openWebPage(KWADRON_HOMEPAGE);
        return this;
    }

    @Step("Search for particular product")
    public HomePage searchTextForProduct (String lookup){
        LOG.info ("Search for product");
        searchBarIcon.click();
        searchBarText.sendKeys(lookup);
        return this;
    }

    @Step ("Click Search Button")
    public HomePage clickSearch (){
        LOG.info( "Click on Search button" );
        searchBarIcon.click();
        return this;
    }

    @Step("Go to the cart page")
    public HomePage goToShoppingCart() {
        LOG.info( "click on the cart button" );
        cartButton.click();
        return this;
    }

    protected void openWebPage(String url) {
        driver.navigate().to(url);
    }


}
