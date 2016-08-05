package CCC_2014;

import java.util.Scanner;

public class S2_2014 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String full = sc.nextLine();
		int a;
		int r;
		int product;
		int sum = 0;
		int nextR;

		while(!full.equals("")) {
			//Gets the values for the Arabic digit, and the Roman numeral
			a = Integer.parseInt(full.substring(0, 1));
			r = getVal(full.substring(1, 2));
			//Gets the product of the 2
			product = a * r;
			//Checks to see if the length of the string is greater than 3,
			//If its not, it wont need to check its proceeding Aromantic number
			//as there is non
			if(full.length() >= 4) {
				nextR = getVal(full.substring(3, 4));
			} else {
				nextR = 0;
			}
			//Checks to see if Roman numeral r is less than the next Roman numeral
			//If it is then we have to subtract this number from the sum
			if(r < nextR) {
				product *= -1;
			}
			//Adds the product to the sum
			sum += product;
			//Slices the string to remove the AR we already evaluated
			full = slice(full);
		}
		
		//Prints the sum
		System.out.println(sum);
		
		sc.close();

	}
	
	//Just returns the substring of the full string minus the first 2 characters
	public static String slice(String str) {
		
		return str.substring(2);
	}
	
	//Simple if/else if checking for what value the Roman numeral is,
	//In CCC for something as simple as an s2, you won't be wanted to over complicate it
	//as you need to use most of your brain power and time on the S3, and S4 questions
	//possible even S5????
	public static int getVal(String r) {
		
		int val = 0;
		
		if(r.equals("I")) {
			val = 1;
		} else if(r.equals("V")) {
			val = 5;
		} else if(r.equals("X")) {
			val = 10;
		} else if(r.equals("L")) {
			val = 50;
		} else if(r.equals("C")) {
			val = 100;
		} else if(r.equals("D")) {
			val = 500;
		} else if(r.equals("M")) {
			val = 1000;
		}
		
		return val;
	}

}
