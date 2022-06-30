package com.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
		
		String[] cssSelector = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[4]/div/div/div/div/div/div/div[1]/div[5]/div[2]/div/div/div/div/div[1]/div/ul/li/button/div/span/div"))
				.getAttribute("class").split(" ");
		String selector = cssSelector[0] + "." + cssSelector[1];
		System.out.println(selector);

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

		System.out.println("I am here");
//		List<WebElement> posts = driver
//				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul"))
//				.findElements(By.tagName("li"));
//
//		System.out.println(posts.size());
//		int i = 0;

		// get css selector

		
		
		List<WebElement> likedPosts = driver.findElements(By.cssSelector(selector));
		System.out.println(likedPosts.size());

//		for (WebElement post : posts) {
////			i++;
////			if (i > 2) {
////				JavascriptExecutor js = (JavascriptExecutor) driver;
////				js.executeScript("window.scrollBy(0, document.body.scrollHeight)", "");
////			}
//
//			System.out.println(post.findElement(By.cssSelector(selector)));
//		}

	}

}