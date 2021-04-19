package pageObject.pages;

import io.qameta.allure.*;
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utility.*;

public class ProductPage extends BasePage {

    private static final Logger LOG = LogManager.getLogger (ProductPage.class.getSimpleName());
    private final String ITEM_PAGE = PropertyManager.getProperty( "page.item" );

    @FindBy(xpath = "//button[@name=\"Submit\"]/span")
    private static WebElement addToCartBtn;

    @FindBy(xpath = "//a[@title=\"View my shopping cart\"]")
    private static WebElement cartBtn;

    public ProductPage (WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }



    @Step("Go to the product page")
    public ProductPage open() {
        LOG.info( "Open Product Webpage" );
        openWebPage(ITEM_PAGE);
        return this;
    }

    @Step("Add item to cart")
    public ProductPage addItem (){
        LOG.info( "adding item to basket" );
        addToCartBtn.click();
        return this;
    }

    @Step("Go to cart")
    public ProductPage goToCart (){
        LOG.info( "Go to cart" );
        cartBtn.click();
        return this;
    }
}
