package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObject.pom;

public class Testcontextsetup {
	
	public WebDriver driver;
	public baseclass baseclass;
	public pom pomanager;
	
	public Testcontextsetup() throws IOException {
		baseclass=new utils.baseclass();
		pomanager=new pom(baseclass.WebDriverManager());
		
		
	}

}
