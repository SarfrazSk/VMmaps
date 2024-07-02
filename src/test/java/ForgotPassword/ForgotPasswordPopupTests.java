package ForgotPassword;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordPopupTests {
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
//        driver.quit();
    }

    private void openForgotPasswordPopup() {
        driver.findElement(By.xpath("//div[normalize-space()='Forgot Password ?']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-fsYfdN hnSogn']")));
    }

    @Test
    public void testValidEmail() {
        openForgotPasswordPopup();
        driver.findElement(By.id("email")).sendKeys("gicipab256@devncie.com");
        driver.findElement(By.xpath("//button[@class='sc-gLLuof kuxdqO']")).click();
        WebElement successMsg = driver.findElement(By.xpath("//div[@class='sc-fsYfdN hnSogn']"));
        Assert.assertTrue(successMsg.isDisplayed());
    }



    @Test
    public void testUIElementsPresence() {
        openForgotPasswordPopup();
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        WebElement bt = driver.findElement(By.xpath("//button[@class='sc-gLLuof kuxdqO']"));
        Assert.assertTrue(bt.isDisplayed());
    }

    @Test
    public void testCloseForgotPasswordPopup() {
        openForgotPasswordPopup();
        driver.findElement(By.xpath("//button[@class='sc-gLLuof eAgKZT']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='sc-fsYfdN hnSogn']")));
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='sc-fsYfdN hnSogn']")).isDisplayed());
    }

    @Test
    public void testPopupTitle() {
        openForgotPasswordPopup();
        WebElement popupTitle = driver.findElement(By.xpath("//h3[@class='popup-title']"));
        Assert.assertEquals(popupTitle.getText(), "Forgot Password?");
    }
}
