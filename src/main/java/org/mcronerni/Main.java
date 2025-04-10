package org.mcronerni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static WebDriver driver;
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/utils/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", new HashMap<String, Boolean>(){{
            put("credentials_enable_service", false);
        }});
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By logoLocator = By.xpath("//div[contains(@class,'login_logo')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
        System.out.println("Logo is Visible");

        String userName = "standard_user";
        WebElement userNameLocator = driver.findElement(By.xpath("//input[contains(@id,'user-name')]"));
        userNameLocator.sendKeys(userName);
        System.out.println("SendKeys: "+userName);

        String password = "secret_sauce";
        WebElement passwordLocator = driver.findElement(By.xpath("//input[contains(@id,'password')]"));
        passwordLocator.sendKeys(password);

        By loginButtonLocator = By.xpath("//input[contains(@id,'login-button')]");
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        loginButton.click();
        System.out.println("Login is clicked");

        By appLogoLocator = By.xpath("//div[contains(@class,'app_logo')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(appLogoLocator));
        System.out.println("App logo is visible");

        String item1 = "Bolt T-Shirt";
        By item1Locator = By.xpath("//div[contains(text(),'"+item1+"')]//ancestor::div[@class='inventory_item']//div[@class='pricebar']//button");
        WebElement item1Button = wait.until(ExpectedConditions.visibilityOfElementLocated(item1Locator));
        item1Button.click();
        System.out.println("Added to cart: " + item1);

        String item2 = "Labs Backpack";
        By item2Locator = By.xpath("//div[contains(text(),'"+item2+"')]//ancestor::div[@class='inventory_item']//div[@class='pricebar']//button");
        WebElement item2Button = wait.until(ExpectedConditions.visibilityOfElementLocated(item2Locator));
        item2Button.click();
        System.out.println("Added to cart: " + item2);

        By shoppingCartLocator = By.xpath("//div[contains(@id,'shopping_cart_container')]//span");
        WebElement shoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartLocator));
        System.out.println("Total Items in cart: " + shoppingCart.getText());

        shoppingCart.click();
        System.out.println("Shopping Cart icon is clicked");

        //skipped shopping cart list
        //insert for loop here

        By checkoutLocator = By.xpath("//a[contains(text(), 'CHECKOUT')]");
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutLocator));
        checkoutButton.click();
        System.out.println("Checkout Button is clicked");

        String fName = "MJ";
        WebElement fNameLocator = driver.findElement(By.xpath("//input[contains(@id, 'first-name')]"));
        fNameLocator.sendKeys(fName);
        System.out.println("SendKeys: "+fName);

        String lName = "Cron";
        WebElement lNameLocator = driver.findElement(By.xpath("//input[contains(@id, 'last-name')]"));
        lNameLocator.sendKeys(lName);
        System.out.println("SendKeys: "+lName);

        String postalCode = "4000";
        WebElement postalCodeLocator = driver.findElement(By.xpath("//input[contains(@id, 'postal-code')]"));
        postalCodeLocator.sendKeys(postalCode);
        System.out.println("SendKeys: "+postalCode);

        By continueLocator = By.xpath("//input[contains(@value,'CONTINUE')]");
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(continueLocator));
        continueButton.click();
        System.out.println("Continue Button is clicked");

        By paymentInfoLocator = By.xpath("//div[contains(@class,'summary_value_label')][1]");
        WebElement paymentInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoLocator));
        System.out.println("Payment Information: "+ paymentInfo.getText());

        By shippingInfoLocator = By.xpath("//div[contains(@class,'summary_value_label')][2]");
        WebElement shippingInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(shippingInfoLocator));
        System.out.println("Shipping Information: "+ shippingInfo.getText());

        By itemTotalLocator = By.xpath("//div[contains(@class,'summary_subtotal_label')]");
        WebElement itemTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(itemTotalLocator));
        System.out.println("Total: "+ itemTotal.getText());

        By taxLocator = By.xpath("//div[contains(@class,'summary_tax_label')]");
        WebElement tax = wait.until(ExpectedConditions.visibilityOfElementLocated(taxLocator));
        System.out.println("Item Total: "+ tax.getText());

        By totalLocator = By.xpath("//div[contains(@class,'summary_total_label')]");
        WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(totalLocator));
        System.out.println("Total: "+ total.getText());

        By finishLocator = By.xpath("//a[contains(text(), 'FINISH')]");
        WebElement finishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(finishLocator));
        finishButton.click();
        System.out.println("Finish Button is clicked");

        By thanksLocator = By.xpath("//h2[contains(@class, 'complete-header')]");
        WebElement thanks = wait.until(ExpectedConditions.visibilityOfElementLocated(thanksLocator));
        System.out.println("Message: "+ thanks.getText());

        Thread.sleep(3000);
        driver.quit();
    }
}