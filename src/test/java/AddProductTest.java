import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.*;
import org.testng.annotations.*;

public class AddProductTest extends BaseTest{

    @FindBy (xpath = "//span[@class=\"editable\"]")
    private static WebElement description;

    @Test
    public void addItemtoCart() throws Exception {

        productPage.open();
        productPage.addItem();
        productPage.goToCart();
        Assert.assertEquals(description , "CHS-BB-21" );


    }
}

