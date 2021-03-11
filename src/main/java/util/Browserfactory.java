package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Browserfactory {
	static WebDriver driver;
	static String browser = null;
	static String url;

	public static void readconfig() {

		try {
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(fs);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static WebDriver init() {
		readconfig();

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver1\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.msedgedriver.driver", "driver\\msedgedriver.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(url);
		return driver;

	}
}
