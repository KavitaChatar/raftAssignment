package test_cases;

import config.driverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.myntraAllProductListPage;

public class testAllProductListItems {
    private WebDriver driver;
    private myntraAllProductListPage productListPage;

    @BeforeTest
    public void setUp(){
        driver = driverManager.initializeDriver();
        productListPage = PageFactory.initElements(driver,myntraAllProductListPage.class);
    }

    @Test
    public void testProductList(){
        productListPage.validateProductListing();
    }

    @AfterClass
    public void endTest(){
        driver.quit();
    }
}
