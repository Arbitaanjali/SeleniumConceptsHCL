package com.hcl.db;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class db {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		List<WebElement> rowsEle = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int rowCount = rowsEle.size();
		System.out.println(rowCount);
		
//		List<WebElement> linksEle=driver.findElements(By.tagName("a"));
//		int size = linksEle.size();
//		System.out.println(size);
		
//		WebElement name1Ele = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[2]"));
//		String name1 = name1Ele.getText();
//		System.out.println(name1);
		
//		for (int i=1; i <rowCount;i++)
//		{
//			System.out.println("i value =" +i);
//			System.out.println("//table[@id='example']/tbody/tr["+i+"]/td[2]");
//		}
		
		for (int i=1; i <rowCount;i++)
		{
			WebElement name1Ele = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]"));
			String name1 = name1Ele.getText();
			System.out.println(name1);
			
			if(name1.equals("Brenden Wagner"))
			{
				//click checkbox
				WebElement checkEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
				checkEle.click();
				
				//get position
				WebElement posEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[3]"));
				String pos = posEle.getText();
				System.out.println(pos);
				
				
			}
		}
	}
}
