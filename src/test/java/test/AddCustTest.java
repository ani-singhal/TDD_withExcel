package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.Browserfactory;
import util.ExcelReader;

public class AddCustTest {
	WebDriver driver;

	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String username = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String name = exlread.getCellData("AddContactInfo", "FullName", 2);
	String compName = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String email = name;

	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String currency = exlread.getCellData("AddContactInfo", "Currency", 2);
	String group = exlread.getCellData("AddContactInfo", "Group", 2);

	@Test
	public void DAshBoardTest() {

		driver = Browserfactory.init();

		LoginPage log = PageFactory.initElements(driver, LoginPage.class);
		log.enteruser(username);
		log.enterpwd(password);
		log.submit();

		DashBoardPage Dash = PageFactory.initElements(driver, DashBoardPage.class);
		Dash.validateHomePage();
		Dash.clickCustomer_But();
		Dash.clickAddCostomer_But();

		AddCustomerPage addcust = PageFactory.initElements(driver, AddCustomerPage.class);
		addcust.validateAddCustPAge();
		addcust.AddUserName(name);
		addcust.selectCompanyName(compName);
		addcust.addemail(email);
		addcust.addcity(city);
		addcust.selectcountry(country);
		addcust.selectcurrency(currency);
		addcust.selectgroup(group);
		addcust.savethePage();

	}

}
