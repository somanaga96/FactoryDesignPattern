package stepDefinitions.utils;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Exception extends BaseUtils {
    public static Scenario scenario;

    public static void logFail(String msg) {
        scenario.attach(msg, "text/plain", msg);
        if (driver != null) {
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), "image/png", "Failed Screenshot");
        }
        Assert.fail(msg);
    }
}
