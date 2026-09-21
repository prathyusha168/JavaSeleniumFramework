package tests;
 
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.CheckoutPage;
import pages.DogsPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.Assert;
 
public class EcommerceTest extends BaseTest {
 
    @Test
    public void loginTest() {
 
    	//Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        loginPage.enterUsername("palleprathyusha16");
        loginPage.enterPassword("Amma@168");
        loginPage.clickSubmit();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("jpetstore"),"Login failed");
        
        //Home Page
        HomePage homepage=new HomePage(driver);
        homepage.clickDogs();
        Assert.assertTrue(driver.getCurrentUrl().contains("DOGS"),"Dogs page was not found##");
        
        //Dogs Page
        DogsPage dogsPage=new DogsPage(driver);
        dogsPage.printDogDetails();
        dogsPage.clickGoldenRetriever();
        Assert.assertTrue(driver.getCurrentUrl().contains("K9-RT-01"),"Golden Retriver page was not found");
        dogsPage.printparticularDogDetailsheadings();
        
        
        //checkoutPage
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.addToCart();
        checkoutPage.proceedToCheckout();
        checkoutPage.continueAddress();
        checkoutPage.confirmAddress();
        Assert.assertTrue(checkoutPage.isOrderConfirmed(),"orderconfirmed was not displayed");
        checkoutPage.printOrderConfirmation();
        checkoutPage.printOrderDetails();
        
        
        
        
         
    }
}