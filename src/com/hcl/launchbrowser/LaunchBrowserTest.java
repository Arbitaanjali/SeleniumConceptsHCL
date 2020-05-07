package com.hcl.launchbrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchBrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://magento.com/");
		
		
//		  By myAccLocator = By.linkText("My Account"); 
//		  WebElement myAccEle =  driver.findElement(myAccLocator);
		 
		
		WebElement myAccEle = driver.findElement(By.linkText("My Account"));
		myAccEle.click();
//		String href = myAccEle.getAttribute("href");
//		System.out.println(href);
		
		
		
		//login
		WebElement emailEle=driver.findElement(By.id("email"));
		emailEle.sendKeys("balaji0017@gmail.com");
		
		//password
		WebElement passEle=driver.findElement(By.id("pass"));
		passEle.sendKeys("welcome@123");
		
		//click on login
		WebElement loginEle=driver.findElement(By.id("send2"));
		loginEle.click();
		
		//make sure mainpage is loaded
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Out")));
//		
//		String expectedId = "MAG004563920";
//		
//		String pageSource = 
		
		String expectedTitle="My Account";
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Failure");
		}
		
		//click on logout
		WebElement logoutEle = driver.findElement(By.partialLinkText("Out"));
		logoutEle.click();
	}

}
