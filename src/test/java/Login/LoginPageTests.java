package Login;

import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPageTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://tracker.vmmaps.com/login");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("gicipab256@devncie.com");
        driver.findElement(By.id("pass")).sendKeys("Gicip@123");
        driver.findElement(By.id("loginSubmit")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://tracker.vmmaps.com/");
    }

    @Test
    public void testInvalidUsername() {
        driver.findElement(By.id("email")).sendKeys("gicipab256@devncieqqq.com");
        driver.findElement(By.id("pass")).sendKeys("Gicip@123");
        driver.findElement(By.id("loginSubmit")).click();
        WebElement errorMsg = driver.findElement(By.xpath("//div[contains(text(),'Cannot login at the moment')]"));
        String actualErrorMessage = errorMsg.getText();
        String expectedErrorMessage = "Cannot login at the moment";
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void testInvalidPassword() {
        driver.findElement(By.id("email")).sendKeys("gicipab256@devncie.com");
        driver.findElement(By.id("pass")).sendKeys("Gicip@12345");
        driver.findElement(By.id("loginSubmit")).click();
        WebElement errorMsg = driver.findElement(By.id("errorMessage"));
        String actualErrorMessage = errorMsg.getText();
        String expectedErrorMessage = "Cannot login at the moment";
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void testEmptyUsername() {
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("Gicip@123");
        driver.findElement(By.id("loginSubmit")).click();
        WebElement errorMsg = driver.findElement(By.xpath("//h3[@class='error-msg']"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    @Test
    public void testEmptyPassword() {
        driver.findElement(By.id("email")).sendKeys("gicipab256@devncie.com");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("loginSubmit")).click();
        WebElement errorMsg = driver.findElement(By.xpath("//h3[@class='error-msg']"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("loginSubmit")).click();
        WebElement errorMsg = driver.findElement(By.id("//h3[@class='error-msg']"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    @Test
    public void testRememberMeChecked() {
        driver.findElement(By.id("email")).sendKeys("gicipab256@devncie.com");
        driver.findElement(By.id("pass")).sendKeys("Gicip@123");
        driver.findElement(By.className("fas fa-square")).click();
        driver.findElement(By.id("loginSubmit")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://tracker.vmmaps.com/");
    }

    @Test
    public void testRememberMeUnchecked() {
        driver.findElement(By.id("email")).sendKeys("gicipab256@devncie.com");
        driver.findElement(By.id("pass")).sendKeys("Gicip@123");
        driver.findElement(By.id("loginSubmit")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://tracker.vmmaps.com/");
    }

    @Test
    public void testLoginButtonDisabledWhenEmptyFields() {
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("");
        WebElement loginButton = driver.findElement(By.id("loginSubmit"));
        Assert.assertFalse(loginButton.isEnabled());
    }


}
