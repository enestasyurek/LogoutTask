package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LogoutStepDef {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("The user is login page")
    public void the_user_is_login_page() {
        loginPage.goToLoginPage();
    }

    @Given("The user logs in as a {string}")
    public void the_user_logs_in_as_a(String string) {
        loginPage.login(string);
        loginPage.waitHomePage();
    }


    //AC1
    @When("The user clicks on the {string} button inside profile info")
    public void the_user_clicks_on_the_button_inside_profile_info(String string) {
        dashboardPage.logout();
    }

    @Then("The user should be on the {string} page")
    public void the_user_should_be_on_the_page(String excepctedPage) {
        String actualPage = loginPage.getPageTitle();
        Assert.assertEquals(actualPage, excepctedPage);
    }

    //AC3
    @When("The user clicks on the step back button")
    public void the_user_clicks_on_the_step_back_button() {
        loginPage.stepBack();
    }


    //AC4

    @Then("The user closes the tabs")
    public void the_user_closes_the_tabs() {

        BrowserUtils.openNewTab();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allOpenTabs = new ArrayList<>(windowHandles);

        for (int i = 0; i < allOpenTabs.size() - 1; i++) {
            Driver.getDriver().switchTo().window(allOpenTabs.get(i));
            Driver.getDriver().close();
        }
        BrowserUtils.switchToWindow((0));
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));


    }

    @Then("The user goes to {string}")
    public void the_user_goes_to(String url) {
        Driver.getDriver().get(url);
    }


    //AC5
    @When("The user waits for {int} minutes")
    public void the_user_waits_for_minutes(Integer min) {
        BrowserUtils.sleep(min * 60);

    }

}
