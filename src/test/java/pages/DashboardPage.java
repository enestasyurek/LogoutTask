package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='javascript: void(0);']" )
    public WebElement userMenu;
    @FindBy(xpath = " //a[@href='/user/logout']")
    public WebElement logoutLink;

    public void logout(){
        userMenu.click();
        logoutLink.click();
        }

    }
