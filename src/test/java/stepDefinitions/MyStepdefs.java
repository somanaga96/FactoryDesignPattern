package stepDefinitions;

import com.codoid.products.exception.FilloException;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import login.LoginPage;
import stepDefinitions.utils.BaseUtils;
import stepDefinitions.utils.ExcelUtils;
import stepDefinitions.utils.ScenarioContext;


import static stepDefinitions.org.Constants.SCREENSHOT_FOLDER;
import static stepDefinitions.org.Constants.configProp;
import static stepDefinitions.utils.Utils.getPropValue;

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

    @Given("User creates a Screenshot folder from {string} with {string}")
    public void userCreatesAScreenshotFolderFromWith(String sheetName, String testCaseId) throws FilloException {
        createScreenshotFolder(testCaseId, sheetName);
        if (sheetName.equalsIgnoreCase("first")) {
            scenarioContext.setContext("filePath", getPropValue(configProp, "SEPA_SHEET_PATH"));
        }
        scenarioContext.setContext("sheetName", sheetName);
        scenarioContext.setContext("testCaseId", testCaseId);
    }

    @And("user update the excel sheet")
    public void userUpdateTheExcelSheet() throws FilloException {
        String sheetName = (String) scenarioContext.getContext("sheetName");
        String testCaseId = (String) scenarioContext.getContext("testCaseId");
        String filePath = (String) scenarioContext.getContext("filePath");
        ExcelUtils.setExcelTestData(filePath, sheetName, testCaseId, "ScreenShotPath", filePath);
//        ExcelUtils.setExcelTestData(getPropValue(configProp, "SEPA_SHEET_PATH"), sheetName, testCaseId, "ScreenShotPath", filePath);
    }
}
