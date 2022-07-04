package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

		// for most liked post get the data from TreeMap -> reactions and display it
		// and Name as String
		Integer[] mostLiked = reactions.keySet().toArray(new Integer[reactions.size()]);
		System.out.println("The most liked post is: ");
		System.out.println(reactions.get(mostLiked[mostLiked.length-1]));
		
		// for most active users getting the frequecy of duplicates in the
		// ArrayList -> peopleReacted and create a TreeMap with the frequency as keySet
		Set<String> mostActiveUsers = new HashSet<String>(peopleReacted);
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		//finding the frequency of most occuring name in the list
		for(String str : mostActiveUsers) {
			map.put(Collections.frequency(peopleReacted, str), str);
		}
		System.out.println("The most active users are as follows : ");
		for(String str: map.descendingMap().values()) {
			System.out.println(str);
		}
		
		
		System.out.println("Successfully extracted the data of most like post and most users online.");

	}

}