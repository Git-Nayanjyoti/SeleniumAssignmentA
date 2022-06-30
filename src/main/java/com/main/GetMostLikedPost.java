package com.main;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.base.Base;


public class GetMostLikedPost extends Base{
	
	public static void main(String[] args) throws Exception{
		
		logIn();
		
		//going inside a community
		Thread.sleep(12000);        
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/nav/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/ul/li[1]/div/div/div/div/a"))
		.click();
		
		//list of post in the given community
		Thread.sleep(12000);
		List<WebElement> posts = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul"))
				.findElements(By.tagName("li"));
		int i = 0;
		
		
		//btn1 -> /html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[3]/div/div/div/div/div/div/div[1]/div[5]/div[2]/div/div/div/div/div[1]/div/ul/li/button
		//btn2 -> /html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[9]/div/div/div/div/div/div/div[1]/div[4]/div[2]/div/div/div/div/div[1]/div/ul/li/button
		//btn3 -> /html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[10]/div/div/div/div/div/div/div[1]/div[4]/div[2]/div/div/div/div/div[1]/div/ul/li/button
		
		//btn1 -> //*[@id="root"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[9]/div/div/div/div/div/div/div[1]/div[4]/div[2]/div/div/div/div/div[1]/div/ul/li/button
		for(WebElement post : posts) {
			i++;
			if(i > 2) {
				driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
			}
			System.out.println(post.findElements(By.tagName("img")).size());
		}
		
		
	}

}