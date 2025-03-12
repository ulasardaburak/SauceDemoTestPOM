package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;

import java.time.Duration;

public class LoginTest {
        WebDriver driver;
        LoginPage loginPage;

        @BeforeClass
        public void setup() {
                System.setProperty("webdriver.chrome.driver", "src/test/java/src/driver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driver.get("https://www.saucedemo.com/");
                loginPage = new LoginPage(driver);
        }

        @Test
        public void testInvalidLogin() {
                loginPage.login("wrong_user", "wrong_pass");
                String actualError = loginPage.getErrorMessage();
                String expectedError = "Epic sadface: Username and password do not match any user in this service";
                Assert.assertEquals(actualError, expectedError, "Unexpected error message!");
        }

        @AfterClass
        public void teardown() {
                driver.quit();
        }
}
