package Misc;

import java.util.ArrayList;

public class ThemeTesting {

	static int variable_name1 = 24;
	static String object_name1 = new String("Hello World.");
	
	public static void main(String[] args) {
		
		// Comments
		int variable_name2 = 1234567890;
		
		// Comments
		String object_name2 = "abcdefghijklmnopqrstuvwxyz";
		
		/*
		 * Long comments
		 */
		
		ArrayList<Integer> object_name3 = new ArrayList<Integer>(4);
		
		int a = 2;
		int b = 3;
		
		int sum = a + b - b * (a / b) % 0;
		String str = null;
		
		for(int i = 0; i < 10; i ++) {
			while(i < 10) {
				i++;
				variable_name2 += variable_name1;
				object_name3.set(2, 5);
				str = object_name3.get(2).toString();
			}
		}
		// Comments
		// Comments
		// Comments
		// Comments
		System.out.println(object_name2 + sum + variable_name2 + str + object_name1 + "");
		System.out.println(object_name3.get(2));
		System.out.println(a + "" + b);
		System.out.println(aTimesB(a, b));
	}
	
	public static int aTimesB(int a, int b) {
		return a * b;
	}

}
