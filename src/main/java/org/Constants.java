package org;

import java.util.Properties;

import static utils.Utils.getProps;

public interface Constants {
    String CONFIG_DIR = "src/test/resources/configuration";
    String SCREENSHOT_FOLDER = "src/test/resources/screenshot/";
    public static Properties configProp = getProps(Constants.CONFIG_DIR, "config");
}
