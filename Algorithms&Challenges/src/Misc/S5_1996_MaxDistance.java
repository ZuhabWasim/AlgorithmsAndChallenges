package Misc;

import java.util.Scanner;

public class S5_1996_MaxDistance {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Retrieves the amount of test cases and the length of the arrays X and Y
		int cases = Integer.parseInt(sc.nextLine());
		
		for(int c = 0; c < cases; c++) {
			int length = sc.nextInt();//Integer.parseInt(sc.nextLine());
			
			// Initializes the two arrays X and Y
			int arrayX[] = new int[length];
			int arrayY[] = new int[length];
			
			// Assigns all of the values in arrays X and Y
			for(int l = 0; l < length; l++) {
				arrayX[l] = sc.nextInt();
			}
			for(int l = 0; l < length; l++) {
				arrayY[l] = sc.nextInt();
			}
			
			int i = 0;
			int currJ = 0;
			int distance;
			int maxDistance = 0;
			int xAtI = 0;
			int yAtJ = 0;
			int j = 0;
			
			
			// Iterates through array Y from end to start
			for(j = length - 1; j >= 0; j--) {
				// If the next value we're checking is the same as the previous
				// We know that we do not need to check it -> skip this iteration
				if(j != length - 1) {
					if(arrayY[j] == arrayY[j + 1]) {
						continue;
					}
				}
				// Finds the value of Y[j] in the X array and puts it into the variable i
				i = binarySearch(arrayX, arrayY[j]);
				
				// Checks to see if i is a valid number
				distance = (i != -1 && i <= j) ? j - i : 0;
				// Updates maxDistance
				if (distance > maxDistance) {
					maxDistance = distance;
					xAtI = arrayX[i];
					yAtJ = arrayY[j];
					currJ = j;
				}
				//maxDistance = (distance > maxDistance) ? distance : maxDistance;
			}
			
			//Prints the max distance
			System.out.println("The maximum distance is " + maxDistance);
			System.out.println(i + ": " + xAtI + ", " + currJ + ": " + yAtJ);
		}
		
		
		sc.close();
	}
	public static int linearSearch(int nums[], int target) {
		
		int index = -1;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == target) {
				index = i;
				break;
			}
		}
		
		return index;
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

	public static int binarySearch(int nums[], int target) {
		
		int min = 0;
		int max = nums.length;
		int guess;
		
		/*while(max > min) {
			guess = (int) (max + min) / 2;
			if(nums[guess] == target) {
				if(guess != 0) {
					while(nums[guess - 1] == nums[guess]) {
						guess --;
						if(guess == 0) {
							break;
						}
					}
				}
				return guess;
			} else if(nums[guess] < target) {
				min = guess + 1;
			} else {
				max = guess - 1;
			}
		}
		return -1;*/
		while(max >= min) {
			guess = (int) (min + max) / 2;
			//System.out.println(guess);
			//System.out.println(guess);
			if(nums[guess] == target) {
				if(guess != 0) {
					while(nums[guess - 1] == nums[guess]) {
						guess --;
						if(guess == 0) {
							break;
						}
					}
				}
				return guess;
			} else if(nums[guess] < target) {
				max = guess - 1;
			} else {
				min = guess + 1;
			}
		}
		return -1;
	}
}