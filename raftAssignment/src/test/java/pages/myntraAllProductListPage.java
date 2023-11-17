package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;


public class myntraAllProductListPage {
    private WebDriver driver;

    //List of WebElements to be used from Myntra Product Listing Page
    @FindBy(css = "#desktop-header-cnt > div.desktop-bound > div.desktop-query > input") WebElement searchBox;
    @FindBy(css = "div.horizontal-filters-sortContainer > div > div > div") WebElement sortButton;
    @FindBy(css = "#desktopSearchResults > div.search-searchProductsContainer.row-base > section > ul > li > div.product-actions > span") WebElement wishlistItem;
    @FindAll(@FindBy(css = "h4.product-product")) List<WebElement> listProductName;
    @FindAll(@FindBy(css = "h3.product-brand")) List<WebElement> listProductBrand;
    @FindAll(@FindBy(css = "span.product-discountedPrice")) List<WebElement> listProductPrice;
    @FindBy(className = "product-sliderContainer") WebElement productContainer;
    @FindBy(className = "pdp-name") WebElement productName;
    @FindBy(className = "pdp-title") WebElement productBrand;
    @FindBy(className = "pdp-price") WebElement productPrice;


    public myntraAllProductListPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProductListDisplayed(){ // check minimum of 50 items are listed
        Assert.assertTrue(listProductName.size()==50);
        return true;
    }
    public void searchForProducts(){ //search for the product and validate results
        searchBox.sendKeys("Curtains");
        searchBox.sendKeys(Keys.ENTER);
        for(WebElement eachProduct:listProductName){
            System.out.println(eachProduct.getText());
            Assert.assertTrue(eachProduct.getText().contains("curtains"));
        }
    }
    public void addProductToWishlist() { //add product to the wishlist
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        actions.moveToElement(productContainer).build().perform();
        wait.until(ExpectedConditions.visibilityOf(wishlistItem));
        wishlistItem.click();
    }

    public void validateProductListing(){ // Validate top 20 listed products should have product name, price and brand details and it's shouldn't be empty
        for(int x=0;x<=20;x++){
            WebElement eachProductName = listProductName.get(x);
            Assert.assertTrue(eachProductName.getText().length()>0);
            WebElement eachProductBrand = listProductBrand.get(x);
            Assert.assertTrue(eachProductBrand.getText().length()>0);
            WebElement eachProductPrice = listProductPrice.get(x);
            Assert.assertTrue(eachProductPrice.getText().length()>0);
            //System.out.println("Product Name :"+eachProductName.getText()+ " | Product Brand :"+eachProductBrand.getText()+" | Product Price :"+eachProductPrice.getText());
        }
    }

    public void sortItems(int index){ // click on the sort button and based on parameters apply sort filters
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sortButton));
        sortButton.click();
        List<WebElement> sortType = sortButton.findElements(By.tagName("li"));
        sortType.get(index).click();
    }

    public void getProductDetails(int index){ // verify product details shown on Home page with product page - Verify product Brand and product price
        String productBrandHomePage = listProductBrand.get(index).getText();
        String productPriceHomePage = listProductPrice.get(index).getText();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement myProduct = listProductPrice.get(index);
        wait.until(ExpectedConditions.visibilityOf(myProduct));
        myProduct.click();

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        wait.until(ExpectedConditions.visibilityOf(productName));

        Assert.assertTrue(productBrand.getText().contains(productBrandHomePage));
        Assert.assertTrue(productPriceHomePage.contains(productPrice.getText().substring(1)));
    }
}
