package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.BasePage;

public class DashBoardPage extends BasePage {
	
	WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	} 
	
	@FindBy(how=How.XPATH, using=" //h2[contains(text(), 'Dashboard')]") WebElement DashBoard_Home;
	@FindBy(how=How.XPATH, using="//span[text()='Customers']") WebElement Customer_But;
	@FindBy(how=How.XPATH, using="//a[text()='Add Customer']") WebElement AddCustomer_But;
	
	
	public void validateHomePage() {
		timer(driver, 4, DashBoard_Home );
		//WebDriverWait wait = new WebDriverWait(driver, 4);
		//wait.until(ExpectedConditions.visibilityOf(DashBoard_Home));
		Assert.assertEquals(DashBoard_Home.getText(), "Dashboard", "DashBoard HOMEPAGE not Found");
	}



	public void clickCustomer_But() {
		Customer_But.click();
	}
	public void clickAddCostomer_But() {
		timer(driver, 6, AddCustomer_But );
		AddCustomer_But.click();
	}
	
}
