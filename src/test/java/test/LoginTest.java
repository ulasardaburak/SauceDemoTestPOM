package test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");


    @Test
    public void loginTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        Assert.assertTrue(productsTitle.isDisplayed(), "Login failed!");
    }
}
