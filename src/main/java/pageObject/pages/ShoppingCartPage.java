package pageObject.pages;

import io.qameta.allure.*;
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import utility.*;

public class ShoppingCartPage extends BasePage {

    private static final Logger log = LogManager.getLogger (ShoppingCartPage.class.getSimpleName());

    public static final String SHOPPING_CART_PAGE = PropertyManager.getProperty( "page.shopping.cart" );



    public ShoppingCartPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    @Step("Open cart page")
    public ShoppingCartPage open() {
        log.info( "Open a page with items in a cart" );
        openWebPage(SHOPPING_CART_PAGE);
        return this;
    }
}
