package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverFactory;
import utility.GenericMethods;

import java.util.List;

public class HomePage extends GenericMethods {

    public HomePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }


    @FindBy(xpath = "//p[.=' Dashboard']")
    WebElement Dashboard;
    @FindBy(xpath = "//a[.='Logout']")
    WebElement logout;

    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    WebElement CustomersMenu;
    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']//li[1]//a[1]")
    WebElement Customer;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement AddNewBtn;
    public @FindBy(id = "Email") WebElement email;
    public @FindBy(id = "Password") WebElement password;
    public @FindBy(id = "FirstName") WebElement firstName;
    public @FindBy(id = "LastName") WebElement lastName;
    public @FindBy(xpath = "//input[@type='radio']") List<WebElement> gender;
    public @FindBy(id = "DateOfBirth") WebElement dateOfBirth;
    public @FindBy(id = "Company") WebElement companyName;
    public @FindBy(id = "IsTaxExempt") WebElement isTaxExemptCheckBox;
    public @FindBy(xpath = "//div[@class='input-group-append']//div[@role='listbox']") WebElement SelectedNewsletterSubscriptionStoreIds;
    public @FindBy(id = "SelectedNewsletterSubscriptionStoreIds") List<WebElement> dropdownValues;
    public @FindBy(id = "//div[@class='input-group-append input-group-required']//div[@role='listbox']") WebElement SelectedCustomerRoleIdsTextBox;
    public @FindBy(id = "SelectedCustomerRoleIds") WebElement SelectedCustomerRoleIdsDropdown;
    public @FindBy(id = "VendorId") WebElement VendorIdTxtbox;
    public @FindBy(xpath = "//em[contains(text(),'Note: if you have a vendor associated with this cu')]") WebElement noteMessage;
    public @FindBy(id = "Active") WebElement ActiveCheckBox;
    public @FindBy(id = "AdminComment") WebElement AdminCommentTextBox;

    public @FindBy(xpath = "//h1[@class='float-left']") WebElement addNewCustomerHeader;


    public void logout() {
        click(logout);
    }


}
