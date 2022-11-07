package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//span[.='Remember me on this computer']")
    public WebElement rememberMe;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }
    public void login(String userType) {

        String password = "";
        String username = "";

        if (userType.toLowerCase().equals("driver")) {
            username = ConfigurationReader.getProperty("driver_username");
            password = ConfigurationReader.getProperty("driver_password");
        } else if (userType.toLowerCase().equals("sales manager")) {
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        } else if (userType.toLowerCase().equals("store manager")) {
            username = ConfigurationReader.getProperty("store_manager_username");
            password = ConfigurationReader.getProperty("store_manager_password");
        }

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void goToLoginPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    public String getPageTitle(){
        return Driver.getDriver().getTitle();
    }
    public void stepBack(){
        Driver.getDriver().navigate().back();
    }



    public void waitHomePage() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            wait.until(ExpectedConditions.titleIs("Dashboard"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
