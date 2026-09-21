package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {	
	WebDriver driver;
	WebDriverWait wait;	
	JavascriptExecutor js;
	//Locators
	By signIn=By.linkText("Sign In");
	By username = By.id("username");
    By password = By.id("password");
    By submit = By.xpath("//button[@type='submit']");
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js=(JavascriptExecutor)driver;
    }
    public void clickSignIn() {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(signIn));
 
        element.click();
    }
    public void enterUsername(String user) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        element.clear();
        element.sendKeys(user);
    }
    public void enterPassword(String pass) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        element.clear();
        element.sendKeys(pass);
    }
    public void clickSubmit() {
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(submit));
        
        js.executeScript("arguments[0].click();", element);
    }
}

//Login page

