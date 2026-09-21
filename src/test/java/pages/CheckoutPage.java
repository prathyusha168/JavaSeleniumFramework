package pages;
 
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class CheckoutPage {
 
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
 
    // LOCATORS
    By addToCart = By.xpath("//a[text()='Add to Cart']");
    By proceedToCheckout = By.xpath("//a[text()='Proceed to Checkout']");
    By continueAddress = By.xpath("//button[@type='submit']");
    By confirmAddress = By.xpath("//button[@type='submit']");
    By orderConfirmationMessage = By.xpath("//p[text()='Thank you, your order has been submitted.']");
    By orderDetailsTable = By.xpath("//table[1]");
  
    // CONSTRUCTOR
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }
 
    // ADD TO CART
    public void addToCart() {
 
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(addToCart));
 
        element.click();
    }
    
    // PROCEED TO CHECKOUT
    public void proceedToCheckout() {
 
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(proceedToCheckout));
 
        js.executeScript("arguments[0].click();", element);
    }
    
    // CONTINUE ADDRESS
    public void continueAddress() {
 
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(continueAddress));
 
        js.executeScript("arguments[0].click();", element);
    }
    
    // CONFIRM ADDRESS
    public void confirmAddress() {
 
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(confirmAddress));
 
        js.executeScript("arguments[0].click();", element);
    }
    
    public boolean isOrderConfirmed() {
    	return wait.until(ExpectedConditions
    			.visibilityOfElementLocated(orderConfirmationMessage)).isDisplayed();
    }
    
    // PRINT ORDER CONFIRMATION
    public void printOrderConfirmation() {
 
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        orderConfirmationMessage));
 
        System.out.println(element.getText());
    }
    
 // PRINT ORDER DETAILS
    public void printOrderDetails() {
 
        WebElement table = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        orderDetailsTable));
 
        List<WebElement> rows =
                table.findElements(By.xpath("//tbody/tr"));
 
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
    }
}
 
    
    
 
 
