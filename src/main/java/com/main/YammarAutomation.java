package com.main;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.Base;


public class YammarAutomation extends Base{

	

	public static void main(String[] args) throws Exception{
		
		logIn();
		
		//going inside a community
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/nav/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/ul/li[1]/div/div/div/div/a/div/div/div[2]/div/div/div/div"))
		.click();
		
		//list of post in the given community
		List<WebElement> posts = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul"))
				.findElements(By.tagName("li"));
		for(WebElement post : posts) {
			
		}
		
		
	}

}