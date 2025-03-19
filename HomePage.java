package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver ;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Move cursor to the target element
    public void moveToElement(WebElement target) {
        try {
            Actions action = new Actions(driver); // Initialize Actions class
            action.moveToElement(target).perform(); // Move the cursor to the element
            System.out.println("Cursor moved to the target element.");
        } catch (Exception e) {
            System.err.println("Failed to move the cursor to the element. Error: " + e.getMessage());
        }
    }

    // Generic method for clicking
    private void click(WebElement target) {
        try {
            target.click();
            target.click();
            System.out.println("Successfully clicked on the target element.");
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Failed to click on the target element. Error: " + e.getMessage());
        }
    }
public GetpaidPage clickgetpaid(){
        WebElement getpaid = driver.findElement(By.xpath("//a[@href='https://app.levelset.com/wizard/SelectDocument/'][1]"));
       moveToElement(getpaid);
        click(getpaid);
        return new GetpaidPage(driver);
}




}
