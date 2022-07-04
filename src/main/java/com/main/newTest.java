package com.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class newTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Nayan");
		list.add("Rahul");
		list.add("kalyan");
		list.add("Rahul");
		list.add("Nayan");
		list.add("Nayan");
		Set<String> s = new HashSet<String>(list);
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		for(String str : s) {
			map.put(Collections.frequency(list, str), str);
		}
		for(String str: map.descendingMap().values()) {
			System.out.println(str);
		}
	}

}
