
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObject.*;
import pageObject.pages.*;
import utility.*;

public abstract class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final Logger assertLogger = LogManager.getLogger( "Assert" );

    protected GridDriverManager driverManager;
    protected PropertyManager propertyManager;

    protected HomePage homePage;
    protected SignIn signIn;
    protected ProductPage productPage;
    protected ShoppingCartPage shoppingCartPage;


    @Parameters({"browserName" , "testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName
            , @Optional("default.properties") String testDataFileName) {
        driverManager = new GridDriverManager();
        driver.set( driverManager.getDriver( browserName , "Grid" ) );
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        context.setAttribute( "WebDriver" , driver.get() );

        propertyManager = new PropertyManager( testDataFileName );
        homePage = new HomePage( driver.get() , propertyManager );
        signIn = new SignIn( driver.get() , propertyManager );
        shoppingCartPage = new ShoppingCartPage( driver.get() , propertyManager );
        productPage = new ProductPage( driver.get(), propertyManager );
    }

    @AfterMethod
    public void browserReset() {
        driver.get().manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp() {
        driver.get().quit();
        driver.remove();
    }
}
