package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.Browserfactory;
import util.ExcelReader;

public class loginTest {
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String username = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void ValiduserLogs() {
		System.out.println(username);
		System.out.println(password);
		
		driver= Browserfactory.init();
		
		LoginPage log= PageFactory.initElements(driver, LoginPage.class);
		log.enteruser(username);
		log.enterpwd(password);
		log.submit();
		
	}

}
