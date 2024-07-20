package stepDefinition;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utility.DriverFactory;

import java.io.IOException;


public class Steps extends DriverFactory {
    LoginPage lp;
    HomePage hp;
    Hooks hooks = new Hooks();
    @Given("user launch the application")
    public void userLaunchApplication() throws IOException {
      hooks.launchUrl();
    }
    @And("close the browser")
    public void CloseBrowser() {
        hooks.closeAll();
    }
    @When("user enter the login details")
    public void user_enter_the_login_details() {
        lp = new LoginPage();
        lp.enterLoginDetails();
    }

    @Then("user should navigate to dashboard page")
    public void user_should_navigate_to_dashboard_page() {

    }

    @Then("click on logout")
    public void click_on_logout() {
        hp = new HomePage();
        hp.logout();
    }


}
