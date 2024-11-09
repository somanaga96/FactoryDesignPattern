package org;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BaseUtils;


import static org.Constants.configProp;
import static utils.Utils.getPropValue;

public class MyStepdefs extends BaseUtils {
    LoginPage loginPage = new LoginPage(driver);

    @Given("user launch the swag lab")
    public void userLaunchTheSwagLab() {
        String url = getPropValue(configProp, "swagUrl");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("URL is not set in config.properties");
        }
        System.out.println("URL: " + url);
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        loginPage.userName.sendKeys(getPropValue(configProp, "username"));
        loginPage.password.sendKeys(getPropValue(configProp, "password"));
        takeScreenshot("Login Page");
    }

    @And("user enter the credential details")
    public void userEnterTheCredentialDetails() {
        loginPage.login.click();
        takeScreenshot("Home Page");
    }
}
