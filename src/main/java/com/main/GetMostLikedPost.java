package com.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.base.Base;

public class GetMostLikedPost extends Base {

	public static void main(String[] args) throws Exception {

		logIn();

		// going inside a community
		Thread.sleep(12000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/nav/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/ul/li[1]/div/div/div/div/a"))
				.click();

		// list of post in the given community
		Thread.sleep(12000);
		
		

		//scroller
		Thread.sleep(3000);
		try {
//			long end = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
			int temp = 1000;
			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long start = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
				if (start <= temp) {
					break;
				}
			    temp += 500;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		List<WebElement> posts = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul"))
				.findElements(By.tagName("li"));
//
		System.out.println(posts.size());
//		WebElement button = driver.findElement(By.xpath("//button[@aria-label=\"Show like reactions\"]"));
		
		for(WebElement post : posts) {
			WebElement button = post.findElement(By.xpath("//button[@aria-label=\\\"Show like reactions\\\"]"));
			if(button.isDisplayed() == true) { 
				button.click();
				//find reaction data or tooltip data
			}
		}
		

		System.out.println("I am here");


	}

}