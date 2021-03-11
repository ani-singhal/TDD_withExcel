package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Browserfactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how=How.ID, using="username") WebElement USER;
	@FindBy(how=How.ID, using="password") WebElement PWD;
	@FindBy(how=How.XPATH, using="//button[@name='login']") WebElement Login_But;
	
	public void enteruser(String userName) {
		USER.sendKeys(userName);
	}
	
	public void enterpwd(String password) {
		PWD.sendKeys(password);
	}
	public void submit() {
		Login_But.click();
	}
	
	

}
