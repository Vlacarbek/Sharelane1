import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingUp {

    WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.get("https://sharelane.com/cgi-bin/register.py");


        }


        @Test
        public void checkPositiveSignUp() {
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
            boolean elementOnPage = driver.findElement(By.cssSelector(".confirmation_message")).isDisplayed();
            Assert.assertTrue(elementOnPage);
            driver.quit();
        }
        @Test
        public void checkNegativeSignUp() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://sharelane.com/cgi-bin/register.py");
            driver.findElement(By.name("zip_code")).sendKeys("12345");
            driver.findElement(By.cssSelector("[value='Continue']")).click();
            driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("");
            driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("");
            driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("");
            driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("");
            driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("");
            driver.findElement(By.cssSelector("[value='Register']")).click();
            String errorMessage = driver.findElement(By.cssSelector(".error_message")).getText();
            Assert.assertEquals(errorMessage, "Oops, error on page. Some of your fields have invalid data or email was previously used");
            driver.quit();
}
        @AfterMethod (alwaysRun = true)
        public void quit(){
            driver.quit();
        }
}

