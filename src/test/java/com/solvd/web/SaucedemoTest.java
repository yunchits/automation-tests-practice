package com.solvd.web;

import com.solvd.LoginInput;
import com.solvd.page.InventoryPage;
import com.solvd.page.LoginPage;
import com.solvd.services.LoginService;
import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoTest implements IAbstractTest {

    @Test
    public void testValidLogin() {
        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

        Assert.assertTrue(loginPage.isPageOpened());

        Assert.assertTrue(loginPage.isUsernameElementPresent());
        Assert.assertTrue(loginPage.isPasswordElementPresent());

        LoginService service = new LoginService();
        InventoryPage inventoryPage = service.login(service.createUser(LoginInput.VALID), driver);

        inventoryPage.isPageOpened();
    }
}
