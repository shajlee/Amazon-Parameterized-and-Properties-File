package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon_Create_An_Account_Parameterized {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	
	
@BeforeTest
@Parameters({"url"})
public void launchUrl(String url) {
	options = new ChromeOptions();
	options.addArguments("--start-maximized");
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--incognito");
	driver = new ChromeDriver(options);
	driver.get(url);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
}

@Test(priority=1)
public void clickOnCreateAnAccountLink() {
	driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
	driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
}
@Test(priority=2, dependsOnMethods = "clickOnCreateAnAccountLink")
@Parameters({"username","useremail", "userpassword", "userpasswordcheck"})
public void createAnAccountCredentials(String username, String useremail, String userpassword, String userpasswordcheck) {
	WebElement name = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys(username);
	
	WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait1.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(useremail);
	
	WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait2.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(userpassword);
	
	WebElement passwordcheck = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
	WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait3.until(ExpectedConditions.elementToBeClickable(passwordcheck)).sendKeys(userpasswordcheck);
	
	WebElement proceed = driver.findElement(By.xpath("//input[@id='continue']"));
	WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait4.until(ExpectedConditions.elementToBeClickable(proceed)).click();
}
@Test(priority =3, dependsOnMethods = {"clickOnCreateAnAccountLink", "createAnAccountCredentials"})
public void amazonHome() {
	WebElement homebutton = driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo']"));
	WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait5.until(ExpectedConditions.elementToBeClickable(homebutton)).click();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

}
