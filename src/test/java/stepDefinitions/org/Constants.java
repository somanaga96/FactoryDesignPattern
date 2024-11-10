package stepDefinitions.org;

import stepDefinitions.utils.Utils;

import java.util.Properties;

public interface Constants {
    String CONFIG_DIR = "src/test/resources/configuration";
    String SCREENSHOT_FOLDER = "src/test/resources/screenshot/";
    public static Properties configProp = Utils.getProps(Constants.CONFIG_DIR, "config");
}
