package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import util.BasePage;

public class ListCutomerPage extends BasePage {
	WebDriver driver;

	public ListCutomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "summary")
	WebElement PROFILE;
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']")
	WebElement LIST_Cust_But;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), ' Contacts ')]")
	WebElement CHECK_Contacts;

	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']")
	WebElement Search_Bar;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement Confirm_Deletion;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement Delete_Confirmation;

	public void clicklistCustomer_But() {
		timer(driver, 4, LIST_Cust_But);
		LIST_Cust_But.click();
	}

	public void validatecontactspage() {
		timer(driver, 4, CHECK_Contacts);
		Assert.assertEquals(CHECK_Contacts.getText(), "Contacts", "ConTact PAge NOT Found");
	}

	public void searchname(String Name) {
		// System.out.println(AddCustomerPage.enteredName);
		System.out.println("++++" + Name);
		String beforeXpath = "//tbody/tr[";
		String AfterXpath = "]/td[3]/a";
		for (int i = 1; i < 5; i++) {
			WebElement check = driver.findElement(By.xpath(beforeXpath + i + AfterXpath));
			if (check.getText().contains(Name)) {
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[7]/a[2]")).click();
				// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
				break;
			}
		}
	}

	public void confirmdelete() {
		Confirm_Deletion.click();
	}

	public void validateDeletion() {
		String textforconfirmation = "Contact Deleted Successfully";
		if (Delete_Confirmation.getText().contains(textforconfirmation)) {
			System.out.println("DELETED SUCCESSFULLY");
		}
	}
	public void verifyprofilepage() {
		timer(driver, 4, PROFILE);
		Assert.assertEquals(PROFILE.getText(), "Summary", "NOT Landed on Profile page");
	}
}
