package Algorithms;
import java.util.Scanner;

public class BinarySearchAlgorithm {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int nums[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		//int nums[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		
		System.out.println("Enter a number. Is it a prime between [1:100]?");
		//System.out.println("Enter a number. [1:100]?");
		int target = Integer.parseInt(sc.nextLine());
		
		int answer = searchUsingBinary(nums, target);
		
		if(answer == -1) {
			System.out.println("This number is not a prime number");
		} else {
			System.out.println("The number " + target + " is prime and is at index: " + answer);
		}
		
		sc.close();
			}

	public static int searchUsingBinary(int nums[], int target) {
		
		int min = 0;
		int max = nums.length - 1;
		int guess;
		
		while(max > min) {
			guess = (int) (min + max) / 2;
			System.out.println(guess);
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

}
