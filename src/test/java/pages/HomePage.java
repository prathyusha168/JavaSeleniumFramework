package pages;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class HomePage {
 
    WebDriver driver;
    WebDriverWait wait;
 
    By dogs = By.xpath("(//a[text()='Dogs'])[3]");
 
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
 
    public void clickDogs() {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(dogs));
 
        element.click();
    }
}

//search feature adding
 