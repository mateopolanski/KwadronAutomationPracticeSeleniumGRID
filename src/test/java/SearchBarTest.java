import org.testng.*;
import org.testng.annotations.*;

public class SearchBarTest extends BaseTest {

    private static final String PRODUCTS_BY_RESULT = "//a[text()=\" Cheyenne HAWK Spirit + Grip \"]";
    private static final String SEARCHED_ITEM = "Cheyenne Hawk Spirit";

    @Test
    public void searchTest() throws Exception {

        homePage.open()
                .searchTextForProduct( SEARCHED_ITEM )
                .clickSearch();
        String url = driver.get().getCurrentUrl();
        Assert.assertEquals(url,PRODUCTS_BY_RESULT);
    }
}