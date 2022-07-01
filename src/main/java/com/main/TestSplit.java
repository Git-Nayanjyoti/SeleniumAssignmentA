package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TestSplit {

	public static List<String[]> listOfdata = new ArrayList<String[]>();
	public static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	public static void main(String[] args) {
		
		createList("1. Jun 23, 0.");
		createList("1. Jun 24, 10.");
		createList("1. Jun 25, 90.");
		createList("1. Jun 26, 40.");
		

		Integer[] highest = map.keySet().toArray(new Integer[map.size()]);
		System.out.println(map.get(highest[highest.length-1]));
		
	}
	public static void createList(String st) {
//		String str = "1. Jun 23, 0.";
		String[] tempArray = st.split("\\W");
		
		map.put(
				Integer.parseInt(tempArray[5]),
				tempArray[2] + " " + tempArray[3]
			);
		
		
		
	}

	
}
