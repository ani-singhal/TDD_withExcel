package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import util.BasePage;

public class AddCustomerPage extends BasePage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h2[text()=' Contacts ']")
	WebElement Home_AddCustomer;
	@FindBy(how = How.ID, using = "account")
	WebElement UserName;
	@FindBy(how = How.ID, using = "cid")
	WebElement Company_Name;
	@FindBy(how = How.ID, using = "email")
	WebElement Email;
	@FindBy(how = How.ID, using = "phone")
	WebElement PHONE;
	@FindBy(how = How.ID, using = "address")
	WebElement ADDRESS;
	@FindBy(how = How.ID, using = "city")
	WebElement CITY;
	@FindBy(how = How.XPATH, using = "//select[@name='country']")
	WebElement COuntry;
	@FindBy(how = How.XPATH, using = "//select[@name='currency']")
	WebElement CURRENCY;
	@FindBy(how = How.XPATH, using = "//select[@name='group']")
	WebElement GROUP;
	@FindBy(how = How.ID, using = "submit")
	WebElement Save_But;

	public void validateAddCustPAge() {
		timer(driver, 4, Home_AddCustomer);
		Assert.assertEquals(Home_AddCustomer.getText(), "Contacts", "AddCustomer Page Not Found");
	}
	static String enteredName;
	public String AddUserName(String name) {
		timer(driver, 4, UserName);
		enteredName = name + randomgen(999);
		UserName.sendKeys(enteredName);
		System.out.println("======="+enteredName);
		return enteredName;
	}

	public void selectCompanyName(String compName) {
		dropdownSel(Company_Name, compName);
	}
	 
	public void addemail(String name) {
		String enteredemail=(name+randomgen(9999))+"@tech.com";
		Email.sendKeys(enteredemail);
	}

	public void addephone(String name) {
		PHONE.sendKeys(name);
	}

	public void addaddress(String name) {
		ADDRESS.sendKeys(name);
	}

	public void addcity(String name) {
		CITY.sendKeys(name);
	}

	public void selectcountry(String name) {
		timer(driver, 4, COuntry);
		dropdownSel(COuntry, name);
	}

	public void selectcurrency(String name) {
		timer(driver, 3, CURRENCY);
		dropdownSel(CURRENCY, name);
	}

	public void selectgroup(String name) {
		timer(driver, 3, GROUP);
		dropdownSel(GROUP, name);
	}

	public void savethePage() {
		timer(driver, 4, Save_But);
		Save_But.click();
		

	}
}
