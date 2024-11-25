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

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void checkLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Vladimir");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Tsarev");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("test@test.ru");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[value='Register']")).click();
        String login = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = "1111";
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value = 'Login']")).click();
        boolean onDisplay = driver.findElement(By.cssSelector(".user")).isDisplayed();
        Assert.assertTrue(onDisplay);
    }
    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
