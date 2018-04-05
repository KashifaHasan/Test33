package Common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Base {

public WebDriver driver = null;
    @Parameters({"os","browserName","url"})

@BeforeMethod
    public void setUp(@Optional("Windows 8") String os, @Optional("firefox") String browserName, @Optional("http://www.google.com") String url) {
        getLocalDriver(os,browserName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
}

    public WebDriver getLocalDriver(String os, String browserName){

        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/kashifahasan/Documents/Assignment/Generic/selenium-browser-driver/geckodriver");
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            if(os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.chrome.driver","..\\Generic\\selenium-browser-driver\\chromedriver.exe");
            }else{
                System.setProperty("webdriver.chrome.driver", "/Users/kashifahasan/Documents/Assignment/Generic/selenium-browser-driver/chromedriver");
            }
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else if(browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","..\\Generic\\selenium-browser-driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if (browserName.equalsIgnoreCase("htmlunit")){
            //By passing the TRUE parameter, we are enabling JS capabilities.
            driver = new HtmlUnitDriver();
        }

        return driver;
    }

   @AfterMethod
    public void cleanUp() {
    try {
        driver.quit();
    } catch (Exception anException) {
        anException.printStackTrace();
    }
   }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }


}
