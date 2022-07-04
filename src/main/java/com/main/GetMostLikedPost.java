package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.Base;

public class GetMostLikedPost extends Base {

	public static void main(String[] args) throws Exception {

		logIn();

		// going inside a community
		Thread.sleep(12000);
		driver.findElement(By.xpath("//span[text()=\"My communities\"]//following::li")).click();

		// list of post in the given community
		Thread.sleep(12000);

		// scroller
		try {
//			long end = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
			int temp = 1000;
			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2500);

				long start = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
				if (start <= temp) {
					break;
				}
				temp += 500;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// get all the post in a list of webElement
		List<WebElement> posts = driver
				.findElement(By.xpath("//div[@role=\"main\"]//h2[text()='Conversations']//following::ul"))
				.findElements(By.xpath("//button[@aria-label=\"Show like reactions\"]"));

		System.out.println(posts.size());

		TreeMap<Integer, String> reactions = new TreeMap<Integer, String>();
		List<String> peopleReacted = new ArrayList<String>();
		for (WebElement post : posts) {
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.moveToElement(post).click().build().perform();
//			post.click();

			// get the no. of likes
			Thread.sleep(5000);
			List<WebElement> reactors = driver.findElements(By.xpath("//div[@id=\"y-modalDialog--title\"]//following::ul/li"));
			int numOfLikes = reactors.size();

			// store numOfLikes and post details in TreeMap reactions
			reactions.put(numOfLikes, post.getText());

			// get the people names who liked the post
			for (WebElement name : reactors) {
				peopleReacted.add(name.getText());
			}

			// name of person who posted the post
			peopleReacted.add(driver
					.findElement(By.xpath("//span[@class=\"undefined lpc-hoverTarget\"]//following::div/a")).getText());

			// close reaction tab
			driver.findElement(By.xpath("//button[@aria-label=\"Close\"]")).click();

		}

		// work left to be done
		// for most liked post get the data from TreeMap -> reactions and display it
		// for most active users find the get the frequecy of duplicates in the
		// ArrayList -> peopleReacted and create a TreeMap with the frequency as keySet
		// and Name as String
		// check how to find duplicates in a Stream or List -> BenchResources.Net
		System.out.println("I am here");

	}

}