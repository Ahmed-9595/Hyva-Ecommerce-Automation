# Hyva-Ecommerce Purchase Flow Automation Framework

This is a **Selenium-based automation framework** for testing the purchasing flow on [Hyva Ecommerce](https://demo.hyva.io/).
The framework is implemented using **Java, Selenium, Maven, Allure, and TestNG**.

This README provides the necessary steps  to **install, configure, and execute** the framework.

---

##  Project Structure

The project is organized as follows:

```
com.revton.qa
│
├── config
│   └── HyvaAppProperties.java         # Configuration properties
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
│   └── PurchaseFlowTest.java          # Test cases for the purchase flow (Includes Logger)
│
├── base
│   ├── TestBase.java                  # Base class for setting up and tearing down tests
│   └── RetryAnalyzer.java             # Retry mechanism for failed tests
│
└── testdata
    ├── CheckoutData.json              # JSON file for checkout test data
    └── SearchData.json                # JSON file for search test data
```

---

## 🛠 Prerequisites

### 1️⃣ Install Java (JDK)
Ensure **Java (JDK)** is installed on your system.

#### **Steps to Install Java:**
- Download the latest JDK from the [Oracle website](https://www.oracle.com/java/) or use OpenJDK.
- Run the installer and follow the setup instructions.
- Set the **JAVA_HOME** environment variable:
    - Open **Control Panel** → **System and Security** → **System** → **Advanced system settings**.
    - Click on **Environment Variables**.
    - Under **System Variables**, click **New** and set:
        - **Variable Name:** `JAVA_HOME`
        - **Variable Value:** Path to your JDK installation (e.g., `C:\Program Files\Java\jdk-17`)
    - Add `%JAVA_HOME%\bin` to the **Path** variable.

✅ Verify installation: Open **Command Prompt** and run:
```
java -version
```

---

### 2️⃣ Install Maven
Maven is required for **dependency management** and **project building**.

#### **Steps to Install Maven:**
- Download Apache Maven from the [official website](https://maven.apache.org/download.cgi).
- Extract the contents to a directory (e.g., `C:\apache-maven-3.8.4`).
- Set the **MAVEN_HOME** environment variable:
    - Open **Control Panel** → **System and Security** → **System** → **Advanced system settings**.
    - Click on **Environment Variables**.
    - Under **System Variables**, click **New** and set:
        - **Variable Name:** `MAVEN_HOME`
        - **Variable Value:** Path to your Maven directory (e.g., `C:\apache-maven-3.8.4`)
    - Add `%MAVEN_HOME%\bin` to the **Path** variable.

✅ Verify installation: Open **Command Prompt** and run:
```
mvn -version
```

---

### 3️⃣ Install Allure Report (Optional)
Allure is used for **test reporting**.

#### **Steps to Install Allure:**
- Download Allure from the [official website](https://github.com/allure-framework/allure2/releases).
- Extract the files to a directory (e.g., `C:\allure`).
- Add `C:\allure\bin` to the **Path** variable.

✅ Verify installation: Open **Command Prompt** and run:
```
allure --version
```

---

## 🚀 Running the Framework in IntelliJ IDEA

### 1️⃣ Install Dependencies
To install the required dependencies using Maven, run the following command from the project root directory:
```
mvn clean install
```
This will download all necessary libraries listed in `pom.xml`.

---

### 2️⃣ Running the Tests
Run the tests using:
```
mvn clean test
```
To run tests in a **specific browser** and **environment** (e.g., Chrome, production), use:
```
mvn clean test -Dbrowser=chrome -Denvironment=production
```

---

### 3️⃣ Generating Allure Reports
After test execution, generate the Allure report using:
```
allure serve allure-results
```
This will open a web page displaying the test report.

---

## 🎯 Conclusion
This framework is designed for **automating the purchasing flow** of the **Hyva Ecommerce website**.
It follows best practices like the **Page Object Model (POM)** to ensure **maintainability and scalability**.

✅ Follow the steps above to install the necessary tools and execute the tests seamlessly.

---

