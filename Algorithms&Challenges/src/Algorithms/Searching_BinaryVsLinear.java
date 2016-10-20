package Algorithms;

import java.util.Scanner;

public class Searching_BinaryVsLinear {

	public static int numGuesses = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[] = {-23,-1,0,0,1,9,12,23,43,54,75,2000}; //{9,43,1,54,23,75,12,-1,-23, 0, 0, 2000};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input a number and the method you like to use (# binary/linear)");
		
		int response = sc.nextInt();
		//String response2 = sc.next();
		
		System.out.println("");
		System.out.println("Searching for " + response + " ...");
		
		//System.out.println(searchUsingBinary(array, 2000));
		//if(response2.equals("binary")) {
			if(binarySearch(array, response)) {
				System.out.println("Found the value " + response + " in " + numGuesses + " guesses.");
			} else {
				System.out.println("Sorry, the value you inputed is not in the array");
			}
		//} else {
			if(linearSearch(array, response)) {
				System.out.println("Found the value " + response + " in " + numGuesses + " guesses.");
			} else {
				System.out.println("Sorry, the value you inputed is not in the array");
			}
		//}
		System.out.println(searchUsingBinary(array, 2000));
		sc.close();
		
	}

	//Locates the target using the method of binary searching
	public static boolean binarySearch(int nums[], int target) {
		
		int min = 0;
		int max = nums.length;
		int guess;
		
		while(max > min) {
			guess = (int) (max + min) / 2;
			numGuesses ++;
			if(nums[guess] == target) {
				return true;
			} else if(nums[guess] < target) {
				min = guess + 1;
			} else {
				max = guess - 1;
			}
		}
		return false;
		
	}
	public static int searchUsingBinary(int nums[], int target) {
		
		int min = 0;
		int max = nums.length;
		int guess;
		
		while(max > min) {
			guess = (int) (min + max) / 2;
			//System.out.println(guess);
			if(nums[guess] == target) {
				return guess;
			} else if(nums[guess] > target) {
				max = guess - 1;
			} else {
				min = guess + 1;
			}
		}
		return -1;
	}
	
	//Locates the target using the method of linear searching
	public static boolean linearSearch(int nums[], int target) {
		
		int guess = 0;
		
		while (guess < nums.length) {
			numGuesses ++;
			if(nums[guess] == target) {
				return true;
			} else {
				guess++;
			}
		}
		return false;
	}
}
