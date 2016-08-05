package CCC_2016;

import java.util.Scanner;

public class J3_2016 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int palLength = 0;
		int a;
		
		//The algorithm for this problem is if the entire word is a palindrome then just return the length
		//If it isn't then go through the array, over and over again,
		//Checking if the given sub string in increasing length is a palindrome and then checks to see
		//if that palindrome is bigger than the previous recorded palindrome.
		//The algorithm skips sub strings of length 1 as 1 character long strings are already
		//palindrome
		
		/*
		 * Example: "BAADAR"
		 * The substrings it will check (S = substring length):
		 * S = 1: "B", "A", "A", "D", "A", "R"
		 * S = 2: "BA", "AA", "AD", "DA" "AR"
		 * S = 3: "BAA", "AAD", "ADA", "DAR"
		 * S = 4: "BAAD", "AADA", "ADAR"
		 * S = 5: "BAADA", "AADAR"
		 * S = 6: "BAADAR"
		 * Remember that the code will not iterate through S = 1, and S = 6 as 1 character long strings are already palindromes
		 * and S = 6, has already been checked when you checked the entire string
		 */
		if(isPalindrome(str)) {
			System.out.println(str.length());
		} else {	
			int stringSize = 2;
			palLength = 1;
			a = 0;
			String sub;
			
			while(stringSize < str.length()) {
				while(a + stringSize < str.length() + 1) {
					sub = str.substring(a, a + stringSize);
					if(isPalindrome(sub)) {
						if(sub.length() > palLength) {
							palLength = sub.length();
						}
					}
					a++;
				}
				a = 0;
				stringSize++;
			}
			System.out.println(palLength);
		}
		sc.close();

	}
	
	/* Sample Input 1
	 * banana
	 * ==5
	 * 
	 * Sample Input 2
	 * abracadabra
	 * ==3
	 * 
	 * Sample Input 3
	 * abba
	 * ==4
	 */
	
	//Determines if a word is a palindrome through recursion
	//The base case is if the string is less than 2 characters long
	//and if the end characters arent the same
	//The recursive case checks if the middle characters make a palindrome
	public static boolean isPalindrome(String str) {
		
		if(str.length() <= 1) {
			return true;
		}
		
		if(!firstCharacter(str).equals(lastCharacter(str))) {
			return false;
		} else {
			return isPalindrome(middleCharacters(str));
		}
	}
	
	public static String firstCharacter(String str) {
		return str.substring(0, 1);
	}
	
	public static String lastCharacter(String str) {
		return str.substring(str.length() - 1, str.length());
	}
	
	public static String middleCharacters(String str) {
		return str.substring(1, str.length() - 1);
	}
}
