package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.base.Base;

public class TestScroll extends Base{
	public static void main(String[] args) throws Exception {
		
		logIn();

		// going inside a community
		Thread.sleep(12000);
		driver.findElement(By.xpath("//span[text()=\"My communities\"]//following::li")).click();

		// list of post in the given community
		Thread.sleep(12000);

		long temp = 0;
		try {
			
			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2500);

				long start = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
				System.out.println("start: " + start);
				
				if (start == temp) {
					break;
				}
				temp = start;
			}
			
			System.out.println("completed the scroll");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
