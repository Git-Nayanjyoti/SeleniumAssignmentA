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
		list.add("Nayan, Rabha");
		list.add("Rahul, Sharma");
		list.add("kalyan, Gogoi");
		list.add("Rahul, Sharma");
		list.add("Nayan, Rabha");
		list.add("Nayan, Rabha");
		list.add("Patil, Verma");
		list.add("Patil, Verma");
		list.add("Vicky, Kaushal");
		list.add("Gopal, Verma");
		list.add("Nayan, Rabha");
		list.add("Patil, Verma");
		list.add("Patil, Verma");
		list.add("Vicky, Kaushal");
		list.add("Gopal, Verma");
		
		List<String> joinedFnameLname = new ArrayList<String>();
		for(String string : list) {
			String[] nameArray = string.split(",");
			String fname = nameArray[0];
			String lname = nameArray[1];
			joinedFnameLname.add(fname + lname);
		}

		Map<Integer,Set<String>> map = new TreeMap<Integer,Set<String>>();
		for(String st : joinedFnameLname) {
			
			Set<String> temp = new HashSet<String>();
			temp.add(st);
			for(String str: joinedFnameLname) {
				if(Collections.frequency(joinedFnameLname, st) == Collections.frequency(joinedFnameLname, str)) {
					temp.add(str);
				}
			}
			map.put(Collections.frequency(joinedFnameLname, st), temp);
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
