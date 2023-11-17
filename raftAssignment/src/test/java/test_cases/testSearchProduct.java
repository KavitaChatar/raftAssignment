package test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import config.*;
import pages.*;

public class testSearchProduct {
    private WebDriver driver;
    private myntraAllProductListPage productListPage;

    @BeforeTest
    public void setUp(){
        driver = driverManager.initializeDriver();
        productListPage = PageFactory.initElements(driver,myntraAllProductListPage.class);
    }

    @Test
    public void testSearchForProducts(){
        productListPage.searchForProducts();
        Assert.assertTrue(productListPage.isProductListDisplayed());
    }

    @Test
    public void testAllItemsListed(){
        productListPage.isProductListDisplayed();
    }

    @AfterClass
    public void endTest(){
        driver.quit();
    }
}
