package amazon;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon_Sign_In_PropertiesFile {
	public static WebDriver driver;
	public static ChromeOptions options;
	public static Properties prop;
	public static FileInputStream ips;
	
	//C:\Users\chowd\eclipse-workspace\Maven_Amazon_Jenkins\src\test\java\amazon\AmazonSignInFlow.properties
	
@BeforeTest
public void launchUrl() throws Exception {
	String path = System.getProperty("user.dir") + "\\src\\test\\java\\amazon\\AmazonSignInFlow.properties";
	prop = new Properties();
	ips = new FileInputStream(path);
	prop.load(ips);
	
	options = new ChromeOptions();
	options.addArguments("--start-maximized");
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	driver.get(prop.getProperty("url"));
}
@Test(priority=1)
public void clickOnSignInLink() {
	driver.findElement(By.cssSelector(prop.getProperty("signInLinkcssSelector"))).click();
}
@Test(priority=2, dependsOnMethods = "clickOnSignInLink")
public void logInCredentials() {
	driver.findElement(By.cssSelector(prop.getProperty("userNameBoxcssSelector"))).sendKeys(prop.getProperty("userName"));
	driver.findElement(By.cssSelector(prop.getProperty("continueButtoncssSelector"))).click();
	driver.findElement(By.cssSelector(prop.getProperty("passwordBoxcssSelector"))).sendKeys(prop.getProperty("password"));
	driver.findElement(By.cssSelector(prop.getProperty("signInButtoncssSelector"))).click();
}
@Test(priority=3, dependsOnMethods = {"clickOnSignInLink", "logInCredentials"})
public void searchPoscaMarkers() {
	driver.findElement(By.cssSelector(prop.getProperty("searchBoxcssSelector"))).sendKeys(prop.getProperty("searchItem"));
	driver.findElement(By.cssSelector(prop.getProperty("searchResultscssSelector"))).click();
	driver.findElement(By.cssSelector(prop.getProperty("itemLinkcssSelector"))).click();
}
@Test(priority=4, dependsOnMethods = {"clickOnSignInLink", "logInCredentials", "searchPoscaMarkers"})
public void addToCartButton() {
	driver.findElement(By.cssSelector(prop.getProperty("addToCartcssSelector"))).click();
}
@Test(priority=5, dependsOnMethods = {"clickOnSignInLink", "logInCredentials", "searchPoscaMarkers", "addToCartButton"})
public void goToCartButton() {
	driver.findElement(By.cssSelector(prop.getProperty("gotoCartcssSelector"))).click();
}
@Test(priority=6, dependsOnMethods = {"clickOnSignInLink", "logInCredentials", "searchPoscaMarkers", "addToCartButton", "goToCartButton"})
public void amazonHomeButton() {
	driver.findElement(By.cssSelector(prop.getProperty("amazonHomecssSelector"))).click();
	
	
	
	
}
	
	
	


}
