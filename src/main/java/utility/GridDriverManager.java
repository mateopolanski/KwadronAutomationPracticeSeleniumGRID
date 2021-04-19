package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.remote.*;

import java.net.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GridDriverManager {

    private static final Logger LOG = LogManager.getLogger(GridDriverManager.class.getSimpleName());

    public WebDriver getDriver(String driverType){
        return getDriver(driverType, "LOCAL");
    }

    public WebDriver getDriver(String driverType, String gridMode){
        WebDriver requestedDriver = null;
        switch (driverType.toUpperCase( Locale.ROOT)) {
            case "CHROME" -> {
                LOG.info("Chrome driver selected");
                requestedDriver = gridMode.toUpperCase(Locale.ROOT).equals("GRID") ?
                        getRemoteDriver(BrowserSettings.getChromeOptions()) : getLocalChrome();
            }

            case "EDGE" -> {
                LOG.info("Edge driver selected");
                requestedDriver = gridMode.toUpperCase(Locale.ROOT).equals("GRID") ?
                        getRemoteDriver(BrowserSettings.getEdgeOptions()) : getLocalEdge();
            }
        }
        return requestedDriver;
    }

    private WebDriver getLocalChrome(){
        LOG.info("Setting up new ChromeDriver");
        System.setProperty("webdriver.chrome.driver", System.getProperty("driver.path") + "/chromedriver.exe");
        return new ChromeDriver(BrowserSettings.getChromeOptions());
    }

    private WebDriver getLocalEdge(){
        LOG.info("Setting up new EdgeDriver");
        System.setProperty("webdriver.edge.driver", System.getProperty("driver.path") + "/msedgedriver.exe");
        return new EdgeDriver(BrowserSettings.getEdgeOptions());
    }

    private WebDriver getRemoteDriver(Capabilities capabilities){
        WebDriver requestedDriver = null;
        try{
            requestedDriver = new RemoteWebDriver(new URL(System.getProperty("selenium.grid.url")), capabilities);
        } catch (MalformedURLException e) {
            LOG.error("Remote driver creation failed");
        }
        return requestedDriver;
    }

}
