package CCC_2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class S5_2016 {

	static HashMap<String, String> previousGens = new HashMap<String, String>();
	static ArrayList<String> nb = new ArrayList<String>(3);
	static HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//previousGens.
		String firstLine[] = sc.nextLine().split(" ");
		
		int n = Integer.parseInt(firstLine[0]);
		long t = Long.parseLong(firstLine[1]);

		String firstGen = sc.nextLine();
		String gen = firstGen;

		for(long i = 0; i < t; i++) {
			int decVal = (int) binToDec(gen);
			if(!previousGens.containsKey("" + decVal)) {
				previousGens.put("" + decVal, nextGen(gen, n));
			}
			gen = previousGens.get("" + decVal);
			System.out.println((i + 1) + " : " + gen);
		}
		
		System.out.println(gen);
		
		sc.close();
	}
	
	public static String lastChar(String st) {
		return st.substring(st.length() - 1);
	}
	
	//Updates the string to the next generation
	//Does so in substrings of length of 8 characters 
	//Done dynamically
	public static String nextGenDyn(String str, int n) {
		
		String neighbours;
		String subGen;
		
		return "";
	}
	
	//Updates the series of strings given to the next generation
	//Does by each individual character
	public static String nextGen(String str, int n) {
		
		String neighbours;
		String newGen = "";
		String c;
		
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				neighbours = lastChar(str) + str.substring(i + 1, i + 2);
			} else if(i == n - 1) {
				neighbours = str.substring(n - 2, n - 1) + str.substring(0, 1);
			} else {
				neighbours = str.substring(i - 1, i) + str.substring(i + 1, i + 2);
			}
			if(neighbours.equals("11") || neighbours.equals("00")) {
				c = "0";
			} else {
				c = "1";
			}
			newGen = newGen + c;
		}
		
		return newGen;
		
	}
	
	//Converts a binary value to decimal
	public static long binToDec(String n) {
		
		String st = revStr(n);
		long sum = 0;
		
		for(int i = 0; i < n.length(); i++) {
			String s = st.substring(i, i +1);
			sum += Integer.parseInt(s) * (Math.pow(2, i));
		}
		
		return sum;
		
	}
	
	//Reverses a string
	public static String revStr(String str) {
		
		String newStr = "";
		
		for(int i = str.length(); i > 0; i--) {
			newStr = newStr + str.substring(i - 1, i);
		}
		
		return newStr;
		
	}
}
