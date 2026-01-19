package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream uti = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties pro = new Properties();
		pro.load(uti);
		String launchbrowser = pro.getProperty("browser");
		String urlvalue = pro.getProperty("link");


		if (driver == null) {
			if (launchbrowser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(urlvalue);
			}

			if (launchbrowser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.get(urlvalue);
			}

		}
		return driver;

	}
}
