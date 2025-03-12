package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @BeforeTest
    public static void setUp(){
    System.setProperty("webdriver.chrome.driver", "src/test/java/src/driver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("baseUrl");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));

    }
    @AfterTest
    public static void tearDown(){
        driver.quit();
    }
}
