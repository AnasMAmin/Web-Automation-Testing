package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;

public class GetpaidPage {

    WebDriver driver;
    //define the page web elements
    // private By stepTitle =By.className("step-title");
    private By allDocuments_price = By.xpath("//div[@class='section']/div/div/div[2]/span[@class='price-amount']");
    private By allDocuments_name = By.xpath("//div[@class='section']/div/div/div[@class='left']");

    //List<WebElement> priceElements = driver.findElements(allDocuments_price); // Get all price elements
    //List<WebElement> nameElements = driver.findElements(allDocuments_name); // Get all name elements
    //constractor to set the driver value
    public GetpaidPage(WebDriver driver) {
        this.driver = driver;
    }


    // Function to get and print the count and names of free documents
    public List<String> printFreeDocuments() {
        List<WebElement> priceElements = driver.findElements(allDocuments_price); // Get all price elements
        List<WebElement> nameElements = driver.findElements(allDocuments_name); // Get all name elements

        List<String> freeDocuments = new ArrayList<>(); // To store names of free documents

        for (int i = 0; i < priceElements.size(); i++) {
            String priceText = priceElements.get(i).getText().trim(); // Get the price text
            if (priceText.equals("Free") || priceText.equals("$0")) { // Check for free price
                String documentName = nameElements.get(i).getText().trim(); // Get the corresponding document name
                freeDocuments.add(documentName); // Add document name to the list
            }
        }
        return freeDocuments;
    }

    //------------------------------------------------------------------------------------------------------------------------//
    // Function to get and print the count and names of documents within a price range
    public List<String> printDocumentsInPriceRange(int minPrice, int maxPrice) {
        List<WebElement> priceElements = driver.findElements(allDocuments_price); // Get all price elements
        List<WebElement> nameElements = driver.findElements(allDocuments_name); // Get all name elements
/*
    // Check if both lists have the same size
    if (priceElements.size() != nameElements.size()) {
        System.out.println("Error: The number of price elements does not match the number of name elements!");
        return; // Exit the function if there is a mismatch
    }
*/
        List<String> matchingDocuments = new ArrayList<>(); // To store names of matching documents

        for (int i = 0; i < priceElements.size(); i++) {
            try {
                String priceText = priceElements.get(i).getText().trim().replace("$", ""); // Remove '$' and trim spaces
                int price = Integer.parseInt(priceText); // Convert price text to integer

                if (price >= minPrice && price <= maxPrice) { // Check if price is within range
                    String paiddocumentName = nameElements.get(i).getText().trim(); // Get the corresponding document name
                    matchingDocuments.add(paiddocumentName); // Add document name to the list
                }
            } catch (NumberFormatException e) {
                //System.out.println("Invalid price format for element at index " + i + ": " + priceElements.get(i).getText());

            }
        }
        System.out.println("Number of documents in price range " + minPrice + " to " + maxPrice + ": " + matchingDocuments.size());

        return matchingDocuments;
    }
}





