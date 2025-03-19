# WebAutomation Testing

This project demonstrates how **Selenium** is used to automate web interactions and validate test results with the **TestNG** framework. It includes functionalities like locating web elements, interacting with them, and running end-to-end validations.

![Project Screenshot](./images/project_overview.png) <!-- Add your screenshot path here -->

---

## **Project Overview**

This project is designed to automate web interactions using **Selenium WebDriver** and validate the behavior of web elements using the **TestNG** framework. It follows a modular structure with reusable methods for better maintainability.

### **Technology Stack**
- **Language**: Java
- **Automation Tool**: Selenium WebDriver
- **Testing Framework**: TestNG
- **Build Tool**: Maven

---

## **Features**

### **1. Selenium-Based Automation**
Selenium WebDriver is the primary tool used for automating browser interactions:
- **Locating Elements Dynamically**:
  ```java
  WebElement element = driver.findElement(By.xpath("//button[text()='Submit']"));
  element.click(); // Perform a click
  ```java


#### Dynamic Locator Example

```java
String xpath = "//div[@class='section']//button[text()='Submit']";
WebElement submitButton = driver.findElement(By.xpath(xpath));
submitButton.click();
  ```

#### Handling Multiple Elements
```java
List<WebElement> elements = driver.findElements(By.className("item"));
for (WebElement element : elements) {
    System.out.println(element.getText());
}
```


### **2. Test Validation Using TestNG**

TestNG is used to validate web interactions. Assertions ensure that web elements behave as expected.

```java
@Test
public void validateDocumentPrices() {
    WebElement priceElement = driver.findElement(By.id("price"));
    String priceText = priceElement.getText();
    Assert.assertEquals(priceText, "$29", "Price validation failed!");
}
```
### **Test Flow**
The test flow for this project follows these steps:

1. **Open the Target Website**:
   - Initialize the WebDriver and navigate to the target website.
2. **Locate Elements Using Selenium**:
   - Use Selenium's locators (e.g., `By.id`, `By.xpath`, `By.cssSelector`) to find web elements.
3. **Perform Actions**:
   - Interact with the web elements by performing actions like clicking buttons, entering text, or selecting dropdown options.
4. **Validate Expected Behavior Using TestNG Assertions**:
   - Use TestNG assertions (e.g., `Assert.assertEquals`, `Assert.assertTrue`) to validate the expected behavior of the web application.


