### Overview

This repository contains the source code for a Selenium testing project in Java. The project is designed to automate the testing of myntra web application for product listing page . I have used the SafariDriver to run the test suites on safari browser, in case of chromedriver change the path of chromedriver and run the test suite.

### Prerequisites

Make sure you have the following installed before running the tests:
* Java Development Kit (JDK)
* Selenium WebDriver
* Web browser drivers (e.g., SafariBrowser, ChromeDriver)

### Setup
1. Clone the repository:git clone (https://github.com/KavitaChatar/raftAssignment.git)
2. Download Selenium WebDriver and browser drivers. Place the drivers in a directory included in your system's PATH.

### Running Tests
Execute the test suite using testng.xml file, incase of errors try running individual test suites (src/test/java/test_cases/...)

### Project Structure
* src/test/java/test_cases: Contains individual test scripts.  
  * Test case 1 ("testAddtoWishlist") : Validate products are getting added to the wishlist items.
  * Test case 2 ("testAllProductListItems") : Validate each product contains basic details such as name, brand and price.
  * Test case 3 ("testProductDetails") : Validate individual product details whether it's the same as shown on product listing page. 
  * Test case 4 ("testSearchProduct") : Validate search product is working as expected
  * Test case 5 ("testSortProductItems") : Validate sorting of products shown on Myntra product listing page. 
* src/test/java/pages: Contains Individual page details(Myntra product listing page) and it's functions.
* src/test/java/config: Includes utility classes to be used to initialize the Webdrivers.

### Configuration
Adjust configurations in the pom.xml file to match your testing environment.

### Reporting
 To be added... 
