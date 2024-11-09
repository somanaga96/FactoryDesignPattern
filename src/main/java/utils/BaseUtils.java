package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static org.Constants.SCREENSHOT_FOLDER;

public class BaseUtils {
    public static WebDriver driver;

    public void takeScreenshot(String message) {
        String scrImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        File newHtmlFile = new File(SCREENSHOT_FOLDER + "scenario1.html");
        try {
            String htmlString = FileUtils.readFileToString(newHtmlFile, "UTF-8");
            String newDiv = "<div> <h3>" + message + "</h3><img src=\"data:image/png;base64, " + scrImage + "\" ><div>--End--";
            htmlString = htmlString.replace("--End--", newDiv);
            FileUtils.writeStringToFile(newHtmlFile, htmlString, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createWebDriver() {
        String name = "chrome";
        switch (name) {
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
}
