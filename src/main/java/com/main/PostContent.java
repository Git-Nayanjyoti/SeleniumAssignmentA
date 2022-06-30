package com.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.base.Base;

public class PostContent extends Base{
	
	public static int i = 0;
	public static void main(String[] args) throws Exception {
		
		logIn();
		while(i < 5) {
			
			if(i>0) {
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("window.scrollBy(document.body.scrollHeight, 0)", "");
				driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
			}
			
			//select the YammerAutomation community
			Thread.sleep(12000); //no such element
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/nav/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/div/ul/li/div/div/div/a"))
			.click();
			
			//write a post
			Thread.sleep(12000);         
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div/button/div/div"))
			.click();
			
			int noOfTimes = i + 1;
			Thread.sleep(15000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/span/div/div[2]/div/div/div/div"))
			.sendKeys("Posting to YammerAutomation for the " + noOfTimes + " time");
			
			//post button
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[5]/div[2]/div/ul/li/div/div/button"))
			.click();
			
			System.out.println("\nposted successfully -> Posting to YammerAutomation for the " + noOfTimes + " time");
			System.out.println("Next post will be posted within next two minutes..");
			
			i++;
			
			TimeUnit.MINUTES.sleep(2);
			
			
			
		}
		
		
	}

}
