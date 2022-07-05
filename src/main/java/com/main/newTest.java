package com.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;

import com.github.dockerjava.api.command.ListTasksCmd;

import freemarker.core.CollectionAndSequence;

public class newTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Nayan");
		list.add("Rahul");
		list.add("kalyan");
		list.add("Rahul");
		list.add("Nayan");
		list.add("Nayan");
		list.add("Patil");
		list.add("Patil");
		list.add("Vicky");
		list.add("Gopal");
		list.add("Nayan");
		list.add("Patil");
		list.add("Patil");
		list.add("Vicky");
		list.add("Gopal");

		Map<Integer,Set<String>> map = new TreeMap<Integer,Set<String>>();
		for(String st : list) {
			Set<String> temp = new HashSet<String>();
			temp.add(st);
			for(String str: list) {
				if(Collections.frequency(list, st) == Collections.frequency(list, str)) {
					temp.add(str);
				}
			}
			map.put(Collections.frequency(list, st), temp);
		}

		Integer[] highest = map.keySet().toArray(new Integer[map.size()]);
		for(int i = highest.length-1; i >= 0 ; i--) {
			System.out.println(map.get(highest[i]));
//			List<String> tempList = new ArrayList<String>(map.get(highest[i]));
//			for(String s : tempList) {
//				System.out.println(s);
//			}
		}

		
	
//		[Ali, Shabbir, Koganti, Raghava, G, Jaganath, Prabalanathan, Haritharan, Gupta, Anchal, SINGH, SHIV RANJAN, Makowski, bob, Vemula, Akanksha, Fabella, Emma, ., Shanu, Sklors, Michael Martin, Lawson, Geraud, Tharthare, Vidula, Patil, Rahul, RABHA, NAYANJYOTI, Agarwal, Preeti]
//				[Ali, Shabbir, Koganti, Raghava, G, Jaganath, Prabalanathan, Haritharan, Gupta, Anchal, SINGH, SHIV RANJAN, Makowski, bob, Vemula, Akanksha, Fabella, Emma, ., Shanu, Sklors, Michael Martin, Lawson, Geraud, Tharthare, Vidula, Patil, Rahul, RABHA, NAYANJYOTI, Agarwal, Preeti]
//				[Ali, Shabbir, Koganti, Raghava, G, Jaganath, Prabalanathan, Haritharan, Gupta, Anchal, Vemula, Akanksha, SINGH, SHIV RANJAN, Makowski, bob, Fabella, Emma, ., Shanu, Sklors, Michael Martin, Lawson, Geraud, Tharthare, Vidula, Patil, Rahul, RABHA, NAYANJYOTI, Agarwal, Preeti]

	}
	

}
