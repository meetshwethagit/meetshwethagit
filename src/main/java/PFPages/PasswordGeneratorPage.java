package PFPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.Keys;

public class PasswordGeneratorPage {
    private WebDriver driver;

    // Locators
    private By passwordLengthInput = By.xpath("//input[@id='passwordLength']");
    private By includeUppercaseCheckbox = By.xpath("//input[@id='option-uppercase']");
    private By includeLowercaseCheckbox = By.xpath("//input[@id='option-lowercase']");
    private By includeNumbersCheckbox = By.xpath("//label[normalize-space()='Numbers']");
    private By includeSymbolsCheckbox = By.xpath("//label[normalize-space()='Symbols']");
    private By generateButton = By.xpath("//button[@title='Generate password']");
    private By generatedPassword = By.xpath("//input[@id='password']");
    private By copypassword = By.xpath("//button[normalize-space()='Copy Password']");

    public PasswordGeneratorPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the page
    public void setPasswordLength(String length) {
  //driver.findElement(passwordLengthInput).clear(); 
       // driver.findElement(passwordLengthInput).sendKeys(String.valueOf(length));
    	WebElement passwordLengthInput = driver.findElement(By.xpath("//input[@id='passwordLength']"));
  passwordLengthInput.sendKeys(Keys.CONTROL, Keys.chord("a")); //select all text in textbox
  passwordLengthInput.sendKeys(Keys.BACK_SPACE); //delete it
  passwordLengthInput.sendKeys(length); //enter new text
     //   driver.findElement(passwordLengthInput).sendKeys(length);
        
   
    }

    public void toggleUppercase(boolean enable) {
        toggleCheckbox(includeUppercaseCheckbox, enable);
    }

    public void toggleLowercase(boolean enable) {
        toggleCheckbox(includeLowercaseCheckbox, enable);
    }

    public void toggleNumbers(boolean enable) {
        toggleCheckbox(includeNumbersCheckbox, enable);
    }

    public void toggleSymbols(boolean enable) {
        toggleCheckbox(includeSymbolsCheckbox, enable);
    }

    private void toggleCheckbox(By checkbox, boolean enable) {
        if (enable != driver.findElement(checkbox).isSelected()) {
            driver.findElement(checkbox).click();
            }
       
        }
        
        
    

    public void generatePassword() {
        driver.findElement(generateButton).click();
    }

    public String getGeneratedPassword() {
        return driver.findElement(generatedPassword).getAttribute("Value");
    }
    
    public void copypassword()
    {
    driver.findElement(copypassword).click();
	
    }
}
