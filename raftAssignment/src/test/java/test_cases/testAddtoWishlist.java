package test_cases;

import config.driverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.myntraAllProductListPage;

public class testAddtoWishlist {
    private WebDriver driver;
    private myntraAllProductListPage productListPage;

    @BeforeTest
    public void setUp(){
        driver = driverManager.initializeDriver();
        productListPage = PageFactory.initElements(driver,myntraAllProductListPage.class);
    }

    @Test
    public void testWishlistItems(){
        productListPage.addProductToWishlist();
    }
    @AfterClass
    public void endTest(){
        driver.quit();
    }
}
