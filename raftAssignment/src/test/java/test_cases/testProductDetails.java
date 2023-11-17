package test_cases;

import config.driverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.myntraAllProductListPage;

import java.util.List;

public class testProductDetails {

    private WebDriver driver;
    private myntraAllProductListPage productListPage;

    @BeforeTest
    public void setUp(){
        driver = driverManager.initializeDriver();
        productListPage = PageFactory.initElements(driver,myntraAllProductListPage.class);
    }

    @Test
    public void testIndividualProductDetails(){
        int randomItem = 2;
        productListPage.getProductDetails(randomItem);

    }
    @AfterClass
    public void endTest(){
        driver.quit();
    }
}
