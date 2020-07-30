# Page Object model Test automation framework using Selenium with Java, TestNG and Maven

### libraries used
Selenium
TestNG
Extent Reports
WebDriver Manager
Test Listeners
Logger

### Steps to execute the tests from command line
cd postman_assignment
mvn clean test

### Pre-requisite
Please download chrome version "83.0.4103" though it is not required to give specific browser but in my system it is working like this.
or 
Uncomment line "WebDriverManager.chromedriver().setup();" in TestBase class and comment the next line if it works.

### Steps to execute the tests from UI
Run tests from CRUDTest class
or
testNG.xml