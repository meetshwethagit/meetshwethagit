package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PFPages.PasswordGeneratorPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Keys;

public class PasswordGeneratorTest {
    private WebDriver driver;
    private PasswordGeneratorPage passwordGeneratorPage;
    protected WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.security.org/password-generator/");
        passwordGeneratorPage = new PasswordGeneratorPage(driver);
  
    }

    @Test
    public void testGeneratePasswordWithAllOptions() {
    	  // Find the password length field and modify the length (e.g., inputting 16 characters)
        WebElement passwordLengthInput = driver.findElement(By.xpath("//input[@id='passwordLength']"));
     //   passwordLengthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), "12"); // Clear and set 16
        
     
        passwordGeneratorPage.setPasswordLength("12");
        passwordGeneratorPage.toggleUppercase(true);
        passwordGeneratorPage.toggleLowercase(true);
        passwordGeneratorPage.toggleNumbers(true);
        passwordGeneratorPage.toggleSymbols(true);
        passwordGeneratorPage.copypassword();
        //passwordGeneratorPage.generatePassword();
        String password = passwordGeneratorPage.getGeneratedPassword();
        // Print the generated password
        System.out.println("Generated password for length 12: " + password);
        Assert.assertEquals(password.length(), 12);
    }

    @Test
    public void testNoOptionsSelected()  {
        passwordGeneratorPage.setPasswordLength("8");
        passwordGeneratorPage.toggleUppercase(true);
        passwordGeneratorPage.toggleLowercase(true);
        passwordGeneratorPage.toggleNumbers(true);
        passwordGeneratorPage.toggleSymbols(true);
     //   passwordGeneratorPage.generatePassword();
        passwordGeneratorPage.copypassword();
        String password = passwordGeneratorPage.getGeneratedPassword();
        System.out.println("Generated password for length 8: " + password);
        Assert.assertTrue(password.isEmpty(), "Password should not be generated if no options are selected.");
    }
//good
    @Test
    public void testGeneratePasswordWithMaxLength() throws InterruptedException {
        	 

        // Set password length to 32
        passwordGeneratorPage.setPasswordLength("32");

        // Ensure that we trigger the password generation (if required by a button)
        WebElement generateButton = driver.findElement(By.xpath("//button[@title='Generate password']")); // Replace with actual button id or locator
        generateButton.click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        // Add a wait to ensure the password is generated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));

        // Fetch generated password
        String gqeneratedPassword = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("value");

        // Print the generated password
        System.out.println("Generated password for length 32: " + gqeneratedPassword);

        // Ensure that a non-empty password is generated and has the correct length
        Assert.assertTrue(!gqeneratedPassword.isEmpty(), "Password should not be empty.");
        Assert.assertEquals(gqeneratedPassword.length(), 32, "Password length should be 32 characters.");
    }
    

    @Test
    public void testInvalidInputForLength() {
    	
    	
        driver.findElement(By.xpath("//input[@id='passwordLength']")).sendKeys("abc");
       // passwordGeneratorPage.generatePassword();
        passwordGeneratorPage.copypassword();
        String password = passwordGeneratorPage.getGeneratedPassword();
        System.out.println(password);
        Assert.assertTrue(password.isEmpty(), "Password should not be generated if input is invalid.");
    }

    
    @Test
    public void testMinInputforLength() {
    	passwordGeneratorPage.setPasswordLength("6");

        passwordGeneratorPage.toggleUppercase(true);
        passwordGeneratorPage.toggleLowercase(true);
        passwordGeneratorPage.toggleNumbers(true);
        passwordGeneratorPage.toggleSymbols(true);
     //   passwordGeneratorPage.generatePassword();
        passwordGeneratorPage.copypassword();
        String password = passwordGeneratorPage.getGeneratedPassword();
        System.out.println("Generated password for length 8: " + password);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
