package com.practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.getCurrentUrl();
		driver.getTitle();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println(allWindowID);
		
		for (String s : allWindowID) {
			if (!s.equals(parentWindow)) {
				driver.switchTo().window(s);
			} 
			
		}
	}

}
