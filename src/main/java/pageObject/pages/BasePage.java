package pageObject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import utility.*;

public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver, PropertyManager propertyManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void openWebPage(String url) {
        driver.navigate().to(url);
    }

    public void click(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void enterText(WebElement element, String text) {
        Actions action = new Actions(driver);
        action.sendKeys(element, text).perform();
    }

}
