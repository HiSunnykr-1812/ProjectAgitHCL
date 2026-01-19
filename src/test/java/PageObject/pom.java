package PageObject;

import org.openqa.selenium.WebDriver;

public class pom {
	
	public WebDriver driver;
	
	public verificationdetails verify;
	public xpath path;
	
	public pom(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public verificationdetails getverify() {
		verify=new verificationdetails(driver);
		return verify;
	}
	
	public xpath getxpath() {
		path=new xpath(driver);
		return path;
	}

}
