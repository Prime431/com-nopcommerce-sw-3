package computer;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;
import zmq.socket.pubsub.Pub;

import java.time.Duration;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //1.0 Create method verifyProductArrangeInAlphaBaticalOrder
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1.1 Click on computer
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //1.3.0 Opening sort by option
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        //1.3.1
        clickOnElement(By.xpath("//option[@value='6']"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1.1 Click on computer
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //1.3.0 Opening sort by option
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[@value='5']"));
        Thread.sleep(5000);
        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]"));
        // getting the actual message
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        String expectedText = "Build your own computer";
        // 2.5 Verify the Text "Build your own computer"
        Assert.assertEquals(actualText, expectedText);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectBYIndexFromDropDown(By.id("product_attribute_1"), "1");
        // 2.7 Select "8GB [+$60.00]" using Select class.
        selectBYIndexFromDropDown(By.id("product_attribute_2"), "5");
        Thread.sleep(5000);
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(4000);
        //2.10 Check box "Microsoft Office [+$50.00]"
        clickOnElement(By.id("product_attribute_5_10"));
        Thread.sleep(4000);
        //2.10 Check box "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        String expectedPrice = "1475.00";
        String actualPrice = getTextFromElement(By.id("price-value-1"));
        //Assert.assertEquals(expectedPrice,actualPrice);
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar
        clickOnElement(By.xpath("//span[@class = 'close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart = mouseHovering(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart = mouseHovering(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions action = new Actions(driver);
        action.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        //2.15 Verify the message "Shopping cart"
        String expectedMessage1 = "Shopping cart";
        String actualMessage1 = getTextFromElement(By.xpath("Shopping cart"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        //  driver.findElement(By.xpath("//input[@class = 'qty-input']")).clear();
        clearTheQuantity(By.xpath("//input[@id='itemquantity11220']"));
        sendTextToElement(By.xpath("//input[@id='itemquantity11220']"), "2");
        clickOnElement(By.id("updatecart"));
        //2.17 Verify the Total"$2,950.00"
        getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.id("termsofservice"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedText1 = "Welcome, Please Sign In!";
        String actualText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText1, actualText1);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Max");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Bond");
        sendTextToElement(By.id("BillingNewAddress_Email"), "bond@gmail.com");
        selectBYIndexFromDropDown(By.id("BillingNewAddress_CountryId"), "133");
        sendTextToElement(By.id("BillingNewAddress_City"), "Mumbai");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "19");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "396436");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "083478378");
        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("(//button[text()='Continue'])[3]"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectBYIndexFromDropDown(By.id("CreditCardType"), "Master card");
        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "mumbai");
        sendTextToElement(By.id("CardNumber"), "patel");
        selectBYIndexFromDropDown(By.id("ExpireMonth"), "3");
        selectBYIndexFromDropDown(By.id("ExpireYear"), "2023");
        sendTextToElement(By.id("CardCode"), "009");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedText2 = "Credit Card";
        String actualText2 = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        Assert.assertEquals(expectedText2, actualText2);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedText3 = "Next Day Air";
        String actualText3 = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        Assert.assertEquals(expectedText3, actualText3);
        //2.33 Verify Total is “$2,950.00”
        String expectedText4 = "$2,950.00";
        String actualText4 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expectedText4, actualText4);
        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.35 Verify the Text “Thank You”
        String expectedText5 = "Thank you";
        String actualText5 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedText5, actualText5);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText6 = "Your order has been successfully processed!";
        String actualText6 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText5, actualText5);
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        //2.37 Verify the text “Welcome to our store”
        String expectedText7 = "Welcome to our store";
        String actualText7 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText7, actualText7);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
