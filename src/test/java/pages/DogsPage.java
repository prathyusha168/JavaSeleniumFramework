package pages;
 
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class DogsPage {
 
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
 
    // LOCATORS
    By dogsTable = By.xpath("//table[@class='table table-striped']");
    By dogRows = By.xpath("//tbody/tr");
    By goldenRetrieverId =
            By.xpath("//td[text()='Golden Retriever']/preceding-sibling::td[1]/a");
    By dogDetailsTableLocator=By.xpath("//table[@class='table table-striped']");
    
    
    public DogsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }
 
    public void printDogDetails() {
 
        WebElement table = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dogsTable)
        );
 
        List<WebElement> rows = table.findElements(dogRows);
 
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
    }
 
 
    public void clickGoldenRetriever() {
 
        WebElement goldenRetriever = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        goldenRetrieverId
                )
        );
 
        System.out.println(
                goldenRetriever.getText() + " -- ID of Golden Retriever"
        );
 
        js.executeScript(
                "arguments[0].click();",
                goldenRetriever
        );
    }
        
     public void printparticularDogDetailsheadings() {
    	 
    	 WebElement dogDetailsTable=wait.until(ExpectedConditions.visibilityOfElementLocated(dogDetailsTableLocator));
    	 List<WebElement>headingsOfDogDetails=dogDetailsTable.findElements(By.xpath("//thead"));
    	 for(WebElement th:headingsOfDogDetails) {
    		 System.out.println(th.getText());
    	 }
     }
    }
 
