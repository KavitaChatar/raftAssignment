package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverManager {

    private static WebDriver driver;

    public static WebDriver initializeDriver(){
        System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/home-furnishing?src=bc");
        return driver;
    }
}
