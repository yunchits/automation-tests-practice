package com.solvd.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumWebTest implements IAbstractTest {

    private RemoteWebDriver driver;

    private static final String URL = "https://www.selenium.dev/selenium/web/web-form.html";

    @BeforeSuite
    void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        URL url = new URL("http://localhost:4444");

        driver = new RemoteWebDriver(
                url,
                options);
    }

    @BeforeMethod
    void beforeTestMethod() {
        driver.get(URL);
    }

    @Test
    void validateWebFormTitle() {
        String title = driver.getTitle();
        assertEquals("Web form", title, "Wrong title!");
    }

    @Test
    void verifyDataInput() {
        SoftAssert softAssert = new SoftAssert();

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text' and @name='my-text' and @id='my-text-id']"));
        textBox.sendKeys("Text box");

        String enteredText = textBox.getAttribute("value");
        softAssert.assertEquals("Text box", enteredText,  "Failed send keys to text box form!");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password' and @name='my-password']"));
        passwordBox.sendKeys("password");

        String enteredPassword = passwordBox.getAttribute("value");
        softAssert.assertEquals("password", enteredPassword, "Failed send keys to password form!");

        WebElement textareaBox = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
        textareaBox.sendKeys("Text area");

        String enteredTextarea = textareaBox.getAttribute("value");
        softAssert.assertEquals("Text area", enteredTextarea, "Failed send keys to text area form!");

        clickSubmitButton();
        assertReceived();
    }

    @Test
    void uploadFile() {
        WebElement fileInput = driver.findElement(By.xpath("//input[@class='form-control' and @type='file' and @name='my-file']"));

        String filePath = "D:\\IDEA Projects\\automation-tests-practice\\src\\test\\resources\\files\\file.txt";
        fileInput.sendKeys(filePath);

        assertTrue(fileInput.getAttribute("value").endsWith("file.txt"), "File uploaded unsuccessfully!");

        clickSubmitButton();
        assertReceived();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();
    }

    private void assertReceived() {
        WebElement message = driver.findElement(By.xpath("//p[@class='lead' and @id='message' and text()='Received!']"));
        String value = message.getText();
        assertEquals(value, "Received!", "Webform is not received!");
    }
}
