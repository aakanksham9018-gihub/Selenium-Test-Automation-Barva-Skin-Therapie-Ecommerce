# Selenium Test Automation - Barva Skin Therapie

## Overview 
This project is a Selenium WebDriver automation project developed using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. It automates various user interactions on the **Barva Skin Therapie** website, including user login, product search, product selection, shopping cart operations, popup handling, window handling, and screenshot capture.

Website Tested:
https://barvaskintherapie.com

---

## Tech Stack 
- Java 
- Selenium WebDriver 4.39.0 
- TestNG 7.11.0 
- Maven 
- Eclipse IDE 
- Google Chrome

---

## Features

The automation suite performs the following tasks:

### Test Case 1 – User Login
- Opens the login popup
- Enters email and password
- Clicks the Login button

### Test Case 2 – Screenshot Capture
- Takes a screenshot of the current page
- Saves it locally

### Test Case 3 – Product Selection
- Opens a skincare product
- Prints:
  - Page title
  - Product price
  - Product size
  - Payment information
- Adds the product to the cart
- Continues shopping

### Test Case 4 – Product Navigation
- Navigates using menu hover
- Opens Lip Balm product
- Opens and closes Patch Test popup
- Adds product to cart

### Test Case 5 – Product Search
- Searches for "Pure Glycerin Soap"
- Opens product
- Handles multiple browser windows
- Selects product variant (if available)
- Checks stock availability
- Adds to cart if in stock

---

## Prerequisites

Before running the project, install:

- Java JDK 8 or above (Java 11 or later is recommended) 
- Maven 
- Google Chrome 
- Eclipse IDE or IntelliJ IDEA 
- Internet connection (for Selenium Manager to download the appropriate browser driver if needed)

---

## Required Dependencies

Example Maven dependencies:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.7.1</version>
</dependency>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.7.1</version>
</dependency>```

---

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/aakanksham9018-gihub/Selenium-Test-Automation-Barva-Skin-Therapie-Ecommerce.git 
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Allow Maven to download all project dependencies.

4. Ensure Google Chrome is installed on your system.

5. Update the screenshot file path in `Project.java` if required.

6. Run the TestNG test class (`Project.java`) using: 
Run As → TestNG Test

---

## Test Scenarios Covered

- Login Automation
- Explicit Waits
- Implicit Waits
- Window Handling
- Mouse Hover Actions
- JavaScript Scrolling
- Screenshot Capture
- Product Search
- Cart Operations
- Popup Handling
- Dynamic Element Handling

---

## Selenium Concepts Used 

- WebDriver 
- TestNG Annotations (`@BeforeTest`, `@BeforeClass`, `@Test`, `@AfterTest`) 
- WebDriverWait (Explicit Wait) 
- ExpectedConditions 
- Actions Class (Mouse Hover Operations) 
- JavaScriptExecutor (Page Scrolling) 
- TakesScreenshot (Screenshot Capture)
- Window Handles (Multiple Browser Window Handling)
- XPath Locators 
- CSS Selectors 
- Dynamic WebElement Handling 
- Popup Handling 
- Exception Handling 
- List Handling for WebElements

---

## Notes 

- Login credentials are hardcoded for testing purposes and should be replaced with secure test data in real projects. 
- Selenium Manager automatically manages the required browser driver in Selenium 4.39.0. 
- Update the screenshot file path with a valid location on your machine. 
- Some website elements may change over time, requiring locator updates. 
- Ensure the website is accessible before running the automation tests.

---

## Future Improvements

- Implement Page Object Model (POM) for better code organization and maintainability
- Add TestNG DataProvider for executing tests with multiple test data sets
- Integrate Extent Reports for detailed test execution reports
- Implement cross-browser testing (Chrome, Firefox, Edge)
- Read test data from external files such as Excel or JSON
- Parameterize browser selection through configuration files
- Add automated screenshots and reporting for failed test cases
- Implement parallel test execution using TestNG

---

## Author

**Aakanksha Mali**

Automation Testing Project using Selenium WebDriver, Java, and TestNG.

## Disclaimer

This project is created for educational and demonstration purposes only.
No real transactions are performed, and no user data or credentials are stored.
