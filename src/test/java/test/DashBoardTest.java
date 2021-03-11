package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.Browserfactory;
import util.ExcelReader;

public class DashBoardTest {
	WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String username = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void DAshBoardTest() {
		
		driver= Browserfactory.init();
		
		LoginPage log= PageFactory.initElements(driver, LoginPage.class);
		log.enteruser(username);
		log.enterpwd(password);
		log.submit();
		
		DashBoardPage Dash =PageFactory.initElements(driver, DashBoardPage.class);
		Dash.validateHomePage();
		Dash.clickCustomer_But();
		Dash.clickAddCostomer_But();
		
	}
		

}
