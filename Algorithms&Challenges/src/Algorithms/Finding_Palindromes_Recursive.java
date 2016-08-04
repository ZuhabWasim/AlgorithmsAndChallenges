package Algorithms;

public class Finding_Palindromes_Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rotor";
		System.out.println(isPalindrome(s));
		
	}

	//Returns if a string is a palindrome which is done recursively
	public static boolean isPalindrome(String str) {
		
		//Base case 1:  If the string is less than 2 characters, 
		//it is already a palindrome
		if(str.length() <= 1) {
			return true;
		}
		
		//Base case 2: if the string's first and last characters
		//are not the same, then it is not a palindrome
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
