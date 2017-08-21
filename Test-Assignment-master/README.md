# Test-Assignment
Test Assignment - Rahul Ronald

# Introduction:
This test is divided into 3 sections:
1.	News Portal (6 Test Requirements)
2.	Radio Portal (7 Test Requirements)
3.	API Integration Test (3 Test Requirements)

## Tools Used:
1.	Eclipse Neon

## Add-ins or APIs Used:
* Selenium WebDriver APIs (Web Automation)
* Gecko Driver (Firefox Support)
* Maven 
* TestNG 
* Apache POI (For Excel reading & writing)
* Log4J (For Logging)
* Rest Assured (Web Service Testing)
* JSON ((Web Service Testing)

## Programming Language Used:
* Java

## Pre-Requisites:
Once you have import the entire project in your Eclipse, please follow the below steps
### Edit Log4j file locations
* Open **log4j.properties** file under `src > test > java`
* Edit the **Application & Selenium log files locations** to your location Workspace location 

## Implementation Explanation:
I have used **Maven project** implementation in eclipse. 
All the **Core business logic** is under `src > test > java`, where I have defined **3 packages for the 3 sections** as explained in Introduction. 
Under **base** package, I have the **BasePage.java** which is inherited by all the class as it has all the important declarations & configurations. 
Under **utils** package, I have defined 2 important helper classes, one is **ExcelReader.java** which helps me to interact with excel sheets and the other is the **TestUtil.java** which has the logic to capture screenshots and other features. All code which is used all the time, is advised to be present in **TestUtil.java**. 
All the Test Cases are location under **testCases** package. Currently, I have created 1 class for each section under test. 

### For Section 1:
Section 1 had 6 test requirements. 
All the business logic is written for these 6 test requirements in multiple methods in 4 classes under abcNews package. Each class is representing a page. In order words, it is a Page Object Model.  
All these 6 test requirements are taken as 6 individual test cases clubbed under a single test cases **TestABCNews.java** under **testCases** package.

I am reading News Home Page title from the **testdata.xlsx** under tab **ABCNews** for validation purpose. Apart from this, for Test Requirement 6 (image validation test) I am, storing all image information in the tab ImageTest. This information can be used for validation purpose. 
*Likewise, we can do more validations on the go, if we maintain this properties file.*

### For Section 2:
Section 2 had 7 test requirements. 
All the business logic is written for these 7 test requirements in multiple methods in 5 classes under abcRadio package. Each class is representing a page or a test feature. 
All these 7 test requirements are taken as 7 individual test cases clubbed under a single test cases **TestABCRadio.java** under **testCases** package.

I am reading ABC Radio Home Page title from the **testdata.xlsx** under tab **ABCRadio** for validation purpose. Also, for test requirement 3, I am reading the text to search from this excel sheet.

### For Section 3:
Section 3 had 3 test requirements. 
I have designed the entire business logic which is written for these 3 test requirements in a single class WebServiceTest under abcWebService package. **With this business logic, I am able to fulfil all the 3 test requirements in 1 go. We can have multiple web services tested against multiple test environments with this logic.** 
For this section, **testdata.xlsx sheet is very critical**. *I am defining Test URL for web services, expected results and also writing the response back to it.*

### Object Repository:
As business logic is the brain of any test automation project, similarly object repository is the heart of the same test automation project. I am maintaining OR in a **OR.properties** file located under `src > test > resources > properties`. It is a very simple key, value property file divided under different sections as per the module and pages in the application.

### Config File:
**Config.properties** file is also very vital, as it has all the important **URLs, browser selection** etc. All the URLs must be specified in this file. 
**config.properties** file is located under `src > test > resources > properties` folder.

### Test Data File:
Important test data is to be entered in **testdata.xlsx**.
It has 3 tabs each for individual section. 

## Instructions to execute the test
The entire test suite is controlled by the **POM.xml** file, which is located under `project`. 
Simply, right click on the **POM.xml** file and select Run As : **Maven Test**. 

## Test Result:

### Test Report:
After the test is completed, the **Test Report** is generated in the Workspace location under `Project (ABC) > target > surefire-reports > emailable-report.html`. You can open it in any browser to have a look for the Consolidated Test Report. 

### Test Result Screenshots:
Also, at every important step, **screenshots** are captured and stored under `Project (ABC) > test-output > screenShots` folder location. All screenshots are stored with timestamp as their name.

### Log Files:
Log files (**Application log & Selenium Log**) are also generated after the test run is completed, which will help the tester to analyse the test results and fix some code, in case of error.









