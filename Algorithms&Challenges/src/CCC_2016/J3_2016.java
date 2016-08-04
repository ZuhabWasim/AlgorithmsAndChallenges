package CCC_2016;

import java.util.Scanner;

public class J3_2016 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int palLength = 0;
		int a;
		
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
