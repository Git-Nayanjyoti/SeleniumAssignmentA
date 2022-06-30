package com.main;

public class splitText {

	public static void main(String[] args) {
		String str = "ms-Image root-530";
		String[] strArray = str.split(" ");
		for(String st : strArray) {
			System.out.println(st.toString());
			
		}
		System.out.println(strArray[0] + "." + strArray[1]);
	}
}
