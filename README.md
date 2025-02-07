Hyva-Ecommerce Purchase Flow Automation Framework
This is a Selenium-based automation framework for testing the purchasing flow on https://demo.hyva.io/. 
The framework is implemented using Java, Selenium, Maven, Allure, and TestNG.

This README provides the necessary steps to install and run the framework .

Project Structure
The project is organized as follows:

com.revton.qa
│
├── config
│   └── hyvaAppProperties.java         # Configuration properties
│
├── dto
│   ├── CheckoutData.java              # Data transfer object for checkout
│   └── SearchData.java                # Data transfer object for search
│
├── factoryPage
│   └── DriverFactory.java             # Factory to manage browser drivers
│
├── pages
│   ├── HomePage.java                  # Home page object
│   ├── ProductPage.java               # Product page object
│   ├── CartPage.java                  # Cart page object
│   ├── CheckoutPage.java              # Checkout page object
│   └── OrderConfirmationPage.java     # Order confirmation page object
│
├── utils
│   ├── ConfigUtils.java               # Utilities for reading configuration files
│   ├── PropertiesUtils.java           # Utilities for properties file handling
│   ├── ElementActions.java            # Utilities for element interactions
│   ├── JsonUtils.java                 # Utilities for handling JSON files
│   └── TestDataUtils.java             # Utilities for test data processing
│
├── test
│   └── PurchaseFlowTest.java          # Test cases for the purchase flow
│
├── base
│   └── TestBase.java                  # Base class for setting up and tearing down tests
│
└── testdata
├── CheckoutData.json              # JSON file for checkout test data
└── SearchData.json                # JSON file for search test data

**Prerequisites**
1. Install Java (JDK)
   Before proceeding, ensure Java is installed on your system.

**Steps to Install Java:**
-Download the latest version of the JDK from the official Oracle website or use OpenJDK.
-Run the installer and follow the instructions to complete the installation.
-Set the JAVA_HOME environment variable:
-Open the Control Panel → System and Security → System → Advanced system settings.
-Click on the Environment Variables button.
-Under System Variables, click New and set:
-Variable Name: JAVA_HOME
-Variable Value: The path to your JDK installation, e.g., C:\Program Files\Java\jdk-17.
-Find the Path variable under System Variables and click Edit. Add a new entry with:
%JAVA_HOME%\bin
To verify Java is installed correctly, open Command Prompt and type: java -version

**2. Install Maven**
   Maven is required for dependency management and building the project.

**Steps to Install Maven:**
-Download Apache Maven from the official Maven website.
-Extract the contents to a directory, e.g., C:\apache-maven-3.8.4.
-Set the MAVEN_HOME environment variable:
-Open Control Panel → System and Security → System → Advanced system settings.
-Click Environment Variables.
-Under System Variables, click New and set:
-Variable Name: MAVEN_HOME
-Variable Value: Path to your Maven directory, e.g., C:\apache-maven-3.8.4.
-Add Maven’s bin directory to the Path variable:
-Add: %MAVEN_HOME%\bin
-To verify Maven is installed correctly, open Command Prompt and type: mvn -version


**3. Install Allure Report (Optional)**
   Allure is used for generating test reports.

**Steps to Install Allure:**
-Download Allure from the official Allure website.
-Extract the files to a directory, e.g., C:\allure.
-Add the Allure bin directory to the Path variable:
-Open Control Panel → System and Security → System → Advanced system settings.
-Click Environment Variables.
-Under System Variables, find and click on Path → Edit → New and add:
C:\allure\bin
-To verify Allure is installed, open Command Prompt and type: allure --version

**Running the Framework in IDEA terminal ex intellij**

1. **Install Dependencies**
 To install the required dependencies using Maven,
 run the following command from the project root directory: **mvn clean install**
 This command will download the necessary libraries and packages listed in pom.xml.

2. **Running the Tests**
 To run the tests, use the following Maven command: **mvn clean test**
 and to run the test in different browser and diffrent environment like production or local  
use the following command: mvn clean test -Dbrowser=chrome -Denvironment=production


3. **Generating Allure Reports**
After the tests complete, you can generate the Allure report by running: allure serve allure-results
This will open a web page with the test report.

**Conclusion**
This framework is designed for testing the purchasing flow of the Hyva website. 
It utilizes best practices like Page Object Model (POM) for maintainability and scalability. 

**Follow the steps above to install the necessary tools and execute the tests seamlessly.**

