package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverFactory;
import utility.GenericMethods;

public class LoginPage extends GenericMethods {

    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "Password")
    WebElement passWord;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;


    public void enterLoginDetails()
    {    waitForElementTobeEnterText(email,getProperty("username"));
        waitForElementTobeEnterText(passWord,getProperty("password"));
        waitForElementTobeClick(submitBtn);
    }


}
