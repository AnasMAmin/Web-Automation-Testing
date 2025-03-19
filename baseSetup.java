import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GetpaidPage;
import pages.HomePage;
import java.time.Duration;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;

public class baseSetup {
    private WebDriver driver;
    protected HomePage homepage;
    protected GetpaidPage getpaidPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        //Navigate the home page URL
        driver.get("https://www.levelset.com/");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 seconds wait
        homepage = new HomePage(driver);
        homepage.clickgetpaid();
        getpaidPage = new GetpaidPage(driver);
    }
    @Test
    public void testingFreeDocuments() {
        // Get and print free documents
        List<String> freedoc =getpaidPage.printFreeDocuments();
        System.out.println("the count of free documents:  " + freedoc.size());
        if (!freedoc.isEmpty()) {
           // System.out.println("Free documents:");
            for (String document : freedoc) {
                System.out.println(document);
            }
        } else {
            System.out.println("No free documents found.");
        }
assertEquals("Not the expected count",2,freedoc.size());
assertEquals("Not the expected",freedoc.get(0),"Exchange a Waiver");
assertEquals("Not the expected",freedoc.get(1),"Send a Payment Document");
    }
    @Test
    public void testingDocumentsInSpecificPriceRange() {
    // Get and print documents in the price range of 30 to 60
        List<String> paidDocuments = getpaidPage.printDocumentsInPriceRange(30, 60);

        // Print results
        if (!paidDocuments.isEmpty()) {
            System.out.print("Matching documents:  ");
            for (String document : paidDocuments) {
                System.out.println(document);
            }        }
        else { System.out.println("No documents found in the specified price range."); }

        assertEquals("the count in correct",1,paidDocuments.size());
        assertEquals("Wrong Name",paidDocuments.get(0),"Send a Warning");
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }



}