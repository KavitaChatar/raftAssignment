package test_cases;

import config.driverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.myntraAllProductListPage;

public class testSortProductItems {
    private WebDriver driver;
    private myntraAllProductListPage productListPage;

    @BeforeTest
    public void setUp(){
        driver = driverManager.initializeDriver();
        productListPage = PageFactory.initElements(driver,myntraAllProductListPage.class);
    }

    @Test
    public void testProductSorting(){
        // Sort Options = ["Recommended","Popularity","What's New","Better Discount","Price: High to Low","Price: Low to High"]
        productListPage.sortItems(2);
    }
    @AfterClass
    public void endTest(){
        driver.quit();
    }
}
