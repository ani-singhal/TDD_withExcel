package util;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void timer(WebDriver driver2, int waitTime, WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver2, waitTime);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public void dropdownSel(WebElement Element, String compName) {
		Select sel = new Select(Element);
		sel.selectByVisibleText(compName);
	}
	
	public int randomgen(int i) {
		Random rnd = new Random();
		return rnd.nextInt(i);
		
	}
}
