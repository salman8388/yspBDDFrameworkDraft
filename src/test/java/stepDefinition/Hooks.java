package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.DriverFactory;

import java.io.IOException;

public class Hooks extends DriverFactory {

    public void launchUrl() throws IOException {
        initiatingBrowser();
        getDriver().get(getProperty("url"));
        System.out.println("URl launched");
    }

    public void closeAll() {
        getDriver().quit();
    }
}
