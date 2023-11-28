package Electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.time.Duration;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1.1 Mouse Hover on “Electronics” Tab
        WebElement electronics = mouseHovering(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = 'Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        WebElement cellphones = mouseHovering(By.xpath("//a[text() = 'Cell phones ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellphones).click().build().perform();
        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1.1 Mouse Hover on “Electronics” Tab
        WebElement electronics = mouseHovering(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = 'Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        WebElement cellphones = mouseHovering(By.xpath("//a[text() = 'Cell phones ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellphones).click().build().perform();
        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText, actualText);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        // 2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//div[@class='product-item']//img[@title='Show details for Nokia Lumia 1020']"));
        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText1 = "Nokia Lumia 1020";
        String actualText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        Assert.assertEquals(expectedText1, actualText1);
        //2.7 Verify the price “$349.00”
        String expectedText2 = "$349.00";
        String actualText2 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedText2, actualText2);
        //2.8 Change quantity to 2
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("The product has been added to your "));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText3 = "The product has been added to your shopping cart";
        String actualText3 = getTextFromElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Assert.assertEquals(expectedText3, actualText3);
        //2.10.1 After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart = mouseHovering(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart = mouseHovering(By.xpath("//button[normalize-space()='Go to cart']"));
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        //2.12 Verify the message "Shopping cart"
        String expectedText4 = "Shopping cart";
        String actualText4 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText4, actualText4);
        //2.13 Verify the quantity is 2
        String expectedText5 = "2";
        String actualText5 = getTextFromElement(By.xpath("//input[@id='itemquantity11249']"));
        Assert.assertEquals(expectedText5, actualText5);
        //2.14 Verify the Total $698.00
        String expectedText6 = "$698.00";
        String actualText6 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expectedText6, actualText6);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedText7 = "Welcome, Please Sign In!";
        String actualText7 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText7, actualText7);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        //2.19 Verify the text “Register”
        String expectedText8 = "Register";
        String actualText8 = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals(expectedText8, actualText8);
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "James");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Bond");
        sendTextToElement(By.xpath("//input[@id='Email']"), "james.gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "Password123@");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Password123@");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        String expectedText9 = "Your registration completed";
        String actualText9 = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedText9, actualText9);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        //2.24 Verify the text “Shopping card”
        String expectedText10 = "Shopping card";
        String actualText10 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText10, actualText10);
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[@for='shippingoption_1']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectBYIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"James");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"6557 4843 4433 4376");
        selectBYIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"01");
        selectBYIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"546");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedText11 = "Payment Method: Credit Card";
        String actualText11 = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedText11, actualText11);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedText12 = "Shipping Method: 2nd Day Air";
        String actualText12 = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals(expectedText12, actualText12);
        //2.37 Verify Total is “$698.00”
        String expectedText13 = "$698.00";
        String actualText13 = getTextFromElement(By.xpath("//span[text()='$698.00'][@class = 'product-subtotal']"));
        Assert.assertEquals(expectedText13, actualText13);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        String expectedText14 = "Thank You";
        String actualText14 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals(expectedText14, actualText14);
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedText15 = "Your order has been successfully processed!";
        String actualText15 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expectedText15, actualText15);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        String expectedText16 = "Welcome to our store";
        String actualText16 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedText16, actualText16);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String  actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

    }

}
