package utils;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends BaseUtils {
    @Before
    public void beforeExecution() {
        System.out.println("hooks executed");
        createWebDriver();
    }
}
